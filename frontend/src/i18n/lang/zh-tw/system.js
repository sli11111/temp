export default {
  source: '來源',
  sid: '用戶ID',
  organization: '機構',
  role: '角色',
  role_name: '角色名稱',
  menu: '菜單',
  permission: '權限',
  basic_info: '基本信息',
  is_manager: '是否為管理',
  empno: '員工號',
  subscriber: '用戶',
  org: '機構',
  sub_org_member_count_d: '直屬成員',
  sub_org_member_count: '所有成員',
  sub_org_count: '下屬機構',
  org_info: '機構信息',
  org_member: '機構成員',
  org_ame: '機構名稱',
  org_id: '機構編碼',
  org_short_name: '機構簡稱',
  param_name: '參數名稱',
  param_desc: '參數說明',
  param_code: '參數編碼',
  param_value: '參數值',
  param_default_value: '參數默認值',
  schedule_task: '計劃任務',
  schedule_cron: '任務安排',
  schedule_status: '任務狀態',
  schedule_switch: '關 / 開',
  schedule_status_enabled: '已啟用',
  schedule_status_running: '執行中',
  schedule_status_disabled: '已禁用',
  schedule_runner: '任務執行器',
  schedule_last_time: '上次執行',
  schedule_time: '執行時間',
  schedule_cost: '執行耗時',
  schedule_result: '執行結果',
  operations_time: '操作時間',
  operations_client_ip: '客戶端IP',
  operations_title: '審計事件類別',
  operations_content: '審計事件',
  operations_method: '方法',
  operations_url: '接口地址',
  operations_cost: '耗時',
  operations_result: '結果',
  cache_name: '緩存名稱',
  cache_key: '緩存編碼',
  cache_val: '緩存值',
  cache_size: '緩存數量',
  cache_refresh_time: '緩存刷新時間',
  dict: '字典',
  dict_type_code: '字典編碼',
  dict_type_name: '字典名稱',
  dict_item_count: '字典項數量',
  dict_item_code: '字典項',
  dict_item_value: '字典值',
  dict_type: '字典類型',
  dict_type_static: '靜態',
  dict_type_dynamic: '動態',
  dict_p: '父級字典',
  menus: {
    system: '系統管理',
    subscriber: '用戶管理',
    role: '角色管理',
    org: '機構管理',
    'data-dictionary': '數據字典',
    parameters: '系統參數配置',
    schedule: '系統計劃任務',
    audit: '審計日誌',
    cache: '系統緩存'
  },
  tips: {
    role_basic_info_hint: '填寫角色名稱以及角色說明。角色是系統中用戶權限的集合，你可以通過給用戶賦予不同的角色，來控製用戶的權限。',
    role_menu_hint: '選擇該角色可以訪問的菜單。',
    role_permission_hint: '選擇該角色的特殊權限。',
    role_subscriber_hint: '為用戶賦予當前角色。',
    settings_changed: '由於您了系統配置參數，建議您刷新頁面再繼續使用本平臺。',
    hint_dict_desc: '動態字典是指可以存儲於數據庫的字典項，可以通過界面修改並立即生效。靜態字典是指由於有特殊用途，通過枚舉等硬編碼方式嵌入程序的字典項（靜態字典不可編輯）。',
    confirm_execute_schedule: '你確定要手動執行計劃任務嗎？',
    confirm_reset_schedule: '你確定要重置計劃任務嗎？',
    confirm_initialize_org: '您確認要初始化根節點機構（生成後可以修改）？'
  }
}
