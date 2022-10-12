import request from '@/utils/request'

export function fetchMenus() {
  return request({
    url: '/system/menus',
    method: 'get'
  })
}

export function submitMenu(data) {
  return request({
    url: '/system/menus',
    method: 'post',
    data: { data }
  })
}

export function deleteMenu(id) {
  return request({
    url: `/system/menu/${id}`,
    method: 'delete'
  })
}

export function fetchMenuRoles(id, search) {
  return request({
    url: `/system/menu/candidates/${id}`,
    method: 'get',
    params: {
      search
    }
  })
}

export function submitMenuRole(id, data) {
  return request({
    url: `/system/menu/candidates/${id}`,
    method: 'post',
    data: {
      data
    }
  })
}

export function dropMenuRole(id, roleId) {
  return request({
    url: `/system/menu/${id}/${roleId}`,
    method: 'delete'
  })
}
