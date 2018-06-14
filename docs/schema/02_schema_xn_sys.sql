-- ----------------------------
--  Table structure for `tsys_biz_log`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_biz_log`;
CREATE TABLE `tsys_biz_log` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `parent_order` varchar(32) NOT NULL COMMENT '上级订单编号',
  `ref_type` varchar(32) NOT NULL COMMENT '关联订单类型',
  `ref_order` varchar(32) NOT NULL COMMENT '关联订单编号',
  `deal_node` varchar(32) NOT NULL COMMENT '处理节点',
  `deal_note` varchar(255) DEFAULT NULL COMMENT '处理说明',
  `status` varchar(32) NOT NULL COMMENT '状态(0 待处理 1 已完成)',
  `operate_role` varchar(32) NOT NULL COMMENT '操作角色',
  `operator` varchar(32) NOT NULL COMMENT '操作人',
  `operator_name` varchar(32) DEFAULT NULL COMMENT '操作人姓名',
  `operator_mobile` varchar(32) DEFAULT NULL COMMENT '操作人手机号',
  `start_datetime` datetime NOT NULL COMMENT '操作开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '操作结束时间',
  `speed_time` varchar(255) DEFAULT NULL COMMENT '花费时间(单位：秒)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务日志跟踪表';

-- ----------------------------
--  Table structure for `tsys_biz_team`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_biz_team`;
CREATE TABLE `tsys_biz_team` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '团队名称',
  `captain` varchar(32) DEFAULT NULL COMMENT '团队长',
  `company_code` varchar(32) DEFAULT NULL COMMENT '所属公司编号',
  `status` char(1) DEFAULT NULL COMMENT '状态（1正常0删除）',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `account_no` varchar(32) DEFAULT NULL COMMENT '收款账号',
  `bank` varchar(255) DEFAULT NULL COMMENT '收款银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '收款支行',
  `water_bill` varchar(255) DEFAULT NULL COMMENT '水单',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务团队';

-- ----------------------------
--  Table structure for `tsys_config`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_config`;
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

-- ----------------------------
--  Table structure for `tsys_department`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_department`;
CREATE TABLE `tsys_department` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型(1=子公司，2=部门，3=岗位)',
  `lead_name` varchar(255) DEFAULT NULL COMMENT '负责人',
  `mobile` varchar(16) DEFAULT NULL COMMENT '负责人手机号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '上级部门编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
--  Table structure for `tsys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_dict`;
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

-- ----------------------------
--  Table structure for `tsys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_menu`;
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

-- ----------------------------
--  Table structure for `tsys_menu_role`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_menu_role`;
CREATE TABLE `tsys_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(96) DEFAULT NULL,
  `menu_code` varchar(96) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_node`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_node`;
CREATE TABLE `tsys_node` (
  `code` varchar(32) NOT NULL COMMENT '节点编号',
  `name` varchar(255) DEFAULT NULL COMMENT '节点名称',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='流程';

-- ----------------------------
--  Table structure for `tsys_node_flow`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_node_flow`;
CREATE TABLE `tsys_node_flow` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `current_node` varchar(32) NOT NULL COMMENT '当前节点',
  `next_node` varchar(32) DEFAULT NULL COMMENT '下一个节点',
  `back_node` varchar(32) DEFAULT NULL COMMENT '返回节点',
  `file_list` text,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节点流程配置';

-- ----------------------------
--  Table structure for `tsys_role`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role`;
CREATE TABLE `tsys_role` (
  `code` varchar(96) DEFAULT NULL,
  `name` varchar(96) DEFAULT NULL,
  `level` varchar(6) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_role_node`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role_node`;
CREATE TABLE `tsys_role_node` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色节点';

-- ----------------------------
--  Table structure for `tsys_user`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_user`;
CREATE TABLE `tsys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `real_name` varchar(255) DEFAULT NULL,
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` char(1) DEFAULT NULL COMMENT '登录密码强度',
  `create_datetme` datetime DEFAULT NULL COMMENT '注册时间',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `company_code` varchar(32) DEFAULT NULL,
  `department_code` varchar(32) DEFAULT NULL,
  `post_code` varchar(32) DEFAULT NULL,
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` text COMMENT '备注',
  `team_code` varchar(32) DEFAULT NULL COMMENT '所属业务团队编号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
