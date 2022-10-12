<template>
  <el-card shadow="never" style="border: 0">
    <template v-if="config.section.title" #header>
      {{ config.section.title }}
    </template>
    <el-form :label-width="config.section.labelWidth || config.labelWidth || 140">
      <el-row>
        <el-col v-for="(item, $index) in config.section.items" :key="$index" :span="determineSpan(item)">
          <el-form-item :prop="determinePropKey(item)" :label="item.label || null" :size="config.size || config.section.size || 'default'" :label-width="item.label ? '' : '0px'">
            <el-input 
              v-if="item.type === 'text' || item.type === 'textarea'" 
              v-model="__data__[item.key]" 
              :type="item.type === 'text' ? 'text' : 'textarea'"
              :placeholder="item.placeholder || item.label || ''"
              :size="config.size || config.section.size || 'default'"
            />
            <el-select 
              v-else-if="item.type === 'select'"  
              v-model="__data__[item.key]" 
              :placeholder="item.placeholder || item.label || ''"
              :size="config.size || config.section.size || 'default'"
              style="width: 100%"
            >
              <el-option v-for="(dict, $key) in determineDict(item, $dicts)" :key="$key" :value="$key" :label="dict" />
            </el-select>
            <el-checkbox
              v-else-if="item.type === 'checkbox'" 
              v-model="__data__[item.key]" 
              type="date"
              :size="config.size || config.section.size || 'default'"
            />
            <el-date-picker 
              v-else-if="item.type === 'date'" 
              v-model="__data__[item.key]" 
              type="date"
              :size="config.size || config.section.size || 'default'"
              style="width: 100%"
            />
            <el-date-picker 
              v-else-if="item.type === 'date-range'" 
              v-model="__data__[item.key.join(':')]" 
              type="daterange"
              :size="config.size || config.section.size || 'default'"
            />    
            <el-upload
              v-else-if="item.type === 'image-uploader'" 
              :action="item.url || `${getBaseUrl()}/attach/upload/${__data__[item.key]}/undefined`"
              :method="item.method || 'post'"
              :name="item.name || 'data'"
              :data="{ batchId: __data__[item.key] }"
              list-type="picture-card"
              :http-request="handleFileUpload"
              :file-list="fileLists[__data__[item.key]] || []"
              :accept="item.accept || 'image/*'"
            >
              <el-icon><plus /></el-icon>
              <template #file="{ file }">
                <div>
                  <img class="el-upload-list__item-thumbnail" :src="file.url.startsWith('blob:') ? file.url : getBaseUrl() + file.url" alt="" />
                  <span class="el-upload-list__item-actions">
                    <span
                      class="el-upload-list__item-preview"
                      @click="handleImageFilePreview(file)"
                    >
                      <el-icon><zoom-in /></el-icon>
                    </span>
                    <span
                      class="el-upload-list__item-delete"
                      @click="handleFileDownload(file)"
                    >
                      <el-icon><download /></el-icon>
                    </span>
                    <span
                      class="el-upload-list__item-delete"
                      @click="handleFileRemove(file)"
                    >
                      <el-icon><delete /></el-icon>
                    </span>
                  </span>
                </div>
              </template>
            </el-upload>
            <el-table 
              v-if="item.type === 'table'" 
              :data="__data__[item.key]"
              :border="item.showBorder"
              style="margin-bottom: 10px;"
              :size="config.size || config.section.size || 'default'"
            >
              <el-table-column v-if="item.showIndex" type="index" width="50" />
              <el-table-column 
                v-for="(column, $index) in (convertColumToLine[item.key] ? convertColumToLine[item.key].columns : item.columns)" 
                :key="$index" 
                :label="column.label" 
                show-overflow-tooltip 
                :align="determineAlign(column, $index)" 
                :header-align="determineHeaderAlign(column)"
              >
                <template #default={row}>
                  <span v-if="row.__mode__ !== 'edit' || (!item.editable && !column.editable)">{{formatter(row[column.key], { dict: column.dict, $dicts: this.$dicts, data: row })}}</span>
                  <el-select 
                    v-else-if="(item.editable || column.editable) && column.dict"  
                    v-model="row[column.key]" 
                    :placeholder="column.label || ''"
                    :size="config.size || config.section.size || 'default'"
                    style="width: 100%"
                  >
                    <el-option v-for="(dict, $key) in determineDict(column, $dicts, row)" :key="$key" :value="$key" :label="dict" />
                  </el-select>
                   <el-input 
                    v-else-if="(item.editable || column.editable) && (!column.type || column.type === 'text')" 
                    v-model="row[column.key]" 
                    :placeholder="column.label || ''"
                    :size="config.size || config.section.size || 'default'"
                  />
                </template>
              </el-table-column>
              <el-table-column v-if="determineEditable(item)" type="index" width="100" align="center">
                <template v-if="!item.tableForm" #default={row,$index}>
                  <el-button-group v-if="row.__mode__ !== 'edit'" size="small">
                    <el-button icon="edit" type="primary" @click="handleTableEdit(item.key, row, $index, 'inline')" />
                    <el-button icon="close" type="danger" @click="__data__[item.key].splice($index, 1)" />
                  </el-button-group>
                  <el-button-group v-else size="small">
                    <el-button icon="select" type="primary" @click="delete row.__mode__" />
                  </el-button-group>
                </template>
                <template v-else #default={row,$index}>
                  <el-button-group size="small">
                    <el-button icon="edit" type="primary" @click="handleTableEdit(item.key, row, $index, 'dialog')" />
                    <el-button icon="close" type="danger" @click="__data__[item.key].splice($index, 1)" />
                  </el-button-group>
                </template>
              </el-table-column>
            </el-table>
            <el-button 
              v-if="item.type === 'table' && determineEditable(item)" 
              style="width: 100%; border-style: dashed;" 
              @click="handleTableAdd(item.key, item.tableForm ? 'dialog' : 'inline')"
            >+</el-button>
            <el-dialog v-if="item.type === 'table' && item.tableForm" v-model="dialogs[item.key].visible">
              <SectionParserElementUI
                :ref="'dialog-' + item.key" 
                v-for="(section, $index) in item.tableForm.sections" 
                :key="$index" 
                :config="getPreparedSection(section)" 
                :formData="dialogs[item.key].current" 
              />
              <template #footer>
                <el-button type="primary" @click="handleTableFormSubmit(item.key)">保存</el-button>
              </template>
            </el-dialog>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </el-card>
  <el-dialog v-model="imagePreviewVisible" width="75%">
    <img style="width: 100%" :src="imagePreviewUrl" alt="" />
  </el-dialog>
