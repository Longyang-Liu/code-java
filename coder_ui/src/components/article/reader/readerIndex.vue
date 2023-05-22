<template>
    <div class="app-container">

        <div style="position: fixed; height:100%; width: 20rem; overflow:auto; margin: 0rem 0 0 1rem" >
            <h3>目录</h3>
            <div
                    v-for="anchor in titles"
                    :key="anchor.id"
                    :style="{ padding: `10px 0 10px ${anchor.indent * 20}px` }"
                    @click="handleAnchorClick(anchor)"
            >
                <a style="cursor: pointer">{{ anchor.title }}</a>
            </div>
        </div>

        <div style="margin-left: 21rem">
            <v-md-preview :text="markdown" ref="preview"></v-md-preview>
        </div>
    </div>
</template>

<script>
    import {getContentById} from "@/api/article/articleContent/articleContentAPI";

    export default {
        name: "readerIndex",
        data(){
            return{
                markdown: '',
                titles: [],
            }
        },
        methods:{
            // 获取路由传递的ID参数，查询文章内容
            getData(){
                const loading = this.$loading({
                    lock: true,
                    text: 'Loading',
                    spinner: 'el-icon-loading',
                    background: 'rgba(0, 0, 0, 0.7)'
                });
                getContentById({
                    id: this.$route.params.articleId
                }).then(res => {
                    this.markdown = res.data.articleContent
                    this.$nextTick(() => {
                        this.getNavigation();
                        loading.close();
                    })
                })
            },
            // 构造文件目录导航
            getNavigation(){
                const anchors = this.$refs.preview.$el.querySelectorAll('h1,h2,h3,h4,h5,h6');
                const titles = Array.from(anchors).filter((title) => !!title.innerText.trim());
                console.log(titles)
                if (!titles.length) {
                    this.titles = [];
                    return;
                }

                const hTags = Array.from(new Set(titles.map((title) => title.tagName))).sort();

                this.titles = titles.map((el) => ({
                    title: el.innerText,
                    lineIndex: el.getAttribute('data-v-md-line'),
                    indent: hTags.indexOf(el.tagName),
                }));

            },
            // 点击目录导航跳转方法
            handleAnchorClick(anchor) {

                const { preview } = this.$refs;
                const { lineIndex } = anchor;

                const heading = preview.$el.querySelector(`[data-v-md-line="${lineIndex}"]`);

                if (heading) {
                    preview.scrollToTarget({
                        target: heading,
                        scrollContainer: window,
                        top: 60,
                    });
                }
            },
        },
        mounted() {
            this.getData();
        }
    }
</script>

<style scoped>

</style>