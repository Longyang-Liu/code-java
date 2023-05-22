// 1.导入 vue 和 vue-router
import Vue from 'vue'
import VueRouter from 'vue-router'

// 首页组件
import indexPage from "@/views/indexPage";

// 任务列表组件
import todoIndex from "@/views/todoList/todoIndex";

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

  ]
});

// 4.共享路由的实例对象
export default router