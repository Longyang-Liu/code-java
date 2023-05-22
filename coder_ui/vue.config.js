const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  // devServer 相关配置
  devServer: {
    port: 8848, // 指定端口号，默认是8080
    open: false, // 是否自动在浏览器中打开页面
  }

})
