<template>
  <div class="app-container" :style="{'min-height': this.height + 'px', height: height + 'px', overflow: 'auto'}">
    <slot />
  </div>
</template>

<script>
export default {
  name: 'AutoHeightContainer',
  data() {
    return {
      height: 700
    }
  },
  mounted() {
    this.handleResize()
  },
  activated() {
    this.handleResize()
  },
  watch: {
    '$store.state.app.windowInnerHeight': {
      handler: 'handleResize',
      immediate: true
    }
  },
  methods: {
    handleResize() {
      this.height = window.innerHeight - 95
    },
  }
}
</script>
