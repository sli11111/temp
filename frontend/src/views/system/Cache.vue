<template>
  <auto-height-container>
    <el-table
      v-loading="list_loading"
      :data="datalist"
      style="width: 100%; margin-bottom: 20px;"
      row-key="key"
      border
      :tree-props="{children: 'content'}"
    >
      <el-table-column
        :label="getCacheKeyColumnLabel()"
        width="220"
        show-overflow-tooltip
      >
        <template #default="{row}">
          <svg-icon
            v-if="row.content"
            icon-class="chip"
          />
          <svg-icon
            v-else
            icon-class="data"
          />
          {{ row.key }}
        </template>
      </el-table-column>
      <el-table-column
        prop="cacheValue"
        :label="$t('system.cache_val')"
        show-overflow-tooltip
      />
      <el-table-column
        prop="size"
        :label="$t('system.cache_size')"
        width="80"
        align="center"
      />
      <el-table-column
        prop="refreshTime"
        :label="$t('system.cache_refresh_time')"
        width="180"
        align="center"
      />
      <el-table-column
        align="center"
        width="180"
        fixed="right"
      >
        <template #default="{row}">
          <el-button-group>
            <el-button
              v-if="row.content"
              :loading="list_loading"
              type="primary"
              size="small"
              @click="refreshCache(row)"
            >
              <el-icon><refresh /></el-icon>
              {{ $t('common.refresh') }}
            </el-button>
            <el-button
              :loading="list_loading"
              type="warning"
              size="small"
              @click="handleEvict(row)"
            >
              <el-icon><delete /></el-icon>
              {{ $t('common.clear') }}
            </el-button>
          </el-button-group>
        </template>
      </el-table-column>
    </el-table>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'

import { fetchCaches, fetchCacheByName, evictCacheByName, evictCacheByKey } from '@/api/system/cache'
import { deepClone } from '@/utils'

const processCacheInfo = function(datalist, refreshTime) {
  for (let i = 0; i < datalist.length; i++) {
    datalist[i].key = datalist[i].cacheName
    datalist[i].refreshTime = refreshTime
    datalist[i].size = datalist[i].content ? datalist[i].content.length : 0
    for (let j = 0; j < datalist[i].content.length; j++) {
      datalist[i].content[j].key = datalist[i].content[j].cacheKey
      datalist[i].content[j].refreshTime = refreshTime
    }
  }
  return datalist
}

export default {
  components: { AutoHeightContainer },
  data() {
    return {
      datalist: [],
      list_loading: false
    }
  },
  async mounted() {
    await this.getList()
  },
  methods: {
    async getList() {
      this.list_loading = true
      const { data } = await fetchCaches()
      const refreshTime = this.$dayjs().format('YYYY-MM-DD HH:mm:ss')
      this.datalist = processCacheInfo(data.datalist, refreshTime)
      this.list_loading = false
    },
    getCacheKeyColumnLabel() {
      return this.$t('system.cache_name') + ' / ' + this.$t('system.cache_key')
    },
    getRemoveHint(row) {
      if (row.content) {
        return this.$t('tips.confirm_evict_cache', { name: row.key })
      } else {
        return this.$t('tips.confirm_evict_cache_by_key', { name: row.key })
      }
    },
    async refreshCache(row) {
      const cacheName = row.cacheName
      this.list_loading = true
      const { data } = await fetchCacheByName(cacheName)
      const refreshTime = this.$dayjs().format('YYYY-MM-DD HH:mm:ss')
      const caches = processCacheInfo(data.datalist, refreshTime)
      const datalist = deepClone(this.datalist)
      for (let i = 0; i < datalist.length; i++) {
        if (datalist[i].cacheName === cacheName) {
          datalist[i] = caches[0]
          break
        }
      }
      this.datalist = datalist
      this.list_loading = false
    },
    async handleEvict(row) {
      const message = this.getRemoveHint(row)
      this.$confirm(message, this.$t('common.tips'), {
        type: 'warning',
        confirmButtonText: this.$t('common.confirm'),
        cancelButtonText: this.$t('common.cancel')
      }).then(async () => {
        if (row.content) {
          await evictCacheByName(row.cacheName)
        } else {
          await evictCacheByKey(row.cacheName, row.cacheKey)
        }
        await this.refreshCache(row)
      }).catch(() => {})
    }
  }
}
</script>
