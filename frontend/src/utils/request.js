import axios from 'axios'
import settings from '@/settings'
import { requestHook, responseHook } from '@/hooks'
import { ElMessage, ElMessageBox } from 'element-plus'

const service = axios.create({
  baseURL: getBaseUrl(),
  withCredentials: settings.client.withCredentials,
  timeout: settings.client.timeout
})

service.interceptors.request.use(
  request => {
    try {
      requestHook.call(request)
      // TODO
    } catch(e) {
      console.error('Error handling request: ', e)
    }
    return request
  },
  error => {
    try {
      // TODO
    } catch(e) {
      console.error('Error handling request error: ', e)
    }
    return Promise.reject(error)
  }
)

service.interceptors.response.use(
  response => {
    try {
      responseHook.call(response)

      // TODO
    } catch(e) {
      console.error('Error handling response: ', e)
    }

    const data = response.data

    if (data) {
      if (data.flag === 0) {
        return data
      } else {
        if (response.status === 401 || data.flag === -6 || data.flag === -9) {
          ElMessageBox.confirm('You have been logged out, you can cancel to stay on this page, or log in again', 'Confirm logout', {
            confirmButtonText: 'Re-Login',
            cancelButtonText: 'Cancel',
            type: 'warning'
          }).then(() => {
            store.dispatch('subscriber/logout').then(() => {
              location.reload()
            })
          })  
        } else {
          const message = data.msg || 'Request error!'
          ElMessage.error(message)
          return Promise.reject(new Error(message))
        }
      }
    } else {
      throw new Error(response.data)
    }
  },
  error => {
    try {
      console.log(error)
      // TODO
    } catch(e) {
      console.error('Error handling response error: ', e)
    }
    return Promise.reject(error)
  }
)

export default service

export function download(url) {
  window.open(getBaseUrl() + url)
}

export function getBaseUrl() {
  const baseUrl = import.meta.env.VITE_BASE_URL === 'PATHNAME' ? window.location.pathname : import.meta.env.VITE_BASE_URL
  if (baseUrl.length > 0 && baseUrl.lastIndexOf('/') === baseUrl.length - 1) {
    return baseUrl.substr(0, baseUrl.length - 1)
  }
  return baseUrl === '/' ? '' : baseUrl
}
