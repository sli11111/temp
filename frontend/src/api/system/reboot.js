import request from '@/utils/request'

export function reboot(password) {
  return request({
    url: '/system/reboot',
    method: 'post',
    data: {
      data: password
    }
  })
}
