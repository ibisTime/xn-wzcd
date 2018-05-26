
/*请款预算单*/
DROP TABLE IF EXISTS `tdq_req_budget`;
CREATE TABLE `tdq_req_budget` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `receipt_bank` varchar(255) DEFAULT NULL COMMENT '收款银行',
  `receipt_account` varchar(255) DEFAULT NULL COMMENT '收款账号',
  `budget_amount` bigint(20) DEFAULT NULL COMMENT '预算金额',
  
  `use_datetime` datetime DEFAULT NULL COMMENT '用款日期',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `finance_check_note` text COMMENT '财务审核说明',
  `pay_amount` bigint(255) DEFAULT NULL COMMENT '打款金额',
  
  `pay_bank` varchar(255) DEFAULT NULL COMMENT '打款银行',
  `pay_account` varchar(255) DEFAULT NULL COMMENT '打款账号',
  `water_bill` varchar(255) DEFAULT NULL COMMENT '水单',
  `pay_datetime` datetime DEFAULT NULL COMMENT '打款时间',
  `pay_remark` text COMMENT '打款备注',
  
  `dz_amount` varchar(255) DEFAULT NULL COMMENT '垫资总额',
  `dz_datetime` datetime DEFAULT NULL COMMENT '垫资日期',
  `collection_bank` varchar(255) DEFAULT NULL COMMENT '收回款银行',
  `collection_amount` bigint(20) DEFAULT NULL COMMENT '收回款金额',
  `collection_account` varchar(255) DEFAULT NULL COMMENT '收回款账号',
  
  `collection_datetime` datetime DEFAULT NULL COMMENT '收回款日期',
  `collection_remark` text COMMENT '收回款备注',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  PRIMARY KEY (`code`) COMMENT '请款预算单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*预算单表*/
