const actionFiles = import.meta.globEager('./actions/*.vue')
export const actions = {}
for (const moduleFilePath in actionFiles) {
  const moduleFile = actionFiles[moduleFilePath]
  actions[moduleFilePath] = moduleFile.default
}


const toolFiles = import.meta.globEager('./tools/*.vue')
export const tools = {}
for (const moduleFilePath in toolFiles) {
  const moduleFile = toolFiles[moduleFilePath]
  tools[moduleFilePath] = moduleFile.default
}
