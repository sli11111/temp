import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    data: {
      data
    }
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

export function fetchProfile() {
  return request({
    url: '/profile/info',
    method: 'get'
  })
}

export function changePassword(data) {
  return request({
    url: '/profile/change-password',
    method: 'post',
    data: { data }
  })
}
