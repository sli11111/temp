import request from '@/utils/request'

export function fetchOrgTree() {
  return request({
    url: '/system/org-tree',
    method: 'get'
  })
}

export function fetchOrgStatistics(orgId) {
  return request({
    url: `/system/org/statistic-${orgId}`,
    method: 'get'
  })
}

export function fetchOrgUsers(orgId, search) {
  return request({
    url: `/system/org/candidates/${orgId}`,
    method: 'get',
    params: {
      search
    }
  })
}

export function submitOrgUser(orgId, data) {
  return request({
    url: `/system/org/candidates/${orgId}`,
    method: 'post',
    data: {
      data
    }
  })
}

export function deleteOrgUser(orgId, data) {
  return request({
    url: `/system/org/candidates/${orgId}`,
    method: 'delete',
    data: {
      data
    }
  })
}

export function submitOrgTree(data) {
  return request({
    url: '/system/org-tree/save',
    method: 'post',
    data: {
      data
    }
  })
}

export function deleteOrg(id) {
  return request({
    url: `/system/org/${id}`,
    method: 'delete'
  })
}

export function SyncOrg() {
  return request({
    url: '/system/org-sync',
    method: 'post'
  })
}
