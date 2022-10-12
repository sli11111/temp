<template>
  <el-dropdown-item v-if="isCancelImpersonateEnabled">
    <span style="display:block; color: #ff4949" @click="handleCancelImpersonate">
      <svg-icon icon-class="spy" />
      终止扮演
    </span>
  </el-dropdown-item>
</template>

<script>
import { cancelImpersonate } from '@/api/system/users'
import { isEmpty } from '@/utils'
import { setToken } from '@/utils/framework'

export default {
  computed: {
    isCancelImpersonateEnabled() {
      const ticket = localStorage.getItem('impersonate_ticket')
      return !isEmpty(ticket)
    }
  },
  methods: {
    async handleCancelImpersonate() {
      try {
        const ticket = localStorage.getItem('impersonate_ticket')
        const { data } = await cancelImpersonate(ticket)
        setToken(data)
      } catch (e) {}
      localStorage.removeItem('impersonate_ticket')
      window.location.href = window.location.href.split('#')[0]
    }
  }
}
</script>
