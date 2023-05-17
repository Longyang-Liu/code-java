import Vue from 'vue'
import App from './App.vue'

// 1.导入路由模块
// import router from '@/router'

Vue.config.productionTip = false

/** ElementUI BEGIN */
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI, { size: 'small', zIndex: 3000 });
/** ElementUI END */


new Vue({
  render: h => h(App),
  // 2.挂载路由模块
  // router: router
}).$mount('#app')
