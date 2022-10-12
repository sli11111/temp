<template>
  <el-table
    v-if="attach_list && attach_list.length > 0"
    v-loading="attach_loading"
    row-key="attachId"
    :show-header="false"
    :data="attach_list"
    :size="size"
    lazy
    :load="handleLoadHistory"
    :tree-props="{children: 'children', hasChildren: 'hasHistory'}"
  >
    <el-table-column>
      <template #default="{row, $index}">
        <span v-if="row.mode !== 'edit'" class="filename-text">
          {{ row.isHistory ? row.realname : row.fileName }}
          <el-link v-if="enable_attach_rename && !row.isHistory" :underline="false" @click="switchFileNameToEditMode(row, $index)">
            <svg-icon icon-class="edit" />
          </el-link>
        </span>
        <span v-if="row.mode === 'edit' && !disabled" class="filename-input">
          <el-input v-model="row.fileName" size="small" @keypress.enter="handleAttachSave(row)">
            <template #append>
              <el-link :underline="false" @click="handleAttachSave(row)">
                <svg-icon icon-class="floppy" />
              </el-link>
            </template>
          </el-input>
        </span>
      </template>
    </el-table-column>
    <el-table-column width="120px" align="center">
      <template #default="{row}">
        {{ getFileSize(row.fileSize) }}
      </template>
    </el-table-column>
    <el-table-column width="160px" align="center">
      <template #default="{row}">
        {{ $dayjs(row.uploadTime).format('YYYY-MM-DD HH:mm:ss') }}
      </template>
    </el-table-column>
    <el-table-column width="100px" align="right">
      <template #default="{row}">
        <el-link v-if="!disabled && !row.isHistory" :underline="false" @click="handleUpload(row)">
          <svg-icon icon-class="upload" />
        </el-link>
        <el-link :underline="false" @click="handleDownload(row)">
          <svg-icon icon-class="download" />
        </el-link>
        <el-link v-if="!disabled && !row.isHistory" :underline="false" @click="showAttachDropConfirm(row)">
          <svg-icon icon-class="delete" />
        </el-link>
      </template>
    </el-table-column>
  </el-table>
  <el-upload
    v-if="!disabled"
    ref="upload"
    drag
    :action="upload_url"
    :multiple="false"
    name="data"
    :file-list="[]"
    :on-success="handleUploadSuccess"
    class="attach-uploader"
  >
    <el-icon><upload /></el-icon>
    <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
    <template #tip>
      <div class="el-upload__tip">{{ tip }}</div>
    </template>
  </el-upload>
</template>

<script>
import { deepClone, isEmpty, getFileSize } from '@/utils'
import { getBaseUrl } from '@/utils/request'

import { fetchAttaches, dropAttach, renameAttach, fetchAttachHistory } from '@/api/system/attach.js'

export default {
  name: 'AttachmentList',
  props: {
    batchId: {
      type: String,
      default: null,
    },
    size: {
      type: String,
      default: ''
    },
    disabled: {
      type: Boolean,
      default: false
    },
    tip: {
      type: String,
      default: null
    },
    baseUrl: {
      type: String,
      default: `${window.location.protocol}//${window.location.host}${getBaseUrl()}/attach`
    },
    enableBatchDownload: {
      type: Boolean,
      default: true
    },
    enableAttachRename: {
      type: Boolean,
      default: true
    },
    enableAttachUpload: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      attachId: undefined,
      attach_list: [],
      attach_loading: false
    }
  },
  watch: {
    batchId: {
      handler: 'refresh',
      immediate: true
    },
  },
  computed: {
    upload_url() {
      return `${getBaseUrl()}/attach/upload/${this.batchId}/${this.attachId}`
    },
    enable_attach_rename() {
      return this.enableAttachRename && !this.attach_loading && !this.disabled
    }
  },
  methods: {
    getFileSize,
    async refresh() {
      if (isEmpty(this.batchId)) {
        this.attach_list = []
        return
      }
      try {
        this.attach_loading = true
        const { data } = await fetchAttaches(this.batchId)
        const attach_list = []
        for (const item of data.datalist) {
          item.name = `${item.fileName}`
          item.url = `${getBaseUrl()}/attach/download/${item.batchId}/${item.attachId}`
          attach_list.push(item)
        }
        this.attach_list = attach_list
      } catch(e) {
        console.error(e)
        this.$message({
          message: this.$t('system.tips.attachment_load_fail'),
          type: 'error',
          duration: 1500
        })
      }
      this.attach_loading = false
    },
    async handleLoadHistory(row, treeNode, resolve) {
      try {
        const { data } = await fetchAttachHistory(row.batchId, row.attachId)
        const list = data.datalist
        resolve(list.map((item, i) => {
          item.url = `${getBaseUrl()}/attach/download/${item.batchId}/${item.attachId}?name=${item.fileName}`
          item.attachId += '_' + i
          item.isHistory = true
          item.realname = item.fileName.substring(item.fileName.indexOf('_') + 1)
          item.versionName = 'Version ' + (list.length - i)
          return item
        }))
      } catch(e) {
        console.error(e)
        this.$message({
          message: this.$t('system.tips.attachment_history_load_fail'),
          type: 'error',
          duration: 1500
        })
        resolve([])
      }
    },
    async handleAttachRemove(file) {
      await dropAttach(file.batchId, file.attachId)
      await this.refresh()
    },
    async handleUpload(file) {
      this.attachId = file.attachId
      console.log(this.$refs.upload)
      this.$refs.upload.uploadRef.$refs.inputRef.click()
    },
    handleDownload(file) {
      window.open(file.url)
    },
    handleUploadSuccess() {
      this.refresh()
      this.attachId = undefined
    },
    async handleAttachSave(row) {
      await renameAttach(row.batchId, row.attachId, row.fileName)
      this.refresh()
    },
    switchFileNameToEditMode(row, index) {
      row.mode = 'edit'
      const attach_list = deepClone(this.attach_list)
      attach_list[index] = row
      this.attach_list = attach_list
    },
    showAttachDropConfirm(file) {
      const that = this
      this.$confirm(that.$t('您确定要删除？'), that.$t('common.tip'), {
        type: 'warning',
        confirmButtonText: that.$t('common.confirm'),
        cancelButtonText: that.$t('common.cancel')
      }).then(() => {
        this.attach_list_loading = true
        this.handleAttachRemove(file)
      }).catch(() => {})
    },
  }
}
</script>

<style  lang="scss">
.attach-uploader {
  width: 100%;
  .el-upload {
    display: block;
    width: 100%;
    .el-upload-dragger {
      width: 100%;
    }
  }
}
</style>
