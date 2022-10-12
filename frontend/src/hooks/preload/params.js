import { fetchParams } from '@/api/common'
import settings from '@/settings.js'
import lodash from 'lodash'

export default function(app) {
  return new Promise((resolve) => {
    fetchParams()
      .then(res => {
        const $settings = lodash.extend(settings, res.data || {})
        app.config.globalProperties['$settings'] = $settings
        window.$settings = $settings
        resolve()
      })
    })
}
