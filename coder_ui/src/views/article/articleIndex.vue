<template>
  <div>
    <page-head style="margin-bottom: 0.5rem"></page-head>
    <article-page></article-page>
  </div>
</template>

<script>
  import ArticlePage from "../../components/article/articlePage";
  import PageHead from "../../components/system/pageComponent/PageHead";
  export default {
    name: "articleIndex",
    components: {PageHead, ArticlePage}
  }
</script>

<style scoped>

</style>