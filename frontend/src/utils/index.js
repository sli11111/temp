import lodash from 'lodash'

export function param2Object(url) {
  const search = url.split('?')[1]
  if (!search) {
    return {}
  }
  return JSON.parse(
    '{"' +
      decodeURIComponent(search)
        .replace(/"/g, '\\"')
        .replace(/&/g, '","')
        .replace(/=/g, '":"')
        .replace(/\+/g, ' ') +
      '"}'
  )
}

/**
 * @param {Function} func
 * @param {number} wait
 * @param {boolean} immediate
 * @return {*}
 */
 export function debounce(func, wait, immediate) {
  let timeout, args, context, timestamp, result

  const later = function() {
    // 据上一次触发时间间隔
    const last = +new Date() - timestamp

    // 上次被包装函数被调用时间间隔 last 小于设定时间间隔 wait
    if (last < wait && last > 0) {
      timeout = setTimeout(later, wait - last)
    } else {
      timeout = null
      // 如果设定为immediate===true，因为开始边界已经调用过了此处无需调用
      if (!immediate) {
        result = func.apply(context, args)
        if (!timeout) context = args = null
      }
    }
  }

  return function(...args) {
    context = this
    timestamp = +new Date()
    const callNow = immediate && !timeout
    // 如果延时不存在，重新设定延时
    if (!timeout) timeout = setTimeout(later, wait)
    if (callNow) {
      result = func.apply(context, args)
      context = args = null
    }

    return result
  }
}

/**
 * This is just a simple version of deep copy
 * Has a lot of edge cases bug
 * If you want to use a perfect deep copy, use lodash's _.cloneDeep
 * @param {Object} source
 * @param {Boolean} strict
 * @returns {Object}
 */
export function deepClone(source, strict) {
  if (strict) {
    return lodash.deepClone(source)
  }
  if (!source && typeof source !== 'object') {
    throw new Error('error arguments', 'deepClone')
  }
  const targetObj = source.constructor === Array ? [] : {}
  Object.keys(source).forEach(keys => {
    if (source[keys] && typeof source[keys] === 'object') {
      targetObj[keys] = deepClone(source[keys])
    } else {
      targetObj[keys] = source[keys]
    }
  })
  return targetObj
}

/**
 * @param {Array} arr
 * @returns {Array}
 */
 export function uniqueArr(arr) {
  return Array.from(new Set(arr))
}

/**
 * @returns {string}
 */
export function createUniqueString() {
  const timestamp = +new Date() + ''
  const randomNum = parseInt((1 + Math.random()) * 65536) + ''
  return (+(randomNum + timestamp)).toString(32)
}

/**
 * Check if string or array is empty
 * @param {String | Array} target
 * @returns {boolean}
 */
 export function isEmpty(target) {
  if (target === undefined || target === null) {
    return true
  }
  if (typeof (target) === 'string' && target.trim() === '') {
    return true
  }
  return target instanceof Array && target.length === 0;
}

export function setCookie(cname, cvalue, exdays) {
  var d = new Date()
  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000))
  var expires = 'expires=' + d.toGMTString()
  document.cookie = cname + '=' + cvalue + '; ' + expires
}

export function getCookie(cname) {
  var name = cname + '='
  var ca = document.cookie.split(';')
  for(var i=0; i<ca.length; i++)
  {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length, c.length)
  }
  return ''
}

export function delCookie (name) {
  document.cookie = name + "=;expires=-1"
}

// resolves . and .. elements in a path array with directory names there
// must be no slashes or device names (c:\) in the array
// (so also no leading and trailing slashes - it does not distinguish
// relative and absolute paths)
function normalizeArray(parts, allowAboveRoot) {
  var res = [];
  for (var i = 0; i < parts.length; i++) {
    var p = parts[i];

    // ignore empty parts
    if (!p || p === '.')
      continue;

    if (p === '..') {
      if (res.length && res[res.length - 1] !== '..') {
        res.pop();
      } else if (allowAboveRoot) {
        res.push('..');
      }
    } else {
      res.push(p);
    }
  }

  return res;
}

