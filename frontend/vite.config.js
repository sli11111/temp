import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import viteSvgIcons from 'vite-plugin-svg-icons'
import resolve from '@rollup/plugin-node-resolve'
import { viteMockServe } from 'vite-plugin-mock'
import prismjs from 'vite-plugin-prismjs'

const path = require('path')

const port = process.env.port || process.env.npm_config_port || 9528

const mode = process.env.NODE_ENV

const root = path.resolve(__dirname, 'src')

export default defineConfig(() => {
  require('dotenv').config({ path: `./.env.${mode}` });
  const config = {
    base: '',
    root,
    publicDir: '../public',
    plugins: [
      vue(),
      // svg icon support
      viteSvgIcons({
        iconDirs: [path.resolve(process.cwd(), 'src/icons')],
        symbolId: 'icon-[dir]-[name]',
      }),
      prismjs({
        languages: 'all',
      })
    ],
    resolve: {
      // https://cn.vitejs.dev/config/#resolve-extensions
      extensions: ['.mjs', '.js', '.ts', '.jsx', '.tsx', '.json', '.vue'],
      alias: {
        '@': path.join(__dirname, 'src')
      }
    },
    optimizeDeps: {
      include: ['@kangc/v-md-editor/lib/theme/vuepress.js', '@kangc/v-md-editor/lib/theme/github.js'],
    },
    server: {
      host: '0.0.0.0',
      port,
      strictPort: false,
      // https://github.com/http-party/node-http-proxy#options
      proxy: {
        '/mock': {
          target: `http://127.0.0.1:${port}`,
          changeOrigin: true,
          ws: true,
          secure: false,
          logLevel: 'debug',
          rewrite: path => path.replace(/\/mock/, '')
        },
        [process.env.VITE_BASE_URL]: {
          target: `${process.env.VITE_HOST}`,
          changeOrigin: true,
          ws: true,
          secure: false,
          logLevel: 'debug',
          rewrite: path => path.replace(process.env.VITE_BASE_URL, '')
        }
      },
      // this might cause trouble when you are coding on code server!
      // open: '/index.html',
    },
    build: {
      outDir: '../dist',
      rollupOptions: {
        input: {
          main: path.resolve(__dirname, '/index.html'),
          //mobile: path.resolve(__dirname, '/mobile.html')
        },
        plugins:[
          resolve()
        ]
      }
    }
  }

  if (mode === 'development') {
    config.plugins.push(
      // https://github.com/anncwb/vite-plugin-mock/
      viteMockServe({
        mockPath: 'mock',
        supportTs: true,
        watchFiles: true,
        ignoreFiles: [],
        prodEnabled: false,
        logger: true
      }))
  }

  return config
})
