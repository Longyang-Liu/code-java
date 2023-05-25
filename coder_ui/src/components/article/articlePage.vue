<template>
  <div class="app-container">
    <el-row type="flex">
      <el-col :span="6"></el-col>
      <el-col :span="12">
        <el-row :gutter="20">
          <el-col :span="4">
            <router-link :to="{ name: 'editorIndex'}">
              <el-button type="text" icon="el-icon-edit" size="medium">editor</el-button>
            </router-link>
          </el-col>
          <el-col :span="20">
            <el-input placeholder="请输入文章名称" v-model="queryParams.articleTitle" @keyup.enter.native="getData" class="input-with-select">
              <el-button slot="prepend" icon="el-icon-delete" @click="getSourceData"></el-button>
              <el-button slot="append" icon="el-icon-search"  @click="getData"></el-button>
            </el-input>
          </el-col>
        </el-row>

        <p></p>
        <el-card v-for="item in dataList" :key="item.id" style="margin-top: 1rem; cursor: pointer" @click.native="viewDetails(item.articleId)">
          <el-tooltip class="item" effect="dark" :content="item.articleTitle" placement="top-start">
            <h2 style="margin: 0; padding: 0" v-html="item.articleTitleWithCSS"></h2>
          </el-tooltip>
          <p v-html="item.articleDescription"></p>
          <el-divider></el-divider>
          <div class="bottom clearfix" >
            <el-row type="flex">
              <el-col :span="22">
                <span>{{ item.creationTime }}</span>
                <el-divider direction="vertical"></el-divider>
                <span>{{ item.createdBy }}</span>
                <!--                                <el-divider direction="vertical"></el-divider>-->

              </el-col>
              <el-col :span="2">
                <el-popover
                        placement="bottom"
                        width="100%"
                        trigger="hover">
                  <p class="settingButtons">
                    <el-button style="font-size: 16px; padding: 0" @click="editorDetails(item.articleId)" class="el-icon-edit-outline" type="text">修改</el-button>
                  </p>
                  <p class="settingButtons">
                    <el-button style="font-size: 16px; padding: 0" @click="deleteDetails(item.articleId)" class="el-icon-delete" type="text">删除</el-button>
                  </p>
                  <p class="settingButtons">
                    <el-button style="font-size: 16px; padding: 0" @click="editorIseq(item)" class="el-icon-sort" type="text">排序</el-button>
                  </p>
                  <el-button slot="reference" style="font-size: 16px; padding: 0" class="el-icon-setting" type="text">操作</el-button>
                </el-popover>
              </el-col>
            </el-row>
          </div>
        </el-card>

        <pagination-ref
                v-show="total>0"
                :total="total"
                :page.sync="queryParams.pageNum"
                :limit.sync="queryParams.pageSize"
                @pagination="getData"
        ></pagination-ref>

      </el-col>
      <el-col :span="6"></el-col>
    </el-row>
  </div>
</template>

<script>
  import {getInfoList} from "@/api/article/articleInfo/articleInfoAPI";
  import {deleteDetail} from "@/api/article/articleInfo/articleInfoAPI";
  import {goDocumentByObj} from "@/utils/RouterUtil";
  import {updateDetail} from "@/api/article/articleInfo/articleInfoAPI";

  export default {
    name: "articlePage",
    data(){
      return{
        dataList: [],
        total: 0,
        queryParams: {
          pageNum: 1,
          pageSize: 4,
          articleTitle: null,
        },
        currentDate: new Date()
      }
    },
    methods:{
      // 查询所有文章生成列表数据
      getData(){
        const loading = this.$loading({
          lock: true,
          text: 'Loading',
          spinner: 'el-icon-loading',
          background: 'rgba(0, 0, 0, 0.7)'
        });
        getInfoList(this.queryParams).then(res => {
          console.log(res.data)
          this.dataList = res.data.records;
          this.cyclicData(this.dataList, this.queryParams.articleTitle)
          this.total = res.data.total;
          loading.close()
        })
      },
      // 数据循环设置高亮
      cyclicData(list, search){
        if(list != null && list.length > 0){
          list.forEach(item => {
            this.$set(item, 'articleTitleWithCSS', item.articleTitle)
            if(search != null){
              if(item.articleTitle != null){
                item.articleTitleWithCSS = this.lightFont(item.articleTitle, search);
              }
              if(item.articleDescription != null){
                item.articleDescription = this.lightFont(item.articleDescription, search);
              }
            }
          })
        }
      },
      // 匹配的关键字显示高亮
      lightFont(source, search) {
        /**
         * 使用正则表达式进行全文匹配关键词
         * ig : 表示 全文查找 ,忽略大小写
         *  i : 忽略大小写
         *  g : 全文查找
         *
         * 使用字符串的replace方法进行替换
         * stringObject.replace('被替换的值',替换的值)
         */
        const res = new RegExp(search, 'ig')
        return source.replace(res, (item) => {
          // item是匹配里面的原字符
          return `<span style="color:red">${item}</span>`
        })
      },
      // 重置搜索
      getSourceData(){
        this.queryParams.articleTitle = null;
        this.getData();
      },
      // 传递ID给阅读器并调用
      viewDetails(id){
        goDocumentByObj('readerIndex', {articleId: id})
      },
      // 传递ID给编辑器并调用
      editorDetails(id){
        goDocumentByObj('editorIndex', {articleId: id})
      },
      // 通过id删除文章数据
      deleteDetails(id){
        this.$confirm('删除文章后不能恢复，是否继续', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteDetail(id).then(() => {
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            this.getData();
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      // 修改文章排序
      editorIseq(data){
        console.log(data)
        this.$prompt('请输入序号', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputValue: data.iseq,
        }).then(({ value }) => {
          updateDetail({
            articleId: data.articleId,
            iseq: value
          }).then(() => {
            this.$message({
              showClose: true,
              type: 'success',
              message: '已更新'
            })
            this.getData();
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });
        });
      },

    },
    mounted() {
      this.getData();
    }
  }
</script>

<style scoped>
  .settingButtons{
    margin: 0.5rem 0 0 0;
    padding: 0;
  }
</style>