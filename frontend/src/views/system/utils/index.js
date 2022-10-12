import $lodash from 'lodash'
import settings from '@/settings'
import { dynamicRoutes } from '@/router'
import { deepClone } from '@/utils'
import { fetchMenus } from '@/api/system/menus'
import { fetchPermissions } from '@/api/system/permissions'

import { filterRoutes, filterMenus } from '@/utils/framework.js'

export async function getMenus() {
  let menu_list = []
  if (settings.system.menu.mode === 'frontend') {
    const routes = filterRoutes(deepClone(dynamicRoutes), { perms: ['SUPER_ADMIN'] })
    menu_list = filterMenus(routes)
  }
  if (settings.system.menu.mode === 'backend') {
    const { data } = await fetchMenus()
    menu_list = data
  }
  return new Promise((resolve) => {
    resolve(menu_list)
  })
}

export async function getAllMenus() {
  let menu_list = []
  if (settings.system.menu.mode === 'frontend') {
    const routes = filterMenus(deepClone(dynamicRoutes))
    menu_list = filterMenus(routes)
  }
  if (settings.system.menu.mode === 'backend') {
    const { data } = await fetchMenus()
    menu_list = data
  }
  return new Promise((resolve) => {
    resolve(menu_list)
  })
}

export async function getPermissions() {
  let perm_list = []
  if (settings.system.perm.mode === 'frontend' || settings.system.perm.mode === 'mixed') {
    perm_list = $lodash.union(perm_list, [])
  }
  if (settings.system.perm.mode === 'backend' || settings.system.perm.mode === 'mixed') {
    const { data } = await fetchPermissions()
    perm_list = $lodash.union(perm_list, data.datalist)
  }
  return new Promise((resolve) => {
    resolve(perm_list)
  })
}