// https://github.com/jinder/path/blob/master/path.js
// path.posix.resolve
export function resolvePath() {
  var resolvedPath = '',
      resolvedAbsolute = false;

  for (var i = arguments.length - 1; i >= -1 && !resolvedAbsolute; i--) {
    // fix: this is not working in browser
    // var path = (i >= 0) ? arguments[i] : process.cwd();
    var path = (i >= 0) ? arguments[i] : '/';

    // Skip empty and invalid entries
    if (typeof path !== 'string') {
      throw new TypeError('Arguments to path.resolve must be strings');
    } else if (!path) {
      continue;
    }

    resolvedPath = path + '/' + resolvedPath;
    resolvedAbsolute = path[0] === '/';
  }

  // At this point the path should be resolved to a full absolute path, but
  // handle relative paths to be safe (might happen when process.cwd() fails)

  // Normalize the path
  resolvedPath = normalizeArray(resolvedPath.split('/'),
                                !resolvedAbsolute).join('/');

  return ((resolvedAbsolute ? '/' : '') + resolvedPath) || '.';
}

Math.easeInOutQuad = function(t, b, c, d) {
  t /= d / 2
  if (t < 1) {
    return c / 2 * t * t + b
  }
  t--
  return -c / 2 * (t * (t - 2) - 1) + b
}

// requestAnimationFrame for Smart Animating http://goo.gl/sx5sts
var requestAnimFrame = (function() {
  return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || function(callback) { window.setTimeout(callback, 1000 / 60) }
})()

/**
 * Because it's so fucking difficult to detect the scrolling element, just move them all
 * @param {number} amount
 */
function move(amount) {
  document.documentElement.scrollTop = amount
  document.body.parentNode.scrollTop = amount
  document.body.scrollTop = amount
}

function position() {
  return document.documentElement.scrollTop || document.body.parentNode.scrollTop || document.body.scrollTop
}

/**
 * @param {number} to
 * @param {number} duration
 * @param {Function} callback
 */
export function scrollTo(to, duration, callback) {
  const start = position()
  const change = to - start
  const increment = 20
  let currentTime = 0
  duration = (typeof (duration) === 'undefined') ? 500 : duration
  var animateScroll = function() {
    // increment the time
    currentTime += increment
    // find the value with the quadratic in-out easing function
    var val = Math.easeInOutQuad(currentTime, start, change, duration)
    // move the document.body
    move(val)
    // do the animation unless its over
    if (currentTime < duration) {
      requestAnimFrame(animateScroll)
    } else {
      if (callback && typeof (callback) === 'function') {
        // the animation is done so lets callback
        callback()
      }
    }
  }
  animateScroll()
}

/**
 * @param {string} path
 * @returns {Boolean}
 */
 export function isExternal(path) {
  return /^(https?:|mailto:|tel:)/.test(path)
}

const regs = {
  package: /^([a-zA-Z.])+$/,
  englishText: /^([a-zA-Z])+$/,
  money: /(^[1-9](\d+)?(\.\d{1,2})?$)|(^0$)|(^\d\.\d{1,2}$)/,
  email: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/,
  phone: /^((0\d{2,3}-)|\d{7,8})|(1[3584]\d{9})$/,
  positiveDigit: /^[+]?(0|([1-9]\d*))(\.\d+)?$/,
  negativeDigit: /^[-]?(0|([1-9]\d*))(\.\d+)?$/,
  digit: /^[+-]?(0|([1-9]\d*))(\.\d+)?$/,
  positiveInteger: /^[+]?(0|([1-9]\d*))$/,
  negativeInteger: /^[-]?(0|([1-9]\d*))$/,
  integer: /^[+-]?(0|([1-9]\d*))(\.\d+)?$/,
  mobile: /^1\d{10}$/
}

/**
 * reg validate
 * @param {Object} rule
 * @param {Object | String} value
 * @param {Function} callback
 */
export function validateByReg(rule, value, callback) {
  if (value === '' || value === null || value === undefined) {
    callback()
  }
  const reg = regs[rule.regName]
  if (!reg.test(value)) {
    callback(new Error(rule.message))
  } else {
    callback()
  }
}


// Menu Functions: 
import settings from '@/settings.js'
import { dynamicRoutes } from '@/router'
import i18n from '@/i18n'
import { fetchMenus } from '@/api/system/menus'
import { fetchPermissions } from '@/api/system/permissions'

