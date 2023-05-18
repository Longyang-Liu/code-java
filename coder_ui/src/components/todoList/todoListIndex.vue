<template>
  <div>
    <el-card>
      <div slot="header" class="clearfix">
        <el-row :gutter="10" >
          <el-col :span="8">
            <span class="contentShow todoTitle">{{title}}</span>
          </el-col>
          <el-col :span="16">
            <el-input  :rows="1" type="textarea" v-model="value" placeholder="todo..." @keyup.enter.native="handleEnter"></el-input>
          </el-col>
        </el-row>
      </div>
      <div v-for="item in dataList" :key="item.id" class="text item fontBox" @dblclick="handleContextMenu(item)">
        <el-row :gutter="10">
          <el-col :span="1.5">
            <el-checkbox v-model="item.finished" size="medium"  @change="changeTask(item)"></el-checkbox>
          </el-col>
          <el-col :span="20">
            <span class="taskP contentShow" >{{ item.content }}</span>
          </el-col>
        </el-row>
      </div>
    </el-card>

    <TodoDrawer
            ref="todoDrawerRef"
            @updateSuccess="updateSuccess"
    ></TodoDrawer>
  </div>
</template>

<script>
  import {addTodo, getList, updateTodo} from "../../api/todoList/todoListAPI";
  import TodoDrawer from "./todoDrawer";
  import {getWorkPackInfo} from "../../api/todoList/workPackAPI";

  export default {
    name: "todoListIndex",
    components: {TodoDrawer},
    data(){
      return{
        value: null,
        title: '标题',
        dataList: [],
        queryParams:{
          packId: null,
        }
      }
    },
    mounted() {
      this.getList();
    },
    methods:{
      // 获取待办数据
      getList(){
        getList(this.queryParams).then(res => {
          this.dataList = this.setFinishEd(res.data.records)
        })
      },
      // 通过工作包ID筛选数据
      getPackTodoList(id){
        getWorkPackInfo(id).then(res => {
          this.title = res.data.name
        })
        this.queryParams.packId = id;
        this.getList();
      },
      // 循环判断任务是否已完成
      setFinishEd(list) {
        list.forEach(item => {
          if (item.finish == 1) {
            this.$set(item, "finished", false);
          }
          else {
            this.$set(item, "finished", true);
          }
        });
        return list;
      },
      // 输入框回车保存事件
      handleEnter(){
        addTodo({
          content: this.value,
          packId: this.queryParams.packId
        }).then(res => {
          this.value = null;
          console.log(res)
          this.getList();
        })
      },
      // 任务勾选事件
      changeTask(item){
        console.log(item)
        let finished = item.finished ? 2 : 1
        console.log(item.finished)
        updateTodo({id: item.id, finish: finished}).then(res => {
          console.log(res)
          this.getList();
          this.$emit("changeTask")
        })
      },
      // 双击任务事件
      handleContextMenu(item){
        console.log(item);
        this.$refs.todoDrawerRef.handleOpen("todo", item.id);
      },
      // 修改任务回调
      updateSuccess(){
        this.getList();
      },
    }
  }
</script>

<style scoped>

  .contentShow{
    width: 100%;
    cursor: pointer;
    word-wrap: break-word;
    word-break: break-all;
  }
  .taskP{
    font-size: 1rem;
  }
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .todoTitle{
    font-weight: 900;
    font-size: 1.2rem;
  }

  .fontBox{

  }

</style>