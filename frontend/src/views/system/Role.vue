<template>
  <auto-height-container>
    <div v-if="!form_visible">
      <div class="filter-container">
        <el-input
          v-model="search_param.search"
          :placeholder="$t('system.role_name')"
          clearable
          class="filter-item"
          style="width: 200px;"
          @keyup.enter="getList"
        />
        <tree-select
          v-model="search_param.menuId"
          :props="{ value: 'id', label: 'name', children: 'children', placeholder: $t('system.menu') }"
          :options="menu_list"
          clearable
          accordion
          class="filter-item"
          style="width: 120px"
        />
        <el-select
          v-model="search_param.permKey"
          :placeholder="$t('system.permission')"
          clearable
          class="filter-item"
          style="width: 120px"
        >
          <el-option
            v-for="item in perm_list"
            :key="item.cone"
            :label="item.name"
            :value="item.code"
          />
        </el-select>
        <el-button
          v-waves
          :disabled="list_loading"
          class="filter-item"
          type="primary"
          icon="search"
          @click="getList"
        >
          {{ this.$t('common.search') }}
        </el-button>
        <el-button-group style="float: right">
          <el-button
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
        style="width: 100%;"
      >
        <el-table-column
          align="center"
          :label="$t('common.name')"
          width="220"
        >
          <template #default="scope">
            {{ scope.row.roleName }}
          </template>
        </el-table-column>
        <el-table-column
          align="header-center"
          :label="$t('common.desc')"
        >
          <template #default="scope">
            {{ scope.row.remark }}
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          :label="$t('common.operations')"
          width="220"
        >
          <template #default="{ row }">
            <el-button-group>
              <el-button
                :disabled="list_loading"
                type="primary"
                icon="edit"
                @click="handleEdit(row)"
              >
                {{ $t('common.edit') }}
              </el-button>
              <el-button
                :disabled="list_loading"
                type="danger"
                icon="delete"
                @click="showDeleteConfirm(row)"
              >
                {{ $t('common.delete') }}
              </el-button>
            </el-button-group>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div v-if="form_visible">
      <el-card shadow="never">
        <template #header>
          {{ getFormTitle() }}
          <el-button-group style="float:right">
            <el-button
              type="default"
              :disabled="submitting"
              icon="refresh-left"
              @click="hideForm"
            >
              {{ this.$t('common.cancel') }}
            </el-button>
            <el-button
              type="primary"
              :loading="submitting"
              @click="handleSubmit"
            >
              <svg-icon icon-class="save" />
              {{ this.$t('common.save') }}
            </el-button>
          </el-button-group>
        </template>
        <el-row :gutter="5">
          <el-col :span="6">
            <el-steps
              direction="vertical"
              :active="activeStep"
              style="height: 300px"
            >
              <el-step
                :title="$t('system.basic_info')"
                :description="$t('system.tips.role_basic_info_hint')"
                :status="activeStep===0 ? 'finish' : 'wait'"
              >
                <template #icon>
                  <svg-icon icon-class="edit" />
                </template>
              </el-step>
              <el-step
                :title="$t('system.menu')"
                :description="$t('system.tips.role_menu_hint')"
                :status="activeStep===1 ? 'finish' : 'wait'"
              >
                <template #icon>
                  <svg-icon icon-class="edit" />
                </template>
              </el-step>
              <el-step
                v-if="perm_list.length > 0"
                :title="$t('system.permission')"
                :description="$t('system.tips.role_permission_hint')"
                :status="activeStep===2 ? 'finish' : 'wait'"
              >
                <template #icon>
                  <svg-icon icon-class="edit" />
                </template>
              </el-step>
              <el-step
                v-if="userMngOn && form_status==='edit'"
                :title="$t('system.subscriber')"
                :description="$t('system.tips.role_subscriber_hint')"
                :status="activeStep===3 ? 'finish' : 'wait'"
              >
                <template #icon>
                  <svg-icon icon-class="edit" />
                </template>
              </el-step>
            </el-steps>
          </el-col>
          <el-col :span="18">
            <el-form
              ref="dataForm"
              :model="form_data"
              label-position="right"
              label-width="100px"
              style="min-height: 400px; margin-bottom: 20px"
              :rules="formRules"
            >
              <el-collapse
                v-model="activeNames"
                accordion
              >
                <el-collapse-item
                  :title="$t('system.basic_info')"
                  name="1"
                >
                  <el-row>
                    <el-col :span="24">
                      <el-form-item
                        :label="$t('common.name')"
                        prop="roleName"
                      >
                        <el-input
                          v-model="form_data.roleName"
                          type="text"
                          maxlength="20"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="24">
                      <el-form-item :label="$t('common.desc')">
                        <el-input
                          v-model="form_data.remark"
                          type="textarea"
                          maxlength="256"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-collapse-item>
                <el-collapse-item
                  :title="$t('system.menu')"
                  name="2"
                >
                  <el-tree
                    ref="menu_tree"
                    :data="menu_list"
                    show-checkbox
                    default-expand-all
                    node-key="id"
                    highlight-current
                    :default-checked-keys="form_data.menus"
                    :check-strictly="role_tree_loading"
                  >
                    <template #default="{ data }">
                      <span class="custom-tree-node">
                        <span>
                          <svg-icon :icon-class="data.meta && data.meta.icon ? data.meta.icon : ''" />
                          {{ $t( data.meta && data.meta.title ? data.meta.title : '' ) }}
                        </span>
                      </span>
                    </template>
                  </el-tree>
                </el-collapse-item>
                <el-collapse-item
                  v-if="perm_list.length > 0"
                  :title="$t('system.Permission')"
                  name="3"
                >
                  <el-table
                    ref="perm_table"
                    :data="perm_list"
                    style="width: 100%"
                    row-key="key"
                    @selection-change="handlePermSelectionChange"
                  >
                    <el-table-column
                      type="selection"
                      width="55"
                      :reserve-selection="true"
                    />
                    <el-table-column
                      :label="$t('common.name')"
                      width="220"
                    >
                      <template #default="{ row }">
                        {{ row.name }}
                      </template>
                    </el-table-column>
                    <el-table-column :label="$t('common.desc')">
                      <template #default="{ row }">
                        {{ row.remark }}
                      </template>
                    </el-table-column>
                  </el-table>
                </el-collapse-item>
                <el-collapse-item
                  v-if="userMngOn && form_status==='edit'"
                  :title="$t('system.subscriber')"
                  name="4"
                >
                  <div class="filter-container">
                    <el-row :gutter="10">
                      <el-col :span="22">
                        <el-select
                          v-model="user_selections"
                          multiple
                          filterable
                          remote
                          :loading="userLoading"
                          :remote-method="getUserOptions"
                          class="filter-item"
                          style="width: 100%"
                        >
                          <el-option
                            v-for="item in userOptions"
                            :key="item.key"
                            :label="item.label"
                            :value="item.key"
                          />
                        </el-select>
                      </el-col>
                      <el-col :span="2">
                        <el-button
                          style="width: 100%"
                          type="primary"
                          class="filter-item"
                          :title="$t('common.add')"
                          :disabled="user_selections.length === 0"
                          @click="handleRoleUsersSubmit"
                        >
                          <svg-icon icon-class="save" />
                        </el-button>
                      </el-col>
                    </el-row>
                  </div>
                  <el-table
                    :data="role_users"
                    border
                  >
                    <el-table-column
                      align="center"
                      prop="sid"
                      label="SID"
                      width="100"
                    />
                    <el-table-column
                      align="center"
                      prop="username"
                      :label="$t('common.username')"
                      width="120"
                    />
                    <el-table-column
                      align="center"
                      prop="nickname"
                      :label="$t('common.nickname')"
                      width="120"
                    />
                    <el-table-column
                      align="center"
                      prop="params.MOBILE"
                      :label="$t('common.mobile')"
                      show-overflow-tooltip
                    />
                    <el-table-column
                      align="center"
                      prop="params.EMAIL"
                      :label="$t('common.email')"
                      show-overflow-tooltip
                    />
                    <el-table-column
                      fixed="right"
                      align="center"
                      width="80"
                    >
                      <template #default="{row}">
                        <el-button-group>
                          <el-button
                            type="danger"
                            icon="delete"
                            @click="showRoleUserDeleteConfirm(row)"
                          />
                        </el-button-group>
                      </template>
                    </el-table-column>
                  </el-table>
                  <pagination
                    v-model="role_user_page"
                    hide-on-single-page
                    style="margin: 0; padding: 10px 0;"
                    @pagination="getCurrentRoleUsers"
                  />
                </el-collapse-item>
              </el-collapse>
            </el-form>
          </el-col>
        </el-row>
      </el-card>
    </div>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import { fetchRoles, fetchRole, submitRole, submitRoleUsers, deleteRole, deleteRoleUser } from '@/api/system/roles'
