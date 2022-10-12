<template>
  <el-button class="right-menu-item hover-effect" type="text" trigger="click" @click="toggleThemeMode">
    <svg-icon :icon-class="'theme-' + themeMode" />
  </el-button>
</template>

<script>
export default {
  name: 'ThemeSwitcher',
  computed: {
    themeMode() {
      return this.$store.state.app.themeMode
    }
  },
  mounted() {
    this.renderTheme()
  },
  methods: {
    toggleThemeMode() {
      this.$store.dispatch('app/toggleThemeMode')
      this.renderTheme()
    },
    renderTheme() {
      this.loadTheme()
      document.body.className = this.$store.state.app.themeMode + 'Mode'
    },
    getThemeFile() {
      return new Promise((resolve, reject) => {
        const client = new XMLHttpRequest()
        client.responseType = ''
        client.onreadystatechange = () => {
          if (client.readyState !== 4) {
            return 
          }
          if (client.status === 200) {
            resolve({
              data: client.response
            })
          }
        }
        client.open('GET', './styles/theme-' + this.themeMode + '.css')
        client.send()
      })
    },
    loadTheme() {
      this.getThemeFile().then(({ data }) => {
        const style = document.createElement('style')
        style.innerText = data
        document.head.appendChild(style)
      })
    }
  }
}
</script>
