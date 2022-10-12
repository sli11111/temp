<template>
  <div style="padding: 2px 15px;" @click="toggleClick">
    <svg-icon :icon-class="'hamburger-' + (isActive ? 'on' : 'off')" width="64" height="64" />
  </div>
</template>

<script>
export default {
  name: 'Hamburger',
  props: {
    isActive: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    toggleClick() {
      this.$emit('toggleClick')
    }
  }
}
</script>

<style scoped>
.hamburger {
  display: inline-block;
  vertical-align: middle;
  width: 20px;
  height: 20px;
}

/* .hamburger.is-active {
  transform: rotate(180deg);
} */
</style>
