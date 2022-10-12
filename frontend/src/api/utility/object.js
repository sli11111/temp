import request from '@/utils/request'

export function fetchObjects(searchParam, page) {
  return request({
    url: '/utility/objects',
    method: 'post',
    data: {
      data: {
        searchParam,
        page
      }
    }
  })
}

export function fetchObject(id) {
  return request({
    url: `/utility/object/${id}`,
    method: 'get'
  })
}

export function saveObject(data, content) {
  data.content = JSON.stringify(content)
  return request({
    url: '/utility/object',
    method: 'post',
    data: {
      data
    }
  })
}

export function dropObject(id) {
  return request({
    url: `/utility/object/${id}`,
    method: 'delete'
  })
}

export function updateObjectPid(id, pid) {
  return request({
    url: `/utility/object/pid/${id}`,
    method: 'post',
    data: {
      data: pid
    }
  })
}

export function updateObjectWid(id, pid) {
  return request({
    url: `/utility/object/wid/${id}`,
    method: 'post',
    data: {
      data: pid
    }
  })
}

export function exportObject(id) {
  return request({
    url: `/utility/object-export/${id}`,
    method: 'get',
    responseType: 'blob'
  })
}
