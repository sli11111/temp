<template>
  <auto-height-container>
    <div class="filter-container">
      <el-input
        v-model="search_param.search"
        :placeholder="$t('common.username') + ' / ' + $t('system.sid')"
        style="width: 240px;"
        class="filter-item"
        @keyup.enter="handleFilter"
      />
      <tree-select
        v-model="search_param.orgId"
        :props="{ value: 'id', label: 'orgName', children: 'children', placeholder: $t('system.organization') }"
        :options="orgTree"
        :clearable="true"
        :accordion="true"
        style="width: 140px"
        :disabled="showNewRoles"
        class="filter-item"
      />
      <el-select
        v-model="search_param.roleId"
        :placeholder="$t('system.role')"
        clearable
        style="width: 140px"
        class="filter-item"
      >
        <el-option
          v-for="item in roleOptions"
          :key="item.roleId"
          :label="item.roleName"
          :value="item.roleId"
        />
      </el-select>
      <el-button
        v-waves
        :disabled="list_loading"
        class="filter-item"
        type="primary"
        icon="search"
        @click="handleFilter"
      >
        {{ $t('common.search') }}
      </el-button>
      <el-button-group style="float: right;">
        <el-button
          v-waves
          :disabled="mode_flag"
          class="filter-item"
          style="margin-left: 10px;"
          :title="$t('common.add')"
          type="primary"
          icon="plus"
          @click="handleAdd"
        />
        <!-- <el-button
          v-waves
          :loading="uploadLoading"
          class="filter-item"
          :title="$t('common.import')"
          type="primary"
          icon="upload2"
          disabled
          @click="handleUpload"
        />
        <el-button
          v-waves
          :loading="downloadLoading"
          class="filter-item"
          :title="$t('common.export')"
          type="primary"
          icon="download"
          disabled
          @click="handleDownload"
        /> -->
      </el-button-group>
    </div>
    <el-table
      v-loading="list_loading"
      :data="datalist"
      border
      fit
      highlight-current-row
      stripe
      style="width: 100%;"
    >
      <el-table-column
        :label="$t('system.sid')"
        prop="sid"
        header-align="center"
        width="120"
      >
        <template #default="{row}">
          <span style="font-family: monospace;">{{ row.sid }}</span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('common.username')"
        prop="username"
        align="center"
        width="160"
      >
        <template #default="{row}">
          <span>{{ row.username }}</span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('system.source')"
        prop="source"
        align="center"
        width="80"
      >
        <template #default="{row}">
          <span>{{ row.source }}</span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('common.nickname')"
        prop="nickname"
        align="center"
        width="160"
        show-overflow-tooltip
      >
        <template #default="{row}">
          <span>{{ row.nickname }}</span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('common.mobile')"
        prop="source"
        align="center"
        width="160"
      >
        <template #default="{row}">
          <span>{{ row.params.MOBILE }}</span>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('common.email')"
        prop="source"
        align="center"
        show-overflow-tooltip
      >
        <template #default="{row}">
          <a
            :href="'mailto:' + row.params.EMAIL"
            target="_blank"
          >{{ row.params.EMAIL }}</a>
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('system.role')"
        prop="roles"
        align="center"
        show-overflow-tooltip
      >
        <template #default="{row}">
          {{ getRoleTxt(row) }}
        </template>
      </el-table-column>
      <el-table-column
        :label="$t('common.operations')"
        width="140"
        fixed="right"
        align="center"
      >
        <template #default="{row}">
          <el-dropdown split-button :disabled="list_loading" :size="getSize(-1)" type="primary" @click="handleEdit(row)">
            <svg-icon icon-class="edit-o" />
            {{ $t('common.edit') }}
            <template #dropdown>
              <el-dropdown-menu class="table-drop-down ">
                <el-dropdown-item v-if="isImpersonatePermitted()" @click="showImpersonateConfirm(row)">
                  <el-link :underline="false" :disabled="isImpersonateUnavailable(row)">
                    <svg-icon icon-class="spy-o" />
                    {{ $t('common.impersonate') }}
                  </el-link>
                </el-dropdown-item>
                <el-dropdown-item type="danger" command="delete" @click="showResetPasswordConfirm(row)">
                  <el-link type="danger" :underline="false">
                    <svg-icon icon-class="reset" />
                    {{ $t('common.reset_password') }}
                  </el-link>
                </el-dropdown-item>
                <el-dropdown-item type="danger" command="delete" @click="showDeleteConfirm(row)">
                  <el-link type="danger" :underline="false">
                    <svg-icon icon-class="delete-o" />
                    {{ $t('common.delete') }}
                  </el-link>
                </el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-model="page"
      hide-on-single-page
      style="padding: 0; margin-top: 20px"
      @pagination="getList"
    />
    <el-dialog
      v-model="form_visible"
      width="80%"
    >
      <template #title>
        <svg-icon icon-class="peoples" /> {{ getFormTitle() }}
      </template>
      <div style="float: left; width: 100%;">
        <el-form
          ref="dataForm"
          :rules="formRules"
          :model="form_data"
          label-position="right"
          label-width="160px"
        >
          <el-row :gutter="5">
            <el-col
              v-if="enable_custom_id"
              :span="12"
            >
              <el-form-item
                :label="$t('common.sid')"
                prop="sid"
              >
                <el-input
                  v-model="form_data.sid"
                  :placeholder="$t('common.sid')"
                  type="text"
                  maxlength="20"
                  show-word-limit
                  :disabled="showNewRoles || formStatus ==='edit'"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                :label="$t('common.username')"
                prop="username"
              >
                <el-input
                  v-model="form_data.username"
                  :placeholder="$t('common.username')"
                  type="text"
                  maxlength="20"
                  show-word-limit
                  :disabled="showNewRoles || formStatus ==='edit'"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                :label="$t('common.nickname')"
                prop="nickname"
              >
                <el-input
                  v-model="form_data.nickname"
                  :placeholder="$t('common.nickname')"
                  type="text"
                  maxlength="20"
                  show-word-limit
                  :disabled="showNewRoles || mode_flag"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                :label="$t('common.email')"
                prop="params.EMAIL"
              >
                <el-input
                  v-model="form_data.params.EMAIL"
                  :placeholder="$t('common.email')"
                  type="text"
                  suffix-icon="message"
                  show-word-limit
                  :disabled="showNewRoles || mode_flag"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                :label="$t('common.mobile')"
                prop="params.MOBILE"
              >
                <el-input
                  v-model="form_data.params.MOBILE"
                  :placeholder="$t('common.mobile')"
                  suffix-icon="phone-outline"
                  :disabled="showNewRoles || mode_flag"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                :label="$t('system.empno')"
                prop="params.EMP_ID"
              >
                <el-input
                  v-model="form_data.params.EMP_ID"
                  :placeholder="$t('system.empno')"
                  suffix-icon="user-solid"
                  :disabled="showNewRoles || mode_flag"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="$t('system.organization')">
                <tree-select
                  v-model="form_data.params.ORG_ID"
                  :props="{ value: 'id', label: 'orgName', children: 'children' }"
                  :options="orgTree"
                  :clearable="true"
                  :accordion="true"
                  style="width: 100%"
                  :disabled="showNewRoles || mode_flag"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                :label="$t('system.is_manager')"
                prop="params.IS_MANAGER"
              >
                <el-switch
                  v-model="form_data.params.IS_MANAGER"
                  :active-text="$t('common.yes')"
                  :inactive-text="$t('common.no')"
                  :disabled="showNewRoles || mode_flag"
                />
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item :label="$t('system.role')">
                <el-select
                  v-model="form_data.roles"
                  multiple
                  style="width: 100%"
                  :disabled="showNewRoles"
                >
                  <el-option
                    v-for="item in roleOptions"
                    :key="item.roleId"
                    :label="item.roleName"
                    :value="item.roleId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="form_visible = false">
            {{ $t('common.cancel') }}
          </el-button>
          <el-button
            type="primary"
            :loading="submitLoading"
            :disabled="showNewRoles"
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
import { mapGetters } from 'vuex'
import { fetchUsers, fetchUser, submitUser, deleteUser, impersonate, resetPassword } from '@/api/system/users'
import { fetchRoles, submitRole } from '@/api/system/roles'
import { fetchOrgTree } from '@/api/system/orgs'
import waves from '@/directive/waves'
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import Pagination from '@/components/Pagination/index.vue'
import TreeSelect from '@/components/TreeSelect/index.vue'
import { deepClone, isEmpty, validateByReg } from '@/utils'
import { getSize, setToken } from '@/utils/framework'
import settings from '@/settings'

