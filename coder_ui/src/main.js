import Vue from 'vue'
import App from './App.vue'

// 1.导入路由模块
import router from '@/router'

Vue.config.productionTip = false

/* v-md-editor 编辑器 start  */
/* 1、v-md-editor 基础引用  */
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import Prism from 'prismjs';
VueMarkdownEditor.use(vuepressTheme, {
  Prism,
});
/* 2、v-md-editor 代码块关键字高亮  */
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
// 引入所有语言包
import hljs from 'highlight.js';
VueMarkdownEditor.use(githubTheme, {
  Hljs: hljs,
});
Vue.use(VueMarkdownEditor);
/* 3、v-md-editor 二次封装  */
import mdEditor from '@/components/article/v-md-editor/index';
Vue.component('MdEditor', mdEditor);

/** 引入预览组件 */
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
import '@kangc/v-md-editor/lib/theme/style/github.css';

VMdPreview.use(githubTheme, {
  Hljs: hljs,
});
Vue.use(VMdPreview);
/* v-md-editor 编辑器 end  */



/** ElementUI BEGIN */
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI, { size: 'small', zIndex: 3000 });
/** ElementUI END */



new Vue({
  render: h => h(App),
  // 2.挂载路由模块
  router: router
}).$mount('#app')
