export default {
  application_name: 'Application ID',
  application_nickname: 'Application Name',
  profile_name: 'Profile Name',
  record_count: 'Record Count',
  version_count: 'Version Count',
  publish_all: 'Publish All',
  publish: 'Publish',
  current_runtime_version: 'Current Runtime',
  log_level: 'Log Level',
  keyword: 'Keyword',
  log_message: 'Log Message',
  index_name: 'Index Name',
  index_doc_count: 'Index Doc Count',
  index_size: 'Index Size',
  index_health: 'Health',
  index_primaries: 'Primary Shards',
  index_replicas: 'Replica Shards',
  node_master: 'M',
  node_data: 'D',
  node_name: 'Node Name',
  node_doc_count: 'Node Doc Count',
  cpu_used_percent: 'CPU Usage',
  mem_used_percent: 'Memory Usage',
  disk_used_percent: 'Disk Usage',
  disk_used: 'Disk Used',
  disk_total: 'Disk Total',
  cluster_name: 'Cluster Name',
  cluster_status: 'Cluster Status',
  cluster_active_shards_percent: 'Active Shards Percent',
  product_path: 'Product Path',
  product_name: 'Product Name',
  product_version: 'Product Version',
  product_size: 'Product Size',
  product_package: 'Product Package',
  product_publish_time: 'Product Publish Time',
  asset: 'Asset',
  asset_id: 'Asset ID',
  asset_pid: 'Parent Asset',
  asset_type: 'Asset Type',
  asset_name: 'Asset Name',
  asset_credential: 'Asset Credential',
  asset_host: 'Asset Host',
  asset_port: 'Asset Port',
  asset_docker_endpoint: 'Docker Endpoint',
  jdbc_url: 'JDBC URL',
  jdbc_driver: 'JDBC Driver',
  remote_desktop_addr: 'Remote Desktop Address',
  remote_desktop_protocol: 'Remote Desktop Protocol',
  remote_desktop_port: 'Remote Desktop Port',
  credential: 'Credential',
  credential_id: 'Credential ID',
  credential_name: 'Credential Name',
  credential_type: 'Credential Type',
  credential_account: 'Account',
  credential_password: 'Password',
  credential_public_key: 'Public Key',
  credential_private_key: 'Private Key',
  credential_token: 'Token',
  menus: {
    'config-center': 'Config Center',
    'log-center': 'Log Center',
    'monitor': 'Monitoring Function',
    'monitor-escluster': 'ES Cluster Monitoring',
    'monitor-service': 'Service Instance Monitoring',
    'monitor-redis': 'Redis Monitoring',
    'monitor-host': 'Host Monitoring',
    products: 'Products',
    assets: 'Assets',
    projects: 'Projects',
    pipeline: 'Pipeline',
    credential: 'Credential',
    dev: 'Development',
    ops: 'Operations',
    workflow: 'Workflow Management',
    'workflow-stat': 'Workflow Stat',
    'workflow-instances': 'Workflow Instances',
    'workflow-design': 'Wordflow Dedign',
    notebook: 'Operation Notes'
  },
  tips: {
    config_center_confirm_delete: 'This operation is unrecoverable. Are you sure you want to delete profiles?',
    config_center_delete_success: 'Config file \'{name}\' has been deleted successfully!',
    config_center_delete_fail: 'Configuration file \'{name}\' deleted failed!',
    config_center_delete_version_success: 'Backup \'{version}\' of profile \'{name}\' has been deleted successfully!',
    config_center_delete_version_fail: 'Backup \'{version}\' of profile \'{name}\' failed to delete!',
    config_center_backup_success: 'Configuration file \'{name}\' has been backed up successfully!',
    config_center_backup_fail: 'Configuration file \'{name}\' backup failed!',
    config_center_confirm_publish_all: 'Are you sure you want to republish all service configurations?',
    config_center_confirm_publish: 'Are you sure you want to republish service configurations of \'{name}\'?',
    config_center_confirm_lookup: 'Unsaved configurations may be lost, Are you sure you want to reload the profile?',
    config_center_confirm_delete_version: 'This operation is unrecoverable. Are you sure you want to delete backup \'{version}\' of profile \'{name}\'?',
    config_center_load_error: 'Configuration file loading error!',
    config_center_load_versions_error: 'Configuration file versions loading error!',
    config_center_load_version_error: 'History configuration file loading error!',
    config_center_notify_error: 'Notify the application that reloading the configuration failed!',
    config_center_submit_success: 'Configuration information submitted successfully!',
    config_center_notify_result: 'Configuration refresh of \'{name}\' has been performed: found {totalCount} instances, success {successCount}'
  }
}
