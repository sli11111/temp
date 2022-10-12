import { getInitialThemeMode, getInitialSidebarState, getInitialSize, SESSION_STORAGE } from '@/utils/framework'
import { getInitialLocale } from '@/i18n'

const SET_THEME_MODE            = 'SET_THEME_MODE'
const SET_LOCALE                = 'SET_LOCALE'
const SET_DEVICE                = 'SET_DEVICE'
const SET_SIDEBAR               = 'SET_SIDEBAR'
const SET_SIZE                  = 'SET_SIZE'
const SET_PASSWORD_DIALOG_STATE = 'SET_PASSWORD_DIALOG_STATE'
const SET_VIEW_NAME             = 'SET_VIEW_NAME'
const SET_WINDOW_INNER_HEIGHT   = 'SET_WINDOW_INNER_HEIGHT'
const SET_WINDOW_INNER_WIDTH    = 'SET_WINDOW_INNER_WIDTH'

const state = {
  windowInnerWidth: window.innerWidth,
  windowInnerHeight: window.innerHeight,
  themeMode: getInitialThemeMode(),
  locale: getInitialLocale(),
  device: 'desktop',
  sidebar: getInitialSidebarState(),
  size: getInitialSize(),
  viewNames: {},
  passwordDialog: 'Deactive'  // 'Deactive' - 未激活密码修改  'Active' - 激活密码修改  'Force' - 强制密码修改
}

const mutations = {
  [SET_THEME_MODE]: (state, themeMode) => {
    state.themeMode = themeMode
  },
  [SET_LOCALE]: (state, locale) => {
    state.locale = locale
  },
  [SET_DEVICE]: (state, device) => {
    state.device = device
  },
  [SET_SIDEBAR]: (state, sidebar) => {
    state.sidebar = sidebar
  },
  [SET_SIZE]: (state, size) => {
    state.size = size
  },
  [SET_PASSWORD_DIALOG_STATE]: (state, dialogStatus) => {
    state.passwordDialog = dialogStatus
  },
  [SET_VIEW_NAME]: (state, {viewNameKey, viewName}) => {
    state.viewNames[viewNameKey] = viewName
  },
  [SET_WINDOW_INNER_HEIGHT]: (state, windowInnerHeight) => {
    state.windowInnerHeight = windowInnerHeight
  },
  [SET_WINDOW_INNER_WIDTH]: (state, windowInnerWidth) => {
    state.windowInnerWidth = windowInnerWidth
  }
}

const actions = {
  toggleThemeMode({ commit, state }) {
    const themeMode = state.themeMode !== 'light' ? 'light' : 'dark'
    window.sessionStorage.setItem(SESSION_STORAGE.THEME_MODE, themeMode)
    commit(SET_THEME_MODE, themeMode)
  },
  setThemeMode({ commit }, themeMode) {
    window.sessionStorage.setItem(SESSION_STORAGE.THEME_MODE, themeMode)
    commit(SET_THEME_MODE, themeMode)
  },
  setLocale({ commit }, locale) {
    window.sessionStorage.setItem(SESSION_STORAGE.LOCALE, locale)
    commit(SET_LOCALE, locale)
  },
  setDevice({ commit }, device) {
    commit(SET_DEVICE, device)
  },
  setSidebar({ commit }, sidebar) {
    window.sessionStorage.setItem(SESSION_STORAGE.SIDEBAR_STATE, sidebar)
    commit(SET_SIDEBAR, sidebar)
  },
  toggleSidebar({ commit, state }) {
    const sidebarState = state.sidebar === 'collapse' ? 'opened' : 'collapse'
    window.sessionStorage.setItem(SESSION_STORAGE.SIDEBAR_STATE, sidebarState)
    commit(SET_SIDEBAR, sidebarState)
  },
  closeSidebar({ commit }) {
    const sidebarState = 'collapse'
    window.sessionStorage.setItem(SESSION_STORAGE.SIDEBAR_STATE, sidebarState)
    commit(SET_SIDEBAR, sidebarState)
  },
  setSize({ commit }, size) {
    window.sessionStorage.setItem(SESSION_STORAGE.SIZE, size)
    commit(SET_SIZE, size)
  },
  setPasswordDialogStatus({ commit }, status) {
    commit(SET_PASSWORD_DIALOG_STATE, status)
  },
  setViewName({ commit }, { viewNameKey, viewName }) {
    commit(SET_VIEW_NAME, { viewNameKey, viewName })
  },
  resize({ commit }, { windowInnerHeight, windowInnerWidth }) {
    commit(SET_WINDOW_INNER_HEIGHT, windowInnerHeight)
    commit(SET_WINDOW_INNER_WIDTH, windowInnerWidth)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
