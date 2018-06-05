DROP TABLE IF EXISTS `tdq_budget_order`;
CREATE TABLE `tdq_budget_order` (
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `loan_product_code` varchar(32) DEFAULT NULL COMMENT '贷款产品编号',
  `loan_product_name` varchar(255) DEFAULT NULL COMMENT '贷款产品名称',
  `loan_bank` varchar(255) DEFAULT NULL COMMENT '贷款银行',
  
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS费用',
  `auth_fee` bigint(20) DEFAULT NULL COMMENT '公证费',
  `fee` bigint(20) DEFAULT NULL COMMENT '服务费',
  `month_rate` decimal(18,8) DEFAULT NULL COMMENT '月供利率(%)',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信单编号',
  
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务种类',
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
  `apply_user_id` varchar(255) DEFAULT NULL COMMENT '申请人编号',
  `apply_user_name` varchar(255) DEFAULT NULL COMMENT '申请人姓名',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  
  `marry_state` varchar(255) DEFAULT NULL COMMENT '婚姻状况',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `education` varchar(255) DEFAULT NULL COMMENT '学历',
  `id_kind` varchar(32) DEFAULT NULL COMMENT '证件类型',
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
  `jour_datetime_start` datetime DEFAULT NULL COMMENT '流水时间起',
  `jour_datetime_end` datetime DEFAULT NULL COMMENT '流水时间止',
  `jour_income` bigint(20) DEFAULT NULL COMMENT '收入',
  
  `jour_expend` bigint(20) DEFAULT NULL COMMENT '支出',
  `jour_balance` bigint(20) DEFAULT NULL COMMENT '帐户余额',
  `jour_month_income` bigint(20) DEFAULT NULL COMMENT '月均收入',
  `jour_month_expend` bigint(20) DEFAULT NULL COMMENT '月均支出',
  `jour_remark` varchar(255) DEFAULT NULL COMMENT '流水备注',
  
  `house_contract` varchar(255) DEFAULT NULL COMMENT '购房合同',
  `house_picture` varchar(255) DEFAULT NULL COMMENT '房屋照片',
  `is_advance_fund` varchar(255) DEFAULT NULL COMMENT '是否垫资',
  `interview_video` varchar(255) DEFAULT NULL COMMENT '面签视频',
  `interview_contract` varchar(255) DEFAULT NULL COMMENT '面签合同',
  
  `advance_fund_datetime` datetime DEFAULT NULL COMMENT '垫资日期',
  `advance_fund_amount` bigint(20) DEFAULT NULL COMMENT '垫资金额',
  `bill_pdf` varchar(255) DEFAULT NULL COMMENT '水单',
  `car_settle_datetime` datetime DEFAULT NULL COMMENT '车辆落户日期',
  `car_number` varchar(255) DEFAULT NULL COMMENT '车牌号',
  
  `car_invoice` varchar(255) DEFAULT NULL COMMENT '车辆发票',
  `car_hgz` varchar(255) DEFAULT NULL COMMENT '合格证',
  `car_jqx` varchar(255) DEFAULT NULL COMMENT '交强险',
  `car_syx` varchar(255) DEFAULT NULL COMMENT '商业险',
  `car_regcerti` varchar(255) DEFAULT NULL COMMENT '登记证书',
  
  `car_pd` varchar(255) DEFAULT NULL COMMENT '车辆批单',
  `car_key` varchar(255) DEFAULT NULL COMMENT '车钥匙',
  `car_big_smj` varchar(255) DEFAULT NULL COMMENT '大本扫描件',
  `bank_commit_datetime` datetime DEFAULT NULL COMMENT '银行提交时间',
  `bank_commit_note` varchar(255) DEFAULT NULL COMMENT '银行提交说明',
  
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `repay_bank_code` varchar(32) DEFAULT NULL COMMENT '还款卡银行编号',
  `repay_bank_name` varchar(255) DEFAULT NULL COMMENT '还款卡银行名称',
  `repay_subbranch` varchar(255) DEFAULT NULL COMMENT '还款卡开户支行',
  
  `repay_bankcard_number` varchar(255) DEFAULT NULL COMMENT '还款卡银行卡号',
  `repay_bill_date` int(11) DEFAULT NULL COMMENT '银行账单日',
  `repay_bank_date` int(11) DEFAULT NULL COMMENT '银行还款日',
  `repay_company_date` int(11) DEFAULT NULL COMMENT '公司还款日',
  `repay_first_month_amount` bigint(20) DEFAULT NULL COMMENT '首期月供金额',
  
  `repay_first_month_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `repay_month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `receipt_bank_code` varchar(255) DEFAULT NULL COMMENT '收款银行编号',
  `receipt_bank_name` varchar(255) DEFAULT NULL COMMENT '收款银行名称',
  
  `receipt_bankcard_number` varchar(255) DEFAULT NULL COMMENT '收款银行卡号',
  `receipt_pdf` varchar(255) DEFAULT NULL COMMENT '收款凭证',
  `receipt_remark` varchar(255) DEFAULT NULL COMMENT '收款备注',
  `pledge_datetime` datetime DEFAULT NULL COMMENT '抵押日期',
  `green_big_smj` varchar(255) DEFAULT NULL COMMENT '绿大本扫描件',
  
  `pledge_bank_commit_datetime` datetime DEFAULT NULL COMMENT '抵押提交银行时间',
  `pledge_bank_commit_note` varchar(255) DEFAULT NULL COMMENT '抵押提交说明',
  `enter_location` varchar(255) DEFAULT NULL COMMENT '入档位置',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  
  `refund_amount` bigint(20) DEFAULT NULL COMMENT '退款金额',
  `refund_bankcard` varchar(255) DEFAULT NULL COMMENT '退款银行卡',
  `refund_bank` varchar(255) DEFAULT NULL COMMENT '退款开户行',
  `refund_subbranch` varchar(255) DEFAULT NULL COMMENT '退款开户支行',
  `refund_bill` varchar(255) DEFAULT NULL COMMENT '退款水单',
  
  `refund_node_code` varchar(32) DEFAULT NULL COMMENT '退款节点编号(0/待退款 1/已退款)',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='准入单';

/*资料传递*/
DROP TABLE IF EXISTS `tdq_logistics`;
CREATE TABLE `tdq_logistics` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 贷前)',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `from_node_code` varchar(255) DEFAULT NULL COMMENT '来方节点',
  `to_node_code` varchar(255) DEFAULT NULL COMMENT '去方节点',
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
  `wan_factor` bigint(20) DEFAULT NULL COMMENT '万元系数',
  `year_rate` decimal(18,8) DEFAULT NULL COMMENT '年利率',
    
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS费用',
  `auth_rate` decimal(18,8) DEFAULT NULL COMMENT '公证费比率',
  `back_rate` decimal(18,8) DEFAULT NULL COMMENT '返点利率',
  `pre_rate` decimal(18,8) DEFAULT NULL COMMENT '前置利率',

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
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
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
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',  
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  `fee_code` varchar(32) NOT NULL COMMENT '手续费编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;