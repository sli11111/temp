import { getToken } from '@/utils/framework.js'
import { getBaseUrl } from '@/utils/request.js'

const ws_handlers = {}
let ws

export const getSocket = function() {
  if (ws && ws.readyState !== 3) {
    return ws
  } else {
    const token = getToken()
    ws = new WebSocket(`${(window.location.protocol === 'https:' ? 'wss://' : 'ws://')}${getBaseUrl()}/common/ws/${token}`)
    ws.onmessage = function(evt) {
      const msg_str = evt.data
      try {
        const data = JSON.parse(msg_str)
        const channelId = data.channelId
        const handler = ws_handlers[channelId]
        if (handler) {
          handler(data)
        }
      } catch (e) {
        console.log(e)
      }
    }
    ws.onerror = function() {
      console.log('异常关闭')
    }
    return ws
  }
}

export const addHandler = function(channelId, handler) {
  ws_handlers[channelId] = handler
}

export const delHandler = function(channelId) {
  delete ws_handlers[channelId]
}

export const sendMessage = function(channelId, data) {
  const ws = getSocket()
  const msg = JSON.stringify({ channelId, data })
  if (!ws || ws.readyState === 0) {
    setTimeout(function() {
      ws.send(msg)
    }, 200)
  } else {
    ws.send(msg)
  }
}
