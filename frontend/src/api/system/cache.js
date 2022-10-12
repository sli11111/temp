import request from '@/utils/request'

export function fetchCaches() {
  return request({
    url: '/system/caches',
    method: 'get'
  })
}

export function fetchCacheByName(name) {
  return request({
    url: `/system/caches?name=${name}`,
    method: 'get'
  })
}

export function evictCacheByName(name) {
  return request({
    url: '/system/caches/evict',
    method: 'delete',
    params: {
      cacheName: name
    }
  })
}

export function evictCacheByKey(name, key) {
  return request({
    url: '/system/caches/evict',
    method: 'delete',
    params: {
      cacheName: name,
      cacheKey: key
    }
  })
}
