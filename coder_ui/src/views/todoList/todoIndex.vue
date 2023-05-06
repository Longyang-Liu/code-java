<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="6">
        <work-pack></work-pack>
      </el-col>
      <el-col :span="18">
        <todo-list-index></todo-list-index>
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

    }
  }
  </script>
  
  <style>

  </style>
  