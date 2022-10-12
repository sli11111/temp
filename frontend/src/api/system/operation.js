import request from '@/utils/request'

export function fetchOperations(page, searchParam) {
  return request({
    url: '/system/operation-logs',
    method: 'post',
    data: {
      data: {
        page,
        searchParam
      }
    }
  })
}
