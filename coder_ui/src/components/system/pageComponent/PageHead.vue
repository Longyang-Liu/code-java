<template>
  <div>
    <el-button @click="goUrl"></el-button>
    <router-link to="/todo">Home</router-link>
  </div>
</template>

<script>
  export default {
    name: "PageHead",
    methods:{

      goUrl(){
        this.$router.push({
          name:'todo',
          params:{
            articleId: "1"
          }
        });
      }
    }
  }
</script>

<style scoped>

</style>