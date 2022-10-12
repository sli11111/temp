import request from '@/utils/request'

export function fetchParams() {
  return request({
    url: '/system/params',
    method: 'get'
  })
}

export function submitParam(data) {
  return request({
    url: '/system/param',
    method: 'post',
    data: {
      data
    }
  })
}
