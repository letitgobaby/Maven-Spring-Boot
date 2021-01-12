<template>
  <div class="login">
    <el-card class="login-card">
      <div slot="header">
        <span>Misolab's Admin</span>
        <div class="pull-right">
          <a target="_blank" href="https://www.github.com/misolab">@Misolab</a>
        </div>
      </div>
      <div class="login-form">
        <el-form :model="formValues" status-icon :rules="rules" ref="loginForm">
          <el-form-item prop="username">
            <el-input
              type="text"
              placeholder="input username"
              v-model="formValues.username"
              autocomplete="off">
              <template slot="prepend">Username</template>
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              type="password"
              placeholder="input password"
              v-model="formValues.password"
              autocomplete="off">
              <template slot="prepend">Password</template>
            </el-input>
          </el-form-item>
          <el-form-item class="pull-right">
            <el-button @click="resetForm('loginForm')">Cancel</el-button>
            <el-button type="primary" @click="submitForm('loginForm')">Login</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<style lang="scss" scoped>
.login {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;

  .login-card {
    width: 480px;
    margin-bottom: 100px;

    .el-form-item {
      margin-bottom: 36px;

      & /deep/ .el-form-item__error {
        left: auto;
        right: 0;
      }
    }
  }
}
</style>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'login',

  data() {
    return {
      formValues: {
        username: '',
        password: ''
      },

      rules: {
        username: [
          { required: true, message: 'Input Username', trigger: 'blur' }
        ],
        password: [
          { required: true, message: 'Input Password', trigger: 'blur' }
        ]
      }
    }
  },

  methods: {
    ...mapActions(['Login']),

    login() {
      return this.Login(this.formValues)
        .then(() => {
          this.$notify.success({
            duration: 1000,
            title: 'ok',
            message: '로그인 성공'
          })

          this.$router.push('/')
        })
        .catch((err) => {
          this.$notify.error({
            title: 'fail',
            message: err.message || '로그인 실패'
          })
        })
    },

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.login()
        } else {
          return false
        }
      })
    },

    resetForm(formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
