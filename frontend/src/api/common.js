import request from '@/utils/request'

export function fetchLanguage(locale) {
  return request({
    url: '/common/language',
    method: 'get',
    params: { locale }
  })
}

export function fetchDicts() {
  return request({
    url: '/common/dicts',
    method: 'get'
  })
}

export function fetchParams() {
  return request({
    url: '/common/settings',
    method: 'get'
  })
}
