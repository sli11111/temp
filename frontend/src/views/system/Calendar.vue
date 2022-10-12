<template>
  <auto-height-container>
    <el-calendar ref="calendar" v-model="current_day">
      <template #header="{ date }">
        <span style="font-size: 26px; font-weight: bold;">{{ date }}</span>
        <el-button-group>
          <el-button size="small" @click="selectDate('prev-year')">上一年</el-button>
          <el-button size="small" @click="selectDate('prev-month')">上一月</el-button>
          <el-button size="small" @click="selectDate('today')">今天</el-button>
          <el-button size="small" @click="selectDate('next-month')">下一月</el-button>
          <el-button size="small" @click="selectDate('next-year')">下一年</el-button>
        </el-button-group>
      </template>
      <template #dateCell="{ data }">
        <div class="day-block" :style="(getType(data.date) !== '0' ? 'color: red' : 'black') + (data.type !== 'current-month' ? '; opacity: .4' : '')">
          <span style="font-size: 22px; font-weight: bold;">{{$dayjs(data.date).format('D')}}</span>&nbsp;
          <span style="font-size: 12px">{{getRemark(data.date)}}</span>
          <el-link class="day-block-edit-link" @click="openEditForm(data.date)">
            <svg-icon icon-class="edit" />
          </el-link>
        </div>
      </template>
    </el-calendar>
  </auto-height-container>
  <el-dialog v-model="form_visible" width="16%">
    <template #title>
      <svg-icon icon-class="edit" /> {{ form_data ? form_data.date : '' }}
    </template>
    <el-select v-model="form_data.holidayFlag" style="width: 100%">
      <el-option value="0" label="工作日" />
      <el-option value="1" label="节假日" />
      <el-option value="2" label="休息日" />
    </el-select>
    <el-input v-model="form_data.remark" />
    <template #footer>
      <el-button type="primary" :loading="form_submitting" @click="submitCanendar">
        保存
      </el-button>
    </template>
  </el-dialog>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import { deepClone } from '@/utils'

import { fetchCalendar, saveCalendar } from '@/api/system/holiday'

export default {
  components: { AutoHeightContainer },
  data() {
    return {
      current_day: this.$dayjs().toDate(),
      current_start: null,
      current_end: null,
      holiday_map: {},
      form_visible: false,
      form_data: null,
      form_submitting: false
    }
  },
  watch: {
    current_day: {
      handler: 'loadDataPossible',
      immediate: true
    }
  },
  methods: {
    selectDate(val) {
      this.$refs.calendar.selectDate(val)
    },
    async loadDataPossible(force) {
      const startDate = this.$dayjs(this.current_day).startOf('month').startOf('week')
      const endDate = startDate.add(41, 'day')

      const start = startDate.format('YYYYMMDD')
      const end   = endDate.format('YYYYMMDD')
      
      if (force || start !== this.current_start || end !== this.current_end) {
        this.current_start = start
        this.current_end   = end
        const { data } = await fetchCalendar(start, end)
        this.holiday_map = data
      }
    },
    getRemark(date) {
      const key = this.$dayjs(date).format('YYYYMMDD')
      if (this.holiday_map[key]) {
        const remark = this.holiday_map[key].remark
        if (remark.startsWith('周')) {
          return ''
        }
        return this.holiday_map[key].remark
      }
      return ''
    },
    getType(date) {
      const key = this.$dayjs(date).format('YYYYMMDD')
      if (this.holiday_map[key]) {
        return this.holiday_map[key].holidayFlag
      }
      return '0'
    },
    openEditForm(date) {
      const key = this.$dayjs(date).format('YYYYMMDD')
      let form_data = { dateId: key }
      if (this.holiday_map[key]) {
        form_data = deepClone(this.holiday_map[key])
      }
      this.form_data = form_data
      this.form_visible = true
    },
    async submitCanendar() {
      this.form_submitting = true
      try {
        const data = deepClone(this.form_data)
        await saveCalendar(data)
        this.form_visible = false
        this.loadDataPossible(true)
      } catch(e) {

      }
      this.form_submitting = false
    }
  }
}
</script>

<style lang="scss" scoped>
.darkMode {
  
}
.el-calendar {
  background-color: transparent;
}
.day-block {
  width: 100%;
  height: 100%;
  .day-block-edit-link {
    display: none;
  }
  &:hover {
    .day-block-edit-link {
      display: inline;
    }
  }
}
</style>
