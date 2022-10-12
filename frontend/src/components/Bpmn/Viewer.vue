<template>
  <div class="containers">
    <div ref="container" class="vue-bpm-diagram-container" />
  </div>
</template>

<script>
import BpmView from 'bpmn-js/dist/bpmn-viewer.development'
import { getDiagram } from '@/api/workflow'

export default {
  name: 'BpmView',
  props: {
    id: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      diagramXML: null,
      activities: []
    }
  },
  watch: {
    id: function(val) {
      this.$emit('loading')
      this.fetchDiagram(val)
    },
    diagramXML: function(val) {
      this.bpmnViewer.importXML(val)
    }
  },
  mounted() {
    const container = this.$refs.container
    const self = this
    this.bpmnViewer = new BpmView({
      container: container
    })
    this.bpmnViewer.on('import.done', function(event) {
      const error = event.error
      const warnings = event.warnings
      if (error) {
        self.$emit('error', error)
      } else {
        self.$emit('shown', warnings)
      }
      const canvas = self.bpmnViewer.get('canvas')
      canvas.zoom('fit-viewport', 'auto')
      if (self.activities !== null && self.activities !== [] && self.activities !== '') {
        self.activities.forEach(activity => {
          let id = activity.id
          if (id.includes('#')) {
            id = id.substring(0, id.indexOf('#'))
          }
          console.log(id)
          canvas.addMarker(id, 'highlight2')
        })
      }
    })
    // 隐藏logo
    const element = document.getElementsByClassName('bjs-powered-by')[0]
    element.style.display = 'none'
    if (this.id) {
      this.fetchDiagram(this.id)
    }
  },
  methods: {
    fetchDiagram: function(id) {
      const self = this
      if (id) {
        getDiagram(id).then(response => {
          return response.data
        }).then(text => {
          if (text.hasOwnProperty('activities')) {
            self.activities = text.activities
          } else {
            self.activities = ''
          }
          self.diagramXML = text.bpmn20Xml
        }).catch(function(err) {
          self.$emit('error', err)
        })
      }
    }
  }
}
</script>

<style scoped>
.vue-bpm-diagram-container {
  height: 400px;
  width: 100%;
}
</style>
