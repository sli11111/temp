<template>
  <auto-height-container>
    <el-alert
      type="info"
      style="margin-bottom: 20px"
      :closable="true"
      show-icon
    >
      <template #title>
        {{$t('common.tip')}}
      </template>
      <template #default>
        <span class="el-alert__title is-bold">{{$t('system.tips.hint_dict_desc')}}</span>
      </template>
    </el-alert>
    <div class="filter-container">
      <el-input
        v-model="search_param"
        style="width: 200px;"
        class="filter-item"
        clearable
        :placeholder="$t('system.dict_type_code') + ' / ' + $t('system.dict_type_name')"
        @keyup.enter="getList"
      />
      <el-button
        v-waves
        :disabled="loading_list"
        type="primary"
        class="filter-item"
        icon="search"
        style="margin-left: 5px;"
        @click="getList"
      >
        {{ this.$t('common.search') }}
      </el-button>
      <el-button-group style="float: right">
        <el-button
          v-waves
          type="primary"
          class="filter-item"
          style="margin-left: 10px;"
          :title="$t('common.add')"
          icon="plus"
          @click="addDictType"
        />
        <!-- <el-button
          v-waves
          :loading="upload_loading"
          class="filter-item"
          :title="$t('common.import')"
          icon="upload2"
          disabled
          @click="handleUpload"
        />
        <el-button
          v-waves
          :loading="download_loading"
          class="filter-item"
          :title="$t('common.export')"
          icon="download"
          disabled
          @click="handleDownload"
        /> -->
      </el-button-group>
    </div>
    <el-table
      v-loading="loading_list"
      :data="dictList"
      stripe
      style="width: 100%"
      :default-sort="{prop: 'type', order: 'ascending'}"
    >
      <el-table-column
        type="expand"
        width="30"
      >
        <template #default="{ row }">
          <dict-option
            :data="this.$dicts[row.codeType]"
            :label="'code'"
            :value="'codeValue'"
            :column="4"
          />
        </template>
      </el-table-column>
      <el-table-column :label="$t('system.dict_type_code')">
        <template #default="{ row }">
          <span>{{ row.codeType }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('system.dict_type_name')">
        <template #default="{ row }">
          <span>{{ row.codeTypeName }}</span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('system.dict_item_count')"
        align="center"
        width="80"
      >
        <template #default="{ row }">
          <span>{{ Object.keys(this.$dicts[row.codeType] || {}).length }}</span>
        </template>
      </el-table-column>
      <el-table-column
        prop="type"
        :label="$t('system.dict_type')"
        align="center"
        width="80"
      >
        <template #default="{ row }">
          <span>{{ this.$t('system.dict_type_' + (row.type ? row.type : 'dynamic')) }}</span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('common.operations')"
        header-align="center"
        width="110"
      >
        <template #default="{ row }">
          <el-button-group
            v-if="'dynamic' === row.type"
            style="float: right"
            :size="getSize(-1)"
          >
            <el-button
              v-waves
              type="primary"
              class="filter-item"
              :title="$t('common.edit')"
              icon="edit-outline"
              @click="editDictType(row)"
            />
            <el-button
              v-waves
              type="danger"
              class="filter-item"
              :title="$t('common.delete')"
              icon="delete"
              @click="delDictType(row)"
            />
          </el-button-group>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-model="current_page"
      hide-on-single-page
      style="padding: 0; margin-top: 20px"
      @pagination="getList"
    />
    <el-dialog
      v-model="form_visible"
      width="75%"
    >
      <template #title>
        <div class="dialog-header">
          <svg-icon icon-class="dict" />
          {{ getFormTitle() }}
        </div>
      </template>
      <el-form
        ref="dict"
        :model="form_data"
        :rules="form_rules"
        label-position="right"
      >
        <el-row :gutter="10">
          <el-col :span="8">
            <el-form-item prop="codeType">
              <el-select
                v-model="form_data.codeType"
                :placeholder="$t('system.dict_type_code')"
                filterable
                allow-create
                clearable
                style="width: 100%"
                @change="handleCodeTypeChange"
              >
                <el-option
                  v-for="(val, key) in code_type_options"
                  :key="key"
                  :label="val"
                  :value="key"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item prop="codeTypeName">
              <el-input
                v-model="form_data.codeTypeName"
                :placeholder="$t('system.dict_type_name')"
                type="text"
                maxlength="20"
                show-word-limit
                clearable
              />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item prop="pid">
              <el-select
                v-model="form_data.pid"
                clearable
                filterable
                remote
                :remote-method="remoteCodeType"
                :loading="pid_loading"
                style="width: 100%"
                :placeholder="$t('system.dict_p')"
                @change="handleChange"
              >
                <el-option
                  v-for="(val, key) in pid_options"
                  :key="key"
                  :label="val"
                  :value="key"
                />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <el-table
        :data="form_data.codes"
        class="sort-table"
        border
      >
        <el-table-column
          :label="$t('system.dict_item_code')"
          header-align="center"
          width="240"
        >
          <template #default="{ row, $index }">
            <el-input
              v-model="row.code"
              class="filter-item"
              clearable
              @blur="handleParamBlur(row, $index)"
            />
          </template>
        </el-table-column>
        <el-table-column
          :label="$t('system.dict_item_value')"
          header-align="center"
          width="240"
        >
          <template #default="{ row, $index }">
            <el-input
              v-model="row.codeValue"
              class="filter-item"
              clearable
              @blur="handleParamBlur(row, $index)"
            />
          </template>
        </el-table-column>
        <el-table-column
          :label="$t('system.dict_p')"
          header-align="center"
        >
          <template #default="{ row, $index }">
            <el-input
              v-if="form_data.pid && form_data.pCode"
              v-model="this.$dicts[form_data.pid][form_data.pCode]"
              class="filter-item"
              disabled
            />
            <el-select
              v-if="form_data.pid && !form_data.pCode"
              v-model="row.pid"
              clearable
              style="width: 100%"
              @change="handleParamBlur(row, $index)"
            >
              <el-option
                v-for="(val, key) in this.$dicts[form_data.pid]"
                :key="key"
                :label="val"
                :value="key"
              />
            </el-select>
            <el-input
              v-if="!form_data.pid"
              v-model="row.pid"
              class="filter-item"
              clearable
            />
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          width="60"
        >
          <template #default="{ $index }">
            <el-button
              v-waves
              v-if="form_data.codes.length !== $index + 1"
              type="danger"
              class="filter-item"
              :title="$t('common.delete')"
              icon="delete"
              :size="getSize(-1)"
              @click="delOption($index)"
            />
          </template>
        </el-table-column>
      </el-table>
      <template #footer>
        <div class="dialog-footer">
          <el-button
            v-waves
            @click="form_visible = false"
          >
            {{ $t('common.cancel') }}
          </el-button>
          <el-button
            v-waves
            type="primary"
            :loading="submit_loading"
            @click="handleSubmit"
          >
            {{ $t('common.confirm') }}
          </el-button>
        </div>
      </template>
    </el-dialog>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import Pagination from '@/components/Pagination/index.vue'
import DictOption from './components/DictOption.vue'

import waves from '@/directive/waves'

import { getDictType, fetchDict, fetchType, deleteType, submitDict } from '@/api/system/dicts'
import { fetchDicts } from '@/api/common'

import { isEmpty, deepClone } from '@/utils'
import { getSize } from '@/utils/framework'

export default {
  components: { AutoHeightContainer, Pagination, DictOption },
  directives: { waves },
  data() {
    return {
      loading_list: false,
      search_param: '',
      dict_types: [],
      current_page: {
        pageNumber: 1,
        pageSize: 10,
        totalPage: 0,
        totalRecord: 0,
      },
      upload_loading: false,
      download_loading: false,
      form_visible: false,
      form_status: 'add',
      form_data: {},
      form_rules: {
        codeTypeName: [{ required: true, message: this.$t('common.tips.is_required'), trigger: 'blur' }],
        codeType: [{ required: true, message: this.$t('common.tips.is_required'), trigger: 'change' }],
      },
      pid_loading: false,
      pid_options: [],
      code_type_options: [],
      submit_loading: false,
    }
  },
  computed: {
    dictList() {
      this.current_page.totalPage = Math.ceil(this.dict_types.length / this.current_page.pageSize)
      return this.dict_types.slice((this.current_page.pageNumber - 1) * this.current_page.pageSize, this.current_page.pageNumber * this.current_page.pageSize)
    }
  },
  mounted() {
    this.getList()
  },
  methods: {
    getSize,
    async getList() {
      this.loading_list = true
      const { data } = await getDictType(this.search_param)
      this.dict_types = data
      this.current_page.totalRecord = data.length
      this.loading_list = false
    },
    async addDictType() {
      this.form_status = 'add'
      await this.remoteCodeType('', undefined)
      this.form_data = { codes: [{ code: '', codeValue: '' }] }
      this.form_visible = true
    },
    async editDictType(row) {
      this.form_status = 'edit'
      this.form_data.codeTypeName = row.codeTypeName
      this.form_data.pid = row.pid
      const str = row.codeType.split('.').pop();
      await this.remoteCodeType('', str)
      if (row.pid && row.codeType.includes('.')) {
        this.form_data.pCode = str
      } else {
        this.form_data.pCode = undefined
      }
      this.form_data.codeType = row.codeType
      this.code_type_options = this.makeCodeTypeOptions(this.$dicts[row.pid])
      const { data } = await fetchDict(row.codeType)
      this.form_data.codes = data.codes.concat({ code: '', codeValue: '' })
      this.form_visible = true
    },
    delDictType(row) {
      const name = row.codeTypeName
      this.$confirm(this.$t('common.tips.confirm_delete', { name }), this.$t('common.tip'), {
        confirmButtonText: this.$t('common.confirm'),
        cancelButtonText: this.$t('common.cancel'),
        type: 'warning'
      }).then(async () => {
        await deleteType(row.codeType)
        this.$message({
          type: 'success',
          message: this.$t('common.tips.delete_success', { name })
        })
        await this.getList()
        // 刷新全局字典
        await this.rebuildDict()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: this.$t('common.tips.delete_fail', { name })
        })
      })
    },
    handleUpload() {},
    handleDownload() {},
    getFormTitle() {
      return this.$t('common.' + this.form_status) + ' ' + this.$t('system.dict')
    },
    async remoteCodeType(query, type) {
      this.pid_loading = true
      const { data } = await fetchType(type, query)
      this.pid_options = Object.assign({}, data)
      this.pid_loading = false
    },
    handleChange() {
      this.form_data.pCode = undefined
      this.form_data.codes.forEach(code => code.pid = '')
      this.code_type_options = this.makeCodeTypeOptions(this.$dicts[this.form_data.pid])
    },
    makeCodeTypeOptions(map) {
      const result = {}
      if (map) {
        Object.keys(map).forEach(key => Object.assign(result, { [this.form_data.pid + '.' + key]: map[key] }))
      }
      return result
    },
    handleCodeTypeChange() {
      if (this.form_data.pid && this.form_data.codeType.includes('.')) {
        this.form_data.pCode = this.form_data.codeType.split('.').pop()
      } else {
        this.form_data.pCode = undefined
      }
    },
    handleSubmit() {
      this.$refs.dict.validate(valid => {
        if (valid) {
          this.submit_loading = true
          const data = deepClone(this.form_data)
          const codes = data.codes
          codes.splice(codes.length - 1, 1)
          if (data.pid && data.pCode && !data.codeType) {
            data.codeType = data.pid + '.' + data.pCode
          }
          codes.map(code => {
            code.codeType = data.codeType
            code.pid = data.pid && data.pCode && !data.codeType ? data.pCode : code.pid
          })
          submitDict(data).then(async () => {
            this.submit_loading = false
            this.form_visible = false
            this.$message({
              type: 'success',
              message: this.$t('common.tips.submit_success')
            })
            await this.getList()
            // 刷新全局字典
            await this.rebuildDict()
          }).catch(() => {
            this.submit_loading = false
            this.$message({
              type: 'info',
              message: this.$t('common.tips.submit_fail')
            })
          })
        } else {
          return false
        }
      })
    },
    handleParamBlur(row, $index) {
      if ($index === this.form_data.codes.length - 1) {
        if (!isEmpty(row.code) || !isEmpty(row.codeValue) || !isEmpty(row.pid)) {
          const params = deepClone(this.form_data.codes)
          params.push({ code: '', codeValue: '' })
          this.form_data.codes = params
        }
      }
    },
    delOption($index) {
      const item = this.form_data.codes.splice($index, 1)
      if (item.code) {
        this.form_data.deleteCodes = (this.form_data.deleteCodes || []).concat(item.code)
      }
    },
    async rebuildDict() {
      const { data } = await fetchDicts()
      const dict = data || []
      dict.convert = function(dictName, dictKey, fallbackDict) {
        const dict = dict[dictName] || fallbackDict || {}
        return dict[dictKey] || dictKey
      }
      this.$dicts = dict
    }
  }
}
</script>
