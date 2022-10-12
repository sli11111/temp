<template>
  <auto-height-container>
    <el-row :gutter="20">
      <el-col :span="8">
        <el-card shadow="never">
          <template #header>
            <div class="clearfix">
              <el-row :gutter="5">
                <el-col :span="12">
                  <el-input
                    v-model="filterText"
                    prefix-icon="search"
                    :placeholder="$t('common.search') + ' ' + $t('system.org')"
                  />
                </el-col>
                <el-col :span="12">
                  <el-button-group style="float: right">
                    <el-button
                      v-if="synchronize"
                      :loading="syncLoading"
                      icon="refresh"
                      @click="toggleSync"
                    />
                    <el-button
                      type="primary"
                      :disabled="draggingLocked"
                      icon="promotion"
                    />
                    <el-button
                      type="danger"
                      :disabled="synchronize"
                      @click="toggleDraggingLock"
                    >
                      <el-icon v-if="draggingLocked">
                        <lock />
                      </el-icon>
                      <el-icon v-else>
                        <unlock />
                      </el-icon>
                    </el-button>
                  </el-button-group>
                </el-col>
              </el-row>
            </div>
          </template>
          <el-tree
            v-if="orgTree && orgTree.length > 0"
            ref="orgTree"
            node-key="id"
            :data="orgTree"
            :expand-on-click-node="false"
            :props="orgTreePropMap"
            :default-expanded-keys="defaultExpandedKeys"
            :filter-node-method="filterNode"
            highlight-current
            draggable
            :allow-drop="allowDrop"
            :allow-drag="allowDrag"
            @node-click="handleClick"
            @node-drag-start="handleDragStart"
            @node-drag-enter="handleDragEnter"
            @node-drag-leave="handleDragLeave"
            @node-drag-over="handleDragOver"
            @node-drag-end="handleDragEnd"
            @node-drop="handleDrop"
          >
            <template #default="{ node, data }">
              <span class="custom-tree-node">
                <span><svg-icon icon-class="org" />&nbsp;{{ node.label }}</span>
                <span v-if="!draggingLocked">
                  <el-button
                    type="text"
                    :disabled="draggingLocked"
                    :title="$t('system.org.addChild')"
                    icon="plus"
                    @click="(e) => addChildOrg(data, e)"
                  />
                  <el-button
                    type="text"
                    :disabled="draggingLocked"
                    :title="$t('common.delete')"
                    icon="delete"
                    @click="(e) => removeOrg(data, e)"
                  />
                </span>
              </span>
            </template>
          </el-tree>
          <el-empty v-if="!orgTree || orgTree.length === 0">
            <el-button type="primary" @click="showInitConfirm">{{$t('common.init')}}</el-button>
          </el-empty>
        </el-card>
      </el-col>
      <el-col :span="16">
        <el-card shadow="never">
          <template #header>
            <div class="clearfix">
              <span>{{ currentOrg ? currentOrg.orgName : $t('common.no_data') }}</span>
              <el-button-group style="float: right;">
                <el-button
                  type="primary"
                  :disabled="draggingLocked || !currentOrg"
                  @click="handleSubmit"
                >
                  <el-icon><s-promotion /></el-icon>
                  {{ $t('common.save') }}
                </el-button>
              </el-button-group>
            </div>
          </template>
          <el-empty v-if="!currentOrg" :description="$t('common.no_data')"></el-empty>
          <div v-if="currentOrg">
            <el-row :gutter="10">
              <el-col
                :xs="12"
                :sm="12"
                :lg="8"
                class="card-panel-col"
              >
                <div class="card-panel">
                  <div class="card-panel-icon-wrapper icon-people">
                    <svg-icon
                      icon-class="member"
                      class-name="card-panel-icon"
                    />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      {{$t('system.sub_org_member_count_d')}}
                    </div>
                    <count-to
                      :start-val="0"
                      :end-val="currentOrgStatistics.userCount || 0"
                      :duration="2600"
                      class="card-panel-num"
                    />
                  </div>
                </div>
              </el-col>
              <el-col
                :xs="12"
                :sm="12"
                :lg="8"
                class="card-panel-col"
              >
                <div class="card-panel">
                  <div class="card-panel-icon-wrapper icon-message">
                    <svg-icon
                      icon-class="member"
                      class-name="card-panel-icon"
                    />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      {{$t('system.sub_org_member_count')}}
                    </div>
                    <count-to
                      :start-val="0"
                      :end-val="currentOrgStatistics.subOrgUserCount || 0"
                      :duration="2600"
                      class="card-panel-num"
                    />
                  </div>
                </div>
              </el-col>
              <el-col
                :xs="12"
                :sm="12"
                :lg="8"
                class="card-panel-col"
              >
                <div class="card-panel">
                  <div class="card-panel-icon-wrapper icon-money">
                    <svg-icon
                      icon-class="org"
                      class-name="card-panel-icon"
                    />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      {{$t('system.sub_org_count')}}
                    </div>
                    <count-to
                      :start-val="0"
                      :end-val="currentOrgStatistics.subOrgCount || 0"
                      :duration="2600"
                      class="card-panel-num"
                    />
                  </div>
                </div>
              </el-col>
            </el-row>
            <el-collapse
              v-model="activeNames"
              accordion
            >
              <el-collapse-item
                :title="$t('system.org_info')"
                name="1"
              >
                <el-form
                  label-position="right"
                  label-width="140px"
                >
                  <el-row>
                    <el-col :span="12">
                      <el-form-item
                        :label="$t('system.org_ame')"
                        prop="orgName"
                      >
                        <el-input
                          v-model="currentOrg.orgName"
                          type="text"
                          maxlength="30"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="12">
                      <el-form-item
                        :label="$t('system.org_id')"
                        prop="orgCode"
                      >
                        <el-input
                          v-model="currentOrg.orgCode"
                          type="text"
                          maxlength="20"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="mode === 'full'">
                    <el-col :span="12">
                      <el-form-item
                        :label="$t('system.org_short_name')"
                      >
                        <el-input
                          v-model="currentOrg.orgNameShort"
                          type="text"
                          maxlength="20"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="12">
                      <el-form-item
                        :label="$t('common.type')"
                      >
                        <el-select
                          v-model="currentOrg.orgType"
                          clearable
                          style="width: 100%"
                        >
                          <el-option
                            v-for="(val, key) in $dicts['ORG_TYPE']"
                            :key="key"
                            :label="val"
                            :value="key"
                          />
                        </el-select>
                      </el-form-item>
                    </el-col>
                    <el-col :span="24">
                      <el-form-item
                        :label="$t('common.address')"
                      >
                        <el-input
                          v-model="currentOrg.officeAddr"
                          type="text"
                          maxlength="120"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="12">
                      <el-form-item
                        :label="$t('common.zipcode')"
                      >
                        <el-input
                          v-model="currentOrg.officeZip"
                          type="text"
                          maxlength="20"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="12">
                      <el-form-item
                        :label="$t('common.tel')"
                      >
                        <el-input
                          v-model="currentOrg.officeTel"
                          type="text"
                          maxlength="20"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="12">
                      <el-form-item
                        :label="$t('common.fax')"
                      >
                        <el-input
                          v-model="currentOrg.officeFax"
                          type="text"
                          maxlength="20"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="24">
                      <el-form-item
                        :label="$t('common.desc')"
                      >
                        <el-input
                          v-model="currentOrg.desc"
                          type="textarea"
                          maxlength="200"
                          show-word-limit
                        />
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-form>
              </el-collapse-item>
              <el-collapse-item
                v-if="userMngOn"
                :title="$t('system.org_member')"
                name="2"
              >
                <div class="filter-container">
                  <el-row :gutter="10">
                    <el-col :span="22">
                      <el-select
                        v-model="userValues"
                        multiple
                        filterable
                        remote
                        :disabled="currentOrgStatus !== 'edit'"
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
                        :title="$t('common.add')+$t('system.User')"
                        :disabled="userValues.length === 0"
                        @click="addOrgUser"
                      >
                        <svg-icon icon-class="save" />
                      </el-button>
                    </el-col>
                  </el-row>
                </div>
                <el-table
                  :data="currentOrgUsers"
                  border
                >
                  <el-table-column
                    align="center"
                    prop="sid"
                    label="SID"
                    width="80"
                  />
                  <el-table-column
                    align="center"
                    prop="nickname"
                    :label="$t('common.nickname')"
                    width="100"
                  />
                  <el-table-column
                    align="center"
                    prop="username"
                    :label="$t('common.username')"
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
                    v-if="currentOrgStatus === 'edit'"
                    fixed="right"
                    align="center"
                    width="80"
                  >
                    <template #default="{ row }">
                      <el-button-group>
                        <el-button
                          type="danger"
                          icon="delete"
                          @click="deleteOrgUser(row)"
                        />
                      </el-button-group>
                    </template>
                  </el-table-column>
                </el-table>
                <pagination
                  v-model="currentOrgUserPage"
                  hide-on-single-page
                  style="margin: 0; padding: 10px 0;"
                  @pagination="getCurrentOrgUsers"
                />
              </el-collapse-item>
            </el-collapse>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </auto-height-container>