import { fetchUsers, fetchRoleCandidates } from '@/api/system/users'
import waves from '@/directive/waves'
import Pagination from '@/components/Pagination/index.vue'
import TreeSelect from '@/components/TreeSelect/index.vue'
import { deepClone } from '@/utils'
import { getAllMenus, getPermissions } from './utils'
import settings from '@/settings'

export default {
  directives: { waves },
  components: { AutoHeightContainer, Pagination, TreeSelect },
  data() {
    return {
      role_tree_loading: false,
      list_loading: false,
      uploadLoading: false,
      downloadLoading: false,
      submitting: false,
      datalist: [],
      search_param: {},
      form_visible: false,
      form_status: 'add',
      formRules: {
        roleName: [{ required: true, message: this.$t('common.tips.is_required'), trigger: 'blur' }]
      },
      default_form_data: {
        roleId: null,
        roleName: null,
        remark: null,
        menus: [],
        perms: []
      },
      form_data: {},
      perm_list: [],
      perm_selections: [],
      menu_list: [],
      menu_selections: [],
      role_users: [],
      role_user_page: {
        pageNumber: 1,
        pageSize: 10,
        totalPage: 0,
        totalRecord: 0
      },
      userOptions: [],
      user_selections: [],
      userLoading: false,
      activeNames: ['1']
    }
  },
  computed: {
    activeStep() {
      return parseInt(this.activeNames[0]) - 1
    },
    userMngOn() {
      return settings.system.role.userMngOn
    }
  },
  async mounted() {
    await this.getList()
    this.perm_list = await getPermissions()
    this.menu_list = await getAllMenus()
  },
  methods: {
    async getList() {
      this.list_loading = true
      const { data } = await fetchRoles(this.search_param)
      this.datalist = data.datalist
      this.list_loading = false
    },
    async getCurrentRoleUsers() {
      const { data } = await fetchUsers(this.role_user_page, { roleId: this.form_data.roleId })
      this.role_users = data.datalist
      this.role_user_page = data.page
    },
    async getUserOptions(search) {
      if (search !== '') {
        this.userLoading = true
        const { data } = await fetchRoleCandidates(this.form_data.roleId, search)
        const userOptions = []
        for (let i = 0; i < data.datalist.length; i++) {
          const user = data.datalist[i]
          userOptions.push({ key: user.sid, label: user.nickname + ' (' + user.username + ')' })
        }
        this.userOptions = userOptions
        this.userLoading = false
      } else {
        this.userOptions = []
      }
    },
    getFormTitle() {
      return this.$t('common.' + this.form_status) + ' ' + this.$t('system.role')
    },
    showForm() {
      this.activeNames = ['1']
      this.form_visible = true
      this.$nextTick(() => {
        const perms = this.form_data.perms || []
        for (let i = 0; i < this.perm_list.length; i++) {
          for (let j = 0; j < perms.length; j++) {
            if (this.perm_list[i].code === perms[j]) {
              this.$refs.perm_table.toggleRowSelection(this.perm_list[i], true)
              break
            }
          }
        }
      })
    },
    hideForm() {
      this.form_visible = false
    },
    showDeleteConfirm(role) {
      this.$confirm(
        this.$t('common.tips.confirm_delete', { name: role.roleName }), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        await this.handleDelete(role.roleId)
      }).catch(() => {})
    },
    showRoleUserDeleteConfirm(subscriber) {
      this.$confirm(
        this.$t('common.tips.confirm_delete', { name: subscriber.nickname }), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        await this.handleDeleteRoleUser(subscriber.sid)
      }).catch(() => {})
    },
    handleAdd() {
      this.form_status = 'add'
      this.form_data = {
        roleName: null,
        remark: null,
        perms: [],
        menus: []
      }
      this.showForm()
    },
    async handleEdit(row) {
      this.form_status = 'edit'
      this.role_tree_loading = true
      const { data } = await fetchRole(row.roleId)
      this.form_data = data

      await this.getCurrentRoleUsers()
      this.showForm()

      await this.$nextTick(() => {
        this.role_tree_loading = false
      })
    },
    handleUpload() {},
    handleDownload() {},
    async handleDelete(roleId) {
      this.list_loading = true
      await deleteRole(roleId)
      await this.getList()
    },
    handlePermSelectionChange(selections) {
      const perms = []
      for (let i = 0; i < selections.length; i++) {
        const permission = selections[i]
        perms.push(permission.code)
      }
      this.form_data.perms = perms
      this.perm_selections = selections
    },
    async handleRoleUsersSubmit() {
      this.submitting = true
      const roleId = this.form_data.roleId
      const subscribers = []
      for (let i = 0; i < this.user_selections.length; i++) {
        subscribers.push({ sid: this.user_selections[i] })
      }
      await submitRoleUsers(roleId, subscribers)
      this.user_selections = []
      await this.getCurrentRoleUsers()
      this.submitting = false
    },
    async handleDeleteRoleUser(userId) {
      this.submitting = true
      await deleteRoleUser(this.form_data.roleId, userId)
      await this.getCurrentRoleUsers()
      this.submitting = false
    },
    async handleSubmit() {
      this.$refs.dataForm.validate(async valid => {
        if (valid) {
          const role = deepClone(this.form_data)
          role.menus = this.$refs.menu_tree.getCheckedKeys()
          role.menus = role.menus.concat(this.$refs.menu_tree.getHalfCheckedKeys())

          this.submitting = true
          await submitRole(role)
          this.submitting = false

          this.$message({
            type: 'success',
            message: this.$t('common.tips.submit_success', { name: this.$t('system.Role') })
          })
          this.hideForm()
          await this.getList()
        } else {
          this.activeNames = ['1']
        }
      })
    }
  }
}
</script>

<style>
  .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }
</style>