export default {
  name: 'SystemUserList',
  components: { AutoHeightContainer, Pagination, TreeSelect },
  directives: { waves },
  data() {
    return {
      list_loading: false,
      uploadLoading: false,
      downloadLoading: false,
      submitLoading: false,
      datalist: [],
      page: { pageNumber: 1, pageSize: 10, totalRecord: 0, totalPage: 0 },
      search_param: {},
      sourceOptions: ['DB'],
      roleOptions: [],
      newRoles: [],
      showNewRoles: false,
      formStatus: 'add',
      form_visible: false,
      form_data: {
        sid: null,
        username: null,
        nickname: null,
        params: {
          EMAIL: '',
          MOBILE: ''
        },
        roles: []
      },
      formRules: {
        sid: [{ required: true, message: this.$t('common.tips.is_required'), trigger: 'blur' }, { validator: this.validateSid, message: this.$t('system.tips.sid_exists'), trigger: 'blur' }],
        username: [{ required: true, message: this.$t('common.tips.is_required'), trigger: 'blur' }, { validator: this.validateUsername, message: this.$t('system.tips.username_exists'), trigger: 'blur' }],
        nickname: [{ required: true, message: this.$t('common.tips.is_required'), trigger: 'blur' }],
        'params.EMAIL': [{ validator: validateByReg, regName: 'email', message: this.$t('tips.is_email'), trigger: 'blur' }],
        'params.MOBILE': [{ validator: validateByReg, regName: 'mobile', message: this.$t('tips.is_mobile'), trigger: 'blur' }],
        // 'params.EMP_ID': [{ required: true, message: this.$t('common.tips.is_required'), trigger: 'blur' }]
      },
      orgTree: [],
      mode_flag: settings.system.user.mode === 'remote',
      enable_custom_id: settings.system.user.enableCustomId,
      impersonate_permitted: true
    }
  },
  computed: {
    ...mapGetters(['sid', 'perms'])
  },
  async mounted() {
    await this.getList()
    await this.getOrgTree()
    await this.getRoles()
    if (this.$route.params && this.$route.params.id && this.$route.params.id !== ':id') {
      const { data } = await fetchUser({ sid: this.$route.params.id })
      await this.handleEdit(data)
    }
  },
  methods: {
    getSize,
    getRoleTxt(row) {
      if (row.roles && row.roles.length > 0) {
        let txt = ''
        for (let i = 0; i < row.roles.length; i++) {
          const role = row.roles[i];
          txt += (i > 0 ? ' ' : '') + row.roles[i].roleName
        }
        return txt
      }
      return '-'
    },
    async getList() {
      this.list_loading = true
      const { data } = await fetchUsers(this.page, this.search_param)
      this.datalist = data.datalist
      this.page = data.page
      this.list_loading = false
    },
    async getOrgTree() {
      const { data } = await fetchOrgTree()
      this.orgTree = data || []
    },
    async getRoles() {
      const { data } = await fetchRoles()
      this.roleOptions = data.datalist
    },
    async getUserRoles() {
      const { data } = await fetchRoles({ userId: this.form_data.sid })
      const roles = []
      if (data && data.length > 0) {
        for (let i = 0; i < data.length; i++) {
          const role = data[i]
          roles.push(role.roleId)
        }
      }
      this.form_data.roles = roles
    },
    async validateSid(rule, value, callback) {
      if (this.formStatus === 'edit') {
        callback()
        return
      }
      const { data } = await fetchUser({ sid: value })
      if (data !== null) {
        callback(new Error(rule.message))
      } else {
        callback()
      }
    },
    async validateUsername(rule, value, callback) {
      if (this.formStatus === 'edit') {
        callback()
        return
      }
      const { data } = await fetchUser({ username: value })
      if (data) {
        callback(new Error(rule.message))
      } else {
        callback()
      }
    },
    getFormTitle() {
      return this.$t('common.' + this.formStatus) + ' ' + this.$t('system.subscriber')
    },
    hideNewRolesForm() {
      this.newRoles = []
      this.showNewRoles = false
    },
    handleFilter() {
      this.page.pageNumber = 1
      this.getList()
    },
    handleUpload() {},
    handleDownload() {},
    handleOperationClick(command, row) {
      console.log(command, row)
    },
    async handleEdit(row) {
      this.formStatus = 'edit'
      const form_data = deepClone(row)
      const { data } = await fetchRoles({ userId: form_data.sid })
      const roles = []
      if (data && data.datalist && data.datalist.length > 0) {
        for (let i = 0; i < data.datalist.length; i++) {
          const role = data.datalist[i]
          roles.push(role.roleId)
        }
      }
      form_data.roles = roles
      this.form_data = form_data
      await this.showUserForm()
    },
    async handleAdd() {
      this.formStatus = 'add'
      this.form_data = { params: {}, roles: [], orgId: null }
      await this.showUserForm()
    },
    async showUserForm() {
      this.showNewRoles = false
      this.newRoles = []

      this.form_visible = true
      if (this.$refs['dataForm']) {
        this.$refs['dataForm'].resetFields()
      }
      this.submitLoading = false
    },
    hideUserForm() {
      this.form_visible = false
    },
    showDeleteConfirm(user) {
      this.$confirm(
        this.$t('common.tips.confirm_delete', { name: user.nickname }), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        await this.handleDelete(user.sid)
      }).catch(() => {})
    },
    async handleDelete(userId) {
      this.list_loading = true
      await deleteUser(userId)
      await this.getList()
    },
    async handleSubmit() {
      this.$refs['dataForm'].validate(async valid => {
        if (valid) {
          this.submitLoading = true
          const data = deepClone(this.form_data)
          data.roles = []
          for (let i = 0; i < this.form_data.roles.length; i++) {
            const role = this.form_data.roles[i]
            data.roles.push({ roleId: role })
          }
          await submitUser(data)
          this.submitLoading = false
          this.hideUserForm()
          await this.getList()
        }
      })
    },
    handleRoleSubmit() {
      submitRole(this.newRoles).then(response => {
        if (response.data && response.data.datalist) {
          this.roleOptions = response.data.datalist
          for (let i = 0; i < this.newRoles.length; i++) {
            this.form_data.roles.push(this.newRoles[i].code)
          }
        }
        this.hideNewRolesForm()
      })
    },
    showResetPasswordConfirm(row) {
      this.$confirm(
        this.$t('common.tips.confirm_reset_password', { name: row.nickname }), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        try {
          await resetPassword(row.sid)
          this.$message({
            message: this.$t('system.tips.reset_password_success'),
            type: 'success',
            duration: 1500
          })
        } catch(e) {
          this.$message({
            message: this.$t('system.tips.reset_password_fail'),
            type: 'error',
            duration: 1500
          })
        }
      }).catch(() => {})
    },
    isImpersonatePermitted() {
      return (settings.system && settings.system.user && settings.system.user.enableImpersonate) && this.perms && this.perms.includes('SUPER_ADMIN')
    },
    isImpersonateUnavailable(row) {
      return row.sid === this.sid || !isEmpty(localStorage.getItem('impersonate_ticket'))
    },
    showImpersonateConfirm(row) {
      this.$confirm(
        this.$t('common.tips.confirm_impersonate', { name: row.nickname }), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        try {
          const { data } = await impersonate(row.sid)
          const ticket = data.ticket
          const token = data.token
          localStorage.setItem('impersonate_ticket', ticket)
          setToken(token)
          window.location.href = window.location.href.split('#')[0]
        } catch(e) {
          this.$message({
            message: this.$t('system.tips.impersonate_fail'),
            type: 'error',
            duration: 1500
          })
        }
      }).catch(() => {})
    },
  }
}
</script>

<style lang="scss" scoped>
.table-drop-down {
  .el-link {
    padding: 5px;
  }
}
</style>
