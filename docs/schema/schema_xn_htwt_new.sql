
/*征信表*/
DROP TABLE IF EXISTS `tdq_credit`;
CREATE TABLE `tdq_credit` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `loanBankCode` varchar(32) DEFAULT NULL COMMENT '贷款银行编号',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `bizType` varchar(4) DEFAULT NULL COMMENT '业务种类',
  `secondCarReport` varchar(255) DEFAULT NULL COMMENT '二手车评估报告',
  `xsz_front` varchar(255) DEFAULT NULL COMMENT '行驶证正面',
  `xsz_reverse` varchar(255) DEFAULT NULL COMMENT '行驶证反面',
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司',
  `saleUserId` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `curNodeCode` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*征信人员表*/
DROP TABLE IF EXISTS `tdq_credit_user`;
CREATE TABLE `tdq_credit_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信业务编号',
  `userName` varchar(255) DEFAULT NULL COMMENT '姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与借款人关系',
  `loanRole` varchar(255) DEFAULT NULL COMMENT '贷款角色',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `id_no_front` varchar(255) DEFAULT NULL COMMENT '身份证正面',
  `id_no_reverse` varchar(255) DEFAULT NULL COMMENT '身份证反面',
  `auth_pdf` varchar(255) DEFAULT NULL COMMENT '征信查询授权书',
  `interview_pic` varchar(255) DEFAULT NULL COMMENT '面签照片',
  `bankCreditResultPdf` varchar(4) DEFAULT NULL COMMENT '银行征信结果',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*收款账号表*/
CREATE TABLE `tb_collect_account` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `type` VARCHAR(4) NULL COMMENT '类型',
  `company_code` VARCHAR(32) NULL COMMENT '公司编号',
  `account_name` VARCHAR(255) NULL COMMENT '户名',
  `account_number` VARCHAR(32) NULL COMMENT '账号',
  `open_bank` VARCHAR(255) NULL COMMENT '开户行',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '收款账号表';

/*身份证区域表*/
CREATE TABLE `tb_id_no_area` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `area_no` VARCHAR(32) NULL COMMENT '身份证区域号',
  `area_name` VARCHAR(255) NULL COMMENT '身份证区域名称',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_estonian_ci
COMMENT = '身份证区域表';

/*经销商信息表*/
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
  `approve_note` VARCHAR(255) NULL COMMENT '审核说明',
  `status` VARCHAR(4) NULL COMMENT '办理状态',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '经销商信息表';

/*银行信息表*/
CREATE TABLE `tb_bank` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `bank_name` VARCHAR(255) NULL COMMENT '银行名称',
  `rate12` DECIMAL NULL COMMENT '12期',
  `rate18` DECIMAL NULL COMMENT '18期',
  `rate24` DECIMAL NULL COMMENT '24期',
  `rate36` DECIMAL NULL COMMENT '36期',
  `branch_abbr_name` VARCHAR(255) NULL COMMENT '支行简称',
  `branch_full_name` VARCHAR(255) NULL COMMENT '支行全称',
  `open_bank` VARCHAR(255) NULL COMMENT '开户行',
  `address` VARCHAR(255) NULL COMMENT '银行地址',
  `phone_number` INT(11) NULL COMMENT '电话号码',
  `post_code` INT(11) NULL COMMENT '邮编',
  ` bank_client` VARCHAR(255) NULL COMMENT '银行委托人',
  `client_valid_date` DATETIME NULL COMMENT '委托有效期',
  `auther_name` VARCHAR(255) NULL COMMENT '授权人姓名',
  `auther_phone_number` INT(11) NULL COMMENT '授权人电话',
  `auther_id_no` VARCHAR(255) NULL COMMENT '授权人身份证',
  `auther_address` VARCHAR(255) NULL COMMENT '授权人地址',
  ` credit_card_type` VARCHAR(4) NULL COMMENT '信用卡类型',
  `credit_card_name` VARCHAR(255) NULL COMMENT '信用卡名称',
  `belong_area` VARCHAR(255) NULL COMMENT '所属地区',
  `bank_mark` VARCHAR(255) NULL COMMENT '总行/支行标识',
  `belong_header_code` VARCHAR(32) NULL COMMENT '所属总行编号',
  `status` VARCHAR(4) NULL COMMENT '状态',
  `updater` VARCHAR(255) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '银行信息表';

/*银行利率明细表*/
CREATE TABLE `tb_bank_rate` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `bank_code` VARCHAR(32) NULL COMMENT '银行编号',
  `period` INT(11) NULL COMMENT '期数',
  `rate` DECIMAL NULL COMMENT '利率',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '银行利率明细表';

/*保险公司信息表*/
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

/*省份编号表*/
CREATE TABLE `tb_province_no` (
  `no` VARCHAR(32) NOT NULL COMMENT '编号',
  `name` VARCHAR(255) NULL COMMENT '名称',
  PRIMARY KEY (`no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '省份编号表';
