<template>
    <div>
        <v-md-editor
        v-model="editorValue"
         :disabled-menus="[]"
         @upload-image="handleUploadImage"
        @save="saveData"
         height="800px">
        </v-md-editor>
    </div>
</template>

<script>
    import {uploadImg} from "@/api/article/articleImg/articleImgAPI";
    import {articleListURL} from "@/utils/BaseUtil.js";

    export default {
        name: 'mdEditor',
        data() {
            return {
                editorValue: this.content != null ? this.content : "",
            }
        },
        props: {
            // 接收值父组件传递值
            content: String
        },
        created() {
            console.log("--------加载md编辑器")
        },
        methods: {
            // v-md-editor 文件上传
            handleUploadImage(event, insertImage, files) {
                event.preventDefault()
                let formData = new FormData()
                formData.append('avatar', files[0])
                uploadImg(formData).then(res => {
                    insertImage({
                        url: articleListURL() + res.data,
                        desc: files[0].name
                    });
                })
            },
            saveData(text, html){
              console.log(html)
                this.$emit("saveData", text)
            }
        },
        watch: {
            editorValue: function (newNum, oldNum) {
              console.log(oldNum)
                // 修改调用者传入的值
                this.$emit('update:content', newNum)
            }
        },
    }
</script>

<style>
</style>