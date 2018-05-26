/*收款账号表(确定)*/
CREATE TABLE `tb_collect_bankcard` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `type` VARCHAR(4) NULL COMMENT '类型',
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

/*身份证区域表(确定)*/
CREATE TABLE `tb_id_no_area` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `area_no` VARCHAR(32) NULL COMMENT '身份证区域号',
  `area_name` VARCHAR(255) NULL COMMENT '身份证区域名称',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '身份证区域表';

/*省份编号表(确定)*/
CREATE TABLE `tb_province_no` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `province_no` VARCHAR(32) NOT NULL COMMENT '省份编号',
  `name` VARCHAR(255) NULL COMMENT '名称',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '省份编号表';

/*银行信息表(确定)*/
CREATE TABLE `tb_bank` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `bank_name` VARCHAR(255) NULL COMMENT '银行名称',
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
COMMENT = '银行信息表';

/*银行利率明细表(确定)*/
CREATE TABLE `tb_bank_rate` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `bank_code` VARCHAR(32) NULL COMMENT '银行编号',
  `period` INT(11) NULL COMMENT '期数',
  `rate` DECIMAL(18,8) NULL COMMENT '利率',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '银行利率明细表';

/*支行信息表(确定)*/
CREATE TABLE `tb_bank_subbranch` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `bank_code` VARCHAR(255) NULL COMMENT '银行编号',
  `abbr_name` VARCHAR(255) NULL COMMENT '简称',
  `full_name` VARCHAR(255) NULL COMMENT '全称',
  `open_bank` VARCHAR(255) NULL COMMENT '开户行',
  `address` VARCHAR(255) NULL COMMENT '银行地址',
  `phone_number` INT(11) NULL COMMENT '电话号码',
  `post_code` INT(11) NULL COMMENT '邮编',
  `bank_client` VARCHAR(255) NULL COMMENT '银行委托人',
  `client_valid_date` DATETIME NULL COMMENT '委托有效期',
  `auther_name` VARCHAR(255) NULL COMMENT '授权人姓名',
  `auther_phone_number` INT(11) NULL COMMENT '授权人电话',
  `auther_id_no` VARCHAR(255) NULL COMMENT '授权人身份证',
  `auther_address` VARCHAR(255) NULL COMMENT '授权人地址',
  `credit_card_type` VARCHAR(4) NULL COMMENT '信用卡类型',
  `credit_card_name` VARCHAR(255) NULL COMMENT '信用卡名称',
  `belong_area` VARCHAR(255) NULL COMMENT '所属地区',
  `updater` VARCHAR(255) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '银行支行信息表';

/*经销商信息表(确定)*/
CREATE TABLE `tb_car_dealer` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `full_name` VARCHAR(255) NULL COMMENT '全称',
  `abbr_name` VARCHAR(255) NULL COMMENT '简称',
  `is_self_develop` VARCHAR(1) NULL COMMENT '是否自主开发',
  `address` VARCHAR(255) NULL COMMENT '地址',
  `car_dealer_type` VARCHAR(4) NULL COMMENT '车行经营性质',
  `main_contact` VARCHAR(255) NULL COMMENT '主要联系人',
  `contact_phone` INT(11) NULL COMMENT '联系人电话',
  `main_brand` VARCHAR(255) NULL COMMENT '主营品牌',
  `parent_group` VARCHAR(255) NULL COMMENT '所属集团',
  `agreement` VARCHAR(255) NULL COMMENT '协议',
  `agreement_valid_date` DATETIME NULL COMMENT '合作协议有效期',
  `agreement_status` VARCHAR(4) NULL COMMENT '协议状态',
  `agreement_pic` VARCHAR(255) NULL COMMENT '车商合作协议',
  `settle_way` VARCHAR(255) NULL COMMENT '结算方式',
  `business_area` VARCHAR(255) NULL COMMENT '业务区域',
  `belong_branch_company` VARCHAR(255) NULL COMMENT '归属分公司',
  `cur_node_code` VARCHAR(32) NULL COMMENT '当前节点编号',
  `approve_note` VARCHAR(255) NULL COMMENT '审核说明',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '经销商信息表';

