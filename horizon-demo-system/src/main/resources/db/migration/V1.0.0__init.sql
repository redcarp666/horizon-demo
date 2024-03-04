create table horizon_system.sys_dept
(
    id          varchar(32)  null comment '主键',
    parent_id   varchar(32)  null comment '上级部门',
    dept_name   varchar(255) null comment '部门名称',
    ancestors   varchar(500) null comment '祖级列表',
    sort        int          null comment '排序',
    leader      varchar(32)  null comment '负责人',
    phone       varchar(255) null comment '部门联系电话',
    status      int          null comment '状态',
    deleted     int          null comment '删除',
    tenant_id   varchar(32)  null comment '租户号',
    create_by   varchar(32)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(32)  null comment '更新人',
    update_time datetime     null comment '更新时间'
)
    comment '部门表' row_format = DYNAMIC;

create table horizon_system.sys_dict
(
    id          varchar(32)  null comment '主键',
    dict_name   varchar(255) null comment '字典名',
    dict_type   varchar(255) null comment '字典类型',
    status      int          null comment '状态',
    remark      varchar(255) null comment '备注',
    deleted     int          null comment '删除',
    tenant_id   varchar(32)  null comment '租户号',
    create_by   varchar(32)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(32)  null comment '更新人',
    update_time datetime     null comment '更新时间'
)
    comment '字典类型表' row_format = DYNAMIC;

create table horizon_system.sys_dict_data
(
    id          varchar(32)  null comment '主键',
    dict_code   varchar(50)  null comment '字典编码',
    dict_label  varchar(50)  null comment '字典标签',
    dict_value  varchar(50)  null comment '字典键值',
    dict_type   varchar(50)  null comment '字典类型',
    sort        int          null comment '排序',
    status      int          null comment '状态',
    remark      varchar(255) null comment '备注',
    deleted     int          null comment '删除',
    tenant_id   varchar(32)  null comment '租户号',
    create_by   varchar(32)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(32)  null comment '更新人',
    update_time datetime     null comment '更新时间'
)
    comment '字典数据表' row_format = DYNAMIC;

create table horizon_system.sys_file
(
    id                 varchar(32)  null comment '附件id',
    file_name          varchar(50)  null comment '附件名',
    file_path          varchar(500) null comment '相对路径',
    file_type          varchar(255) null comment '文件类型',
    file_ext           varchar(20)  null comment '文件扩展名',
    file_length        int          null comment '文件长度(字节)',
    file_md5           varchar(50)  null comment '文件md5',
    business_id        varchar(32)  null comment '业务id',
    business_file_type varchar(255) null comment '业务文件类型',
    deleted            int          null comment '删除',
    tenant_id          varchar(32)  null comment '租户号',
    create_by          varchar(32)  null comment '创建人',
    create_time        datetime     null comment '创建时间',
    update_by          varchar(32)  null comment '更新人',
    update_time        datetime     null comment '更新时间'
)
    comment '附件表' row_format = DYNAMIC;

create table horizon_system.sys_menu
(
    id          varchar(32)  not null comment '主键'
        primary key,
    menu_name   varchar(50)  null comment '菜单名',
    parent_id   varchar(32)  null comment '父菜单ID',
    sort        int          null comment '排序',
    path        varchar(500) null comment '路由路径',
    component   varchar(100) null comment '组件路径',
    query       varchar(255) null comment '路由参数',
    is_frame    varchar(255) null comment '是否外链',
    menu_type   int          null comment '菜单类型;菜单类型（0目录 1菜单 2按钮）',
    status      int          null comment '状态',
    permission  varchar(100) null comment '权限标识',
    icon        varchar(255) null comment '图标',
    deleted     int          null comment '删除',
    tenant_id   varchar(32)  null comment '租户号',
    create_by   varchar(32)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(32)  null comment '更新人',
    update_time datetime     null comment '更新时间'
)
    comment '菜单表' row_format = DYNAMIC;

create table horizon_system.sys_post
(
    id          varchar(32)  null comment '主键',
    post_code   varchar(50)  null comment '岗位编码',
    post_name   varchar(50)  null comment '岗位名称',
    sort        int          null comment '排序',
    status      int          null comment '状态',
    remark      varchar(255) null comment '备注',
    deleted     int          null comment '删除',
    tenant_id   varchar(32)  null comment '租户号',
    create_by   varchar(32)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(32)  null comment '更新人',
    update_time datetime     null comment '更新时间'
)
    comment '岗位表' row_format = DYNAMIC;

create table horizon_system.sys_role
(
    id          varchar(32) null comment '主键',
    role_name   varchar(50) null comment '角色名',
    sort        int         null comment '排序',
    status      int         null comment '状态',
    deleted     int         null comment '删除',
    tenant_id   varchar(32) null comment '租户号',
    create_by   varchar(32) null comment '创建人',
    create_time datetime    null comment '创建时间',
    update_by   varchar(32) null comment '更新人',
    update_time datetime    null comment '更新时间'
)
    comment '角色表' row_format = DYNAMIC;

create table horizon_system.sys_role_menu
(
    id          varchar(32)  not null comment '主键'
        primary key,
    menu_id     varchar(32)  null comment '菜单id',
    role_id     varchar(32)  null comment '角色id',
    permission  varchar(100) null comment '权限标识',
    deleted     int          null comment '删除',
    tenant_id   varchar(32)  null comment '租户号',
    create_by   varchar(32)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(32)  null comment '更新人',
    update_time datetime     null comment '更新时间'
)
    comment '角色菜单关联表' row_format = DYNAMIC;

create table horizon_system.sys_user
(
    id                varchar(32)  not null comment '主键'
        primary key,
    user_name         varchar(50)  null comment '用户账号',
    user_display_name varchar(50)  null comment '用户昵称',
    dept_id           varchar(32)  null comment '部门id',
    email             varchar(100) null comment '用户邮箱',
    phone             varchar(20)  null comment '手机号码',
    sex               int          null comment '性别',
    password          varchar(255) null comment '用户密码',
    status            varchar(2)   null comment '状态',
    remark            varchar(255) null comment '备注',
    deleted           int          null comment '删除',
    tenant_id         varchar(32)  null comment '租户号',
    create_by         varchar(32)  null comment '创建人',
    create_time       datetime     null comment '创建时间',
    update_by         varchar(32)  null comment '更新人',
    update_time       datetime     null comment '更新时间'
)
    comment '用户表' row_format = DYNAMIC;

create table horizon_system.sys_user_role
(
    id          varchar(32) null comment '主键',
    user_id     varchar(32) null comment '用户id',
    role_id     varchar(32) null comment '角色id',
    deleted     int         null comment '删除',
    tenant_id   varchar(32) null comment '租户号',
    create_by   varchar(32) null comment '创建人',
    create_time datetime    null comment '创建时间',
    update_by   varchar(32) null comment '更新人',
    update_time datetime    null comment '更新时间'
)
    comment '用户角色关联表' row_format = DYNAMIC;