</template>

<script>
import { deepClone } from '@/utils'
import * as utils from './utils'
import { extractObjectAsData, extractDataAsObject } from './funcs.js'
import { uploadAttach, fetchAttaches, dropAttach } from '@/api/system/attach.js'
import { download, getBaseUrl } from '@/utils/request.js'

export default {
  name: 'SectionParserElementUI',
  props: {
    config: {
      type: Object,
      required: true
    },
    formData: {
      type: Object,
      default: {}
    }
  },
  data() {
    return {
      __data__: {},
      imagePreviewVisible: false,
      fileLists: {},
      convertColumToLine: {},
      dialogs: {}
    }
  },
  watch: {
    formData: {
      handler: 'refresh',
      immediate: true
    },
    fileLists: {
      handler: 'loadFileLists',
      immediate: true
    },
  },
  methods: {
    ...utils,
    getBaseUrl,
    getPreparedSection(section) {
      const config = deepClone(this.config)
      if (config.sections) {
        delete config.sections
      }
      config.section = section
      return config
    },
    refresh() {
      let __data__ = {}
      if (this.config.section && this.config.section.items) {
        extractObjectAsData(this.formData, this.config.section.items, __data__)
      }
      // Extra Action:
      // 1. init fileLists for el-uploader
      const fileLists = {}
      for (const item of this.config.section.items) {
        if (item.type === 'image-uploader') {
          const batchId = __data__[item.key]
          if (batchId) {
            fileLists[batchId] = null
          }
        }
      }
      this.fileLists = fileLists
      // 2. init data for tables that need convert column to line
      for (const item of this.config.section.items) {
        if (item.type === 'table' && item.convertColumToLine) {
          const originData = __data__[item.key] || []
          const transferedData = (function(){
            const result = []
            let i = 0
            for (const column of item.columns) {
              if (column.key !== item.convertColumToLine.headerKey) {
                result.push({ '__NAME__': column.label })
                i++
              }
            }
            return result
          })()
          const transferedColumns = [{
            key: '__NAME__',
            label: ''
          }]
          for (const originLine of originData) {
            const headerValue = originLine[item.convertColumToLine.headerKey]
            transferedColumns.push({ key: '__VALUE__' + headerValue, label: headerValue })
            
            let i = 0
            for (const column of item.columns) {
              if (column.key !== item.convertColumToLine.headerKey) {
                transferedData[i]['__VALUE__' + headerValue] = originLine[column.key]
                i++
              }
            }
          }
          console.log(transferedData)
          console.log(transferedColumns)
          this.convertColumToLine[item.key] = {
            columns: transferedColumns
          }
          __data__[item.key] = transferedData
        }
      }
      // 3. init dialogs
      for (const item of this.config.section.items) {
        if (item.type === 'table' && item.tableForm) {
          this.dialogs[item.key] = {
            visible: false
          }
        }
      }

      this.__data__ = __data__
    },
    getFormData() {
      const result = {}
      for (const key in this.__data__) {
        extractDataAsObject(this.__data__, key, result)
      }
      return result
    },
    async loadFileList(batchId) {
      const { data } = await fetchAttaches(batchId)
      // debugger
      for (const item of data.datalist) {
        item.name = ''
        item.url = `/attach/download/${item.batchId}/${item.attachId}`
      }
      this.fileLists[batchId] = data.datalist || []
    },
    handleTableAdd(key, type) {
      if (!this.__data__[key]) {
        this.__data__[key] = []
      }
      
      switch(type) {
        case 'dialog':
          this.dialogs[key].current = {}
          this.dialogs[key].currentIndex = -1
          this.dialogs[key].visible = true
          break
        case 'inline':
        default:
          this.__data__[key].push({ __mode__: 'edit' })
          break
      }
    },
    handleTableFormSubmit(key) {
      const sections = this.$refs['dialog-' + key]
      const result = {}
      for (const section of sections) {
        const data = section.getFormData()
        this.$lodash.extend(result, data)
      }

      if (this.dialogs[key].currentIndex >= 0) {
        this.__data__[key][this.dialogs[key].currentIndex] = result
      } else {
        this.__data__[key].push(result)
      }
      
       this.dialogs[key].visible = false
    },
    handleTableEdit(key, row, index, type) {
      switch(type) {
        case 'dialog':
          this.dialogs[key].current = deepClone(row)
          this.dialogs[key].currentIndex = index
          this.dialogs[key].visible = true
          break
        case 'inline':
        default:
          row.__mode__ = 'edit'
          break
      }
    },
    loadFileLists() {
      function containsBlob(list) {
        for (const item in list) {
          if (item.url.startsWith('blob:')) {
            return true
          }
        }
        return false
      }
      for (const batchId in this.fileLists) {
        if (!(this.fileLists[batchId] instanceof Array) || containsBlob(this.fileLists)) {
          this.loadFileList(batchId)
        }
      }
    },
    async handleFileUpload(e) {
      const formData = new FormData()
      formData.append(e.filename, e.file)
      const batchId = e.data.batchId

      try {
        const { data } = await uploadAttach(batchId, 'undefined', formData)
      } catch(e) {
        console.error(e)
      }

      this.loadFileList(batchId)
    },
    handleImageFilePreview(file) {
      this.imagePreviewUrl = getBaseUrl() + file.url
      this.imagePreviewVisible = true
    },
    handleFileDownload(file) {
      download(file.url)
    },
    async handleFileRemove(file) {
      await dropAttach(file.batchId, file.attachId)
      this.loadFileList(file.batchId)
    }
  }
}
</script>

