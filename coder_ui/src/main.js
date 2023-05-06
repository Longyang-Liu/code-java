import Vue from 'vue'
import App from './App.vue'


Vue.config.productionTip = false

/** ElementUI BEGIN */
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI, { size: 'small', zIndex: 3000 });
/** ElementUI END */


new Vue({
  render: h => h(App),
}).$mount('#app')
