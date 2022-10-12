<template>
  <el-tooltip
    v-if="enableFullScreen"
    :content="$t('common.fullscreen')"
    effect="dark"
    placement="bottom"
  >
    <div class="right-menu-item hover-effect">
      <svg-icon
        :icon-class="isFullScreen ? 'fullscreen-exit' : 'fullscreen'"
        @click="handleToggleFullScreen"
      />
    </div>
  </el-tooltip>
</template>

<script>
import screenfull from 'screenfull'
import settings from '@/settings'

export default {
  name: 'FullScreen',
  data() {
    return {
      isFullScreen: false
    }
  },
  computed: {
    enableFullScreen() {
      return settings.layout.enableFullScreen && screenfull.enabled
    }
  },
  mounted() {
    this.init()
  },
  beforeUnmount() {
    this.destroy()
  },
  methods: {
    handleToggleFullScreen() {
      if (!screenfull.enabled) {
        this.$message({
          message: '您的浏览器禁止全屏',
          type: 'warning'
        })
        return false
      }
      screenfull.toggle()
    },
    change() {
      this.isFullScreen = screenfull.isFullscreen
    },
    init() {
      if (screenfull.enabled) {
        screenfull.on('change', this.change)
      }
    },
    destroy() {
      if (screenfull.enabled) {
        screenfull.off('change', this.change)
      }
    }
  }
}
</script>
