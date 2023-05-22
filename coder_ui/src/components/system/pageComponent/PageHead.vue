<template>
  <div>
    <el-row :gutter="10">
      <el-col :span="6">
        <el-button icon="el-icon-house" circle @click="goToIndex"></el-button>
      </el-col>
      <el-col :span="1.5"><el-button icon="el-icon-s-order" circle @click="goTodo"></el-button></el-col>
      <el-col :span="1.5"><el-button icon="el-icon-notebook-1" circle @click="goToNote"></el-button></el-col>
    </el-row>
  </div>
</template>

<script>
  import {goDocumentByObj} from "@/utils/RouterUtil";

  export default {
    name: "PageHead",
    methods:{
      // 跳转到首页
      goToIndex(){
        goDocumentByObj('indexPage', null)
      },
      // 跳转到todo
      goTodo(){
        goDocumentByObj('taskTodo', null)
      },
      // 跳转到文章管理
      goToNote(){
        goDocumentByObj('articleIndex', null)
      },
    }
  }
</script>

<style scoped>

</style>