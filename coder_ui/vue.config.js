const { defineConfig } = require('@vue/cli-service')

const baseUrl = "http://127.0.0.1"

module.exports = defineConfig({
  transpileDependencies: true,

  // devServer 相关配置
  devServer: {
    port: 8848, // 指定端口号，默认是8080
    open: false, // 是否自动在浏览器中打开页面

    proxy: {
      ['/task']: {
        // 使用环境变量中的值
        target: baseUrl + ':1000', //服务端接口地址
        changeOrigin: true,
        pathRewrite: {
          '^/task': '',
        },
      },
      ['/article']: {
        // 使用环境变量中的值
        target: baseUrl + ':2345', //服务端接口地址
        changeOrigin: true,
        pathRewrite: {
          '^/article': '',
        },
      },
    },
  },


})
