import request from '@/utils/request'

export function fetchRoles(searchParam) {
  return request({
    url: '/system/roles',
    method: 'post',
    data: {
      data: searchParam
    }
  })
}

export function fetchRole(roleId) {
  return request({
    url: `/system/role/${roleId}`,
    method: 'get'
  })
}

export function submitRole(role) {
  return request({
    url: '/system/role/save',
    method: 'post',
    data: {
      data: role
    }
  })
}

export function submitRoleUsers(roleId, subscribers) {
  return request({
    url: `/system/role/candidates/${roleId}`,
    method: 'post',
    data: {
      data: subscribers
    }
  })
}

export function deleteRole(roleId) {
  return request({
    url: `/system/role/${roleId}`,
    method: 'delete'
  })
}

export function deleteRoleUser(roleId, userId) {
  return request({
    url: `/system/role/${roleId}/${userId}`,
    method: 'delete'
  })
}
