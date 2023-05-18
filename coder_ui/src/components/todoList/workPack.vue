<template>
  <div>
    <el-input :rows="1" type="textarea" v-model="value" placeholder="packName..." @keyup.enter.native="handleEnter"></el-input>
    <p v-for="item in dataList" :key="item.id" class="packName" style="display: flex; align-content: center">
      <el-progress v-if="item.progress < 50" :width="25" type="circle" :percentage="item.progress" :show-text="false" status="warning"></el-progress>
      <el-progress v-else-if="item.progress < 100" :width="25" type="circle" :percentage="item.progress" :show-text="false"></el-progress>
      <el-progress v-else :width="25" type="circle" :percentage="item.progress" :show-text="true" status="success"></el-progress>
      <span @dblclick="showPackDetail(item)" @click="showPackTodoList(item)">{{ item.name }}</span>
    </p>

    <TodoDrawer
            ref="todoDrawerRef"
            @updateSuccess="updateSuccess"
    ></TodoDrawer>
  </div>
</template>

<script>
  import TodoDrawer from "./todoDrawer";

  import {addWorkPack, getList} from "../../api/todoList/workPackAPI";

  export default {
    name: "workPack",
    components:{
      TodoDrawer
    },
    data(){
      return{
        value: null,
        dataList: [],
        clickTimer: false,
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
        if (this.clickTimer) {
          window.clearTimeout(this.clickTimer);
          this.clickTimer = null;
        }
        this.clickTimer = window.setTimeout(function() {
          console.log("你单击了我");
        }, 300);
        this.$emit("showPackTodoList", item)
      },
      // 双击可修改工作包信息
      showPackDetail(item){
        if (this.clickTimer) {
          window.clearTimeout(this.clickTimer);
          this.clickTimer = null;
        }
        this.$refs.todoDrawerRef.handleOpen("workPack", item.id);
      },
      // 操作成功回调
      updateSuccess(){
        this.getList();
      }
    }
  }
</script>

<style scoped>

  .packName{
    cursor: pointer;
    margin-left: 1rem;
  }

</style>