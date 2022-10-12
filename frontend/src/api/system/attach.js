import request from '@/utils/request'

export function uploadAttach(batchId, attachId, formData) {
  return request({
    url: `/attach/upload/${batchId}/${attachId}`,
    method: 'post',
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    data: formData,
    ignoreEncryption: true
  })
}

export function fetchAttaches(batchId) {
  return request({
    url: `/attach/${batchId}`,
    method: 'get'
  })
}

export function fetchAttach(batchId, attachId) {
  return request({
    url: `/attach/${batchId}/${attachId}`,
    method: 'get'
  })
}

export function fetchAttachHistory(batchId, attachId) {
  return request({
    url: `/attach/history/${batchId}/${attachId}`,
    method: 'get'
  })
}

export function dropAttach(batchId, attachId) {
  return request({
    url: `/attach/${batchId}/${attachId}`,
    method: 'delete'
  })
}

export function renameAttach(batchId, attachId, data) {
  return request({
    url: `/attach/${batchId}/${attachId}`,
    method: 'post',
    data: {
      data
    }
  })
}
