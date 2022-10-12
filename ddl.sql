/*==============================================================
    SYS_CODE: 字典
==============================================================*/
DROP TABLE IF EXISTS SYS_CODE;
CREATE TABLE SYS_CODE (
                          ID           varchar(36)  NOT NULL COMMENT '主键'
    ,CODE         varchar(128) NOT NULL COMMENT '字典项编码'
    ,CODE_TYPE    varchar(128) NOT NULL COMMENT '字典项类型'
    ,CODE_VALUE   varchar(128) NOT NULL COMMENT '字典项值'
    ,ORDER_BY     int          DEFAULT 0 NOT NULL COMMENT '字典项排序'
    ,PAR_CODE_ID  varchar(36)  NULL COMMENT '父字典项编码'
    ,CREATED_TS   timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '字典';
ALTER TABLE SYS_CODE COMMENT '字典';
ALTER TABLE SYS_CODE ADD INDEX IK_SYSCODE_TYPE (CODE_TYPE);


/*==============================================================
    SYS_CODE_TYPE: 字典类型表
==============================================================*/
DROP TABLE IF EXISTS SYS_CODE_TYPE;
CREATE TABLE SYS_CODE_TYPE (
                               ID               varchar(36)  NOT NULL COMMENT '主键'
    ,CODE_TYPE        varchar(128) NOT NULL COMMENT '字典类型'
    ,CODE_TYPE_NAME   varchar(128) NOT NULL COMMENT '字典类型名称'
    ,PAR_CODE_TYPE_ID varchar(36)  NULL COMMENT '父代码类别ID'
    ,CREATED_TS       timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY       varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS      timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY      varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT     int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '字典类型表';
ALTER TABLE SYS_CODE_TYPE COMMENT '字典类型表';
ALTER TABLE SYS_CODE_TYPE ADD INDEX IK_SYSCODETYPE_TYPE (CODE_TYPE);


/*==============================================================
    SYS_HOLIDAY: 节假日
==============================================================*/
DROP TABLE IF EXISTS SYS_HOLIDAY;
CREATE TABLE SYS_HOLIDAY (
                             DATE_ID      varchar(36)  NOT NULL COMMENT '主键（日期）'
    ,HOLIDAY_FLAG varchar(128) NOT NULL COMMENT '节假日标记'
    ,REMARK       varchar(512) NULL COMMENT '节假日备注'
    ,CREATED_TS   timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (DATE_ID)
)
    COMMENT '节假日';
ALTER TABLE SYS_HOLIDAY COMMENT '节假日';
ALTER TABLE SYS_HOLIDAY ADD INDEX IK_SYSHOLIDAY_FLAG (HOLIDAY_FLAG);


/*==============================================================
    SYS_MESSAGE: 系统消息
==============================================================*/
DROP TABLE IF EXISTS SYS_MESSAGE;
CREATE TABLE SYS_MESSAGE (
                             ID           varchar(36)   NOT NULL COMMENT '主键'
    ,SEND_TYPE    varchar(128)  NOT NULL COMMENT '发送类型'
    ,TITLE        varchar(128)  NOT NULL COMMENT '消息标题'
    ,CONTENT      varchar(1024) NOT NULL COMMENT '消息内容'
    ,VALID_DATE   timestamp     NULL COMMENT '有效期'
    ,CREATED_TS   timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '系统消息';
ALTER TABLE SYS_MESSAGE COMMENT '系统消息';


/*==============================================================
    SYS_MESSAGE_PUBLISH:
==============================================================*/
DROP TABLE IF EXISTS SYS_MESSAGE_PUBLISH;
CREATE TABLE SYS_MESSAGE_PUBLISH (
                                     ID           varchar(36)  NOT NULL COMMENT '主键'
    ,MESSAGE_ID   varchar(36)  NOT NULL COMMENT '消息ID'
    ,SEND_TYPE    varchar(128) NOT NULL COMMENT '发送类型'
    ,TARGET_ID    varchar(36)  NULL COMMENT '目标ID'
    ,CREATED_TS   timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '';
ALTER TABLE SYS_MESSAGE_PUBLISH COMMENT '';


/*==============================================================
    SYS_NOTICE: 公告
==============================================================*/
DROP TABLE IF EXISTS SYS_NOTICE;
CREATE TABLE SYS_NOTICE (
                            ID           varchar(36)   NOT NULL COMMENT '主键'
    ,NOTICE_TYPE  varchar(128)  NULL COMMENT '公告类型'
    ,TITLE        varchar(128)  NOT NULL COMMENT '公告标题'
    ,CONTENT      varchar(1024) NOT NULL COMMENT '公告内容'
    ,PUBLISH_TIME timestamp     NOT NULL COMMENT '公告发布时间'
    ,IS_VISIBLE   char(1)       DEFAULT 'Y' NOT NULL COMMENT '是否可见'
    ,CREATED_TS   timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '公告';
ALTER TABLE SYS_NOTICE COMMENT '公告';


/*==============================================================
    SYS_NOTICE_PUBLISH: 公告发布
==============================================================*/
DROP TABLE IF EXISTS SYS_NOTICE_PUBLISH;
CREATE TABLE SYS_NOTICE_PUBLISH (
                                    ID           varchar(36)  NOT NULL COMMENT '主键'
    ,NOTICE_ID    varchar(36)  NOT NULL COMMENT '公告ID'
    ,SCOPE        varchar(128) DEFAULT 'all' NOT NULL COMMENT '发布范围'
    ,TARGET_ID    varchar(36)  NOT NULL COMMENT '发布目标'
    ,CREATED_TS   timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '公告发布';
ALTER TABLE SYS_NOTICE_PUBLISH COMMENT '公告发布';
ALTER TABLE SYS_NOTICE_PUBLISH ADD INDEX IK_SYSNOTICEPUBLISH_NST (NOTICE_ID, SCOPE, TARGET_ID);


/*==============================================================
    SYS_OPER_LOG: 操作日志
==============================================================*/
DROP TABLE IF EXISTS SYS_OPER_LOG;
CREATE TABLE SYS_OPER_LOG (
                              ID                     varchar(36)    NOT NULL
    ,CLIENT_IP              varchar(128)   NULL
    ,USER_ID                varchar(36)    NULL
    ,USER_NAME              varchar(128)   NULL
    ,OPER_BGN_TS            timestamp      NULL
    ,OPER_END_TS            timestamp      NULL
    ,METHOD                 varchar(128)   NULL
    ,URL                    varchar(128)   NULL
    ,REQ_INFO               longtext       NULL
    ,RESP_INFO              longtext       NULL
    ,REQ_REST               varchar(128)   NULL
    ,MODEL_NAME             varchar(128)   NULL
    ,MODEL_DESC             varchar(1024)  NULL
    ,FUNC_NAME              varchar(128)   NULL
    ,FUNC_DESC              varchar(1024)  NULL
    ,REMARK                 varchar(512)   NULL
    ,LOG_TYPE               varchar(128)   NULL
    ,LOG_STATUS             varchar(128)   NULL
    ,SERVICE_ID             varchar(128)   NULL
    ,GROUP_ID               varchar(128)   NULL
    ,BROWSER_GROUP          varchar(128)   NULL
    ,BROWSER_MANUFACTURER   varchar(128)   NULL
    ,BROWSER_NAME           varchar(128)   NULL
    ,BROWSER_RENDER_ENGINE  varchar(128)   NULL
    ,BROWSER_TYPE           varchar(128)   NULL
    ,CLIENT_LOCALE          varchar(128)   NULL
    ,CLIENT_RESOLUTION      varchar(128)   NULL
    ,DEVICE_MANUFACTURER    varchar(128)   NULL
    ,DEVICE_TYPE            varchar(128)   NULL
    ,GEO_CITY_CODE          varchar(128)   NULL
    ,GEO_CITY_NAME          varchar(128)   NULL
    ,GEO_CITY_NAME_L        varchar(128)   NULL
    ,GEO_COUNTRY_CODE       varchar(128)   NULL
    ,GEO_COUNTRY_NAME       varchar(128)   NULL
    ,GEO_COUNTRY_NAME_L     varchar(128)   NULL
    ,GEO_LONGITUDE          decimal(20, 2) NULL
    ,GEO_LATITUDE           decimal(20, 2) NULL
    ,GEO_POSTAL_CODE        varchar(128)   NULL
    ,GEO_SUBDIVISION_CODE   varchar(128)   NULL
    ,GEO_SUBDIVISION_NAME   varchar(128)   NULL
    ,GEO_SUBDIVISION_NAME_L varchar(128)   NULL
    ,OS_MANUFACTURER        varchar(128)   NULL
    ,OS_NAME                varchar(128)   NULL
    ,OS_TYPE                varchar(128)   NULL
    ,OS_VERSION             varchar(128)   NULL
    ,USER_AGENT             varchar(128)   NULL
    ,PAGE_TITLE             varchar(128)   NULL
    ,PAGE_URL               varchar(128)   NULL
    ,REFERER                varchar(128)   NULL
    ,SUBJECT_ID             varchar(128)   NULL
    ,KEYWORD                varchar(128)   NULL
    ,CODE1                  varchar(128)   NULL
    ,CODE2                  varchar(128)   NULL
    ,CODE3                  varchar(128)   NULL
    ,CODE4                  varchar(128)   NULL
    ,CODE5                  varchar(128)   NULL
    ,CODE6                  varchar(128)   NULL
    ,CREATED_TS             timestamp      NULL COMMENT '创建时间'
    ,CREATED_BY             varchar(36)    NULL COMMENT '创建人SID'
    ,LAST_UPD_TS            timestamp      NULL COMMENT '修改时间'
    ,LAST_UPD_BY            varchar(36)    NULL COMMENT '修改人SID'
    ,UPDATE_COUNT           int            DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '操作日志';
ALTER TABLE SYS_OPER_LOG COMMENT '操作日志';


/*==============================================================
    SYS_ORG: 机构
==============================================================*/
DROP TABLE IF EXISTS SYS_ORG;
CREATE TABLE SYS_ORG (
                         ID             varchar(36)   NOT NULL COMMENT '主键'
    ,ORG_CODE       varchar(36)   NOT NULL COMMENT '机构编码'
    ,ORG_NAME       varchar(128)  NOT NULL COMMENT '机构名称'
    ,ORG_NAME_SHORT varchar(128)  NULL COMMENT '机构简称'
    ,ORG_TYPE       varchar(128)  DEFAULT '01' NOT NULL COMMENT '机构类型'
    ,PAR_ORG_ID     varchar(36)   NULL COMMENT '父机构ID'
    ,B_ORG_ID       varchar(36)   NULL COMMENT '归属机构ID'
    ,ORDER_BY       int           DEFAULT 0 NULL COMMENT '机构排序'
    ,ORG_STATUS     varchar(128)  DEFAULT '02' NOT NULL COMMENT '机构状态'
    ,UPD_STATUS     varchar(128)  DEFAULT '01' NOT NULL COMMENT '机构更新状态'
    ,ORG_CODE_HR    varchar(36)   NULL COMMENT '机构HR系统编码'
    ,ORG_CODE_CB    varchar(36)   NULL COMMENT '机构核心系统编码'
    ,MNG_POSTN_ID   varchar(36)   NULL COMMENT '机构领导'
    ,REMARK         varchar(512)  NULL COMMENT '机构备注'
    ,LAWYER         varchar(36)   NULL COMMENT '法人代表'
    ,REG_ADDR       varchar(1024) NULL COMMENT '注册地址'
    ,OFFICE_ADDR    varchar(1024) NULL COMMENT '办公地址'
    ,OFFICE_ZIP     varchar(128)  NULL COMMENT '办公地址邮编'
    ,OFFICE_TEL     varchar(128)  NULL COMMENT '办公地址电话'
    ,OFFICE_FAX     varchar(128)  NULL COMMENT '办公地址传真'
    ,EMAIL          varchar(128)  NULL COMMENT '办公邮箱'
    ,CREATED_TS     timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY     varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS    timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY    varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT   int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '机构';
ALTER TABLE SYS_ORG COMMENT '机构';
ALTER TABLE SYS_ORG ADD UNIQUE INDEX IK_SYSORG_CODE (ORG_CODE);


/*==============================================================
    SYS_PARAM: 系统参数
==============================================================*/
DROP TABLE IF EXISTS SYS_PARAM;
CREATE TABLE SYS_PARAM (
                           ID           varchar(36)   NOT NULL COMMENT '主键'
    ,PARAM_KEY    varchar(128)  NOT NULL COMMENT '参数键'
    ,PARAM_NAME   varchar(128)  NULL COMMENT '参数名称'
    ,PARAM_VALUE  varchar(1024) NULL COMMENT '参数值'
    ,REMARK       varchar(512)  NULL COMMENT '备注'
    ,CREATED_TS   timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '系统参数';
ALTER TABLE SYS_PARAM COMMENT '系统参数';


/*==============================================================
    SYS_RESOURCE: 资源
==============================================================*/
DROP TABLE IF EXISTS SYS_RESOURCE;
CREATE TABLE SYS_RESOURCE (
                              ID              varchar(36)   NOT NULL COMMENT '主键'
    ,RESOURCE_NAME   varchar(128)  NOT NULL COMMENT '资源名称'
    ,SHORT_NAME      varchar(128)  NULL COMMENT '资源短名称'
    ,ENG_NAME        varchar(128)  NULL COMMENT '资源英文缩写'
    ,ORDER_BY        int           DEFAULT 0 NOT NULL COMMENT '资源排序'
    ,RESOURCE_URL    varchar(1024) NULL COMMENT '资源地址'
    ,RESOURCE_TYPE   varchar(128)  DEFAULT 'MENU' NOT NULL COMMENT '资源类型'
    ,SHORT_ICON      varchar(128)  NULL COMMENT '资源图标'
    ,PAR_RESOURCE_ID varchar(36)   NULL COMMENT '父资源ID'
    ,REMARK          varchar(512)  NULL COMMENT '备注'
    ,CREATED_TS      timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY      varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS     timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY     varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT    int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '资源';
ALTER TABLE SYS_RESOURCE COMMENT '资源';
ALTER TABLE SYS_RESOURCE ADD INDEX IDX_SYSRESOURCE_TYPE (RESOURCE_TYPE);


/*==============================================================
    SYS_ROLE: 角色
==============================================================*/
DROP TABLE IF EXISTS SYS_ROLE;
CREATE TABLE SYS_ROLE (
                          ID           varchar(36)  NOT NULL COMMENT '主键'
    ,ROLE_NAME    varchar(128) NOT NULL COMMENT '角色名称'
    ,REMARK       varchar(512) NULL COMMENT '角色备注'
    ,CREATED_TS   timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '角色';
ALTER TABLE SYS_ROLE COMMENT '角色';
ALTER TABLE SYS_ROLE ADD UNIQUE INDEX IK_SYSROLE_NAME (ROLE_NAME);


/*==============================================================
    SYS_ROLE_RESOURCE: 角色资源
==============================================================*/
DROP TABLE IF EXISTS SYS_ROLE_RESOURCE;
CREATE TABLE SYS_ROLE_RESOURCE (
                                   ID            varchar(36)  NOT NULL COMMENT '主键'
    ,ROLE_ID       varchar(36)  NOT NULL COMMENT '角色ID'
    ,RESOURCE_ID   varchar(36)  NOT NULL COMMENT '资源ID'
    ,RESOURCE_TYPE varchar(128) NOT NULL COMMENT '资源类型'
    ,CREATED_TS    timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY    varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS   timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY   varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT  int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '角色资源';
ALTER TABLE SYS_ROLE_RESOURCE COMMENT '角色资源';
ALTER TABLE SYS_ROLE_RESOURCE ADD UNIQUE INDEX IK_SYSROLERESOURCE_RRID (ROLE_ID, RESOURCE_ID, RESOURCE_TYPE);


/*==============================================================
    SYS_SCHEDULE: 计划任务
==============================================================*/
DROP TABLE IF EXISTS SYS_SCHEDULE;
CREATE TABLE SYS_SCHEDULE (
                              ID           varchar(36)   NOT NULL COMMENT '主键'
    ,RUNNER       varchar(1024) NOT NULL COMMENT '计划任务执行器'
    ,CRON         varchar(128)  NULL COMMENT '计划任务时间'
    ,STATUS       varchar(128)  NOT NULL COMMENT '计划任务状态'
    ,REMARK       varchar(512)  NULL COMMENT '备注'
    ,LAST_RUN     timestamp     NULL COMMENT '上次运行'
    ,VERSION      varchar(128)  NOT NULL COMMENT '配置版本号'
    ,CREATED_TS   timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '计划任务';
ALTER TABLE SYS_SCHEDULE COMMENT '计划任务';


/*==============================================================
    SYS_SCHEDULE_HISTORY:
==============================================================*/
DROP TABLE IF EXISTS SYS_SCHEDULE_HISTORY;
CREATE TABLE SYS_SCHEDULE_HISTORY (
                                      ID           varchar(36)   NOT NULL COMMENT '主键'
    ,RUNER        varchar(1024) NOT NULL COMMENT '计划任务执行器'
    ,CRON         varchar(128)  NULL COMMENT '计划任务时间'
    ,START_TIME   timestamp     NOT NULL COMMENT '开始时间'
    ,END_TIME     timestamp     NOT NULL COMMENT '结束时间'
    ,RESULT       varchar(128)  NOT NULL COMMENT '执行结果'
    ,REMARK       varchar(512)  NULL COMMENT '备注'
    ,CREATED_TS   timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '';
ALTER TABLE SYS_SCHEDULE_HISTORY COMMENT '';


/*==============================================================
    SYS_USER: 用户
==============================================================*/
DROP TABLE IF EXISTS SYS_USER;
CREATE TABLE SYS_USER (
                          ID           varchar(36)  NOT NULL COMMENT '用户SID'
    ,USERNAME     varchar(128) NOT NULL COMMENT '用户名'
    ,REALNAME     varchar(128) NULL COMMENT '用户昵称'
    ,ORG_ID       varchar(36)  NULL COMMENT '机构ID'
    ,CREATED_TS   timestamp    NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)  NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp    NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)  NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int          DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '用户';
ALTER TABLE SYS_USER COMMENT '用户';
ALTER TABLE SYS_USER ADD UNIQUE INDEX IK_SYSUSER_NAME (USERNAME);


/*==============================================================
    SYS_USER_MESSAGE: 用户消息
==============================================================*/
DROP TABLE IF EXISTS SYS_USER_MESSAGE;
CREATE TABLE SYS_USER_MESSAGE (
                                  ID           varchar(36)   NOT NULL COMMENT '主键'
    ,MESSAGE_ID   varchar(36)   NULL COMMENT '系统消息ID'
    ,SENDER_ID    varchar(36)   NOT NULL COMMENT '发送人ID'
    ,RECEIVER     varchar(36)   NOT NULL COMMENT '接收人ID'
    ,MESSAGE_TYPE varchar(128)  NOT NULL COMMENT '消息类型'
    ,TITLE        varchar(128)  NULL COMMENT '消息标题'
    ,CONTENT      varchar(1024) NULL COMMENT '消息内容'
    ,IS_READ      char(1)       DEFAULT 'N' NOT NULL COMMENT '是否已读'
    ,REPLY_ID     varchar(36)   NULL COMMENT '回复ID'
    ,CREATED_TS   timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '用户消息';
ALTER TABLE SYS_USER_MESSAGE COMMENT '用户消息';


/*==============================================================
    SYS_USER_PARAM: 用户参数
==============================================================*/
DROP TABLE IF EXISTS SYS_USER_PARAM;
CREATE TABLE SYS_USER_PARAM (
                                ID           varchar(36)   NOT NULL COMMENT '主键'
    ,USER_ID      varchar(36)   NOT NULL COMMENT '用户ID'
    ,PARAM_KEY    varchar(128)  NOT NULL COMMENT '参数键'
    ,PARAM_NAME   varchar(128)  NULL COMMENT '参数名称'
    ,PARAM_VALUE  varchar(1024) NULL COMMENT '参数值'
    ,REMARK       varchar(512)  NULL COMMENT '备注'
    ,CREATED_TS   timestamp     NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36)   NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp     NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36)   NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int           DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '用户参数';
ALTER TABLE SYS_USER_PARAM COMMENT '用户参数';
ALTER TABLE SYS_USER_PARAM ADD UNIQUE INDEX IK_SYSUSERPARAM_SIDKEY (USER_ID, PARAM_KEY);


/*==============================================================
    SYS_USER_ROLE: 用户角色
==============================================================*/
DROP TABLE IF EXISTS SYS_USER_ROLE;
CREATE TABLE SYS_USER_ROLE (
                               ID           varchar(36) NOT NULL COMMENT '主键'
    ,USER_ID      varchar(36) NOT NULL COMMENT '用户ID'
    ,ROLE_ID      varchar(36) NOT NULL COMMENT '角色ID'
    ,CREATED_TS   timestamp   NULL COMMENT '创建时间'
    ,CREATED_BY   varchar(36) NULL COMMENT '创建人SID'
    ,LAST_UPD_TS  timestamp   NULL COMMENT '修改时间'
    ,LAST_UPD_BY  varchar(36) NULL COMMENT '修改人SID'
    ,UPDATE_COUNT int         DEFAULT 0 NULL COMMENT '修改次数'
    ,PRIMARY KEY (ID)
)
    COMMENT '用户角色';
ALTER TABLE SYS_USER_ROLE COMMENT '用户角色';
ALTER TABLE SYS_USER_ROLE ADD UNIQUE INDEX IK_SYSUSERROLE_SIDROLEID (USER_ID, ROLE_ID);


