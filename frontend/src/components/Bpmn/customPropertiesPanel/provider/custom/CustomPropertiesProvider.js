import inherits from 'inherits'

import PropertiesActivator from 'bpmn-js-properties-panel/lib/PropertiesActivator'
import {
  is
} from 'bpmn-js/lib/util/ModelUtil'

import idProps from 'bpmn-js-properties-panel/lib/provider/bpmn/parts/IdProps'
import nameProps from 'bpmn-js-properties-panel/lib/provider/bpmn/parts/NameProps'
import executableProps from 'bpmn-js-properties-panel/lib/provider/bpmn/parts/ExecutableProps'
import customDefinedProps from './parts/CustomProps'

function createGeneralTabGroups(element, bpmnFactory, canvas, elementRegistry, translate) {
  // 所有配置统一放置General面板
  var generalGroup = {
    id: 'general',
    label: 'General',
    entries: []
  }

  // 所有属性共有的
  idProps(generalGroup, element, translate) // id
  nameProps(generalGroup, element, bpmnFactory, canvas, translate) // name

  // Process额外包含的
  if (is(element, 'bpmn:Process')) {
    executableProps(generalGroup, element, translate) // 可执行 isExecutable
    customDefinedProps(generalGroup, element) // 版本标记 camunda:versionTag
  }

  // UserTask额外包含的
  if (is(element, 'bpmn:UserTask')) {
    customDefinedProps(generalGroup, element) // camunda:candidateUsers camunda:candidateGroups
  }

  return [
    generalGroup
  ]
}

// 这里是要用到什么就引入什么
export default function AuthorityPropertiesProvider(
  eventBus, bpmnFactory, canvas,
  elementRegistry, translate
) {
  PropertiesActivator.call(this, eventBus)

  this.getTabs = function(element) {
    var generalTab = {
      id: 'general',
      label: '基本信息',
      groups: createGeneralTabGroups(element, bpmnFactory, canvas, elementRegistry, translate)
    }

    return [
      generalTab
    ]
  }
}

inherits(AuthorityPropertiesProvider, PropertiesActivator)
