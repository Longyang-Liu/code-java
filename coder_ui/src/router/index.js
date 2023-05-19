// 1.导入 vue 和 vue-router
import Vue from 'vue'
import VueRouter from 'vue-router'

import todoIndex from "@/views/todoList/todoIndex";

// 2.调用 Vue.use()，把 VueRouter 安装为Vue插件
Vue.use(VueRouter)

// 3.创建路由实例对象
const router = new VueRouter({
  mode: 'history',
  routes: [

    {
      path: "/todo",
      name: 'todo',
      component: todoIndex
    },
    {
      path: "/todo1",
      name: 'todo1',
      component: todoIndex
    },

  ]
});

// 4.共享路由的实例对象
export default router