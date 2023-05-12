<template>
  <div>
    <el-input :rows="1" type="textarea" v-model="value" placeholder="packName..." @keyup.enter.native="handleEnter"></el-input>
    <p v-for="item in dataList" :key="item.id" class="packName" >
      <span @dblclick="showPackDetail(item)" @click="showPackTodoList(item)">{{ item.name }}</span>
    </p>
  </div>
</template>

<script>
  import {addWorkPack, getList} from "../../api/todoList/workPackAPI";

  export default {
    name: "workPack",
    data(){
      return{
        value: null,
        dataList: [],
      }
    },
    mounted() {
      this.getList();
    },
    methods:{
      // 获取工作包数据
      getList(){
        getList().then(res => {
          this.dataList = res.data.records
          console.log(res)
        })
      },
      // 工作包输入框回车事件
      handleEnter(){
        console.log(this.value)

        addWorkPack({
          name: this.value,
        }).then(() => {
          this.value = null;
          this.getList();
        })
      },
      // 单击展示工作包任务
      showPackTodoList(item){
        this.$emit("showPackTodoList", item)
      },
      // 双击可修改工作包信息
      showPackDetail(){

      },
    }
  }
</script>

<style scoped>

  .packName{
    cursor: pointer;
  }

</style>