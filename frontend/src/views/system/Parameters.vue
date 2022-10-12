<template>
  <auto-height-container>
    <el-table
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row
      :default-sort="{prop: 'desc', order: 'ascending'}"
      style="width: 100%"
    >
      <el-table-column
        width="200px"
        align="center"
        :label="$t('system.param_name')"
      >
        <template #default="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column
        prop="desc"
        show-overflow-tooltip
        header-align="center"
        :label="$t('system.param_desc')"
      >
        <template #default="{row}">
          <span>{{ row.desc }}</span>
        </template>
      </el-table-column>

      <el-table-column
        show-overflow-tooltip
        header-align="center"
        :label="$t('system.param_code')"
        width="200"
      >
        <template #default="{row}">
          <span>{{ row.key }}</span>
        </template>
      </el-table-column>

      <el-table-column
        show-overflow-tooltip
        width="200px"
        :label="$t('system.param_default_value')"
        align="center"
      >
        <template #default="{row}">
          <span>{{ row.defaultValue }}</span>
        </template>
      </el-table-column>

      <el-table-column
        width="300px"
        :label="$t('system.param_value')"
        align="center"
      >
        <template #default="{row}">
          <template v-if="row.edit">
            <el-input
              v-model="row.value"
              class="edit-input"
              :size="getSize(-1)"
            />
            <el-button
              class="cancel-btn"
              :size="getSize(-1)"
              type="warning"
              icon="refresh-left"
              @click="cancelEdit(row)"
            >
              {{ $t('common.cancel') }}
            </el-button>
          </template>
          <span v-else>{{ row.value || row.defaultValue }}</span>
        </template>
      </el-table-column>

      <el-table-column
        align="center"
        width="120"
      >
        <template #default="{row}">
          <el-button
            v-if="row.edit"
            :loading="row.loading"
            type="danger"
            :size="getSize(-1)"
            @click="confirmEdit(row)"
          >
            <svg-icon icon-class="save" />
            {{ $t('common.save') }}
          </el-button>
          <el-button
            v-else
            type="primary"
            :size="getSize(-1)"
            @click="handleEdit(row)"
          >
            <el-icon><edit /></el-icon>
            {{ $t('common.edit') }}
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'

import { fetchParams, submitParam } from '@/api/system/params'

import { getSize } from '@/utils/framework.js'

export default {
  components: { AutoHeightContainer },
  data() {
    return {
      list: null,
      listLoading: true
    }
  },
  mounted() {
    this.getList()
  },
  methods: {
    getSize,
    async getList() {
      this.listLoading = true
      const { data } = await fetchParams()
      const items = data.datalist
      this.list = items.map(v => {
        v.edit = false
        v.originalValue = v.value //  will be used when user click the cancel botton
        return v
      })
      this.listLoading = false
    },
    handleEdit(row) {
      row.edit = !row.edit
      if (!row.value) {
        row.value = String(row.defaultValue)
      }
    },
    cancelEdit(row) {
      row.value = row.originalValue
      row.edit = false
      // this.$message({
      //   type: 'warning',
      //   message: this.$t('tips.submit_cancel', { name: row.name })
      // })
    },
    async confirmEdit(row) {
      if (!row.value) {
        row.value = String(row.defaultValue)
      }
      try {
        row.loading = true
        await submitParam(row)
        this.$message({
          type: 'success',
          message: this.$t('common.tips.submit_success', { name: row.name }) + '\n' + this.$t('system.tips.settings_changed')
        })
        row.edit = false
      } catch(error) {
        this.$message({
          type: 'danger',
          message: this.$t('common.tips.submit_fail', { name: row.name })
        })
      }
      row.loading = false
    }
  }
}
</script>

<style scoped>
.edit-input {
  padding-right: 100px;
}
.cancel-btn {
  position: absolute;
  right: 15px;
}
</style>
