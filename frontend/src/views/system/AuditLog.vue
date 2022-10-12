<template>
  <auto-height-container>
    <div class="filter-container">
      <el-input
        v-model="search_param.text"
        :placeholder="$t('system.operations_content')"
        clearable
        class="filter-item"
        style="width: 200px;"
        @keyup.enter="handleFilter"
        @clear="handleFilter"
      />
      <el-date-picker
        v-model="search_param.timerange"
        type="datetimerange"
        clearable
        class="filter-item"
        :range-separator="$t('common.to')"
        :start-placeholder="$t('common.start_time')"
        :end-placeholder="$t('common.end_time')"
        @change="handleFilter"
      />
      <el-button
        v-waves
        type="primary"
        icon="search"
        class="filter-item"
        @click="handleFilter"
      >
        {{ $t('common.search') }}
      </el-button>
    </div>
    <el-table
      v-loading="list_loading"
      :data="datalist"
      row-key="id"
      border
      fit
      highlight-current-row
      stripe
      style="width: 100%;"
      default-expand-all
    >
      <el-table-column
        :label="$t('system.operations_time')"
        prop="datetime"
        align="center"
        width="220"
      >
        <template #default="{ row }">
          <span>{{ $dayjs(row.operBgnTs).format('YYYY-MM-DD HH:mm:ss.SSS') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作人" header-align="center">
        <el-table-column
          :label="$t('common.username')"
          prop="username"
          align="center"
          width="120"
        >
          <template #default="{ row }">
            <span>{{ row.userName }}</span>
          </template>
        </el-table-column>
         <el-table-column
          :label="$t('system.operations_client_ip')"
          prop="ip"
          align="center"
          width="120"
        >
          <template #default="{ row }">
            <span>{{ row.clientIp }}</span>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="审计对象" header-align="center">
        <el-table-column
          :label="$t('system.operations_title')"
          prop="title"
          show-overflow-tooltip
          header-align="center"
          width="260"
        >
          <template #default="{ row }">
            <span>{{ row.modelName }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :label="$t('system.operations_content')"
          prop="content"
          show-overflow-tooltip
          header-align="center"
        >
          <template #default="{ row }">
            <span>{{ row.funcName }}</span>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="执行动作" header-align="center">
        <el-table-column
            :label="$t('system.operations_method')"
            prop="method"
            show-overflow-tooltip
            align="center"
            width="80"
        >
          <template #default="{ row }">
            <span>{{ row.method }}</span>
          </template>
        </el-table-column>
        <el-table-column
            :label="$t('system.operations_url')"
            prop="url"
            show-overflow-tooltip
            header-align="center"
            width="180"
        >
          <template #default="{ row }">
            <span>{{ row.url }}</span>
          </template>
        </el-table-column>
        <el-table-column
            :label="$t('system.operations_cost')"
            show-overflow-tooltip
            align="center"
            width="120"
        >
          <template #default="{ row }">
            <span>{{ row.operEndTs - row.operBgnTs }}ms</span>
          </template>
        </el-table-column>
        <el-table-column
            :label="$t('system.operations_result')"
            show-overflow-tooltip
            align="center"
            width="120"
        >
          <template #default="{ row }">
            <span>{{ row.reqRest }}</span>
          </template>
        </el-table-column>
      </el-table-column>
    </el-table>
    <pagination
      v-model="page"
      hide-on-single-page
      style="padding: 0; margin-top: 20px"
      @pagination="getList"
    />
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import Pagination from '@/components/Pagination/index.vue'

import waves from '@/directive/waves'

import { fetchOperations } from '@/api/system/operation'

export default {
  components: { AutoHeightContainer, Pagination },
  directives: { waves },
  data() {
    const end = new Date()
    const start = new Date()
    start.setTime(start.getTime() - 1000 * 600)
    return {
      list_loading: false,
      download_loading: false,
      datalist: [],
      page: { pageNumber: 1, pageSize: 10, totalRecord: 0, totalPage: 0 },
      search_param: {
        timerange: [start, end]
      }
    }
  },
  mounted() {
    this.getList()
  },
  methods: {
    async getList() {
      this.list_loading = true
      const { data } = await fetchOperations(this.page, this.search_param)
      this.datalist = data.datalist
      this.page = data.page
      this.list_loading = false
    },
    handleFilter() {
      this.page.pageNumber = 1
      this.getList()
    }
  }
}
</script>
