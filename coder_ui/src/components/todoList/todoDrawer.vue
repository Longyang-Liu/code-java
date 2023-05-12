<template>
  <div>
    <el-drawer
            title="更多"
            :visible.sync="drawer"
            direction="rtl"
            :before-close="handleClose">

      <TodoInfoDetail
              :todo-id="todoId"
              ref="infoDetailRef"
              @updateSuccess="updateSuccess"
      ></TodoInfoDetail>

    </el-drawer>
  </div>
</template>

<script>
  import TodoInfoDetail from './todoInfoDetail.vue';

  export default {
    name: "todoDrawer",
    data() {
      return {
        drawer: false,
        todoId: null,
      };
    },
    methods: {
      // 关闭抽屉
      handleClose() {
        this.drawer = !this.drawer;
      },
      // 打开抽屉
      handleOpen(id) {
        this.todoId = id;
        this.drawer = !this.drawer;
        this.$nextTick(() => {
          this.$refs.infoDetailRef.getContent(id)
        })
      },
      // 修改完成回调方法
      updateSuccess(){
        this.drawer = !this.drawer;
        this.$emit("updateSuccess")
      },
    },
    components: { TodoInfoDetail }
  }
</script>