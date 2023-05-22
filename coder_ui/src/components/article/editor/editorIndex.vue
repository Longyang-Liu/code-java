<template>
    <div>
        <el-form ref="form" :model="form" label-width="5rem" :rules="rules">
                <el-row>
                    <el-form-item label="标题" prop="articleTitle">
                        <el-input v-model="form.articleTitle" placeholder="请输入文章标题" maxlength="128" show-word-limit></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="简述" prop="articleDescription">
                        <el-input type="textarea" v-model="form.articleDescription" placeholder="请输入描述" maxlength="255" show-word-limit></el-input>
                    </el-form-item>
                </el-row>
        </el-form>
        <MdEditor @saveData="saveData" :content.sync="form.articleContent" v-if="initSuccess"></MdEditor>
    </div>
</template>

<script>
    import {insertDetail} from "@/api/article/articleInfo/articleInfoAPI";
    import {getDetailById, updateDetail} from "@/api/article/articleInfo/articleInfoAPI";

    export default {
        name: "editorIndex",
        data(){
            return{
                initSuccess: false,
                // 表单
                form: {
                    id: null,
                    articleTitle: null,
                    articleDescription: null,
                    articleContent: null,
                },
                // 表单规则
                rules:{
                    articleTitle: [
                        { required: true, message: '请输入文章标题', trigger: 'blur' },
                    ],
                    articleDescription: [
                        { required: true, message: '请输入描述', trigger: 'blur' },
                    ],
                }
            }
        },
        methods:{
            // 保存方法
            saveData(text){
                this.$refs.form.validate((valid) => {
                    if (valid) {
                        const loading = this.$loading({
                            lock: true,
                            text: 'Loading',
                            spinner: 'el-icon-loading',
                            background: 'rgba(0, 0, 0, 0.7)'
                        });
                        if(this.form.articleId != null || this.form.id != null){
                            updateDetail(this.form).then(() => {
                                this.$message({
                                    showClose: true,
                                    type: 'success',
                                    message: '已更新'
                                })
                                loading.close();
                            })
                        }else{
                            insertDetail({
                                articleTitle: this.form.articleTitle,
                                articleContent: text,
                                articleDescription: this.form.articleDescription
                            }).then(res => {
                                console.log(res)
                                if(res.status == 200){
                                    this.$message({
                                        showClose: true,
                                        type: 'success',
                                        message: '已发布'
                                    })
                                    this.form.articleId = res.data;
                                    this.form.articleContent = res.text;
                                    loading.close();
                                }
                            })
                        }


                    }
                });
            },
            // 获取数据
            getData(){
                if(this.$route.params.articleId != null){
                    const loading = this.$loading({
                        lock: true,
                        text: 'Loading',
                        spinner: 'el-icon-loading',
                        background: 'rgba(0, 0, 0, 0.7)'
                    });
                    getDetailById({
                        id: this.$route.params.articleId
                    }).then(res => {
                        this.form = res.data
                        console.log(res.data)
                        this.initSuccess = true;
                        loading.close();
                    })
                }else{
                    this.initSuccess = true;
                }

            }
        },
        mounted() {
            this.getData();
        },
    }
</script>

<style scoped>

</style>