import { createRouter, createWebHashHistory } from 'vue-router'
import Layout from '@/layout/index.vue'
import { deepClone } from '@/utils'
import { getToken } from '../utils/framework'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import store from '@/store'
import settings from '@/settings'
import i18n from '@/i18n'

// routes scanned from modules folder
const scannedRoutes = []
const moduleFiles = import.meta.globEager('./modules/*.js')
for (const moduleFileName in moduleFiles) {
  const module = moduleFiles[moduleFileName]
  const moduleName = moduleFileName.replace(/^\.\/(.*)\.\w+$/, '$1').replace('modules/', '')
  const target = module.default
  if (Array.isArray(target)) {
    for (const route of target) {
      scannedRoutes.push(route)
    }
  } else {
    scannedRoutes.push(target)
  }
  console.log(`[Sancho] Route module loaded: ${moduleName}`)
}

// routes must exist
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index.vue')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index.vue'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404.vue'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401.vue'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/blank.vue'),
        name: 'Dashboard',
        isMenu: true,
        isAnon: true,
        meta: { title: 'common.menus.Dashboard', icon: 'home', affix: true, noCache: true }
      }
      // dashboardRoute()
    ]
  },
  {
    path: '/demo',
    component: Layout,
    children: [
      {
        path: 'vue-json-parser',
        component: () => import('@/views/demo/VueJsonParser/index.vue'),
        hidden: true,
        meta: { title: 'demo.menus.vue-json-parser', icon: 'finance' }
      }
    ]
  }
]

// routes will be filtered
export const dynamicRoutes = [
  ...scannedRoutes,
  // mismatched route all goes to 404
  { path: '/:pathMatch(.*)*', redirect: '/404', hidden: true }
]

const router = createRouter({
  history: createWebHashHistory(),
  scrollBehavior: () => ({ left: 0 }),
  routes: deepClone([...constantRoutes, ...dynamicRoutes])
})

const whiteList = ['/login', '/auth-redirect']
router.beforeEach(async(to, from, next) => {
  try {
    NProgress.start()

    const token = getToken()

    if (token) {
      console.log(`[Sancho] Token fetched by router: ${token}`)
      if (to.path === '/login') {
        // if is logged in, redirect to the home page
        next({ path: '/' })
      } else {
        // determine whether the user has obtained his permission roles through getInfo
        let profile = store.state.subscriber.profile
        if (profile) {
          next()
        } else {
          try {
            await store.dispatch('subscriber/updateProfile')
          } catch(error) {
            await store.dispatch('subscriber/logout')
            next(`/login`)
            return
          }
          
          // Fetch Remote Menus
          const remoteRoutes = []
          // const { data } = await fetchMenus()
          // remoteRoutes.push(...parseMenus2Routes(data))
          const routes = deepClone([...constantRoutes, ...remoteRoutes, ...dynamicRoutes])
          // Update Routes
          const accessibleRoutes = await store.dispatch('subscriber/updateRoutes', routes)

          for (const route of accessibleRoutes) {
            router.addRoute(route)
          }
          router.addRoute({ path: '/:pathMatch(.*)*', redirect: '/404', hidden: true })

          // hack method to ensure that addRoutes is complete
          // set the replace: true, so the navigation will not leave a history record
          next({ ...to, replace: true })
        }
      }
    } else {
      if (whiteList.indexOf(to.path) >= 0) {
        next()
      } else {
        next(`/login?redirect=${to.path}`)
      }
    }
  } catch(e) {
    console.error('Error handling before route: ', e)
  }
})

router.afterEach(async (r) => {
  let title = window.$settings && window.$settings['SYSTEM_TITLE'] ? window.$settings['SYSTEM_TITLE'] : settings.title
  try {
    if (r.meta) {
      if (r.meta.getTitle && typeof r.meta.getTitle === 'function') {
        title = await r.meta.getTitle(r)
      } else {
        title = title += (r.meta.title ? ' - ' + i18n.global.t(r.meta.title) : '')
      }
    }
    // do something
  } catch(e) {
    console.error('Error handling after route: ', e)
  }
  NProgress.done()
  document.title = title
})

export default router