/*经销商协议表(确定)*/
CREATE TABLE `tb_car_dealer_protocol` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `car_dealer_code` VARCHAR(32) NULL COMMENT '经销商编号',
  `bank_code` VARCHAR(32) NULL COMMENT '银行编号',
  `plat_ct_rate12` DECIMAL(18,8) NULL COMMENT '我司12期基准利率',
  `plat_ct_rate24` DECIMAL(18,8) NULL COMMENT '我司24期基准利率',
  
  `plat_ct_rate36` DECIMAL(18,8) NULL COMMENT '我司36期基准利率',
  `plat_zk_rate12` DECIMAL(18,8) NULL COMMENT '我司12期基准利率',
  `plat_zk_rate24` DECIMAL(18,8) NULL COMMENT '我司24期基准利率',
  `plat_zk_rate36` DECIMAL(18,8) NULL COMMENT '我司36期基准利率',
  `assure_type` VARCHAR(32) NULL COMMENT '担保费类型(1单笔/2贷款额百分比)',
  
  `assure_fee` bigint(20) NULL COMMENT '单笔担保费',
  `assure_rate` DECIMAL(18,8) NULL COMMENT '担保费贷款额百分比',
  `dz_type` VARCHAR(32) NULL COMMENT '垫资费类型(1单笔/2贷款额百分比)',
  `dz_fee` bigint(20) NULL COMMENT '单笔垫资费',
  `dz_rate` DECIMAL(18,8) NULL COMMENT '垫资费贷款额百分比',

  `ly_amount_type` VARCHAR(32) NULL COMMENT '履约保证金类型(1单笔/2贷款额百分比)',
  `ly_amount_fee` bigint(20) NULL COMMENT '单笔履约保证金',
  `ly_amount_rate` DECIMAL(18,8) NULL COMMENT '履约保证金贷款额百分比',
  `gps_type` VARCHAR(32) NULL COMMENT 'GPS类型(1单笔/2贷款额百分比)',
  `gps_fee` bigint(20) NULL COMMENT '单笔GPS费',
  `gps_rate` DECIMAL(18,8) NULL COMMENT 'GPS垫资费贷款额百分比',

  `other_type` VARCHAR(32) NULL COMMENT '杂费类型(1单笔/2贷款额百分比)',
  `other_fee` bigint(20) NULL COMMENT '单笔杂费',
  `other_rate` DECIMAL(18,8) NULL COMMENT '杂费贷款额百分比',
  `introduce_type` VARCHAR(32) NULL COMMENT '介绍费类型(1单笔/2贷款额百分比)',
  `introduce_fee` bigint(20) NULL COMMENT '单笔介绍费',
  `introduce_rate` DECIMAL(18,8) NULL COMMENT '介绍费贷款额百分比',

  `return_point_type` VARCHAR(32) NULL COMMENT '返点类型(1单笔/2贷款额百分比)',
  `return_point_fee` bigint(20) NULL COMMENT '单笔返点',
  `return_point_rate` DECIMAL(18,8) NULL COMMENT '返点贷款额百分比',
  `is_dz` VARCHAR(32) NULL COMMENT '是否垫资(1 是 0 否)',
  
  `insu_agency_year1_type` VARCHAR(32) NULL COMMENT '1年保险代理费类型(1平台/2车行)',
  `insu_agency_year1_fee` bigint(20) NULL COMMENT '1年保险代理费',
  `insu_agency_year2_type` VARCHAR(32) NULL COMMENT '2年保险代理费类型(1平台/2车行)',
  `insu_agency_year2_fee` bigint(20) NULL COMMENT '2年保险代理费',
  `insu_agency_year3_type` VARCHAR(32) NULL COMMENT '3年保险代理费类型(1平台/2车行)',
  
  `insu_agency_year3_fee` bigint(20) NULL COMMENT '3年保险代理费',
  `policy_note` text NULL COMMENT '政策说明',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '经销商协议表';

/*保险公司信息表(确定)*/
DROP TABLE IF EXISTS `tb_insurance_company`;
CREATE TABLE `tb_insurance_company` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `name` VARCHAR(255) NULL COMMENT '名称',
  `contact` VARCHAR(255) NULL COMMENT '联系人',
  `mobile` INT(11) NULL COMMENT '联系电话',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '保险公司信息表';

/*GPS库存管理(确定)*/
DROP TABLE IF EXISTS `tb_gps`;
CREATE TABLE `tb_gps` (
  `code` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `gps_no` VARCHAR(32) NOT NULL COMMENT 'gps编号',
  `gps_type` VARCHAR(32) NOT NULL COMMENT 'gps类型( 1 有线 0 无线)',
  `company_code` VARCHAR(32) NULL COMMENT '公司编号',
  `apply_user` VARCHAR(32) NULL COMMENT '申请人',
  `apply_status` VARCHAR(32) NULL COMMENT '申请状态',
  `apply_datetime` DATETIME NULL COMMENT '申请日期',
  
  `use_status` VARCHAR(32) NULL COMMENT '使用状态',
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
  `status` VARCHAR(32) NULL COMMENT '状态(1 0 待审核 1 审核通过,待发货 2 审核不通过 3 已发货,待收货 4 已收货)',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'gps申领管理';