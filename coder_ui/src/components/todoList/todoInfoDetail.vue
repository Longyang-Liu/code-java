<template>
  <div style="margin: 0.2rem 0.5rem;">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="名字" label-width="50px">
        <el-input type="textarea" v-model="form.content"></el-input>
      </el-form-item>
      <el-form-item label="备注" label-width="50px">
        <el-input type="textarea" v-model="form.memo"></el-input>
      </el-form-item>
    </el-form>
    <el-row class="contentDiv">
      <el-button style="width: 100%;" type="success" @click="changeTodo">保存修改</el-button>
    </el-row>
    <el-row class="contentDiv">
      <el-button style="width: 100%;" type="danger" @click="deletedTodo">删除任务</el-button>
    </el-row>


  </div>
</template>

<script>
  import {delTodoInfo, getTodoListInfo, updateTodo} from "../../api/todoList/todoListAPI";
  import {newMessage} from "../../utils/InfoUtil";
  export default {
    name: "todoInfoDetail",
    props:{
      todoId: String
    },
    data(){
      return{
        form:{
          content: null,
          memo: null,
        }
      }
    },
    methods: {
      // 通过ID查询任务
      getContent(id){
        getTodoListInfo(id).then(res => {
          this.form = res.data
        })
      },
      // 修改任务
      changeTodo(){
        console.log(this.form)
        updateTodo(this.form).then(res => {
          console.log(res.data);
          newMessage("success", '修改成功')
          this.$emit("updateSuccess")
        })
      },
      // 删除任务
      deletedTodo(){
        let that = this;
        this.$confirm('删除操作不可逆，是否继续', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          delTodoInfo(that.form.id).then(() => {
            that.$emit("updateSuccess")
            newMessage("success", '删除成功')
          })
        })
      },


    }
  }
</script>

<style scoped>
  .contentDiv{
    margin-bottom: 0.5rem;
  }
</style>