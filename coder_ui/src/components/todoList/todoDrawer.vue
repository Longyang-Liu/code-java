<template>
  <div>
    <el-drawer
            title="更多"
            :visible.sync="drawer"
            direction="rtl"
            :before-close="handleClose">
      <work-pack-info-detail v-if=" 'workPack' ==showType" ref="packDetailRef" @updateSuccess="updateSuccess"></work-pack-info-detail>
      <TodoInfoDetail v-else ref="infoDetailRef" @updateSuccess="updateSuccess"></TodoInfoDetail>

    </el-drawer>
  </div>
</template>

<script>
  import TodoInfoDetail from './todoInfoDetail.vue';
  import WorkPackInfoDetail from "./workPackInfoDetail";

  export default {
    name: "todoDrawer",
    data() {
      return {
        drawer: false,
        todoId: null,
        showType: null,
      };
    },
    methods: {
      // 关闭抽屉
      handleClose() {
        this.drawer = !this.drawer;
      },
      // 打开抽屉
      handleOpen(type, id) {
        this.showType = type;
        this.drawer = !this.drawer;
        this.$nextTick(() => {
          if("workPack" == type){
            this.$refs.packDetailRef.getPackContent(id)
          }else{
            this.$refs.infoDetailRef.getInfoContent(id)
          }

        })
      },
      // 修改完成回调方法
      updateSuccess(){
        this.drawer = !this.drawer;
        this.$emit("updateSuccess")
      },
    },
    components: {WorkPackInfoDetail, TodoInfoDetail }
  }
</script>