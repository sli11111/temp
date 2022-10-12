<template>
  <van-cell :title="label" :value="date" @click="show = true" />
  <van-calendar v-model:show="show" @confirm="onConfirm" />
</template>

<script>
export default {
  emits: [ 'update:modelValue' ],
  props: {
    modelValue: {
      type: (Number || Date),
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
      date: null
    }
  },
  watch: {
    modelValue: {
      handler: 'refresh',
      immediate: true
    }
  },
  methods: {
    refresh() {
      if (!this.modelValue) {
        this.date = ''
      } else {
        this.date = this.formatDate(this.modelValue)
      }
    },
    onConfirm(value) {
      this.$emit('update:modelValue', value)
      this.date = this.formatDate(value)
      this.show = false
    },
    formatDate(value) {
      if (!value) {
        return ''
      }
      let date = value instanceof Date ? value : new Date(value)
      return this.$dayjs(date).format('YYYY/MM/DD')
    }
  }
}
</script>

