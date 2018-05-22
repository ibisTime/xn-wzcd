/*系统*/
CREATE TABLE `tsys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` char(1) DEFAULT NULL COMMENT '登录密码强度',
  `create_datetme` datetime DEFAULT NULL COMMENT '注册时间',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tsys_menu` (
  `code` varchar(96) DEFAULT NULL,
  `name` varchar(96) DEFAULT NULL,
  `type` varchar(6) DEFAULT NULL,
  `url` varchar(192) DEFAULT NULL,
  `order_no` varchar(24) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `parent_code` varchar(96) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tsys_role` (
  `code` varchar(96) DEFAULT NULL,
  `name` varchar(96) DEFAULT NULL,
  `level` varchar(6) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tsys_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(96) DEFAULT NULL,
  `menu_code` varchar(96) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(96) DEFAULT NULL,
  `ckey` varchar(765) DEFAULT NULL,
  `cvalue` text,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `company_code` varchar(96) DEFAULT NULL,
  `system_code` varchar(96) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` char(3) DEFAULT NULL,
  `parent_key` varchar(96) DEFAULT NULL,
  `dkey` varchar(96) DEFAULT NULL,
  `dvalue` varchar(765) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  `company_code` varchar(96) DEFAULT NULL,
  `system_code` varchar(96) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tstd_cnavigate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `url` varchar(255) DEFAULT NULL COMMENT '访问Url',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 显示 0 不显示)',
  `location` varchar(32) DEFAULT NULL COMMENT '位置',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `belong` varchar(32) DEFAULT NULL COMMENT '属于(1 全局 2 地方默认 3 地方默认编号)',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `content_type` varchar(32) DEFAULT NULL COMMENT '内容源类型',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*部门表*/
CREATE TABLE `tsys_department` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `name` VARCHAR(255) NULL COMMENT '部门名称',
  `lead_name` VARCHAR(255) NULL COMMENT '负责人',
  `mobile` INT(11) NULL COMMENT '负责人手机号',
  `parent_code` VARCHAR(32) NULL COMMENT '上级部门编号',
  `status` VARCHAR(4) NULL COMMENT '状态',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '部门表';

/*节点表*/
DROP TABLE IF EXISTS `tsys_node`;
CREATE TABLE `tsys_node` (
    `code` VARCHAR(32) NOT NULL COMMENT '节点编号',
    `name` VARCHAR(255) DEFAULT NULL COMMENT '节点名称',
    `type` VARCHAR(4) DEFAULT NULL COMMENT '类型',
    `next_node` VARCHAR(32) DEFAULT NULL COMMENT '下一个节点',
    `back_node` VARCHAR(32) DEFAULT NULL COMMENT '返回节点',
    `remark` VARCHAR(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`code`) COMMENT '节点'
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

/*角色节点表*/
DROP TABLE IF EXISTS `tsys_role_node`;
CREATE TABLE `tsys_role_node` (
    `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
    `role_code` VARCHAR(32) DEFAULT NULL COMMENT '角色编号',
	`node_code` VARCHAR(32) DEFAULT NULL COMMENT '节点编号',
    PRIMARY KEY (`id`) COMMENT '角色节点'
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

/*业务日志跟踪表*/
DROP TABLE IF EXISTS `tsys_biz_log`;
CREATE TABLE `tsys_biz_log` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `parent_order` varchar(32) NOT NULL COMMENT '上级订单编号',
  `ref_type` varchar(32) NOT NULL COMMENT '关联订单类型',
  `ref_order` varchar(32) NOT NULL COMMENT '关联订单编号',
  `start_node` varchar(32) NOT NULL COMMENT '开始节点',

  `end_node` varchar(32) NULL COMMENT '下个节点(处理完后记录)',
  `status` varchar(32) NOT NULL COMMENT '状态(0 待处理 1 已完成)',
  `operate_role` varchar(32) NOT NULL COMMENT '操作角色',
  `operator` varchar(32) NOT NULL COMMENT '操作人',
  `operater_name` varchar(32) NULL COMMENT '操作人姓名',
  
  `operator_mobile` varchar(32) NULL COMMENT '操作人手机号',
  `start_datetime` datetime NOT NULL COMMENT '操作开始时间',
  `start_datetime` datetime  NULL COMMENT '操作结束时间',
  `speed_time` int(11) NULL COMMENT '花费时间(单位：秒)',
  PRIMARY KEY (`id`) COMMENT '业务日志跟踪表'
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;
