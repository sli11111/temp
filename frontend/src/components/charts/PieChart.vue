<template>
  <div v-bind="$attrs" :style="{height: height, width: width}" />
</template>

<script>
import * as echarts from 'echarts/lib/echarts'
import 'echarts/theme/macarons'
import resize from './resize'
import default_options from './options'

export default {
  name: 'ArkPieChart',
  mixins: [resize],
  props: {
    value: {
      type: Array,
      default: null
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '360px'
    },
    colors: {
      type: Array,
      default: function() {
        return default_options.color
      }
    },
    unitName: {
      type: String,
      default: ''
    },
    title: {
      type: String,
      default: ''
    },
    debug: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      chart: null
    }
  },
  watch: {
    value: {
      handler: 'refresh',
      immediate: true
    }
  },
  methods: {
    options() {
      if (!this.value) {
        return {}
      }
      const series = []
      const titles = []
      const series_count = this.value.length
      for (let series_num = 0; series_num < this.value.length; series_num++) {
        const serie_data = this.value[series_num]
        const data = []
        for (const name in serie_data.data) {
          const value = serie_data.data[name]
          data.push({ name, value })
        }
        const title = {
          text: serie_data.title || this.title,
          left: (50 / series_count) * (series_num * 2 + 1) + '%',
          top: '50%',
          textAlign: 'center',
          textStyle: {
            fontSize: 14,
            color: 'white'
          }
        }
        titles.push(title)
        const serie = {
          name: serie_data.title || this.title,
          type: 'pie',
          radius: ['0%', '60%'],
          avoidLabelOverlap: true,
          itemStyle: {
            borderColor: '#fff',
            borderWidth: 1
          },
          label: {
            alignTo: 'edge',
            borderWidth: 1,
            formatter: '{name|{b}}\n{data|{c} ' + this.unitName + '}',
            margin: '10%',
            bleedMargin: '10',
            distanceToLabelLine: -70,
            edgeDistance: 10,
            lineHeight: 15,
            backgroundColor: 'transparent',
            rich: {
              data: {
                fontSize: 10,
                color: '#999'
              }
            }
          },
          labelLine: {
            showAbove: true,
            length: 15,
            length2: 1,
            maxSurfaceAngle: 180
          },
          top: '0%',
          width: (this.$el.clientWidth / series_count) + 'px',
          left: (50 / series_count) * (series_num * 2) + '%',
          data,
          animationType: 'scale',
          animationEasing: 'elasticOut',
          animationDelay: function() {
            return Math.random() * 200
          }
        }
        series.push(serie)
      }
      const options = {
        color: this.colors,
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}' + this.unitName + ')'
        },
        title: titles,
        series
      }
      if (this.debug) {
        console.log(options)
      }
      return options
    },
    refresh() {
      this.$nextTick(() => {
        this.chartWidth = this.$el.clientWidth
        const options = this.options()
        if (!this.chart) {
          this.chart = echarts.init(this.$el, 'macarons')
        }
        this.chart.setOption(options)
      })
    }
  }
}
</script>
