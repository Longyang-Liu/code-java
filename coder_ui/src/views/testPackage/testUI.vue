<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12">11</el-col>
      <el-col :span="12">22</el-col>
    </el-row>

  </div>
</template>

<script>
  import {getTestList} from "../../api/todoList/todoListAPI";

  export default {
    name: "testUI",
    mounted() {
      this.testMethod();
    },
    methods:{
      testMethod(){
        getTestList().then(res => {
          console.log(res)
        })
      }
    }
  }
</script>

<style scoped>

</style>