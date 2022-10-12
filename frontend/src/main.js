import { createApp } from 'vue'

import router from '@/router'
import store from '@/store'
import i18n from '@/i18n'

import App from '@/Main.vue'
const app = createApp(App)
  .use(router)
  .use(store)
  .use(i18n)

// UI Library: ElementPlus
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'
import en from 'element-plus/lib/locale/lang/en'
import zhCn from 'element-plus/lib/locale/lang/zh-cn'
import zhTw from 'element-plus/lib/locale/lang/zh-tw'
import * as ElIconModules from '@element-plus/icons'
for(let iconName in ElIconModules){
  app.component(iconName, ElIconModules[iconName])
}
app.use(ElementPlus, { 
  size: store.state.app.size, 
  locale: (function(locale){
    switch(locale) {
      case 'zh-cn':
        return zhCn
      case 'zh-tw':
        return zhTw
      default:
        return en
    }
  }(store.state.app.locale)) 
})

// UI Library: Vant
import vant from 'vant'
import 'vant/lib/index.css'
app.use(vant)

// Directives
import dragger from "v-dragger"
app.use(dragger)
import clickAway from 'vue3-click-away'
app.use(clickAway)

// custom Styles support
import '@/style/index.scss'

// svg icon support  
import 'vite-plugin-svg-icons/register'
import svgIcon from '@/components/SvgIcon/index.vue'
app.component('svg-icon', svgIcon)

// directive
import directives from './directive'
app.use(directives)

// Markdown Editor
import VMdEditor from '@kangc/v-md-editor'
import '@kangc/v-md-editor/lib/style/base-editor.css'

import VMdPreview from '@kangc/v-md-editor/lib/preview'
import '@kangc/v-md-editor/lib/style/preview.css'

import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress'
import '@kangc/v-md-editor/lib/theme/style/vuepress.css'

// highlightjs
import hljs from 'highlight.js'

// // codemirror 编辑器的相关资源
// import Codemirror from 'codemirror'
// // mode
// import 'codemirror/mode/markdown/markdown.js'
// import 'codemirror/mode/javascript/javascript.js'
// import 'codemirror/mode/css/css.js'
// import 'codemirror/mode/htmlmixed/htmlmixed.js'
// import 'codemirror/mode/vue/vue.js'
// // edit
// import 'codemirror/addon/edit/closebrackets.js'
// import 'codemirror/addon/edit/closetag.js'
// import 'codemirror/addon/edit/matchbrackets.js'
// // placeholder
// // import 'codemirror/addon/display/placeholders.js'
// // active-line
// import 'codemirror/addon/selection/active-line.js'
// // scrollbar
// import 'codemirror/addon/scroll/simplescrollbars.js'
// import 'codemirror/addon/scroll/simplescrollbars.css'
// // style
// import 'codemirror/lib/codemirror.css'

//VMdEditor.Codemirror = Codemirror
import Prism from 'prismjs'

VMdEditor.use(vuepressTheme, {
  Prism,
  Hljs: hljs,
})

VMdPreview.use(vuepressTheme, {
  Prism,
  Hljs: hljs,
})
app.use(VMdEditor)
app.use(VMdPreview)

import '@/utils/onresize.js'

import { preloadHook } from './hooks'
preloadHook.promise(app).then(() => {
  app.mount('#app')
})