DROP TABLE IF EXISTS `tdq_budget_order`;
CREATE TABLE `tdq_budget_order` (
  `code` varchar(32) NOT NULL COMMENT '预算单编号',
  `loan_type` varchar(4) DEFAULT NULL COMMENT '客户类型',
  `loan_name` varchar(32) DEFAULT NULL COMMENT '客户姓名',
  `car_dealer` varchar(32) DEFAULT NULL COMMENT '汽车经销商',
  `loan_bank` varchar(32) DEFAULT NULL COMMENT '贷款银行',
  `original_price` bigint(20) DEFAULT NULL COMMENT '厂商指导价',
  `car_model` varchar(32) DEFAULT NULL COMMENT '车辆型号',
  `loan_periods` int(11) DEFAULT NULL COMMENT '贷款周期',
  `invoice_price` bigint(20) DEFAULT NULL COMMENT '发票价格',
  `shop_way` varchar(32) DEFAULT NULL COMMENT '购车途径',
  `rate_type` varchar(4) DEFAULT NULL COMMENT '利率类型',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `is_survey` varchar(4) DEFAULT NULL COMMENT '是否需要贷前调查',
  `bank_rate` decimal(10,0) DEFAULT NULL COMMENT '银行利率',
  `company_loan_cs` decimal(10,0) DEFAULT NULL COMMENT '我司贷款成数',
  `is_advance_fund` varchar(4) DEFAULT NULL COMMENT '是否垫资',
  `global_rate` decimal(10,0) DEFAULT NULL COMMENT '综合利率',
  `fee` bigint(20) DEFAULT NULL COMMENT '服务费',
  `fact_subsidy` bigint(20) DEFAULT NULL COMMENT '厂家贴息',
  `bank_loan_cs` decimal(10,0) DEFAULT NULL COMMENT '银行贷款成数',
  `business_company` varchar(255) DEFAULT NULL COMMENT '业务公司',
  `salesman` varchar(32) DEFAULT NULL COMMENT '业务员',
  `car_price` bigint(20) DEFAULT NULL COMMENT '车辆价格',
  `bank_branch` varchar(255) DEFAULT NULL COMMENT '银行经办支行',
  `is_house_property` varchar(4) DEFAULT NULL COMMENT '房产证情况',
  `house_property` varchar(255) DEFAULT NULL COMMENT '房产证',
  `is_house_contract` varchar(4) DEFAULT NULL COMMENT '有无购房合同',
  `house_contract` varchar(255) DEFAULT NULL COMMENT '购房合同',
  `house_ invoice` varchar(255) DEFAULT NULL COMMENT '购房发票',
  `is_license` varchar(4) DEFAULT NULL COMMENT '营业执照情况',
  `license` varchar(255) DEFAULT NULL COMMENT '营业执照',
  `is_site_prove` varchar(4) DEFAULT NULL COMMENT '提供场地证明',
  `site_prove` varchar(255) DEFAULT NULL COMMENT '场地证明',
  `site_area` varchar(255) DEFAULT NULL COMMENT '经营场地面积',
  `car_type` varchar(4) DEFAULT NULL COMMENT '现有车辆类型',
  `is_drice_license` varchar(4) DEFAULT NULL COMMENT '有无驾照',
  `drice_license` varchar(255) DEFAULT NULL COMMENT '驾照',
  `other_property_note` varchar(255) DEFAULT NULL COMMENT '其他资产说明',
  `apply_birth_address` varchar(255) DEFAULT NULL COMMENT '申请人户籍地',
  `apply_now_address` varchar(255) DEFAULT NULL COMMENT '现住地址',
  `house_type` varchar(4) DEFAULT NULL COMMENT '现住房屋类型',
  `gh_birth_address` varchar(255) DEFAULT NULL COMMENT '共还人户籍地',
  `guarantor1_birth_address` varchar(255) DEFAULT NULL COMMENT '担保1户籍地',
  `guarantor2_birth_address` varchar(255) DEFAULT NULL COMMENT '担保2户籍地',
  `other_note` varchar(255) DEFAULT NULL COMMENT '其他情况说明',
  `oil_subsidy` bigint(20) DEFAULT NULL COMMENT '油补',
  `oil_subsidy_kil` decimal(10,0) DEFAULT NULL COMMENT '油补公里数',
  `is_company_insure` decimal(10,0) DEFAULT NULL COMMENT '我司续保',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS收费',
  `ly_amount` bigint(20) DEFAULT NULL COMMENT '履约保证金',
  `gps_deduct` bigint(20) DEFAULT NULL COMMENT 'GPS提成',
  `fx_amount` bigint(20) DEFAULT NULL COMMENT '担保风险金',
  `gps_fee_way` varchar(4) DEFAULT NULL COMMENT 'GPS收费方式',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '杂费',
  `charge_way` varchar(4) DEFAULT NULL COMMENT '手续费收取方式',
  `marry_divorce` varchar(255) DEFAULT NULL COMMENT '结婚证离婚证',
  `apply_hk` varchar(255) DEFAULT NULL COMMENT '户口本(主贷本人页)',
  `bank_bill` varchar(255) DEFAULT NULL COMMENT '银行流水',
  `single_prove` varchar(255) DEFAULT NULL COMMENT '单身证明',
  `income_prove` varchar(255) DEFAULT NULL COMMENT '收入证明',
  `live_prove` varchar(255) DEFAULT NULL COMMENT '居住证明',
  `build_prove` varchar(255) DEFAULT NULL COMMENT '自建房证明',
  `hk_first_page` varchar(255) DEFAULT NULL COMMENT '户口本（首页）',
  `hk_main_page` varchar(255) DEFAULT NULL COMMENT '户口本（户主页）',
  `gh_hk` varchar(255) DEFAULT NULL COMMENT '共还人户口本',
  `guarantor1_id_no` varchar(255) DEFAULT NULL COMMENT '担保人1身份证',
  `guarantor1_hk` varchar(255) DEFAULT NULL COMMENT '担保人1户口本',
  `guarantor2_id_no` varchar(255) DEFAULT NULL COMMENT '担保人2身份证',
  `guarantor2_hk` varchar(255) DEFAULT NULL COMMENT '担保人2户口本',
  `house_pic` varchar(255) DEFAULT NULL COMMENT '小区外观',
  `house_unit_pic` varchar(255) DEFAULT NULL COMMENT '单元楼照片',
  `house_door_pic` varchar(255) DEFAULT NULL COMMENT '门牌照片',
  `house_room_pic` varchar(255) DEFAULT NULL COMMENT '客厅照片',
  `loaner_hourse_pic` varchar(255) DEFAULT NULL COMMENT '主贷与住宅合影',
  `salesman_loaner_pic` varchar(255) DEFAULT NULL COMMENT '签约员与客户合影',
  `company_name_pic` varchar(255) DEFAULT NULL COMMENT '企业名称照片',
  `work_place_pic` varchar(255) DEFAULT NULL COMMENT '办公场地照片',
  `workshop_pic` varchar(255) DEFAULT NULL COMMENT '生产车间照片',
  `second_information` varchar(255) DEFAULT NULL COMMENT '二手车信息',
  `second_hgz` varchar(255) DEFAULT NULL COMMENT '二手车合格证',
  `second_odometer` varchar(255) DEFAULT NULL COMMENT '里程表',
  `second_car_front_pic` varchar(255) DEFAULT NULL COMMENT '车前正面照',
  `second_console_pic` varchar(255) DEFAULT NULL COMMENT '中控台',
  `second_eval_pdf` varchar(255) DEFAULT NULL COMMENT '车300评估页',
  `second_qxb_pic` varchar(255) DEFAULT NULL COMMENT '汽修宝截图',
  `second_car_in_pic` varchar(255) DEFAULT NULL COMMENT '车内饰',
  `second_number` varchar(255) DEFAULT NULL COMMENT '铭牌',
  `other_material_pdf` varchar(255) DEFAULT NULL COMMENT '其他材料附件',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注事项',
  `revocation_reason` varchar(255) DEFAULT NULL COMMENT '撤销理由',
  `apply_datetime` datetime DEFAULT NULL COMMENT '预算单申请时间',
  `commit_bank_datetime` datetime DEFAULT NULL COMMENT '提交银行时间',
  `commit_bank_note` varchar(255) DEFAULT NULL COMMENT '提交银行说明',
  `bank_fk_amount` bigint(20) DEFAULT NULL COMMENT '银行放款金额',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `receipt_bank` bigint(20) DEFAULT NULL COMMENT '收款银行',
  `receipt_bankcard` varchar(32) DEFAULT NULL COMMENT '收款账号',
  `receipt_remark` varchar(255) DEFAULT NULL COMMENT '收款凭证',
  `pledge_commit_datetime` datetime DEFAULT NULL COMMENT '收款备注',
  `pledge_commit_note` varchar(255) DEFAULT NULL COMMENT '抵押提交说明',
  `pledge_contract_code` varchar(32) DEFAULT NULL COMMENT '抵押合同编号',
  `insurance_company` varchar(255) DEFAULT NULL COMMENT '保险公司',
  `car_color` varchar(255) DEFAULT NULL COMMENT '车辆颜色',
  `car_brand` varchar(255) DEFAULT NULL COMMENT '车辆品牌',
  `frame_no` varchar(32) DEFAULT NULL COMMENT '车架号码',
  `engine_no` varchar(32) DEFAULT NULL COMMENT '发动机号码',
  `commerce_insurance` bigint(20) DEFAULT NULL COMMENT '商业险合计',
  `insurance_effect_datetime` datetime DEFAULT NULL COMMENT '保险生效日期',
  `insurance_bank` varchar(255) DEFAULT NULL COMMENT '保险经办银行',
  `guarantee_contract_code` varchar(32) DEFAULT NULL COMMENT '担保合同编号',
  `reg_certificate_code` varchar(32) DEFAULT NULL COMMENT '登记证书号',
  `other_contact` varchar(255) DEFAULT NULL COMMENT '其他联系人',
  `contact_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
  `guarantor_name` varchar(32) DEFAULT NULL COMMENT '担保人姓名',
  `guarantor_mobile` varchar(16) DEFAULT NULL COMMENT '担保人手机',
  `bank_card_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `bill_datetime` datetime DEFAULT NULL COMMENT '对账单日',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '月还款额',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证',
  `file_list` varchar(255) DEFAULT NULL COMMENT '已入档清单',
  `is_complete` varchar(4) DEFAULT NULL COMMENT '资料是否完善',
  `store_place` varchar(255) DEFAULT NULL COMMENT '存放位置',
  `file_remark` varchar(255) DEFAULT NULL COMMENT '入档备注',
  `operator` varchar(255) DEFAULT NULL COMMENT '经办人',
  `operate_datetime` datetime DEFAULT NULL COMMENT '经办日期',
  `operate_department` varchar(255) DEFAULT NULL COMMENT '经办部门',
  `makecard_remark` varchar(255) DEFAULT NULL COMMENT '制卡备注',
  `delivery_datetime` datetime DEFAULT NULL COMMENT '提车日期',
  `is_right_invoice` varchar(4) DEFAULT NULL COMMENT '发票是否正确',
  `current_invoice_price` bigint(20) DEFAULT NULL COMMENT '现发票价',
  `invoice` varchar(255) DEFAULT NULL COMMENT '发票',
  `certification` varchar(255) DEFAULT NULL COMMENT '合格证',
  `force_insurance` bigint(20) DEFAULT NULL COMMENT '交强险',
  `business_insurance` bigint(20) DEFAULT NULL COMMENT '商业险',
  `motor_reg_certification` varchar(255) DEFAULT NULL COMMENT '机动车登记证书',
  `pd_pdf` varchar(255) DEFAULT NULL COMMENT '批单',
  `fbh_remark` varchar(255) DEFAULT NULL COMMENT '发保合备注',
  `fbh_warn_day` int(11) DEFAULT NULL COMMENT '发保合预警天数',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `should_back_amount` bigint(20) DEFAULT NULL COMMENT '应退按揭款',
  `pay_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_bank` varchar(255) DEFAULT NULL COMMENT '付款银行',
  `pay_account` varchar(255) DEFAULT NULL COMMENT '付款账号',
  `pay_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  `cancel_reason` varchar(255) DEFAULT NULL COMMENT '作废原因',
  `cancel_sk_amount` bigint(20) DEFAULT NULL COMMENT '收款金额',
  `cancel_sk_bank` varchar(255) DEFAULT NULL COMMENT '收款银行',
  `cancel_sk_account` varchar(255) DEFAULT NULL COMMENT '收款账号',
  `cancel_sk_receipt_datetime` datetime DEFAULT NULL COMMENT '收款时间',
  `cancel_finance_remark` varchar(255) DEFAULT NULL COMMENT '财务备注',
  `ancel _apply_datetime` datetime DEFAULT NULL COMMENT '申请日期',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*征信表*/
DROP TABLE IF EXISTS `tdq_credit`;
CREATE TABLE `tdq_credit` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司',
  `salesman` varchar(32) DEFAULT NULL COMMENT '业务员',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `loan_bank` varchar(64) DEFAULT NULL COMMENT '贷款银行',
  `shop_way` varchar(255) DEFAULT NULL COMMENT '购车途径',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `xsz_front` varchar(255) DEFAULT NULL COMMENT '行驶证正面',
  `xsz_reverse` varchar(255) DEFAULT NULL COMMENT '行驶证反面',
  `flow_code` varchar(32) DEFAULT NULL COMMENT '流程编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*征信人员表*/
DROP TABLE IF EXISTS `tdq_credit_user`;
CREATE TABLE `tdq_credit_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信业务编号',
  `loan_role` varchar(64) DEFAULT NULL COMMENT '贷款角色',
  `loan_name` varchar(64) DEFAULT NULL COMMENT '客户姓名',
  `relation` varchar(64) DEFAULT NULL COMMENT '与借款人关系',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `is_print` varchar(1) DEFAULT NULL COMMENT '是否打件',
  `id_no_front` varchar(255) DEFAULT NULL COMMENT '身份证正面',
  `id_no_reverse` varchar(255) DEFAULT NULL COMMENT '身份证反面',
  `auth_pdf` varchar(255) DEFAULT NULL COMMENT '征信查询授权书',
  `interview_pic` varchar(255) DEFAULT NULL COMMENT '面签照片',
  `bank_result` varchar(32) DEFAULT NULL COMMENT '银行查询结果',
  `court_result` varchar(32) DEFAULT NULL COMMENT '法院网查询结果',
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
