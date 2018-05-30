/*资料传递*/
DROP TABLE IF EXISTS `tdq_logistics`;
CREATE TABLE `tdq_logistics` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 贷前)',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `biz_node_code` varchar(255) DEFAULT NULL COMMENT '业务节点',
  `ref_file_list` varchar(255) DEFAULT NULL COMMENT '参考材料清单(逗号隔开)',
  `send_file_list` varchar(255) DEFAULT NULL COMMENT '寄送材料清单(逗号隔开)',
  `send_type` varchar(4) DEFAULT NULL COMMENT '寄送方式(1 线下 2 快递)',
  `logistics_company` varchar(32) DEFAULT NULL COMMENT '快递公司',
  `logistics_code` varchar(255) DEFAULT NULL COMMENT '快递单号',
  `send_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `send_note` varchar(255) DEFAULT NULL COMMENT '发货说明',
  `receipt_datetime` datetime DEFAULT NULL COMMENT '收件时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待发件 1已发件待收件 2已收件审核 3已收件待补件)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*贷款产品*/
DROP TABLE IF EXISTS `tdq_loan_product`;
CREATE TABLE `tdq_loan_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `loan_bank` varchar(255) DEFAULT NULL COMMENT '贷款银行',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS费用',
  `auth_fee` bigint(20) DEFAULT NULL COMMENT '公证费',
  
  `fee` bigint(20) DEFAULT NULL COMMENT '服务费',
  `month_rate` decimal(18,8) DEFAULT NULL COMMENT '月供利率',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0 待上架 1已上架 2已下架)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*GPS 安装*/
DROP TABLE IF EXISTS `tdq_budget_order_gps`;
CREATE TABLE `tdq_budget_order_gps` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `gps_dev_no` varchar(32) DEFAULT NULL COMMENT 'gps设备号',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'gps类型',
  `az_location` varchar(32) DEFAULT NULL COMMENT '安装位置',
  `az_datetime` datetime DEFAULT NULL COMMENT '安装时间',
  `az_user` varchar(255) DEFAULT NULL COMMENT '安装人员',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `budget_order` varchar(32) NOT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*手续费汇总 准入审核通过产生*/
DROP TABLE IF EXISTS `tdq_budget_order_fee`;
CREATE TABLE `tdq_budget_order_fee` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `should_amount` bigint(20) DEFAULT NULL COMMENT '应收手续费总额',
  `real_amount` bigint(20) DEFAULT NULL COMMENT '实收手续费总额',
  
  `is_settled` varchar(32) DEFAULT NULL COMMENT '是否已结清(0 待结清 1 已结清)',  
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',  
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  `budget_order` varchar(32) NOT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*手续费明细*/
DROP TABLE IF EXISTS `tdq_budget_order_fee_detail`;
CREATE TABLE `tdq_budget_order_fee_detail` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `remit_type` varchar(32) NOT NULL COMMENT '交款类型',
  `remit_company_code` varchar(32) DEFAULT NULL COMMENT '交款业务公司编号',
  `remit_project` varchar(255) DEFAULT NULL COMMENT '交款项目',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  
  `plat_bankcard` varchar(255) DEFAULT NULL COMMENT '平台账户',
  `remit_user` varchar(255) DEFAULT NULL COMMENT '汇款人',
  `reach_datetime` datetime DEFAULT NULL COMMENT '到账时间',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;