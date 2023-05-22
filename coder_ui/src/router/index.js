// 1.导入 vue 和 vue-router
import Vue from 'vue'
import VueRouter from 'vue-router'

// 首页组件
import indexPage from "@/views/indexPage";

// 任务列表组件
import todoIndex from "@/views/todoList/todoIndex";

// 文章组件
import articleIndex from "@/views/article/articleIndex";
import readerIndex from "@/components/article/reader/readerIndex";
import editorIndex from "@/components/article/editor/editorIndex";

// 2.调用 Vue.use()，把 VueRouter 安装为Vue插件
Vue.use(VueRouter)

// 3.创建路由实例对象
const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: "/",
      name: 'indexPage',
      component: indexPage
    },
    {
      path: "/taskTodo",
      name: 'taskTodo',
      component: todoIndex
    },

    // 文章管理
    {
      path: "/articleIndex",
      name: 'articleIndex',
      component: articleIndex
    },
    {
      path: "/editorIndex",
      name: 'editorIndex',
      component: editorIndex
    },
    {
      path: "/readerIndex",
      name: 'readerIndex',
      component: readerIndex
    },

  ]
});

// 4.共享路由的实例对象
export default router