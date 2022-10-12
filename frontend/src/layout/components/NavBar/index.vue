<template>
  <div class="navbar">
    <hamburger
      id="hamburger-container"
      :is-active="sidebar !== 'collapse'"
      class="hamburger-container"
      @toggleClick="toggleSidebar"
    />
    <breadcrumb
      id="breadcrumb-container"
      class="breadcrumb-container"
    />
    <div id="global-sub-function-slot" style="display: inline-block; font-size: 14px; line-height: 50px; margin-left: 8px;"></div>
    <div class="right-menu">
      <template v-if="device!=='mobile'">
        <component :is="$key" v-for="(tool, $key) in tools" :key="$key" />
      </template>
      <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
        <div class="avatar-wrapper">
          <img
            v-if="avatar"
            :src="avatar+'?imageView2/1/w/80/h/80'"
            class="user-avatar"
          >
          <el-avatar
            v-else
            :class="'user-avatar' + (isCancelImpersonateEnabled ? ' impersonate' : '')"
          >
            <svg-icon
              v-if="!isCancelImpersonateEnabled"
              icon-class="male"
            />
            <svg-icon
              v-if="isCancelImpersonateEnabled"
              icon-class="spy"
            />
          </el-avatar>
          <!-- <el-icon><caret-bottom /></el-icon> -->
        </div>
        <template #dropdown>
          <el-dropdown-menu class="sancho-user-menu">
            <component :is="$key" v-for="(action, $key) in actions" :key="$key" />
            <el-divider style="margin: 0px;"></el-divider>
            <el-dropdown-item>
              <span style="display:block;" @click="logout">
                <svg-icon icon-class="quit-o" />
                {{ $t('common.logout') }}
              </span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import settings from '@/settings'
import Breadcrumb from './Breadcrumb.vue'
import Hamburger from './Hamburger.vue'
import { tools, actions } from './loader.js'
import { getBaseUrl } from '@/utils/request.js'
import { isEmpty } from '@/utils'

export default {
  components: { Breadcrumb, Hamburger, ...tools, ...actions },
  data() {
    return {
      tools,
      actions,
      avatar: null
    }
  },
  computed: {
    sidebar() {
      return this.$store.state.app.sidebar
    },
    device() {
      return this.$store.state.app.device
    },
    isCancelImpersonateEnabled() {
      const ticket = localStorage.getItem('impersonate_ticket')
      return !isEmpty(ticket)
    }
  },
  mounted() {
    console.log(tools)
    // this.$nextTick(() => {
    //   this.$store.dispatch('app/navbarReady')
    // })
  },
  methods: {
    toggleSidebar() {
      this.$store.dispatch('app/toggleSidebar')
    },
    logout() {
      this.$store.dispatch('subscriber/logout')
      setTimeout(function() {
        window.location = `${window.location.protocol}//${window.location.host}${window.location.pathname}`
      }, 1000)
    }
  }
}
</script>

<style lang="scss">
@import "@/style/mixin.scss";
@import "@/style/variables.scss";

.sancho-user-menu {
  .el-dropdown-menu__item {
    padding: 0 15px;
    text-align: left;
  }
}

.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  // box-shadow: 0 1px 4px rgba(0,21,41,.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: .3s;
    -webkit-tap-highlight-color:transparent;

    &:hover {
      // background: rgba(0, 0, 0, .025)
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 10px;
      height: 100%;
      font-size: 18px;
      line-height: 50px;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: .3s;

        // &:hover {
        //   background: rgba(0, 0, 0, .025)
        // }
      }
    }

    .right-menu-divider {
      display: inline-block;
      height: 60%;
      vertical-align: super;
    }

    .avatar-container {
      margin-right: 30px;

      .avatar-wrapper {
        margin-top: 0px;
        position: relative;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;

           &.impersonate {
             background-color: #ff4949;
           }
        }

        .el-icon {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
  }
}
</style>