export async function getMenus() {
  let menu_list = []
  if (settings.system.menu.mode === 'frontend') {
    const routes = deepClone([...dynamicRoutes])
    const filter = function(routes, path) {
      const menus = []
      for (let i = 0; i < routes.length; i++) {
        const obj = routes[i]
        if ((obj.isMenu === undefined || obj.isMenu) && obj.name) {
          const menu = { id: obj.name, name: obj.meta ? i18n.global.t(obj.meta.title) : obj.path, status: true }
          if (obj.meta) {
            menu.perms = obj.meta.role
            menu.icon = obj.meta.icon
          }
          menu.url = (path || '') + (obj.path.charAt(0) === '/' ? '' : '/') + obj.path
          if (obj.children) {
            menu.children = filter(obj.children, menu.url)
          }
          menus.push(menu)
        }
      }
      return menus
    }
    menu_list = filter(routes)
  }
  if (settings.system.menu.mode === 'backend') {
    const { data } = await fetchMenus()
    menu_list = data
  }
  return new Promise((resolve) => {
    resolve(menu_list)
  })
}

export async function getPermissions() {
  let perm_list = []
  if (settings.system.perm.mode === 'frontend' || settings.system.perm.mode === 'mixed') {
    perm_list = $lodash.union(perm_list, [])
  }
  if (settings.system.perm.mode === 'backend' || settings.system.perm.mode === 'mixed') {
    const { data } = await fetchPermissions()
    perm_list = $lodash.union(perm_list, data.datalist)
  }
  return new Promise((resolve) => {
    resolve(perm_list)
  })
}

/**
 * Convert file byte size to readable format
 * @param {Number} fileByte
 */
 export function getFileSize(fileByte) {
  var fileSizeByte = fileByte
  var fileSizeMsg = ''
  if (fileSizeByte < 1048576) fileSizeMsg = (fileSizeByte / 1024).toFixed(2) + 'KB'
  else if (fileSizeByte === 1048576) fileSizeMsg = '1MB'
  else if (fileSizeByte > 1048576 && fileSizeByte < 1073741824) fileSizeMsg = (fileSizeByte / (1024 * 1024)).toFixed(2) + 'MB'
  else if (fileSizeByte > 1048576 && fileSizeByte === 1073741824) fileSizeMsg = '1GB'
  else if (fileSizeByte > 1073741824 && fileSizeByte < 1099511627776) fileSizeMsg = (fileSizeByte / (1024 * 1024 * 1024)).toFixed(2) + 'GB'
  else fileSizeMsg = '>1TB'
  return fileSizeMsg
}

export function getFileSizeObj(fileByte) {
  var fileSizeByte = fileByte
  if (fileSizeByte < 1048576) {
    return {
      size: (fileSizeByte / 1024).toFixed(2),
      unit: 'KB'
    }
  } else if (fileSizeByte === 1048576) {
    return {
      size: 1,
      unit: 'MB'
    }
  } else if (fileSizeByte > 1048576 && fileSizeByte < 1073741824) {
    return {
      size: (fileSizeByte / (1024 * 1024)).toFixed(2),
      unit: 'MB'
    }
  } else if (fileSizeByte > 1048576 && fileSizeByte === 1073741824) {
    return {
      size: 1,
      unit: 'GB'
    }
  } else if (fileSizeByte > 1073741824 && fileSizeByte < 1099511627776) {
    return {
      size: (fileSizeByte / (1024 * 1024 * 1024)).toFixed(2),
      unit: 'GB'
    }
  } else {
    return {
      size: (fileSizeByte / (1024 * 1024 * 1024 * 1024)).toFixed(2),
      unit: 'TB'
    }
  }
}

export function uuid() {
  var dt = new Date().getTime();
  var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = (dt + Math.random()*16)%16 | 0;
      dt = Math.floor(dt/16);
      return (c=='x' ? r :(r&0x3|0x8)).toString(16);
  });
  return uuid;
}

export function getStringPhysicalLength(str) {
  let totalLength = 0;
  str = str + ''
  let list = str.split('')
  for(var i = 0; i < list.length; i++) {
    var s = list[i]
    if (s.match(/[\u0000-\u00ff]/g)) {
    totalLength += 1
   } else if (s.match(/[\u4e00-\u9fa5]/g)) { //中文
    totalLength += 2
   } else if (s.match(/[\uff00-\uffff]/g)) { //全角
    totalLength += 2
   }
  }  
  return totalLength
}
