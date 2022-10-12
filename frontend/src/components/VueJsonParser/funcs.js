import _ from 'lodash'
import { uuid } from '@/utils'

export function extractObjectAsData(object, items, result) {
  for (let i = 0; i < items.length; i++) {
    const item = items[i]
    if (item.key) {
      if (item.key instanceof Array) {
        let value = []
        for (let j = 0; j < item.key.length; j++) {
          value.push(_.get(object, item.key[j], null))
        }
        result[item.key.join(':')] = value
      } else if (item.type === 'image-uploader') {
        const value = _.get(object, item.key, null)
        result[item.key] = value ? value : uuid()
      } else {
        result[item.key] = _.get(object, item.key, null)
      }
    }
  }
}

export function extractDataAsObject(data, key, result) {
  let value = data[key]
  if (value instanceof Array && key.indexOf(':') >= 0) {
    let keys = key.split(':')
    for (let i = 0; i < keys.length; i++) {
      if (keys[i]) {
        extractDataAsObject({ [keys[i]]: value[i] }, keys[i], result)
      }
    }
  } else {
    if (value instanceof Date) {
      _.set(result, key, value.getTime())
    } else if (value instanceof Array) {
      for (const item of value) {
        if (item.__mode__) {
          delete item.__mode__
        }
      }
      _.set(result, key, value)
    } else {
      _.set(result, key, value)
    }
  }
}

export function deepClone(target) {
  const map = new WeakMap()
  
  function isObject(target) {
      return (typeof target === 'object' && target ) || typeof target === 'function'
  }

  function clone(data) {
      if (!isObject(data)) {
          return data
      }
      if ([Date, RegExp].includes(data.constructor)) {
          return new data.constructor(data)
      }
      if (typeof data === 'function') {
          return new Function('return ' + data.toString())()
      }
      const exist = map.get(data)
      if (exist) {
          return exist
      }
      const keys = Reflect.ownKeys(data)
      const allDesc = Object.getOwnPropertyDescriptors(data)
      const result = Object.create(Object.getPrototypeOf(data), allDesc)
      map.set(data, result)
      keys.forEach(key => {
          const val = data[key]
          if (isObject(val)) {
              result[key] = clone(val)
          } else {
              result[key] = val
          }
      })
      return result
  }

  return clone(target)
}
