import request from '@/utils/request'

export function fetchUsers(page, searchParam) {
  return request({
    url: '/system/subscribers',
    method: 'post',
    data: {
      data: {
        page,
        searchParam
      }
    }
  })
}

export function fetchUser(params) {
  return request({
    url: `/system/subscriber`,
    method: 'get',
    params: params
  })
}

export function fetchRoleCandidates(roleId, search) {
  return request({
    url: `/system/role/candidates/${roleId}`,
    method: 'get',
    params: {
      search
    }
  })
}

export function fetchOrgCandidates(orgId) {
  return request({
    url: `/system/org/candidates/${orgId}`,
    method: 'get'
  })
}

export function submitUser(user) {
  return request({
    url: '/system/subscriber/save',
    method: 'post',
    data: {
      data: user
    }
  })
}

export function deleteUser(userId) {
  return request({
    url: `/system/subscriber/${userId}`,
    method: 'delete'
  })
}

export function impersonate(sid) {
  return request({
    url: '/system/impersonate',
    method: 'post',
    data: {
      data: sid
    }
  })
}

export function cancelImpersonate(ticket) {
  return request({
    url: '/system/impersonate/undo',
    method: 'post',
    data: {
      data: ticket
    }
  })
}

export function resetPassword(sid) {
  return request({
    url: '/system/subscriber/reset-password',
    method: 'post',
    data: {
      data: {
        sid
      }
    }
  })
}
