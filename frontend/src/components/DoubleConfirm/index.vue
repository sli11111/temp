<template>
  <el-dialog v-model="visiable" width="30%" :before-close="handleCancel">
    <template #title>
      <el-icon><warning /></el-icon> {{ title }}
    </template>
    <span style="font-size: 14px">
      {{ text_hint }}
    </span>
    <p style="font-weight: 800; margin-bottom: 5px;">请输入以下内容以确认：<span style="color: #F56C6C;">{{ text_confirm }}</span></p>
    <el-input v-model="input" size="small" placeholder="请输入红色的文字"></el-input>
    <template #footer>
      <span class="dialog-footer">
        <el-button :disabled="loading" size="small" @click="handleCancel">取 消</el-button>
        <el-button type="primary" :loading="loading" size="small" :disabled="text_confirm && input !== text_confirm" @click="handleConfirm">确 定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
export default {
  name: 'DoubleConfir',
  props: {
    title: {
      type: String,
      default: '提示'
    }
  },
  data() {
    return {
      visiable: false,
      loading: false,
      input: '',
      text_hint: '',
      text_confirm: '',
      callback: async function() {
        // do nothing
      }
    }
  },
  methods: {
    confirm(options) {
      this.input = ''
      this.text_hint = options.hintText || ''
      this.text_confirm = options.confirmText || ''
      this.callback = options.callback || null
      this.visiable = true
    },
    handleCancel() {
      this.visiable = false
      this.loading = false
      this.input = ''
    },
    async handleConfirm() {
      try {
        this.loading = true
        if (this.callback) {
          await this.callback()
        }
        this.visiable = false
        this.input = ''
      } catch(e) {
        // do nothing
      }
      this.loading = false
    }
  }
}
</script>
