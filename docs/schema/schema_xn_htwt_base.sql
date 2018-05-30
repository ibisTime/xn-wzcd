/*收款账号表(确定)*/
DROP TABLE IF EXISTS `tb_collect_bankcard`;
CREATE TABLE `tb_collect_bankcard` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `type` VARCHAR(4) NULL COMMENT '类型(1 普通账户 2 经销商的收款账号 3 经销商返点账号)',
  `company_code` VARCHAR(32) NULL COMMENT '公司编号',
  `real_name` VARCHAR(255) NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` VARCHAR(255) NULL COMMENT '账号',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '收款账号表';

/*平台银行信息表(确定)*/
DROP TABLE IF EXISTS `tb_bank`;
CREATE TABLE `tb_bank` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `bank_code` VARCHAR(32) NULL COMMENT '银行编号',
  `bank_name` VARCHAR(255) NULL COMMENT '银行名称',
  `subbranch` VARCHAR(255) NULL COMMENT '支行名称',
  `rate12` DECIMAL NULL COMMENT '12期',
  `rate18` DECIMAL NULL COMMENT '18期',
  `rate24` DECIMAL NULL COMMENT '24期',
  `rate36` DECIMAL NULL COMMENT '36期',
  `status` VARCHAR(4) NULL COMMENT '状态(0 已下架 1 已上架)',
  `updater` VARCHAR(255) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '平台银行信息表';

/*GPS库存管理(确定)*/
DROP TABLE IF EXISTS `tb_gps`;
CREATE TABLE `tb_gps` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `gps_dev_no` VARCHAR(32) NOT NULL COMMENT 'gps编号',
  `gps_type` VARCHAR(32) NOT NULL COMMENT 'gps类型( 1 有线 0 无线)',
  
  `company_code` VARCHAR(32) NULL COMMENT '公司编号',
  `apply_user` VARCHAR(32) NULL COMMENT '申领人',
  `apply_status` VARCHAR(32) NULL COMMENT '申领状态(0 待申领 1 已申领)',
  `apply_datetime` DATETIME NULL COMMENT '申领日期',
  `apply_code` VARCHAR(32) NULL COMMENT '申领编号',
  
  `use_status` VARCHAR(32) NULL COMMENT '使用状态(0 待使用 1 已使用)',
  `use_datetime` DATETIME NULL COMMENT '使用日期',
  `biz_code` VARCHAR(32) NULL COMMENT '业务编号',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'gps库存管理';

/*GPS申领管理(确定)*/
DROP TABLE IF EXISTS `tb_gps_apply`;
CREATE TABLE `tb_gps_apply` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `type` VARCHAR(32) NOT NULL COMMENT '类型(1 公司 2 个人)',
  `company_code` VARCHAR(32) NULL COMMENT '公司编号',
  `apply_user` VARCHAR(32) NULL COMMENT '申请人',
  `apply_datetime` DATETIME NULL COMMENT '申请日期',
  
  `apply_count` int(11) NULL COMMENT '申请个数',
  `send_datetime` DATETIME NULL COMMENT '发货日期',
  `receive_datetime` DATETIME NULL COMMENT '收货日期',
  `status` VARCHAR(32) NULL COMMENT '状态(0 待审核 1 审核通过,待发货 2 审核不通过 3 已发货,待收货 4 已收货)',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'gps申领管理';
