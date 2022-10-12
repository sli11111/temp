import { getToken, setToken, removeToken, filterRoutes, SUPER_ADMIN } from '@/utils/framework'
import { fetchProfile, login, logout } from '@/api/subscriber'

const SET_TOKEN   = 'SET_TOKEN'
const SET_SID     = 'SET_SID'
const SET_PROFILE = 'SET_PROFILE'
const SET_PERMS   = 'SET_PERMS'
const SET_ROLES   = 'SET_ROLES'
const SET_ROUTES  = 'SET_ROUTES'

const state = {
  token: getToken(),
  sid: null,
  profile: null,
  perms: [],
  roles: [],
  routes: []
}

const mutations = {
  [SET_TOKEN]: (state, token) => {
    state.token = token
  },
  [SET_SID]: (state, sid) => {
    state.sid = sid
  },
  [SET_PERMS]: (state, perms) => {
    state.perms = perms
  },
  [SET_ROLES]: (state, roles) => {
    state.roles = roles
  },
  [SET_PROFILE]: (state, profile) => {
    state.profile = profile
  },
  [SET_ROUTES]: (state, routes) => {
    state.routes = routes
  }
}

const actions = {
  login({ commit }, loginInfo) {
    const { username, password } = loginInfo
    return new Promise((resolve, reject) => {
      login({ username: username.trim(), password: password.trim() }).then(response => {
        const { data } = response
        commit(SET_TOKEN, data)
        setToken(data)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },
  logout({ commit }) {
    return new Promise((resolve, reject) => {
      function cleanUpSubscriber(commit) {
        removeToken()
        commit(SET_TOKEN, null)
        commit(SET_SID, null)
        commit(SET_PERMS, [])
        commit(SET_ROLES, [])
        commit(SET_PROFILE, null)
      }
      logout().then(() => {
        cleanUpSubscriber(commit)
        resolve()
      }).catch(error => {
        console.log('[Sancho] Backend logout error: ', error)
        cleanUpSubscriber(commit)
        resolve()
      })
    })
    
  },
  updateProfile({ commit }) {
    return new Promise((resolve, reject) => {
      fetchProfile().then(response => {
        const { data } = response
        commit(SET_SID, data.sid)
        commit(SET_PERMS, data.perms || [])
        commit(SET_ROLES, data.roles || [])
        commit(SET_PROFILE, data)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },
  updateRoutes({ state, commit }, routes) {
    return new Promise(resolve => {
      const perms = state.perms
      let accessibleRoutes
      if (perms.includes(SUPER_ADMIN)) {
        accessibleRoutes = routes
      } else {
        accessibleRoutes = filterRoutes(routes, { perms: perms })
      }
      commit(SET_ROUTES, accessibleRoutes)
      resolve(accessibleRoutes)
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
