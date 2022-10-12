<template>
  <el-dropdown-item>
    <span style="display:block;" @click="showChangePasswordForm">
      <svg-icon icon-class="key" />
      修改密码
    </span>
  </el-dropdown-item>
</template>

<script>
export default {
  methods: {
    showChangePasswordForm() {
      this.$store.dispatch('app/setPasswordDialogStatus', 'Active')
    }
  }
}
</script>
