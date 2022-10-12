<template>
  <el-dialog v-model="visible" width="320px" :close-on-click-modal="!closable" :show-close="closable" :before-close="clearForm">
    <template #title>
      <svg-icon icon-class="key" />
      修改密码
    </template>
    <el-alert v-if="$store.state.app.passwordDialog === 'Force'" title="系统提示" type="error" effect="dark" style="margin-bottom: 10px;">
      您的密码已过期或为初始密码，必须修改后才能继续使用本系统！
    </el-alert>
    <el-form :model="form" ref="form" :rules="rules">
      <el-form-item prop="password_old">
        <el-input v-model="form.password_old" type="password" placeholder="请输入旧密码" />
      </el-form-item>
      <el-form-item prop="password_new">
        <el-input v-model="form.password_new" type="password" placeholder="请输入新密码" @keyup="handleNewPasswordChange" />
        <el-progress :percentage="password_score" :status="password_status" :show-text="false" style="width: 100%" />
      </el-form-item>
      <el-form-item prop="password_repeat">
        <el-input v-model="form.password_repeat" type="password" placeholder="请再次输入新密码" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button :loading="submitting" type="primary" style="width: 100%;" @click="handleSubmit">提交</el-button>
    </template>
  </el-dialog>
</template>

<script>
import settings from '@/settings.js'

import { changePassword } from '@/api/subscriber.js'

const config = settings.system.password
const encrypt = (function(){
  if (typeof config.encrypt === 'function') {
    return config.encrypt
  }
  return a => { return a }
})()

export default {
  emits: ['onSuccess'],
  data() {
    const that = this
    const validateNewPassword = function(rule, value, callback) {
      if (value === that.form.password_old) {
        callback(new Error(`新旧密码不能相同`))
        return
      }
      if (!value || value.leghth >= config.minLength) {
        callback(new Error(`密码必须大于 ${config.minLength} 位`))
        return
      }
      if (that.password_score < settings.system.password.minPasswordScore) {
        callback(new Error('密码强度不足：必须包含字母、数字和特殊符号'))
        return
      }
      callback()
    }
    const validateRepeatPassword = function(rule, value, callback) {
      if (that.form.password_new !== value) {
        callback(new Error('两次输入新密码不一致'))
        return
      }
      callback()
    }
    return {
      password_score: 0,
      form: {
        password_old: '',
        password_new: '',
        password_repeat: ''
      },
      rules: {
        password_old: [
          { required: true, message: '必须输入', trigger: 'blur', }
        ],
        password_new: [
          { required: true, message: '必须输入', trigger: 'blur', },
          { validator: validateNewPassword, trigger: 'blur' }
        ],
        password_repeat: [
          { required: true, message: '必须输入', trigger: 'blur', },
          { validator: validateRepeatPassword, trigger: 'blur' }
        ]
      },
      submitting: false
    }
  },
  computed: {
    visible() {
      return this.$store.state.app.passwordDialog !== 'Deactive' 
    },
    closable() {
      return this.$store.state.app.passwordDialog !== 'Force' 
    },
    password_score_name() {
      if (this.password_score === 100) {
        return '强'
      } 
      if (this.password_score === 66) {
        return '中'
      }
      if (this.password_score === 33) {
        return '弱'
      }
      return ''
    },
    password_status() {
      if (this.password_score === 100) {
        return 'success'
      } 
      if (this.password_score === 66) {
        return 'warning'
      }
      if (this.password_score === 33) {
        return 'exception'
      }
      return ''
    }
  },
  methods: {
    clearForm() {
      this.$refs.form.resetFields()
      this.password_score = 0
      this.$store.dispatch('app/setPasswordDialogStatus', 'Deactive')
    },
    handleNewPasswordChange() {
      if (this.form.password_repeat) {
        this.$refs.form.validateField('password_repeat')
      }
      if (config.strongRegexp.test(this.form.password_new)) {
        this.password_score = 100
        return
      }
      if (config.mediumRegexp.test(this.form.password_new)) {
        this.password_score = 66
        return
      }
      if (config.weekRegexp.test(this.form.password_new)) {
        this.password_score = 33
        return
      }
      this.password_score = 0
    },
    handleSubmit() {
      this.$refs.form.validate(async (valid) => {
        if (valid) {
          this.submitting = true
          try {
            const data = {
              password: encrypt(this.form.password_old),
              newPassword: encrypt(this.form.password_new)
            }
            await changePassword(data)
            this.$store.dispatch('app/setPasswordDialogStatus', 'Deactive')
            this.$message({
              message: this.$t('密码修改成功'),
              type: 'success',
              duration: 1500
            })
            this.$emit('onSuccess')
          } catch(e) {
            console.log(e)
          }
          this.submitting = false
        } 
      })
    }
  }
}
</script>
