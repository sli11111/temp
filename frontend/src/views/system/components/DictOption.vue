<template>
  <div class="el-descriptions">
    <div class="el-descriptions__body">
      <div class="el-descriptions__table">
        <el-row
          v-for="i in row"
          :key="i"
          :gutter="5"
        >
          <template
            v-for="j in column"
            :key="j"
          >
            <el-col
              :span="span"
              class="el-descriptions__cell is-right"
            >
              {{ getValue(i, j, true) }}
            </el-col>
            <el-col
              :span="span"
              class="el-descriptions__cell"
            >
              <div
                v-if="!isEnd(i, j)"
                class="name-wrapper"
              >
                <el-tag
                  type="success"
                  checked
                >
                  {{ getValue(i, j) }}
                </el-tag>
              </div>
            </el-col>
          </template>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'DictOption',
  props: {
    data: {
      type: Object,
      default: () => {}
    },
    column: {
      type: Number,
      default: 2
    }
  },
  computed: {
    row() {
      const l = Object.keys(this.data || {}).length
      return l % this.column === 0 ? Math.ceil(l / this.column) : Math.ceil(l / this.column)
    },
    span() {
      return Math.ceil(12 / this.column)
    }
  },
  methods: {
    getValue(i, j, flag) {
      const num = (i - 1) * this.column + (j - 1)
      if (num >= Object.keys(this.data || {}).length) {
        return ''
      }
      return flag ? Object.keys(this.data || {})[num] : this.data[Object.keys(this.data || {})[num]]
    },
    isEnd(i, j) {
      const num = (i - 1) * this.column + (j - 1)
      return num >= Object.keys(this.data || {}).length
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
