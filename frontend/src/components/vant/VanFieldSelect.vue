<template>
  <van-cell :title="label" :value="text" @click="show = true" />
  <van-action-sheet v-model:show="show">
    <van-picker :title="label" :columns="columns" :default-index="defaultIndex" @confirm="onConfirm" @cancel="onCancel" />
  </van-action-sheet>
</template>

<script>
export default {
  emits: [ 'update:modelValue' ],
  props: {
    modelValue: {
      type: String,
      default: null
    },
    dict: {
      type: Object,
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
      columns: []
    }
  },
  watch: {
    dict: {
      handler: 'updateColumns',
      immediate: true
    }
  },
  computed: {
    text() {
      for (let i = 0; i < this.columns.length; i++) {
        if (this.modelValue === this.columns[i].key) {
          return this.columns[i].text
        }
      }
      return ''
    },
    defaultIndex() {
      for (let i = 0; i < this.columns.length; i++) {
        if (this.modelValue === this.columns[i].key) {
          return i
        }
      }
      return 0
    }
  },
  methods: {
    updateColumns() {
      if (!this.dict) {
        this.columns = []
      }
      const columns = []
      for (const key in this.dict) {
        columns.push({ text: this.dict[key], key })
      }
      this.columns = columns
    },
    onConfirm(value, index) {
      this.$emit('update:modelValue', this.columns[index].key)
      this.show = false
    },
    onCancel() {
      this.show = false
    }
  }
}
</script>
