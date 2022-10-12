<template>
  <div :class="classObj" class="app-wrapper">
    <div v-if="device === 'mobile' && sidebar === 'opened'" class="drawer-bg" @click="handleClickOutside" />
    <sidebar class="sidebar-container" />
    <div :class="{ hasTagsView: needTagsView }" class="main-container">
      <div :class="{ 'fixed-header': fixedHeader}">
        <navbar />
        <tags-view v-if="needTagsView" />
      </div>
      <view-port />
    </div>
  </div>
  <PasswordChangeDialog @onSuccess="handlePasswordChangeSuccess" />
</template>

<script>
import { Sidebar, Navbar, TagsView, ViewPort } from './components'
import PasswordChangeDialog from '@/views/system/components/PasswordChangeDialog.vue'

import { markRaw } from '@vue/reactivity'
import settings from '@/settings'
import ResizeMixin from './mixin/ResizeHandler'
import { mapState } from 'vuex'

export default {
  name: 'Layout',
  components: { Sidebar, Navbar, TagsView, ViewPort, PasswordChangeDialog },
  mixins: [ResizeMixin],
  computed: {
    ...mapState({
      sidebar: state => state.app.sidebar,
      device: state => state.app.device
    }),
    key() {
      return this.$route.fullPath
    },
    fixedHeader() {
      return settings.layout.fixedHeader
    },
    needTagsView() {
      return settings.layout.tagsView
    },
    classObj() {
      return {
        hideSidebar: this.sidebar === 'collapse',
        openSidebar: this.sidebar !== 'collapse',
        darkMode: this.$store.state.app.themeMode === 'dark',
        lightMode: this.$store.state.app.themeMode !== 'dark'
      }
    }
  },
  mounted() {
    // 系统判定用户必须修改密码
    const profile = this.$store.state.subscriber.profile
    const time = profile.params['PASSWORD_CREATE_TIME']
    const isInvalidTime = function() {
      if (!time) {
        return false
      }
      const timestamp = parseInt(time)
      // TODO 比较时间进行操作
      return true
    }
    if (!isInvalidTime(time)) {
      this.$store.dispatch('app/setPasswordDialogStatus', 'Force')
    }
  },
  methods: {
    decideComponent(component) {
      // 解决嵌套路由问题
      if (settings.useNestedRoute || (this.$route.meta && !this.$route.meta.nested)) {
        return markRaw(this.$route.matched[this.$route.matched.length - 1].components.default)
      } else {
        return component
      }
    },
    handleClickOutside() {
      this.$store.dispatch('app/closeSidebar')
    },
    handlePasswordChangeSuccess() {
      this.$store.dispatch('subscriber/updateProfile')
    }
  }
}
</script>

<style lang="scss" scoped>
@import "@/style/mixin.scss";
@import "@/style/variables.scss";

.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;

  &.mobile.openSidebar {
    position: fixed;
    top: 0;
  }
}

.drawer-bg {
  background: #000;
  opacity: 0.3;
  width: 100%;
  top: 0;
  height: 100%;
  position: absolute;
  z-index: 999;
}

.fixed-header {
  position: fixed;
  top: 0;
  right: 0;
  z-index: 9;
  width: calc(100% - #{$sideBarWidth});
  transition: width 0.28s;
}

.hideSidebar .fixed-header {
  width: calc(100% - #{$sideBarHiddenWidth})
}

.mobile .fixed-header {
  width: 100%;
}
</style>
