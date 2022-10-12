<template>
  <div class="app-container">
    <div ref="canvas" class="canvas" />
    <div id="js-properties-panel" class="panel" />
  </div>
</template>

<script>
import BpmModeler from 'bpmn-js/dist/bpmn-modeler.development'
import propertiesPanelModule from 'bpmn-js-properties-panel'
import propertiesProviderModule from 'bpmn-js-properties-panel/lib/provider/camunda'
import camundaModdleDescriptor from 'camunda-bpmn-moddle/resources/camunda'
import customTranslate from './utils/customTranslate'
// 以下为bpmn工作流绘图工具的样式
import 'bpmn-js/dist/assets/diagram-js.css' // 左边工具栏以及编辑节点的样式
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn-codes.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn-embedded.css'
import 'bpmn-js-properties-panel/dist/assets/bpmn-js-properties-panel.css' // 右边工具栏样式
// import customProviderModule from './customPropertiesPanel/provider/custom'

const xmlStr = '<?xml version="1.0" encoding="UTF-8"?><bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:camunda="http://camunda.org/schema/1.0/bpmn" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" id="Definitions_16heepc" targetNamespace="http://bpmn.io/schema/bpmn" exporter="Camunda Modeler" exporterVersion="3.7.2"></bpmn:definitions>'
export default {
  name: 'BpmModeler',
  props: {
    bpmn: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      // bpm建模器
      container: null,
      canvas: null,
      bpmnModeler: null,
      bpmnXml: '',
      bpmnData: {
        processId: '',
        processName: '',
        versionTag: ''
      }
    }
  },
  created() {
  },
  mounted() {
    // console.log(this.bpmn)
    debugger
    this.init(this.bpmn)
  },
  methods: {
    async init(val) {
      // 获取到属性ref为“canvas”的dom节点
      const canvas = this.$refs.canvas
      // 建模
      this.bpmnModeler && this.bpmnModeler.destroy()
      let bpmnModeler = new BpmModeler(
        {
          container: canvas,
          // 添加控制板
          propertiesPanel: {
            parent: '#js-properties-panel'
          },
          additionalModules: [
            // 左边工具栏以及节点
            propertiesProviderModule,
            // 右边的工具栏
            propertiesPanelModule,
            { translate: ['value', customTranslate] }
            // ,customProviderModule
          ],
          moddleExtensions: {
            camunda: camundaModdleDescriptor
          }
        })
      // await this.createNewDiagram(val)

      if (val === '') {
        val = xmlStr
      }

      try {
        const result = await bpmnModeler.importXML(val);
        const { warnings } = result;
        console.log(warnings);
        const bpmnCanvas = bpmnModeler.get('canvas')
        bpmnCanvas.zoom('fit-viewport')
      } catch (err) {
        console.log(err.message, err.warnings);
      }

      this.bpmnModeler = bpmnModeler
      // 隐藏logo
      const element = document.getElementsByClassName('bjs-powered-by')[0]
      element.style.display = 'none'
    },
    // async createNewDiagram(val, bpmnModeler) {
    //   // 将字符串转换成图显示出来
    //   if (val === '') {
    //     val = xmlStr
    //   }
    //   // bpmnModeler.importXML(val, (err) => {
    //   //   if (err) {
    //   //     // console.log(xml)
    //   //     console.error(err)
    //   //   }
    //   //   // 设置图像大小适应
    //   //   const bpmnCanvas = bpmnModeler.get('canvas')
    //   //   bpmnCanvas.zoom('fit-viewport')
    //   // })

    //   // try {
    //   //   debugger
    //   //   const result = await bpmnModeler.importXML(xmlStr);
    //   //   const { warnings } = result;
    //   //   console.log(warnings);
    //   //   const bpmnCanvas = bpmnModeler.get('canvas')
    //   //   bpmnCanvas.zoom('fit-viewport')
    //   // } catch (err) {
    //   //   console.log(err.message, err.warnings);
    //   // }
    // },
    getXml() {
      // 获取xml字符串
      this.bpmnXml = ''
      this.bpmnModeler.saveXML({ format: true }, (err, xml) => {
        if (err) {
          alert(err)
        }
        this.bpmnXml = xml
        return xml
      })
      return this.bpmnXml
    },
    getData() {
      this.bpmnData.processId = this.bpmnModeler.getDefinitions().rootElements[0].id
      this.bpmnData.versionTag = this.bpmnModeler.getDefinitions().rootElements[0].versionTag
      this.bpmnData.processName = this.bpmnModeler.getDefinitions().rootElements[0].name
      return this.bpmnData
    }
  }
}
</script>

<style scoped>
.canvas{
  margin: -20px;
  width: 100%;
  height: calc(100vh);
}
.panel{
  position: absolute;
  right: 0;
  top: 0;
  width: 300px;
  height: calc(100vh);
  overflow-x: hidden !important;
}
</style>
