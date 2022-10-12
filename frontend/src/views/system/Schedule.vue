<template>
  <auto-height-container>
    <div class="filter-container">
      <el-button-group style="float: right;">
        <el-button
          v-waves
          class="filter-item"
          style="margin-left: 10px;"
          :title="$t('common.refresh')"
          type="primary"
          icon="refresh"
          @click="getList(true)"
        />
      </el-button-group>
    </div>
    <el-table
      v-loading="list_loading"
      :data="datalist"
      border
      fit
      highlight-current-row
      stripe
    >
      <el-table-column
        :label="$t('system.schedule_task')"
        prop="remark"
      >
        <template #default="{row}">
          {{ $t('system.schedule_runner') }}：{{ row.runner }}<br>
          {{ $t('common.desc') }}：{{ row.remark }}
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('system.schedule_cron')"
        align="center"
        width="160"
      >
        <template #default="{row}">
          <span>{{ row.cron }}
            <el-button
              type="text"
              icon="edit"
              @click="showCronInput(row)"
            />
          </span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('system.schedule_status')"
        prop="status"
        align="center"
        width="120"
      >
        <template #default="{row}">
          <el-tag
            v-if="row.status === 'ON'"
            type="success"
            effect="dark"
          >
            {{ $t('system.schedule_status_enabled') }}
          </el-tag>
          <el-tag
            v-if="row.status === 'RUNNING'"
            type="warning"
            effect="dark"
          >
            {{ $t('system.schedule_status_running') }}
          </el-tag>
          <el-tag
            v-if="row.status === 'OFF'"
            type="info"
            effect="dark"
          >
            {{ $t('system.schedule_status_disabled') }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('system.schedule_switch')"
        align="center"
        width="80"
      >
        <template #default="{row}">
          <el-switch
            :disabled="!row.cron || row.status === 'RUNNING'"
            v-model="row.switch"
            active-color="#13ce66"
            inactive-color="#ff4949"
            @change="changeStatus(row)"
          />
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('system.schedule_last_time')"
        width="240"
      >
        <template #default="{row}">
          {{ $t('system.schedule_time') }}: {{ row.lastRun ? $dayjs(row.lastRun).format('YYYY-MM-DD HH:mm:ss') : '-' }}<br>
          {{ $t('system.schedule_cost') }}: {{ lastRunLasts(row) }}<br>
          {{ $t('system.schedule_result') }}: {{ lastRunResult(row) }}
          <el-popover
            placement="bottom"
            width="260"
            trigger="hover"
          >
            <div>
              {{ $t('common.start_time') }}: {{ row.lastRunReport ? $dayjs(row.lastRunReport.startTime).format('YYYY-MM-DD HH:mm:ss') : '-' }}<br>
              {{ $t('common.end_time') }}: {{ row.lastRunReport ? $dayjs(row.lastRunReport.endTime).format('YYYY-MM-DD HH:mm:ss') : '-' }}<br>
              {{ $t('common.remark') }}: <br>
              {{ row.lastRunReport ? row.lastRunReport.remark : '-' }}
            </div>
            <template #reference>
              <el-link>
                <el-icon><question /></el-icon>
              </el-link>
            </template>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column
        width="220"
        fixed="right"
        align="center"
      >
        <template #default="{row}">
          <el-button-group>
            <el-tooltip
              class="item"
              effect="dark"
              :content="$t('common.execute')"
              placement="top"
            >
              <el-button
                :disabled="row.status === 'OFF'"
                :loading="row.status === 'RUNNING'"
                type="primary"
                icon="caret-right"
                @click="showExecuteConfirm(row)"
              />
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="dark"
              :content="$t('common.reset')"
              placement="top"
            >
              <el-button
                :disabled="row.status !== 'RUNNING'"
                type="primary"
                icon="refresh-left"
                @click="showResetConfirm(row)"
              />
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="dark"
              :content="$t('common.history')"
              placement="top"
            >
              <el-button
                type="primary"
                @click="showHistoryDialog(row)"
              >
                <svg-icon icon-class="history" />
              </el-button>
            </el-tooltip>
          </el-button-group>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      v-model="cron_form_visible"
      width="75%"
    >
      <template #title>
        <svg-icon icon-class="cron" />Cron {{$t('common.expression')}}
      </template>
      <CronInput
        ref="cronInput"
        v-model="current_row.cron"
        mode="simple"
      />
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="cron_form_visible = false">
            {{ $t('common.cancel') }}
          </el-button>
          <el-button
            type="primary"
            :loading="submitting"
            @click="changeCron"
          >
            {{ $t('common.confirm') }}
          </el-button>
        </div>
      </template>
    </el-dialog>
    <el-dialog
      v-model="cron_history_visible"
      width="75%"
    >
      <template #title>
        <svg-icon icon-class="cron" />计划任务执行历史
      </template>
      <el-table
        v-loading="history_datalist_loading"
        :data="history_datalist"
        border
        fit
        highlight-current-row
        stripe
        style="width: 100%;"
      >
        <el-table-column
          label="开始时间"
          width="200"
          align="center"
        >
          <template #default="{row}">
            {{ $dayjs(row.startTime).format('YYYY-MM-DD HH:mm:ss') }}
          </template>
        </el-table-column>
        <el-table-column
          label="结束时间"
          width="200"
          align="center"
        >
          <template #default="{row}">
            {{ $dayjs(row.endTime).format('YYYY-MM-DD HH:mm:ss') }}
          </template>
        </el-table-column>
        <el-table-column
          label="执行结果"
          width="120"
          align="center"
        >
          <template #default="{row}">
            <el-tag
              :type="row.result === 'SUCCESS' ? 'success' : 'danger'"
              effect="dark"
            >
              {{ $dicts.convert('REQUEST_RESULT', row.result) }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="备注">
          <template #default="{row}">
            {{ row.remark }}
          </template>
        </el-table-column>
      </el-table>
      <pagination
        v-model="history_datalist_page"
        hide-on-single-page
        style="padding: 0; margin-top: 20px"
        @pagination="getHistoryList"
      />
    </el-dialog>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import CronInput from './components/CronInput.vue'
import Pagination from '@/components/Pagination/index.vue'

import waves from '@/directive/waves'

import { fetchSchedules, submitSchedule, resetSchedule, executeSchedule, fetchScheduleHistories } from '@/api/system/schedule'
import { addHandler, delHandler, sendMessage } from '@/api/system/ws'

import { deepClone } from '@/utils'

export default {
  name: 'SystemSchedule',
  components: { AutoHeightContainer, CronInput, Pagination },
  directives: { waves },
  data() {
    return {
      datalist: [],
      list_loading: false,
      refresh_timer: null,
      refresh_time: null,
      cron_form_visible: false,
      cron_history_visible: false,
      current_row: {},
      submitting: false,
      history_datalist: [],
      history_datalist_loading: false,
      history_datalist_runner: '',
      history_datalist_page: { pageNumber: 1, pageSize: 10, totalRecord: 0, totalPage: 0 }
    }
  },
  mounted() {
    const that = this
    addHandler('sys-schedule', async () => await that.getList())
    sendMessage('sys-schedule', { on: true })
    this.getList()
  },
  unmounted() {
    // clearInterval(this.refresh_timer)
    sendMessage('sys-schedule', { on: false })
    delHandler('sys-schedule')
  },
  methods: {
    async getList(showLoading = false) {
      this.list_loading = showLoading
      const { data } = await fetchSchedules()
      const datalist = data.datalist
      for (let i = 0; i < datalist.length; i++) {
        datalist[i].on = datalist[i].status !== 'STOPPED'
        datalist[i].disabled = datalist[i].status === 'RUNNING'
        datalist[i].switch = datalist[i].status === 'ON'
      }
      this.datalist = datalist
      this.refresh_time = this.$dayjs().format('YYYY-MM-DD HH:mm:ss')
      this.list_loading = false
    },
    async getHistoryList() {
      this.history_datalist_loading = true
      const { data } = await fetchScheduleHistories(this.history_datalist_runner, this.history_datalist_page)
      this.history_datalist = data.datalist
      this.history_datalist_page = data.page
      this.history_datalist_loading = false
    },
    async changeStatus(row) {
      const new_status = row.status === 'OFF' ? 'ON' : 'OFF'
      const new_row = deepClone(row)
      new_row.status = new_status
      await submitSchedule(new_row)
      await this.getList()
    },
    showCronInput(row) {
      this.current_row = row
      this.cron_form_visible = true
    },
    async changeCron() {
      const new_cron = this.$refs.cronInput.cron1
      const new_row = deepClone(this.current_row)
      new_row.cron = new_cron
      await submitSchedule(new_row)
      await this.getList()
      this.cron_form_visible = false
    },
    lastRunLasts(row) {
      if (row.lastRunReport) {
        const start = this.$dayjs(row.lastRunReport.startTime)
        const end = this.$dayjs(row.lastRunReport.endTime)
        return this.$dayjs.duration(end.diff(start)).humanize()
      }
      return '-'
    },
    lastRunResult(row) {
      if (row.lastRunReport) {
        return this.$dicts.convert('REQUEST_RESULT', row.lastRunReport.result)
      }
      return '-'
    },
    async showExecuteConfirm(row) {
      this.$confirm(
        this.$t('system.tips.confirm_execute_schedule', { name: row.remark }), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        await executeSchedule(row.runner)
        await this.getList()
      }).catch(() => {})
    },
    async showResetConfirm(row) {
      this.$confirm(
        this.$t('system.tips.confirm_reset_schedule', { name: row.remark }), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        await resetSchedule(row.runner)
        await this.getList()
      }).catch(() => {})
    },
    showHistoryDialog(row) {
      this.history_datalist_page.pageNumber = 1
      this.history_datalist = []
      this.history_datalist_runner = row.runner
      this.cron_history_visible = true
      this.getHistoryList()
    }
  }
}
</script>
