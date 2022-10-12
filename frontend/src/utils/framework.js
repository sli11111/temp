import Cookies from 'js-cookie'
import settings from '@/settings'
import store from '@/store'
import i18n from '@/i18n'

const SESSION_STORAGE_KEYS = {
  THEME_MODE: 'sancho-theme-mode',
  LOCALE: 'sancho-locale',
  SIDEBAR_STATE: 'sancho-sidebar-state',
  TOKEN: 'sancho-token',
  SIZE: 'sancho-size'
}

export const SESSION_STORAGE = SESSION_STORAGE_KEYS

export const SUPER_ADMIN = 'SUPER_ADMIN'

export function setLocale(val) {
  window.sessionStorage.setItem(SESSION_STORAGE_KEYS.LOCALE, val.toLowerCase())
}

// session > auto > default > other
export function getInitialThemeMode() {
  let val = window.sessionStorage.getItem('sancho-theme-mode')
  if (!val) {
    if (settings.theme.enableAutoThemeModeDetect && window.matchMedia) {
      val = window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'
    } else {
      val = settings.theme.defaultThemeMode
    }
  }
  return val.toLowerCase()
}

// session > settings > default > other
export function getInitialSidebarState() {
  let val = window.sessionStorage.getItem('sancho-sidebar-state')
  if (!val) {
    val = settings.layout && settings.layout.collapseSidebar ? 'collapse' : 'opened'
    window.sessionStorage.setItem('sancho-sidebar-state', val)
  }
  return val
}

// session > settings > default > other
export function getInitialSize() {
  let val = window.sessionStorage.getItem('sancho-size')
  if (!val) {
    val = settings.layout && settings.layout.size ? settings.layout.size : 'small'
    window.sessionStorage.setItem('sancho-size', val)
  }
  return val
}

const sizes = ['small', 'default', 'large']
export function getSize(offset) {
  const currentSize = store.state.app.size
  let currentSizeIndex = 0
  for (let i = 0; i < sizes.length; i++) {
    if (sizes[i] === currentSize) {
      currentSizeIndex = i
      const targetIndex = currentSizeIndex + offset
      if (targetIndex < 0) {
        return sizes[0]
      } else if (targetIndex > sizes.length - 1) {
        return sizes[sizes.length - 1]
      } else {
        return sizes[targetIndex]
      }
    }
  }
  return currentSize
}

export function getToken() {
  switch (settings.security.tokenStrategy) {
    case 'header':
      return window.sessionStorage.getItem('sancho-token')
    case 'cookie':
    default:
      return Cookies.get(settings.security.tokenKey.cookie)
  }
}

export function setToken(token) {
  switch (settings.security.token_strategy) {
    case 'header':
      window.sessionStorage.setItem(SESSION_STORAGE_KEYS, token)
      break
    case 'cookie':
    default:
      document.cookie = `${settings.security.tokenKey.cookie}=${token}; path=./`
      break
  }
}

export function removeToken() {
  switch(settings.security.tokenStrategy) {
    case 'header':
      window.sessionStorage.removeItem('sancho-token')
      break
    case 'cookie':
    default:
      Cookies.remove(settings.security.tokenKey.cookie)
      break
  }
}

export function hasPermission(actionKey) {
  const perms = store.state.subscriber.perms

  if (!actionKey || perms.includes(SUPER_ADMIN)) {
    return true
  }

  // if (actionKey === IP_RESTRAINED) {
  //   // TODO
  //   return false
  // } else {
    return perms.includes(actionKey)
  // }
}

export function filterRoutes(routes, { perms }) {
  const res = []

  routes.forEach(route => {
    const tmp = { ...route }

    if (!(tmp.isMenu) || (tmp.isMenu && hasPermission(tmp.meta ? tmp.meta.title : '_' )) || tmp.isAnon) {
      if (tmp.children) {
        tmp.children = filterRoutes(tmp.children, { perms })
      }
      res.push(tmp)
    }
  })

  return res
}

export function filterMenus(routes) {
  const res = []

  routes.forEach(route => {
    const tmp = { ...route }
    tmp.id = tmp.meta && tmp.meta.title ? tmp.meta.title : tmp.path
    tmp.name = i18n.global.t(tmp.meta && tmp.meta.title ? tmp.meta.title : tmp.path)

    if (tmp.children) {
      tmp.children = filterMenus(tmp.children)
    }

    if (tmp.isMenu || tmp.path === 'dashboard') {
      res.push(tmp)
    } else if (tmp.children) {
      tmp.children.forEach(tmpChild => {
        if (tmpChild.isMenu || tmpChild.path === 'dashboard') {
          res.push(tmpChild)
        }
      })
    }
  })

  return res
}
