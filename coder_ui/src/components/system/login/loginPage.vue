<template>
  <div class="login-container">
    <h1>用户登录</h1>
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="username">用户名</label>
        <input type="text" id="username" v-model="username" required>
      </div>
      <div class="form-group">
        <label for="password">密码</label>
        <input type="password" id="password" v-model="password" required>
      </div>
      <button type="submit">登录</button>
    </form>
  </div>
</template>

<script>
  import {goDocumentByObj} from "@/utils/RouterUtil";

  export default {
    name: 'loginPage',
    data() {
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      handleSubmit() {
        // 这里编写提交表单的代码，例如调用服务器接口进行验证等
        console.log('用户名：', this.username)
        console.log('密码：', this.password)
        // 跳转到首页
        goDocumentByObj('indexPage', null)

      }
    }
  }
</script>

<style scoped>
  .login-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #f0f3f4;
  }

  .form-group {
    margin-bottom: 10px;
  }

  label {
    display: block;
    margin-bottom: 5px;
  }

  input[type="text"],
  input[type="password"] {
    width: 200px;
    padding: 7px;
    border: none;
    border-radius: 3px;
    box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.2);
  }

  button {
    margin-top: 20px;
    padding: 10px 20px;
    border: none;
    border-radius: 3px;
    background-color: #3498db;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
  }
</style>