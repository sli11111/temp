import Layout from '@/layout/index.vue'

export default {
  path: '/system',
  component: Layout,
  isMenu: true,
  redirect: 'noRedirect',
  meta: { title: 'system.menus.system', icon: 'cogs', noCache: true },
  children: [
    {
      path: 'calendar',
      component: () => import('@/views/system/Calendar.vue'),
      isMenu: true,
      meta: { title: 'system.menus.calendar', icon: 'calendar', noCache: true, },
    },
    {
      path: 'subscriber',
      component: () => import('@/views/system/Subscriber.vue'),
      isMenu: true,
      meta: { title: 'system.menus.subscriber', icon: 'user', noCache: true, },
    },
    {
      path: 'role',
      component: () => import('@/views/system/Role.vue'),
      isMenu: true,
      meta: { title: 'system.menus.role', icon: 'role', noCache: true, },
    },
    {
      path: 'organization',
      component: () => import('@/views/system/Organization.vue'),
      isMenu: true,
      meta: { title: 'system.menus.org', icon: 'org', noCache: true, },
    },
    {
      path: 'parameters',
      component: () => import('@/views/system/Parameters.vue'),
      isMenu: true,
      meta: { title: 'system.menus.parameters', icon: 'settings', noCache: true, },
    },
    {
      path: 'schedule',
      component: () => import('@/views/system/Schedule.vue'),
      isMenu: true,
      meta: { title: 'system.menus.schedule', icon: 'schedule', noCache: true, },
    },
    {
      path: 'data-dictionary',
      component: () => import('@/views/system/DataDictionary.vue'),
      isMenu: true,
      meta: { title: 'system.menus.data-dictionary', icon: 'dictionary', noCache: true, },
    },
    {
      path: 'cache',
      component: () => import('@/views/system/Cache.vue'),
      isMenu: true,
      meta: { title: 'system.menus.cache', icon: 'cache', noCache: true, },
    },
    {
      path: 'credential',
      component: () => import('@/views/devops/Credential/index.vue'),
      isMenu: true,
      meta: { title: 'devops.menus.credential', icon: 'credential', noCache: true, },
    },
    {
      path: 'audit',
      component: () => import('@/views/system/AuditLog.vue'),
      isMenu: true,
      meta: { title: 'system.menus.audit', icon: 'audit', noCache: true, },
    },
  ]
}
