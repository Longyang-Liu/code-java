<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="6">
        <WorkPack @showPackTodoList="showPackTodoList"></WorkPack>
      </el-col>
      <el-col :span="18">
        <TodoDetail ref="todoDetailRef"></TodoDetail>
      </el-col>
    </el-row>

  </div>
</template>
  
  <script>
  import TodoDetail from '@/components/todoList/todoDetail.vue';
import WorkPack from '@/components/todoList/workPack.vue';

  export default {
    name: 'todoIndex',
    components: {
      TodoDetail,
      WorkPack
    },
    methods:{
      // 查询对应工作包的计划
      showPackTodoList(id){
        console.log(id)
        this.$refs.todoDetailRef.getPackTodoList(id);
      }
    }
  }
  </script>
  
  <style>

  </style>
  