import request from '@/utils/request'

export function fetchWorkspaces(data) {
  return request({
    url: '/utility/workspaces/all',
    method: 'post',
    data: { data }
  })
}

export function fetchWorkspacesByPage(searchParam, page) {
  return request({
    url: '/utility/workspaces',
    method: 'post',
    data: {
      data: {
        searchParam,
        page
      }
    }
  })
}

export function fetchWorkspace(id) {
  return request({
    url: `/utility/workspace/${id}`,
    method: 'get'
  })
}

export function saveWorkspace(data) {
  return request({
    url: '/utility/workspace/save',
    method: 'post',
    data: { data }
  })
}

export function dropWorkspace(id) {
  return request({
    url: `/utility/workspace/${id}`,
    method: 'delete'
  })
}

export function saveWorkspaceResources(data) {
  return request({
    url: '/utility/workspace/resources/save',
    method: 'post',
    data: {
      data
    }
  })
}

export function fetchWorkspaceResources(wid, type, page) {
  return request({
    url: `/utility/workspace/resources/${wid}/${type}`,
    method: 'post',
    data: {
      data: {
        page
      }
    }
  })
}

export function updateWorkspacePid(id, pid) {
  return request({
    url: `/utility/workspace/${id}`,
    method: 'post',
    data: {
      data: pid
    }
  })
}

export function fetchWorkspaceTree(rootWorkspaceId, workspaceTypes, objectTypes, resourceTypes) {
  return request({
    url: '/utility/workspace/tree',
    method: 'post',
    data: {
      data: { rootWorkspaceId, workspaceTypes, objectTypes, resourceTypes }
    }
  })
}
