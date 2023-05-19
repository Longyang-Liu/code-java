<template>
  <div>

    <el-row :gutter="20">
      <el-col :span="6">
        <work-pack ref="workPackRef" @showPackTodoList="showPackTodoList"></work-pack>
      </el-col>
      <el-col :span="18">
        <todo-list-index ref="todoListIndexRef" @changeTask="changeTask"></todo-list-index>
      </el-col>
    </el-row>

  </div>
</template>
  
  <script>


  import TodoListIndex from "../../components/todoList/todoListIndex";
  import WorkPack from "../../components/todoList/workPack";
  export default {
    name: 'todoIndex',
    components: {
      WorkPack,
      TodoListIndex

    },
    methods:{
      // 点击工作包筛选数据
      showPackTodoList(item){
        console.log(item)
        this.$refs.todoListIndexRef.getPackTodoList(item.id);
      },
      // 任务完成状态改变
      changeTask(){
        this.$refs.workPackRef.getList();
      },
    }
  }
  </script>
  
  <style>

  </style>
  