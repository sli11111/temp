import request from '@/utils/request'

export function sendAlert(data) {
  return request({
    url: '/system/alert',
    method: 'post',
    data: { data }
  })
}

export function fetchAlerts(searchParam, page) {
  return request({
    url: '/system/alerts',
    method: 'post',
    data: { data: { searchParam, page } }
  })
}

export function handleAlert(data) {
  return request({
    url: '/system/alert/handle',
    method: 'post',
    data: { data }
  })
}
