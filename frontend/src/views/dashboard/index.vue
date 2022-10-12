<template>
  <auto-height-container class="dashboard-container classic">
    <el-row :gutter="20">
      <el-col :span="24">
        <el-card shadow="never" class="dashboard-block">
          <template #header>
            <div class="clearfix">
              <span>网关流量</span>
            </div>
          </template>
          <LogCountChart an="service-gateway" key1="ACCESS" key2="ARRIVED" chart-type="bar" :hours="12" :show-timestamps="true" />
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="24">
        <el-card shadow="never" class="dashboard-block">
          <template #header>
            <div class="clearfix">
              <span>服务健康</span>
            </div>
          </template>
          <el-row :gutter="10">
            <el-col v-for="service in applications" :key="service.name" :span="6">
              <ServiceHealthCard :service="service" />
            </el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-card shadow="never" class="dashboard-block">
          <template #header>
            <div class="clearfix">
              <span>热门服务排名</span>
            </div>
          </template>
          <ServiceRankChart by="times" />
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card shadow="never" class="dashboard-block">
          <template #header>
            <div class="clearfix">
              <span>慢服务排名</span>
            </div>
          </template>
          <ServiceRankChart by="cost" />
        </el-card>
      </el-col>
    </el-row>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import ServiceHealthCard from '@/views/devops/monitor/Service/components/ServiceHealthCard.vue'
import LogCountChart from '@/views/devops/monitor/Service/components/LogCountChart.vue'
import ServiceRankChart from '@/views/devops/monitor/Service/components/ServiceRankChart.vue'

import { getApplications, fetchServiceHealth } from '@/api/devops/monitor-service.js'

export default {
  components: { AutoHeightContainer, ServiceHealthCard, LogCountChart, ServiceRankChart },
  data() {
    return {
      applications: []
    }
  },
  mounted() {
    this.refreshApplications()
  },
  methods: {
    async refreshApplications() {
      const applications_raw = await getApplications()
      const now = new Date()
      const searchParam = {
        startTime: now.getTime() - (1000 * 60 * 60 * 4),
        endTime: now.getTime()
      }
      const { data } = await fetchServiceHealth(searchParam)
      const applications = []
      for (const app of applications_raw) {
        for (const health_info of data) {
          if (health_info.an.toUpperCase() === app.name) {
            app.health_info = health_info
          }
        }
        applications.push(app)
      }
      this.applications = applications
    }
  }
}
</script>
