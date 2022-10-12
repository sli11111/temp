import entryFactory from 'bpmn-js-properties-panel/lib/factory/EntryFactory'
import { is } from 'bpmn-js/lib/util/ModelUtil' // is做类型判断

export default function(group, element) {
  if (is(element, 'bpmn:UserTask')) {
    // Candidate Users
    group.entries.push(entryFactory.textField({
      id: 'candidateUsers',
      label: '候选用户',
      modelProperty: 'candidateUsers'
    }))

    // Candidate Groups
    group.entries.push(entryFactory.textField({
      id: 'candidateGroups',
      label: '候选组',
      modelProperty: 'candidateGroups'
    }))
  }

  if (is(element, 'bpmn:Process')) {
    // 版本标记
    group.entries.push(entryFactory.textField({
      id: 'versionTags',
      label: '版本标记',
      modelProperty: 'versionTag'
    }))
  }
}
