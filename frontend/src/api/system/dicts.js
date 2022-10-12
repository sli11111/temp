import request from '@/utils/request'

export function fetchDicts(type) {
  return request({
    url: `/system/dicts/${type}`,
    method: 'get'
  })
}

export function deleteType(type) {
  return request({
    url: `/system/dict/${type}`,
    method: 'delete'
  })
}

export function deleteDict(type, item) {
  return request({
    url: `/system/dict/${type}/${item}`,
    method: 'delete'
  })
}

export function fetchDict(type) {
  return request({
    url: `/system/dict/${type}`,
    method: 'get'
  })
}

export function fetchType(type, search) {
  return request({
    url: `/system/dict/candidates/${type}`,
    method: 'get',
    params: {
      search
    }
  })
}

export function submitDict(data) {
  return request({
    url: '/system/dict',
    method: 'post',
    data: {
      data
    }
  })
}

export function getDictType(searchParam) {
  return request({
    url: '/system/dict-types',
    method: 'post',
    data: {
      data: searchParam
    }
  })
}