</template>

<script>
import AutoHeightContainer from '@/components/AutoHeightContainer/index.vue'
import CountTo from '@/components/CountTo/index.vue'
import Pagination from '@/components/Pagination/index.vue'

import { fetchOrgTree, fetchOrgStatistics, fetchOrgUsers, submitOrgTree, deleteOrg, submitOrgUser, deleteOrgUser, SyncOrg } from '@/api/system/orgs'
import { fetchUsers } from '@/api/system/users'

import { deepClone } from '@/utils'
import settings from '@/settings'

export default {
  components: { AutoHeightContainer, CountTo, Pagination },
  data() {
    return {
      mode: settings.system.org.mode,
      userMngOn: settings.system.org.userMngOn,
      synchronize: settings.system.org.synchronize,
      userOptions: [],
      userValues: [],
      userLoading: false,
      activeNames: ['1'],
      draggingLocked: true,
      syncLoading: false,
      filterText: '',
      orgTree: [],
      orgTreePropMap: {
        label: settings.system.org.showName === 'full' ? 'orgName' : 'orgNameShort',
        children: 'children',
        disabled: function(data, node) {
          return true
        },
        isLeaf: function(data, node) {
          return node.children && node.children.length > 0
        }
      },
      defaultExpandedKeys: [],
      currentOrgStatus: '',
      currentOrg: null,
      currentOrgStatistics: {},
      currentOrgUsers: [],
      currentOrgUserPage: {
        pageNumber: 1,
        pageSize: 10,
        totalPage: 1,
        totalRecord: 0
      }
    }
  },
  watch: {
    filterText(val) {
      this.$refs.orgTree.filter(val)
    }
  },
  mounted() {
    this.getTree()
  },
  methods: {
    showInitConfirm() {
      this.$confirm(
        this.$t('system.tips.confirm_initialize_org'), this.$t('common.tip'), {
          type: 'warning',
          confirmButtonText: this.$t('common.confirm'),
          cancelButtonText: this.$t('common.cancel')
        }
      ).then(async () => {
        const org = { orgCode: 'ROOT_ORG_CODE', orgName: 'ROOT_ORG_NAME', orgType: '00', orgName: 'Root Organization', orgNameShort: 'Root Organization', desc: 'This organization is initialized by system.' }
        submitOrgTree(new Array(org)).then(response => {
          this.getOrgTree(response)
        })
      }).catch(() => {})
    },
    async getTree() {
      fetchOrgTree().then(response => {
        this.getOrgTree(response)
      })
    },
    async getCurrentOrgStatistics() {
      const { data } = await fetchOrgStatistics(this.currentOrg.id)
      this.currentOrgStatistics = data
    },
    async getCurrentOrgUsers() {
      const { data } = await fetchUsers(this.currentOrgUserPage, { orgId: this.currentOrg.id })
      this.currentOrgUsers = data.datalist
      this.currentOrgUserPage = data.page
    },
    async getUserOptions(query) {
      if (query !== '') {
        this.userLoading = true
        const { data } = await fetchOrgUsers(this.currentOrg.id, query)
        const userOptions = []
        for (let i = 0; i < data.datalist.length; i++) {
          const user = data.datalist[i]
          userOptions.push({ key: user.sid, label: user.username + '(' + user.nickname + ')' })
        }
        this.userOptions = userOptions
        this.userLoading = false
      } else {
        this.userOptions = []
      }
    },
    async toggleSync() {
      this.syncLoading = true
      SyncOrg().then(async () => {
        await this.getTree()
        this.syncLoading = false
      }).catch(() => {
        this.syncLoading = false
      })
    },
    getOrgTree: function(response) {
      const orgTree = response.data
      for (let i = 0; i < orgTree.length; i++) {
        this.defaultExpandedKeys.push(orgTree[i].id)
      }
      this.orgTree = orgTree
    },
    stopPropagation(e) {
      e.stopPropagation()
      e.preventDefault()
    },
    filterNode: function(value, data) {
      if (!value) return true
      return data.orgName.indexOf(value) !== -1
    },
    isRootNode: function(node) {
      return node.data.id === null
    },
    handleClick: function(data, node) {
      this.currentOrgStatus = 'edit'
      this.currentOrgStatistics = []
      this.currentOrgUsers = []
      this.userValues = []
      this.currentOrgUserPage.pageNumber = 1
      this.currentOrg = deepClone(data)
      this.currentOrg.pid = this.isRootNode(node) ? null : node.parent.data.id

      this.getCurrentOrgStatistics()
      this.getCurrentOrgUsers()
    },
    addChildOrg: function(data, e) {
      this.currentOrgStatus = 'add'
      this.currentOrgStatistics = []
      this.currentOrgUsers = []
      this.userValues = []
      this.currentOrgUserPage.pageNumber = 1
      this.currentOrg = {}
      this.currentOrg.pid = data.id
      this.stopPropagation(e)
    },
    removeOrg: function(data, e) {
      const name = this.$t('system.org') + ' \'' + data.orgName + '\''
      this.$confirm(this.$t('common.tips.confirm_delete', { name }), this.$t('common.tip'), {
        confirmButtonText: this.$t('common.confirm'),
        cancelButtonText: this.$t('common.cancel'),
        type: 'warning'
      }).then(() => {
        deleteOrg(data.id).then(response => {
          this.getOrgTree(response)
          this.$message({
            type: 'success',
            message: this.$t('common.tips.delete_success', { name })
          })
        })
      }).catch(() => {})
      this.stopPropagation(e)
    },
    addOrgUser() {
      const list = this.userValues.map(value => ({ sid: value }))
      submitOrgUser(this.currentOrg.id, list).then(() => {
        this.getCurrentOrgUsers()
      })
    },
    deleteOrgUser(data) {
      deleteOrgUser(this.currentOrg.id, new Array(data)).then(() => {
        this.getCurrentOrgUsers()
      })
    },
    handleDragStart(node, ev) {
      //this.$log.info('drag start', node, ev)
    },
    handleDragEnter(draggingNode, dropNode, ev) {
      //this.$log.info('tree drag enter: ', dropNode.label, ev)
    },
    handleDragLeave(draggingNode, dropNode, ev) {
      //this.$log.info('tree drag leave: ', dropNode.label, ev)
    },
    handleDragOver(draggingNode, dropNode, ev) {
      //this.$log.info('tree drag over: ', dropNode.label, ev)
    },
    handleDragEnd(draggingNode, dropNode, dropType, ev) {
      //this.$log.info('tree drag end: ', dropNode && dropNode.label, dropType, ev)
    },
    handleDrop(draggingNode, dropNode, dropType, ev) {
      //this.$log.info('tree drop: ', dropNode.label, dropType, ev)
    },
    allowDrop(draggingNode, dropNode, type) {
      //this.$log.info(draggingNode, dropNode, type)
      return true
    },
    allowDrag(draggingNode) {
      //this.$log.info(draggingNode)
      return !this.draggingLocked
    },
    toggleDraggingLock() {
      this.draggingLocked = !this.draggingLocked
    },
    async handleSubmit() {
      const org = this.currentOrg
      submitOrgTree(new Array(org)).then(response => {
        this.getOrgTree(response)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.custom-tree-node {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  padding-right: 8px;
}

  .card-panel-col {
  margin-bottom: 32px;
}

.card-panel {
  height: 82px;
  cursor: pointer;
  font-size: 12px;
  position: relative;
  overflow: hidden;
  color: #666;
  //box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
  border: 1px solid rgba(0, 0, 0, .05);

  &:hover {
    .card-panel-icon-wrapper {
      color: #fff;
    }

    .icon-people {
      background: #40c9c6;
    }

    .icon-message {
      background: #36a3f7;
    }

    .icon-money {
      background: #f4516c;
    }

    .icon-shopping {
      background: #34bfa3
    }
  }

  .icon-people {
    color: #40c9c6;
  }

  .icon-message {
    color: #36a3f7;
  }

  .icon-money {
    color: #f4516c;
  }

  .icon-shopping {
    color: #34bfa3
  }

  .card-panel-icon-wrapper {
    float: left;
    margin: 5px 0 0 5px;
    padding: 16px;
    transition: all 0.38s ease-out;
    border-radius: 6px;
  }

  .card-panel-icon {
    float: left;
    font-size: 38px;
  }

  .card-panel-description {
    float: right;
    font-weight: bold;
    margin: 14px 14px 14px 0;

    .card-panel-text {
      line-height: 18px;
      font-size: 14px;
      margin-bottom: 12px;
    }

    .card-panel-num {
      font-size: 18px;
    }
  }
}
</style>
