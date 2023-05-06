<template>
  <div>
    <el-input :rows="1" type="textarea" v-model="value" placeholder="packName..." @keyup.enter.native="handleEnter"></el-input>
    <p v-for="item in dataList" :key="item.id" class="packName" >
      <span @dblclick="showPackDetail(item)" @click="showPackTodoList(item)">{{ item.name }}</span>
    </p>
  </div>
</template>

<script>
  export default {
    name: "workPack",
    data(){
      return{
        value: null,
        dataList: [],
      }
    },
    mounted() {
    },
    methods:{
      // 工作包输入框回车事件
      handleEnter(){

      },
      // 单击展示工作包任务
      showPackTodoList(){

      },
      // 双击可修改工作包信息
      showPackDetail(){

      },
    }
  }
</script>

<style scoped>

</style>