const DEFAULT_SPAN = {
  text:         8,
  select:       8,
  table:        24,
  date:         8,
  'date-range': 8
}

export function determineSpan(item) {
  return item.span ? item.span : DEFAULT_SPAN[item.type]
}

export function determineDict(item, $dicts, data) {
  if (item.dict) {
    if (typeof item.dict === 'string') {
      try {
        const dictName = eval(item.dict)
        return $dicts[dictName] || {}
      } catch(e) {
        return $dicts[item.dict] || {}
      }
    } else {
      return item.dict
    }
  }
  return {}
}

export function determinePropKey(item) {
  if (item.key) {
    return item.key instanceof Array ? item.key.join(':') : item.key
  }
  return null
}

export function determineAlign(column, index) {
  if (column.align) {
    return column.align
  }
  return index === 0 ? 'left' : 'center'
}

export function determineHeaderAlign(column) {
  if (column.headerAlign) {
    return column.headerAlign
  }
  if (column.align) {
    return column.align
  }
  return 'center'
}

export function formatter(value, { dict, $dicts, data }) {
  if (dict) {
    const d = determineDict({ dict }, $dicts, data)
    return d[value] ? d[value] : value
  }

  return value
}

export function determineEditable(item) {
  if (item.editable) {
    return true
  }
  for (const column of item.columns) {
    if (column.editable) {
      return true
    }
  }
  return false
}

export function handleDbClick(row, column, event) {
  row.__mode__ = 'edit'
}
