import { createStore } from 'vuex'

const moduleFiles = import.meta.globEager('./modules/*.js')
const modules = {}
for (const moduleFileName in moduleFiles) {
  const module = moduleFiles[moduleFileName]
  const moduleName = moduleFileName.replace(/^\.\/(.*)\.\w+$/, '$1').replace('modules/', '')
  const target = module.default
  modules[moduleName] = target
  console.log(`[Sancho] Storage unit loaded: ${moduleName}`)
}

export const getters = {
  sidebar: state => state.app.sidebar,
  perms: state => state.subscriber.perms,
  roles: state => state.subscriber.roles,
  menus: state => state.subscriber.menus,
  token: state => state.subscriber.token,
  sid:   state => state.subscriber.sid
}

const store = createStore({
  modules,
  getters
})

export default store
