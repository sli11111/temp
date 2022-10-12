import request from '@/utils/request'

export function fetchCalendar(start, end) {
  return request({
    url: `/system/holiday/calendar/${start}-${end}`,
    method: 'get'
  })
}

export function saveCalendar(data) {
  return request({
    url: '/system/holiday/calendar',
    method: 'post',
    data: { data }
  })
}
