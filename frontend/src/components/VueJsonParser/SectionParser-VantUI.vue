<template>
  <van-form>
    <van-cell-group inset>
      <template v-if="config.section.title" #title>
        {{ config.section.title }}
      </template>
      <template v-for="(item, $index) in config.section.items" :key="$index">
        <van-field
          v-if="item.type === 'text'" 
          v-model="__data__[item.key]" 
          :label="item.label || null"
          :placeholder="item.placeholder || ''"
          input-align="right"
        />
        <van-field-select
          v-else-if="item.type === 'select'" 
          v-model="__data__[item.key]" 
          :label="item.label || null"
          :dict="determineDict(item, $dicts)"
        />
        <van-field-date
          v-else-if="item.type === 'date'" 
          v-model="__data__[item.key]" 
          :label="item.label || null"
        />
        <van-field-date-range
          v-else-if="item.type === 'date-range'" 
          v-model="__data__[item.key.join(':')]" 
          :label="item.label || null"
        />
      </template>
    </van-cell-group>
  </van-form>
</template>

<script>
import * as utils from './utils'
import { extractObjectAsData, extractDataAsObject } from './funcs.js'

import VanFieldSelect from '@/components/vant/VanFieldSelect.vue'
import VanFieldDate from '@/components/vant/VanFieldDate.vue'
import VanFieldDateRange from '@/components/vant/VanFieldDateRange.vue'

export default {
  components: { VanFieldSelect, VanFieldDate, VanFieldDateRange },
  props: {
    config: {
      type: Object,
      required: true
    },
    formData: {
      type: Object,
      default: {}
    }
  },
  data() {
    return {
      __data__: {}
    }
  },
  watch: {
    formData: {
      handler: 'refresh',
      immediate: true
    }
  },
  methods: {
    ...utils,
    refresh() {
      let __data__ = {}
      if (this.config.section && this.config.section.items) {
        extractObjectAsData(this.formData, this.config.section.items, __data__)
      }
      this.__data__ = __data__
    },
    getFormData() {
      const result = {}
      for (const key in this.__data__) {
        extractDataAsObject(this.__data__, key, result)
      }
      return result
    }
  }
}
</script>
