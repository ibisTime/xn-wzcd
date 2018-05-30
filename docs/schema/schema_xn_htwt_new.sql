
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

CREATE TABLE `tdq_budget_order` (
`code` varchar(32) DEFAULT NULL COMMENT '编号',
`loan_product_code` varchar(32) DEFAULT NULL COMMENT '贷款产品编号',
`loan_product_name` varchar(255) DEFAULT NULL COMMENT '产品名称',
`loan_bank` varchar(255) DEFAULT NULL COMMENT '贷款银行',
`gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS费用',
`auth_fee` bigint(20) DEFAULT NULL COMMENT '公证费',
`fee` bigint(20) DEFAULT NULL COMMENT '服务费',
`month_rate` decimal(18,8) DEFAULT NULL COMMENT '月供利率(%)',
`credit_code` varchar(32) DEFAULT NULL COMMENT '征信单编号',
`biz_type` varchar(255) DEFAULT NULL COMMENT '业务种类',
`loan_period` varchar(255) DEFAULT NULL COMMENT '贷款期限',
`invoice_company` varchar(255) DEFAULT NULL COMMENT '开票单位',
`car_brand` varchar(255) DEFAULT NULL COMMENT '品牌',
`original_price` bigint(20) DEFAULT NULL COMMENT '市场指导价',
`invoice_price` bigint(20) DEFAULT NULL COMMENT '开票价',
`car_color` varchar(255) DEFAULT NULL COMMENT '颜色',
`month_deposit` bigint(20) DEFAULT NULL COMMENT '月供保证金',
`first_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
`first_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
`loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款额',
`settle_address` varchar(255) DEFAULT NULL COMMENT '落户地点',
`apply_user_name` varchar(255) DEFAULT NULL COMMENT '申请人姓名',
`gender` varchar(255) DEFAULT NULL COMMENT '性别',
`marry_state` varchar(255) DEFAULT NULL COMMENT '婚姻状况',
`nation` varchar(255) DEFAULT NULL COMMENT '民族',
`education` varchar(255) DEFAULT NULL COMMENT '学历',
`id_no` varchar(255) DEFAULT NULL COMMENT '身份证号',
`family_number` varchar(255) DEFAULT NULL COMMENT '家庭人口',
`mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
`now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
`post_code1` varchar(255) DEFAULT NULL COMMENT '邮编1',
`residence_address` varchar(255) DEFAULT NULL COMMENT '户口所在地',
`post_code2` varchar(255) DEFAULT NULL COMMENT '邮编2',
`family_main_asset` varchar(255) DEFAULT NULL COMMENT '家庭主要财产',
`main_asset_include` varchar(255) DEFAULT NULL COMMENT '主要财产包括',
`main_income` varchar(255) DEFAULT NULL COMMENT '主要收入来源',
`work_company_name` varchar(255) DEFAULT NULL COMMENT '工作单位名称',
`work_company_address` varchar(255) DEFAULT NULL COMMENT '工作单位地址',
`self_company_area` varchar(255) DEFAULT NULL COMMENT '自营公司单位面积',
`employee_quantity` varchar(255) DEFAULT NULL COMMENT '员工数量',
`enterprise_month_output` varchar(255) DEFAULT NULL COMMENT '企业月产值',
`position` varchar(255) DEFAULT NULL COMMENT '职位',
`post_title` varchar(255) DEFAULT NULL COMMENT '职称',
`month_income` varchar(255) DEFAULT NULL COMMENT '月收入',
`mate_name` varchar(255) DEFAULT NULL COMMENT '配偶姓名',
`mate_mobile` varchar(255) DEFAULT NULL COMMENT '配偶手机号',
`mate_id_no` varchar(255) DEFAULT NULL COMMENT '配偶身份证号',
`mate_education` varchar(255) DEFAULT NULL COMMENT '配偶学历',
`mate_company_name` varchar(255) DEFAULT NULL COMMENT '配偶工作单位名称',
`mate_company_address` varchar(255) DEFAULT NULL COMMENT '配偶工作单位地址',
`mate_company_contact_no` varchar(255) DEFAULT NULL COMMENT '配偶工作单位联系电话',
`gua_name` varchar(255) DEFAULT NULL COMMENT '担保人姓名',
`gua_mobile` varchar(255) DEFAULT NULL COMMENT '担保人手机号',
`gua_id_no` varchar(255) DEFAULT NULL COMMENT '担保人身份证号',
`gua_phone` varchar(255) DEFAULT NULL COMMENT '担保人固定电话',
`gua_company_name` varchar(255) DEFAULT NULL COMMENT '担保人工作单位名称',
`gua_company_address` varchar(255) DEFAULT NULL COMMENT '担保人工作单位地址',
`gua_house_asset_address` varchar(255) DEFAULT NULL COMMENT '担保人房产地址',
`emergency_name1` varchar(255) DEFAULT NULL COMMENT '家庭紧急联系人信息1 姓名',
`emergency_relation1` varchar(255) DEFAULT NULL COMMENT '家庭紧急联系人信息1 与申请人关系',
`emergency_mobile1` varchar(255) DEFAULT NULL COMMENT '家庭紧急联系人信息1 手机号码',
`emergency_name2` varchar(255) DEFAULT NULL COMMENT '家庭紧急联系人信息2 姓名',
`emergency_relation2` varchar(255) DEFAULT NULL COMMENT '家庭紧急联系人信息2 与申请人关系',
`emergency_mobile2` varchar(255) DEFAULT NULL COMMENT '家庭紧急联系人信息2 手机号码',
`jour_datetime_start` DATETIME DEFAULT NULL COMMENT '流水时间起',
`jour_datetime_end` DATETIME DEFAULT NULL COMMENT '流水时间止',
`jour_income` bigint(20) DEFAULT NULL COMMENT '收入',
`jour_expend` bigint(20) DEFAULT NULL COMMENT '支出',
`jour_balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
`jour_month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
`jour_month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
`jour_remark` varchar(255) DEFAULT NULL COMMENT '备注',
`house_contract` varchar(255) DEFAULT NULL COMMENT '购房合同',
`house_picture` varchar(255) DEFAULT NULL COMMENT '房屋照片',
`is_advance_fund` varchar(255) DEFAULT NULL COMMENT '是否垫资',
`interview_video` varchar(255) DEFAULT NULL COMMENT '面签视频',
`interview_contract` varchar(255) DEFAULT NULL COMMENT '面签合同',
`advance_fund_datetime` DATETIME DEFAULT NULL COMMENT '垫资日期',
`advance_fund_amount` bigint(20) DEFAULT NULL COMMENT '垫资金额',
`bill_pdf` varchar(255) DEFAULT NULL COMMENT '水单',
`car_settle_datetime` DATETIME DEFAULT NULL COMMENT '车辆落户日期',
`car_number` varchar(255) DEFAULT NULL COMMENT '车牌号',
`car_invoice` varchar(255) DEFAULT NULL COMMENT '发票',
`car_hgz` varchar(255) DEFAULT NULL COMMENT '合格证',
`car_jqx` varchar(255) DEFAULT NULL COMMENT '交强险',
`car_syx` varchar(255) DEFAULT NULL COMMENT '商业险',
`car_regcerti` varchar(255) DEFAULT NULL COMMENT '登记证书',
`car_pd` varchar(255) DEFAULT NULL COMMENT '车辆批单',
`car_key` varchar(255) DEFAULT NULL COMMENT '车钥匙',
`car_big_smj` varchar(255) DEFAULT NULL COMMENT '大本扫描件',
`bank_commit_datetime` DATETIME DEFAULT NULL COMMENT '银行提交时间',
`bank_commit_note` varchar(255) DEFAULT NULL COMMENT '银行提交说明',
`bankLoan_datetime` DATETIME DEFAULT NULL COMMENT '银行放款时间',
`receipt_bank_code` varchar(255) DEFAULT NULL COMMENT '收款银行',
`receipt_bank_name` varchar(255) DEFAULT NULL COMMENT '收款银行名称',
`receipt_bankcard_number` varchar(255) DEFAULT NULL COMMENT '收款银行卡号',
`receipt_pdf` varchar(255) DEFAULT NULL COMMENT '收款凭证',
`receipt_remark` varchar(255) DEFAULT NULL COMMENT '收款备注',
`pledge_datetime` DATETIME DEFAULT NULL COMMENT '抵押日期',
`green_big_smj` varchar(255) DEFAULT NULL COMMENT '绿大本扫描件',
`pledge_bank_commit_datetime` DATETIME DEFAULT NULL COMMENT '抵押提交银行时间',
`pledge_bank_commit_note` varchar(255) DEFAULT NULL COMMENT '抵押提交说明',
`enter_location` varchar(255) DEFAULT NULL COMMENT '入档位置',
`sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员',
`company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
`apply_datetime` DATETIME DEFAULT NULL COMMENT '申请时间',
`cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
`remark` varchar(32) DEFAULT NULL COMMENT '备注',
PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '预算单';


