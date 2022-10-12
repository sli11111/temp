import request from '@/utils/request'

export function fetchPermissions() {
  return request({
    url: '/system/permissions',
    method: 'get'
  })
}
