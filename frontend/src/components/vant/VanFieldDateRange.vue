<template>
  <van-cell :title="label" @click="show = true">
    {{text}}
  </van-cell>
  <van-calendar v-model:show="show" type="range" :default-date="currentModelValue" @confirm="onConfirm" />
</template>

<script>
export default {
  emits: [ 'update:modelValue' ],
  props: {
    modelValue: {
      type: Array,
      default: null
    },
    label: {
      type: String,
      default: null
    },
    placeholder: {
      type: String,
      default: null
    }
  },
  data() {
    return {
      show: false,
      minDate: null,
      maxDate: null
    }
  },
  watch: {
    modelValue: {
      handler: 'refresh',
      immediate: true
    }
  },
  computed: {
    text() {
       if (this.modelValue && this.modelValue.length === 2 && this.modelValue[0] && this.modelValue[1]) {
        let date1 = this.modelValue[0] instanceof Date ? this.modelValue[0] : new Date(this.modelValue[0])
        let date2 = this.modelValue[1] instanceof Date ? this.modelValue[1] : new Date(this.modelValue[1])
        return this.$dayjs(date1).format('YYYY/MM/DD') + '-' + this.$dayjs(date2).format('YYYY/MM/DD')
      }
      return ''
    },
    currentModelValue() {
      if (this.modelValue && this.modelValue.length === 2 && this.modelValue[0] && this.modelValue[1]) {
        let date1 = this.modelValue[0] instanceof Date ? this.modelValue[0] : new Date(this.modelValue[0])
        let date2 = this.modelValue[1] instanceof Date ? this.modelValue[1] : new Date(this.modelValue[1])
        return [date1, date2]
      }
      return null
    }
  },
  methods: {
    refresh() {
      // if (this.modelValue && this.modelValue.length === 2) {
      //   this.minDate = this.modelValue[0] instanceof Date ? this.modelValue[0] : new Date(this.modelValue[0])
      //   this.maxDate = this.modelValue[1] instanceof Date ? this.modelValue[1] : new Date(this.modelValue[1])
      // } else {
      //   this.minDate = null
      //   this.maxDate = null
      // }
    },
    onConfirm(values) {
      this.$emit('update:modelValue', values)
      this.show = false
    },
  }
}
</script>

