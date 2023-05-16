<template>
  <div style="margin: 0.2rem 0.5rem;">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="名称" label-width="50px">
        <el-input type="textarea" v-model="form.name"></el-input>
      </el-form-item>
<!--      <el-form-item label="备注" label-width="50px">-->
<!--        <el-input type="textarea" v-model="form.memo"></el-input>-->
<!--      </el-form-item>-->
    </el-form>
    <el-row class="contentDiv">
      <el-button style="width: 100%;" type="success" @click="change">保存修改</el-button>
    </el-row>
    <el-row class="contentDiv">
      <el-button style="width: 100%;" type="danger" @click="deleted">删除任务包</el-button>
    </el-row>


  </div>
</template>

<script>
  import {newMessage} from "../../utils/InfoUtil";
  import {delPackInfo, getWorkPackInfo, updateWorkPack} from "../../api/todoList/workPackAPI";
  import {getList} from "../../api/todoList/todoListAPI";
  export default {
    name: "workPackInfoDetail",
    data(){
      return{
        form:{
          content: null,
          memo: null,
        }
      }
    },
    methods: {
      // 通过ID查询
      getPackContent(id){
        getWorkPackInfo(id).then(res => {
          this.form = res.data
          console.log(res)
        })
      },
      // 修改
      change(){
        console.log(this.form)
        updateWorkPack(this.form).then(res => {
          console.log(res.data);
          newMessage("success", '修改成功')
          this.$emit("updateSuccess")
        })
      },
      // 删除
      deleted(){
        let that = this;
        this.$confirm('删除操作不可逆，是否继续', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          getList({packId: that.form.id}).then(res => {
            if(res.data.total > 0){
              newMessage("warning", '请先删除包内任务', false)
            }else{
              console.log("hsjd")
              delPackInfo(that.form.id).then(() => {
                that.$emit("updateSuccess")
                newMessage("success", '删除成功')
              })
            }
          })
        })
      },
      // 查询工作包下面的数据



    }
  }
</script>

<style scoped>
  .contentDiv{
    margin-bottom: 0.5rem;
  }
</style>