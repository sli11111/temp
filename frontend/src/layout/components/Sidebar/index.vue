<template>
  <div :class="{'has-logo':showLogo}">
    <logo
      v-if="showLogo"
      :collapse="isCollapse"
    />
    <el-scrollbar wrap-class="scrollbar-wrapper">
      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        :background-color="variables.menuBg"
        :text-color="variables.menuText"
        :unique-opened="false"
        :active-text-color="variables.menuActiveText"
        :collapse-transition="false"
        mode="vertical"
      >
        <sidebar-item
          v-for="route in menus"
          :key="route.path"
          :item="route"
          :base-path="route.path"
        />
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import Logo from './Logo.vue'
import SidebarItem from './SidebarItem.vue'
import variables from '@/style/variables.scss'
import { deepClone } from '@/utils'

export default {
  components: { Logo, SidebarItem },
  computed: {
    // ...mapGetters([
    //   'sidebar',
    //   'menus'
    // ]),
    // ...mapState({
    //   'routes': state => state.subscriber.routes,
    // }),
    menus() {
      const menus = []
      const routes = deepClone(this.$store.state.subscriber.routes)
      routes.forEach(route => {
        if (route.isMenu || route.path === 'dashboard') {
          menus.push(route)
        } else if (route.children) {
          for (const croute of route.children) {
            if (croute.isMenu || croute.isAnon) {
              menus.push(croute)
            }
          }
        }
      })
      return menus
    },
    activeMenu() {
      const route = this.$route
      const { meta, path } = route
      // if set path, the sidebar will highlight the path you set
      if (meta.activeMenu) {
        return meta.activeMenu
      }
      return path
    },
    showLogo() {
      return true
    },
    variables() {
      return variables
    },
    isCollapse() {
      return this.$store.state.app.sidebar === 'collapse'
    }
  }
}
</script>
