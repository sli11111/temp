<template>
  <component ref="section" :is="config.parser" v-for="(section, $index) in config.sections" :key="$index" :config="getPreparedSection(section)" :formData="formData" />
</template>

<script>
import { deepClone } from './funcs'
import ElementUIParser from './SectionParser-ElementUI.vue'
import VantUIParser from './SectionParser-VantUI.vue'

export default {
  name: 'VueJsonParser',
  components: { element: ElementUIParser, vant: VantUIParser },
  props: {
    /**
     * Json Example: 
     * {
     *  parser: 'element',
     *  sections: [{
     *    showTitle: false
     *    items: [{
     *      type: 'text',
     *      key: 'a.a.a',
     *      label: '',
     *      span: 24
     *    },
     *    {
     *      type: 'select',
     *      key: 'a.a.b',
     *      dictName: '',
     *      dict: '',
     *    },
     *    {
     *      type: 'date',
     *      key: 'a.a.c'
     *    },
     *    {
     *      type: 'date',
     *      key: 'a.a.c'
     *    }]
     *  }]
     * }
     */
    json: {
      type: String,
      required: true
    },
    formData: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      parsers: {
        vant: VantUIParser,
        element: ElementUIParser
      },
      config: {
        parser: 'element',
        sections: []
      }
    }
  },
  errorCaptured (err, vm, info) {
    console.log(err)
    // -> 错误返回
    console.log(vm)
    // -> vue实例
    console.log(info)
    // -> 在哪个钩子发生错误
    return false
  },
  watch: {
    formData: {
      handler: 'refresh',
      immediate: true
    }
  },
  methods: {
    refresh() {
      if (this.json && this.formData) {
        this.config = JSON.parse(this.json)
      }
    },
    getPreparedSection(section) {
      const config = deepClone(this.config)
      if (config.sections) {
        delete config.sections
      }
      config.section = section
      return config
    },
    /**
     * returns current datas
     */
    getFormData(full) {
      const sectionRefs = this.$refs.section
      let result = {}
      for (let i = 0; i < sectionRefs.length; i++) {
        const sectionRef = sectionRefs[i]
        if (sectionRef.getFormData) {
          const sectionData = sectionRef.getFormData()
          result = this.$lodash.extend(result, sectionData)
        }
      }
      if (full) {
        result = this.$lodash.extend({}, this.formData, result)
      }
      return result
    }
  }
}
</script>
