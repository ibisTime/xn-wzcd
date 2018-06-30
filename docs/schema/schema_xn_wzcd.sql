/*
 Navicat MySQL Data Transfer

 Source Server         : 47.96.161.183
 Source Server Version : 50633
 Source Host           : 47.96.161.183
 Source Database       : dev_xn_wzcd

 Target Server Version : 50633
 File Encoding         : utf-8

 Date: 06/29/2018 15:20:11 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_bank`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank`;
CREATE TABLE `tb_bank` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '支行名称',
  `rate12` decimal(10,0) DEFAULT NULL COMMENT '12期',
  `rate18` decimal(10,0) DEFAULT NULL COMMENT '18期',
  `rate24` decimal(10,0) DEFAULT NULL COMMENT '24期',
  `rate36` decimal(10,0) DEFAULT NULL COMMENT '36期',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 已下架 1 已上架)',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台银行信息表';

-- ----------------------------
--  Table structure for `tb_bank_rate`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank_rate`;
CREATE TABLE `tb_bank_rate` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `period` int(11) DEFAULT NULL COMMENT '期数',
  `rate` decimal(18,8) DEFAULT NULL COMMENT '利率',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行利率明细表';

-- ----------------------------
--  Table structure for `tb_bank_subbranch`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank_subbranch`;
CREATE TABLE `tb_bank_subbranch` (
  `code` varchar(32) NOT NULL COMMENT '序号',
  `bank_code` varchar(255) DEFAULT NULL COMMENT '银行编号',
  `bank_type` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `abbr_name` varchar(255) DEFAULT NULL COMMENT '简称',
  `full_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `open_bank` varchar(255) DEFAULT NULL COMMENT '开户行',
  `address` varchar(255) DEFAULT NULL COMMENT '银行地址',
  `phone_number` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `post_code` varchar(32) DEFAULT NULL COMMENT '邮编',
  `bank_client` varchar(255) DEFAULT NULL COMMENT '银行委托人',
  `client_valid_date` datetime DEFAULT NULL COMMENT '委托有效期',
  `auther_name` varchar(255) DEFAULT NULL COMMENT '授权人姓名',
  `auther_phone_number` varchar(32) DEFAULT NULL COMMENT '授权人电话',
  `auther_id_no` varchar(255) DEFAULT NULL COMMENT '授权人身份证',
  `auther_address` varchar(255) DEFAULT NULL COMMENT '授权人地址',
  `credit_card_type` varchar(4) DEFAULT NULL COMMENT '信用卡类型',
  `credit_card_name` varchar(255) DEFAULT NULL COMMENT '信用卡名称',
  `belong_area` varchar(255) DEFAULT NULL COMMENT '所属地区',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行支行信息表';

-- ----------------------------
--  Table structure for `tb_car_dealer`
-- ----------------------------
DROP TABLE IF EXISTS `tb_car_dealer`;
CREATE TABLE `tb_car_dealer` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `full_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `abbr_name` varchar(255) DEFAULT NULL COMMENT '简称',
  `is_self_develop` varchar(1) DEFAULT NULL COMMENT '是否自主开发',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `car_dealer_type` varchar(4) DEFAULT NULL COMMENT '车行经营性质',
  `main_contact` varchar(255) DEFAULT NULL COMMENT '主要联系人',
  `contact_phone` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `main_brand` varchar(255) DEFAULT NULL COMMENT '主营品牌',
  `parent_group` varchar(255) DEFAULT NULL COMMENT '所属集团',
  `agreement_valid_date_start` datetime DEFAULT NULL COMMENT '合作协议有效期起',
  `agreement_valid_date_end` datetime DEFAULT NULL COMMENT '合作协议有效期止',
  `agreement_status` varchar(4) DEFAULT NULL COMMENT '协议状态',
  `agreement_pic` varchar(255) DEFAULT NULL COMMENT '车商合作协议',
  `settle_way` varchar(255) DEFAULT NULL COMMENT '结算方式(1现结2月结3季结)',
  `business_area` varchar(255) DEFAULT NULL COMMENT '业务区域',
  `belong_branch_company` varchar(255) DEFAULT NULL COMMENT '归属分公司',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点编号',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `policy_note` varchar(255) DEFAULT NULL COMMENT '政策说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经销商信息表';

-- ----------------------------
--  Table structure for `tb_car_dealer_protocol`
-- ----------------------------
DROP TABLE IF EXISTS `tb_car_dealer_protocol`;
CREATE TABLE `tb_car_dealer_protocol` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '经销商编号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `plat_ct_rate12` decimal(18,8) DEFAULT NULL COMMENT '我司12期基准利率传统',
  `plat_ct_rate24` decimal(18,8) DEFAULT NULL COMMENT '我司24期基准利率传统',
  `plat_ct_rate36` decimal(18,8) DEFAULT NULL COMMENT '我司36期基准利率传统',
  `plat_zk_rate12` decimal(18,8) DEFAULT NULL COMMENT '我司12期基准利率直客',
  `plat_zk_rate24` decimal(18,8) DEFAULT NULL COMMENT '我司24期基准利率直客',
  `plat_zk_rate36` decimal(18,8) DEFAULT NULL COMMENT '我司36期基准利率直客',
  `assure_type` varchar(32) DEFAULT NULL COMMENT '担保费类型(1单笔/2贷款额百分比)',
  `assure_fee` bigint(20) DEFAULT NULL COMMENT '单笔担保费',
  `assure_rate` decimal(18,8) DEFAULT NULL COMMENT '担保费贷款额百分比',
  `dz_type` varchar(32) DEFAULT NULL COMMENT '垫资费类型(1单笔/2贷款额百分比)',
  `dz_fee` bigint(20) DEFAULT NULL COMMENT '单笔垫资费',
  `dz_rate` decimal(18,8) DEFAULT NULL COMMENT '垫资费贷款额百分比',
  `ly_amount_type` varchar(32) DEFAULT NULL COMMENT '履约保证金类型(1单笔/2贷款额百分比)',
  `ly_amount_fee` bigint(20) DEFAULT NULL COMMENT '单笔履约保证金',
  `ly_amount_rate` decimal(18,8) DEFAULT NULL COMMENT '履约保证金贷款额百分比',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'GPS类型(1单笔/2贷款额百分比)',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT '单笔GPS费',
  `gps_rate` decimal(18,8) DEFAULT NULL COMMENT 'GPS垫资费贷款额百分比',
  `other_type` varchar(32) DEFAULT NULL COMMENT '杂费类型(1单笔/2贷款额百分比)',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '单笔杂费',
  `other_rate` decimal(18,8) DEFAULT NULL COMMENT '杂费贷款额百分比',
  `introduce_type` varchar(32) DEFAULT NULL COMMENT '介绍费类型(1单笔/2贷款额百分比)',
  `introduce_fee` bigint(20) DEFAULT NULL COMMENT '单笔介绍费',
  `introduce_rate` decimal(18,8) DEFAULT NULL COMMENT '介绍费贷款额百分比',
  `return_point_type` varchar(32) DEFAULT NULL COMMENT '返点类型(1单笔/2贷款额百分比)',
  `return_point_fee` bigint(20) DEFAULT NULL COMMENT '单笔返点',
  `return_point_rate` decimal(18,8) DEFAULT NULL COMMENT '返点贷款额百分比',
  `is_dz` varchar(32) DEFAULT NULL COMMENT '是否垫资(1 是 0 否)',
  `insu_agency_year1_type` varchar(32) DEFAULT NULL COMMENT '1年保险代理费类型(1平台/2车行)',
  `insu_agency_year1_fee` bigint(20) DEFAULT NULL COMMENT '1年保险代理费',
  `insu_agency_year2_type` varchar(32) DEFAULT NULL COMMENT '2年保险代理费类型(1平台/2车行)',
  `insu_agency_year2_fee` bigint(20) DEFAULT NULL COMMENT '2年保险代理费',
  `insu_agency_year3_type` varchar(32) DEFAULT NULL COMMENT '3年保险代理费类型(1平台/2车行)',
  `insu_agency_year3_fee` bigint(20) DEFAULT NULL COMMENT '3年保险代理费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经销商协议表';

-- ----------------------------
--  Table structure for `tb_collect_bankcard`
-- ----------------------------
DROP TABLE IF EXISTS `tb_collect_bankcard`;
CREATE TABLE `tb_collect_bankcard` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 普通账户 2 经销商的收款账号 3 经销商返点账号)',
  `belong_bank` varchar(32) DEFAULT NULL COMMENT '三种银行',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(32) DEFAULT NULL COMMENT '支行编号',
  `bankcard_number` varchar(255) DEFAULT NULL COMMENT '账号',
  `point_rate` decimal(18,8) DEFAULT NULL COMMENT '返点比例',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收款账号表';

-- ----------------------------
--  Table structure for `tb_gps`
-- ----------------------------
DROP TABLE IF EXISTS `tb_gps`;
CREATE TABLE `tb_gps` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `gps_dev_no` varchar(32) NOT NULL COMMENT 'gps编号',
  `gps_type` varchar(32) NOT NULL COMMENT 'gps类型( 1 有线 0 无线)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `company_apply_status` varchar(32) DEFAULT NULL COMMENT '公司申领状态(0 待申领 1 已申领)',
  `company_apply_datetime` datetime DEFAULT NULL COMMENT '公司申领日期',
  `company_apply_code` varchar(32) DEFAULT NULL COMMENT '公司申领编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申领人',
  `apply_status` varchar(32) DEFAULT NULL COMMENT '申领人申领状态(0 待申领 1 已申领)',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申领日期',
  `apply_code` varchar(32) DEFAULT NULL COMMENT '申领编号',
  `use_status` varchar(32) DEFAULT NULL COMMENT '使用状态(0 待使用 1 已使用)',
  `use_datetime` datetime DEFAULT NULL COMMENT '使用日期',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gps库存管理';

-- ----------------------------
--  Table structure for `tb_gps_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tb_gps_apply`;
CREATE TABLE `tb_gps_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) NOT NULL COMMENT '类型(1 公司 2 个人)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请日期',
  `apply_reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `apply_count` int(11) DEFAULT NULL COMMENT '申请个数',
  `approve_user` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核日期',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `send_datetime` datetime DEFAULT NULL COMMENT '发货日期',
  `receive_datetime` datetime DEFAULT NULL COMMENT '收货日期',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0 待审核 1 审核通过,待发货 2 审核不通过 3 已发货,待收货 4 已收货)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gps申领管理';

-- ----------------------------
--  Table structure for `tb_id_no_area`
-- ----------------------------
DROP TABLE IF EXISTS `tb_id_no_area`;
CREATE TABLE `tb_id_no_area` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `area_no` varchar(32) DEFAULT NULL COMMENT '身份证区域号',
  `area_name` varchar(255) DEFAULT NULL COMMENT '身份证区域名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证区域表';

-- ----------------------------
--  Table structure for `tb_insurance_company`
-- ----------------------------
DROP TABLE IF EXISTS `tb_insurance_company`;
CREATE TABLE `tb_insurance_company` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保险公司信息表';

-- ----------------------------
--  Table structure for `tb_loan_cs`
-- ----------------------------
DROP TABLE IF EXISTS `tb_loan_cs`;
CREATE TABLE `tb_loan_cs` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) NOT NULL COMMENT '类型(1 新车 2 二手车)',
  `min_cs` decimal(18,8) DEFAULT NULL COMMENT '最低成数',
  `max_cs` decimal(18,8) DEFAULT NULL COMMENT '最高成数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我司贷款成数';

-- ----------------------------
--  Table structure for `tb_province_no`
-- ----------------------------
DROP TABLE IF EXISTS `tb_province_no`;
CREATE TABLE `tb_province_no` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `province_no` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份编号表';

-- ----------------------------
--  Table structure for `tbf_withhold`
-- ----------------------------
DROP TABLE IF EXISTS `tbf_withhold`;
CREATE TABLE `tbf_withhold` (
  `trans_id` varchar(32) NOT NULL COMMENT '商户订单号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编码',
  `bankcard_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `trans_amount` bigint(32) DEFAULT NULL COMMENT '代扣金额',
  `ref_no` varchar(32) DEFAULT NULL COMMENT '关联订单号',
  `resp_code` varchar(32) DEFAULT NULL COMMENT '应答码',
  `resp_msg` varchar(255) DEFAULT NULL COMMENT '应答信息',
  `member_id` varchar(32) DEFAULT NULL COMMENT '商户号',
  `terminal_id` varchar(32) DEFAULT NULL COMMENT '终端号',
  `txn_type` varchar(32) DEFAULT NULL COMMENT '交易类型',
  `txn_sub_type` varchar(32) DEFAULT NULL COMMENT '交易子类',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '接入类型',
  `trade_date` datetime DEFAULT NULL COMMENT '订单发送时间',
  `trans_no` varchar(32) DEFAULT NULL COMMENT '宝付交易号',
  `succ_amt` bigint(32) DEFAULT NULL COMMENT '成功金额',
  `trans_serial_no` varchar(32) DEFAULT NULL COMMENT '商户流水号',
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdh_cost`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_cost`;
CREATE TABLE `tdh_cost` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  `item` varchar(255) DEFAULT NULL COMMENT '费用项名称',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `pay_datetime` datetime DEFAULT NULL COMMENT '发生时间',
  `pay_way` varchar(255) DEFAULT NULL COMMENT '发生付款方式',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `repay_datetime` datetime DEFAULT NULL COMMENT '执行时间',
  `repay_way` varchar(255) DEFAULT NULL COMMENT '执行付款方式',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdh_judge`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_judge`;
CREATE TABLE `tdh_judge` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `case_number` varchar(32) DEFAULT NULL COMMENT '案号',
  `plaintiff` varchar(32) DEFAULT NULL COMMENT '原告',
  `defendant` varchar(32) DEFAULT NULL COMMENT '被告',
  `case_subject` varchar(32) DEFAULT NULL COMMENT '诉讼标的',
  `case_car` varchar(32) DEFAULT NULL COMMENT '涉案车辆',
  `case_fee` varchar(32) DEFAULT NULL COMMENT '诉讼费',
  `case_start_datetime` varchar(32) DEFAULT NULL COMMENT '起诉日期',
  `case_status` varchar(32) DEFAULT NULL COMMENT '起诉状态',
  `case_pdf` varchar(255) DEFAULT NULL COMMENT '起诉附件',
  `court_datetime` datetime DEFAULT NULL COMMENT '开庭日期',
  `judge_datetime` datetime DEFAULT NULL COMMENT '判决日期',
  `judge_pdf` varchar(255) DEFAULT NULL COMMENT '判决附件',
  `exe_case_number` varchar(32) DEFAULT NULL COMMENT '执行案号',
  `exe_apply_user` varchar(32) DEFAULT NULL COMMENT '执行申请人',
  `execute_mark_amount` bigint(20) DEFAULT NULL COMMENT '执行标的额',
  `exe_datetime` datetime DEFAULT NULL COMMENT '执行日期',
  `exe_result` varchar(255) DEFAULT NULL COMMENT '执行结果',
  `sale_datetime` datetime DEFAULT NULL COMMENT '拍卖日期',
  `exe_pdf` varchar(255) DEFAULT NULL COMMENT '执行裁定书',
  `status` varchar(4) DEFAULT NULL COMMENT '状态 0 待处理 1 结束',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='司法审判表';

-- ----------------------------
--  Table structure for `tdh_overdue_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_overdue_menu`;
CREATE TABLE `tdh_overdue_menu` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `batch_datetime` datetime DEFAULT NULL COMMENT '批量日期',
  `real_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号',
  `loan_bank_name` varchar(255) DEFAULT NULL COMMENT '贷款银行名称',
  `loan_amount` bigint(11) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `remain_amount` bigint(11) DEFAULT NULL COMMENT '剩余金额',
  `fk_datetime` datetime DEFAULT NULL COMMENT '放款日期',
  `overdue_amount` bigint(11) DEFAULT NULL COMMENT '逾期金额',
  `overdue_datetime` datetime DEFAULT NULL COMMENT '逾期日期',
  `import_datetime` datetime DEFAULT NULL COMMENT '导入日期',
  `import_note` varchar(255) DEFAULT NULL COMMENT '导入说明',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待处理 1 已处理)',
  `handle_datetime` datetime DEFAULT NULL COMMENT '处理日期',
  `handle_note` varchar(255) DEFAULT NULL COMMENT '处理说明',
  `budget_order_code` varchar(32) DEFAULT NULL COMMENT '准入单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导入逾期名单';

-- ----------------------------
--  Table structure for `tdh_overdue_repay`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_overdue_repay`;
CREATE TABLE `tdh_overdue_repay` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `overdue_code` varchar(32) DEFAULT NULL COMMENT '逾期名单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='逾期名单关联表';

-- ----------------------------
--  Table structure for `tdh_remind_log`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_remind_log`;
CREATE TABLE `tdh_remind_log` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  `way` varchar(255) DEFAULT NULL COMMENT '催收方式',
  `to_user` varchar(255) DEFAULT NULL COMMENT '催收对象姓名',
  `content` text COMMENT '催收文本',
  `create_datetime` datetime DEFAULT NULL COMMENT '催收时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdh_repay_biz`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_repay_biz`;
CREATE TABLE `tdh_repay_biz` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `id_kind` varchar(32) DEFAULT NULL COMMENT '证件号类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号编号',
  `bankcard_code` varchar(32) DEFAULT NULL COMMENT '还款卡编号',
  `ref_type` varchar(4) DEFAULT NULL COMMENT '关联类型(0=商品，1=车贷)',
  `ref_code` varchar(32) DEFAULT NULL COMMENT '关联编号',
  `biz_price` bigint(20) DEFAULT NULL COMMENT '业务总价',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` varchar(20) DEFAULT NULL COMMENT '首付金额',
  `loan_bank` varchar(32) DEFAULT NULL COMMENT '贷款银行',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `rest_periods` int(11) DEFAULT NULL COMMENT '剩余期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `loan_start_datetime` datetime DEFAULT NULL COMMENT '贷款时间起点',
  `loan_end_datetime` datetime DEFAULT NULL COMMENT '贷款时间终点',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `fx_deposit` bigint(20) DEFAULT NULL COMMENT '风险保证金',
  `first_repay_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `first_repay_amount` bigint(20) DEFAULT NULL COMMENT '首期月供金额',
  `bill_datetime` int(11) DEFAULT NULL COMMENT '每期账单日',
  `month_datetime` int(11) DEFAULT NULL COMMENT '每期还款日',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `ly_deposit` bigint(20) DEFAULT NULL COMMENT '履约保证金（可退）',
  `cut_ly_deposit` bigint(20) DEFAULT NULL COMMENT '扣除的履约保证金',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  `rest_amount` bigint(20) DEFAULT NULL COMMENT '剩余欠款',
  `rest_total_cost` bigint(20) DEFAULT NULL COMMENT '未还清收总成本',
  `overdue_total_deposit` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金总额',
  `overdue_total_deposit_income` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金总收入',
  `total_in_deposit` bigint(20) DEFAULT NULL COMMENT '额外保证金收入',
  `rest_overdue_amount` bigint(20) DEFAULT NULL COMMENT '剩余逾期总金额',
  `total_overdue_count` int(11) DEFAULT NULL COMMENT '累计逾期期数',
  `cur_overdue_count` int(11) DEFAULT NULL COMMENT '现有逾期期数',
  `rest_replace_repay_amount` bigint(20) DEFAULT NULL COMMENT '现有代偿金额',
  `total_replace_repay_count` int(11) DEFAULT NULL COMMENT '累计代偿次数',
  `cur_replace_repay_count` int(11) DEFAULT NULL COMMENT '现在代偿次数',
  `black_handle_note` text COMMENT '黑名单处理结果备案',
  `is_advance_settled` varchar(255) DEFAULT NULL COMMENT '是否提前结清(0=正常结清 1=提前结清)',
  `settle_attach` varchar(255) DEFAULT NULL COMMENT '结清证明',
  `settle_datetime` datetime DEFAULT NULL COMMENT '结清时间',
  `deposit_receipt` varchar(255) DEFAULT NULL COMMENT '押金单',
  `refund_bank_subbranch` varchar(255) DEFAULT NULL COMMENT '退款开户行',
  `refund_bank_real_name` varchar(255) DEFAULT NULL COMMENT '退款户名',
  `refund_bankcard` varchar(255) DEFAULT NULL COMMENT '退款账号',
  `second_company_insurance` varchar(255) DEFAULT NULL COMMENT '第二年按公司指定续保',
  `third_company_insurance` varchar(255) DEFAULT NULL COMMENT '第三年按公司指定续保',
  `release_apply_note` varchar(255) DEFAULT NULL COMMENT '解除抵押说明',
  `release_datetime` datetime DEFAULT NULL COMMENT '解除抵押时间',
  `release_note` varchar(255) DEFAULT NULL COMMENT '解除抵押回录说明',
  `release_template_id` varchar(32) DEFAULT NULL COMMENT '解除抵押模板',
  `judge_receipt_datetime` datetime DEFAULT NULL COMMENT '司法诉讼收款时间',
  `judge_receipt_amount` bigint(20) DEFAULT NULL COMMENT '司法诉讼收款金额',
  `judge_receipt_bank` varchar(255) DEFAULT NULL COMMENT '司法诉讼收款银行',
  `judge_receipt_bankcard` varchar(255) DEFAULT NULL COMMENT '司法诉讼收款银行账号',
  `judge_note` varchar(255) DEFAULT NULL COMMENT '司法诉讼备注',
  `judge_bill_pdf` varchar(255) DEFAULT NULL COMMENT '司法诉讼收款凭证',
  `settle_pay_datetime` datetime DEFAULT NULL COMMENT '结清付款时间',
  `settle_bank` varchar(255) DEFAULT NULL COMMENT '结清付款银行',
  `settle_bankcard` varchar(255) DEFAULT NULL COMMENT '结清付款账号',
  `settle_pdf` text COMMENT '结清打款凭证',
  `settle_note` text COMMENT '结清说明',
  `updater` varchar(255) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款业务表';

-- ----------------------------
--  Table structure for `tdh_repay_plan`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_repay_plan`;
CREATE TABLE `tdh_repay_plan` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `ref_type` varchar(32) DEFAULT NULL COMMENT '类型',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '借款人编号',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `cur_periods` int(11) DEFAULT NULL COMMENT '当前期数',
  `repay_datetime` datetime DEFAULT NULL COMMENT '还款时间',
  `repay_capital` bigint(20) DEFAULT NULL COMMENT '本期本金',
  `repay_interest` decimal(18,8) DEFAULT NULL COMMENT '本期利息',
  `repay_amount` bigint(20) DEFAULT NULL COMMENT '本期还款金额',
  `payed_amount` bigint(20) DEFAULT NULL COMMENT '已还金额',
  `overplus_amount` bigint(20) DEFAULT NULL COMMENT '剩余欠款',
  `overdue_amount` bigint(20) DEFAULT NULL COMMENT '逾期金额',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点',
  `overdue_handler` varchar(255) DEFAULT NULL COMMENT '逾期处理人',
  `overdue_handle_datetime` datetime DEFAULT NULL COMMENT '逾期处理时间',
  `overdue_handle_note` text COMMENT '逾期处理说明',
  `total_fee` bigint(20) DEFAULT NULL COMMENT '清收费用总额',
  `payed_fee` bigint(20) DEFAULT NULL COMMENT '已缴纳清收费用总额',
  `overdue_deposit` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金',
  `overdue_deposit_way` varchar(255) DEFAULT NULL COMMENT '再次逾期保证金收取方式',
  `repay_is_part` char(1) DEFAULT NULL COMMENT '是否部分还款',
  `real_repay_amount` bigint(20) DEFAULT NULL COMMENT '实际还款金额',
  `remind_count` int(11) DEFAULT NULL COMMENT '已催款次数',
  `real_replace_repay_amount` bigint(20) DEFAULT NULL COMMENT '实际代偿金额',
  `replace_real_repay_amount` bigint(20) DEFAULT NULL COMMENT '实际代偿金额',
  `replace_is_repay` char(1) DEFAULT NULL COMMENT '代偿是否缴纳',
  `replace_repay_datetime` datetime DEFAULT NULL COMMENT '代偿时间',
  `replace_back_repay_amount` bigint(20) DEFAULT NULL COMMENT '收回代偿金额',
  `replace_back_repay_datetime` datetime DEFAULT NULL COMMENT '收回代偿时间',
  `collection_way` varchar(255) DEFAULT NULL COMMENT '催收方式',
  `collection_target` varchar(255) DEFAULT NULL COMMENT '催收对象',
  `collection_process` varchar(255) DEFAULT NULL COMMENT '催收过程',
  `collection_wish` varchar(255) DEFAULT NULL COMMENT '客户意愿',
  `collection_result` varchar(32) DEFAULT NULL COMMENT '催收结果',
  `deposit_is_provide` varchar(4) DEFAULT NULL COMMENT '是否提供押金',
  `collection_note` varchar(255) DEFAULT NULL COMMENT '催收情况说明',
  `pawnshop_is_redeem` varchar(4) DEFAULT NULL COMMENT '是否典当行赎回',
  `pawnshop_name` varchar(255) DEFAULT NULL COMMENT '典当行名称',
  `ransom` varchar(255) DEFAULT NULL COMMENT '典当行赎金小写',
  `ts_car_amount` bigint(20) DEFAULT NULL COMMENT '拖车申请金额',
  `ts_user_name` varchar(255) DEFAULT NULL COMMENT '拖车人姓名',
  `ts_bankcard_number` varchar(255) DEFAULT NULL COMMENT '拖车收款账号',
  `ts_bank_name` varchar(255) DEFAULT NULL COMMENT '拖车开户行',
  `ts_subbranch` varchar(255) DEFAULT NULL COMMENT '拖车开户支行',
  `tc_apply_note` varchar(255) DEFAULT NULL COMMENT '拖车申请说明',
  `remit_datetime` datetime DEFAULT NULL COMMENT '打款时间',
  `remit_amount` bigint(20) DEFAULT NULL COMMENT '打款金额',
  `remit_bank_code` varchar(32) DEFAULT NULL COMMENT '打款银行',
  `remit_bill_pdf` varchar(255) DEFAULT NULL COMMENT '打款水单',
  `take_car_address` varchar(255) DEFAULT NULL COMMENT '收车地点',
  `take_datetime` datetime DEFAULT NULL COMMENT '拖车时间',
  `take_name` varchar(255) DEFAULT NULL COMMENT '拖车人员',
  `take_location` varchar(255) DEFAULT NULL COMMENT '拖车停放位置',
  `take_note` varchar(255) DEFAULT NULL COMMENT '拖车说明',
  `deal_result` varchar(255) DEFAULT NULL COMMENT '处理结果',
  `sell_price` bigint(20) DEFAULT NULL COMMENT '出售价格',
  `deposit` bigint(20) DEFAULT NULL COMMENT '保证金',
  `fee_note` varchar(255) DEFAULT NULL COMMENT '费用说明',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款计划表';

-- ----------------------------
--  Table structure for `tdh_replace_repay_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_replace_repay_apply`;
CREATE TABLE `tdh_replace_repay_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) NOT NULL COMMENT '代偿性质',
  `amount` bigint(20) NOT NULL COMMENT '预算金额',
  `biz_code` varchar(32) NOT NULL COMMENT '业务编号',
  `receipt_bank` varchar(32) NOT NULL COMMENT '收款人开户行',
  `receipt_real_name` varchar(32) NOT NULL COMMENT '收款人名称',
  `receipt_account` varchar(32) NOT NULL COMMENT '收款人账号',
  `is_urgent` varchar(32) NOT NULL COMMENT '是否加急',
  `apply_user` varchar(32) NOT NULL COMMENT '申请人',
  `apply_datetime` datetime NOT NULL COMMENT '申请时间',
  `apply_note` varchar(32) DEFAULT NULL COMMENT '申请说明',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代偿申请单';

-- ----------------------------
--  Table structure for `tdh_replace_repay_plan`
-- ----------------------------
DROP TABLE IF EXISTS `tdh_replace_repay_plan`;
CREATE TABLE `tdh_replace_repay_plan` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `is_plat_issue` varchar(32) DEFAULT NULL COMMENT '与我司过往是否有纠纷',
  `take_way` varchar(32) DEFAULT NULL COMMENT '代偿后采取的方式',
  `defer_days` int(11) DEFAULT NULL COMMENT '暂缓天数',
  `apply_reason` varchar(32) DEFAULT NULL COMMENT '代偿申请原因',
  `apply_reason_note` varchar(255) DEFAULT NULL COMMENT '代偿申请原因说明',
  `risk_note` varchar(255) DEFAULT NULL COMMENT '风控经理意见',
  `repay_rate` decimal(18,8) DEFAULT NULL COMMENT '代偿利率',
  `repay_date` datetime DEFAULT NULL COMMENT '付款日期',
  `repay_bankcard` varchar(255) DEFAULT NULL COMMENT '付款银行卡',
  `repay_bank` varchar(32) DEFAULT NULL COMMENT '付款银行',
  `repay_user` varchar(32) DEFAULT NULL COMMENT '付款人',
  `repay_bill` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  `repay_note` varchar(255) DEFAULT NULL COMMENT '付款说明',
  `biz_code` varchar(32) NOT NULL COMMENT '业务编号(还款计划)',
  `replace_apply_code` varchar(32) DEFAULT NULL COMMENT '代偿申请编号',
  `customer_user_id` varchar(32) DEFAULT NULL COMMENT '客户用户编号',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代偿还款计划单';

-- ----------------------------
--  Table structure for `tdq_advance_fund`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_advance_fund`;
CREATE TABLE `tdq_advance_fund` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `budget_code` varchar(32) NOT NULL COMMENT '预算单编号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '汽车经销商编号',
  `use_amount` bigint(20) DEFAULT NULL COMMENT '用款金额(应退按揭款)',
  `gps_fee_way` varchar(4) DEFAULT NULL,
  `loan_bank_code` varchar(32) DEFAULT NULL COMMENT '贷款银行编号',
  `is_advance_fund` varchar(32) DEFAULT NULL COMMENT '是否垫资（1是0否）',
  `collect_bankcard_code` varchar(32) DEFAULT NULL COMMENT '收款账号编号',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  `make_bill_note` varchar(255) DEFAULT NULL COMMENT '制单意见说明',
  `advance_fund_amount` bigint(20) DEFAULT NULL COMMENT '垫资金额',
  `advance_fund_datetime` datetime DEFAULT NULL COMMENT '垫资日期',
  `pay_bankcard_code` varchar(32) DEFAULT NULL COMMENT '付款银行编号',
  `bill_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  `note` varchar(255) DEFAULT NULL COMMENT '意见说明',
  `cancel_reason` varchar(255) DEFAULT NULL COMMENT '撤销理由',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `type` varchar(4) DEFAULT NULL COMMENT '1总公司业务 2分公司业务',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `total_advance_fund_code` varchar(32) DEFAULT NULL COMMENT '垫资汇总单编号(分公司业务才有)',
  `loan_amount` bigint(20) DEFAULT NULL,
  `service_charge` bigint(20) DEFAULT NULL,
  `service_charge_way` varchar(4) DEFAULT NULL,
  `gps_fee` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`code`) COMMENT '垫资表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='垫资表';

-- ----------------------------
--  Table structure for `tdq_budget_order`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order`;
CREATE TABLE `tdq_budget_order` (
  `code` varchar(32) NOT NULL COMMENT '预算单编号',
  `customer_type` varchar(4) DEFAULT NULL COMMENT '客户类型',
  `customer_name` varchar(32) DEFAULT NULL COMMENT '客户姓名',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '汽车经销商编号',
  `loan_bank_code` varchar(32) DEFAULT NULL COMMENT '贷款银行编号',
  `loan_bank_subbranch` tinytext COMMENT '贷款银行经办支行',
  `original_price` bigint(20) DEFAULT NULL COMMENT '厂商指导价',
  `car_model` varchar(32) DEFAULT NULL COMMENT '车辆型号',
  `loan_periods` int(11) DEFAULT NULL COMMENT '贷款周期',
  `invoice_price` bigint(20) DEFAULT NULL COMMENT '发票价格',
  `shop_way` varchar(32) DEFAULT NULL COMMENT '购车途径',
  `rate_type` varchar(4) DEFAULT NULL COMMENT '利率类型',
  `pre_loan_amount` bigint(20) DEFAULT NULL COMMENT '之前贷款金额',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `is_survey` varchar(4) DEFAULT NULL COMMENT '是否需要贷前调查',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `company_loan_cs` decimal(18,8) DEFAULT NULL COMMENT '我司贷款成数',
  `pre_company_loan_cs` decimal(18,8) DEFAULT NULL COMMENT '发票不匹配之前我司贷款成数',
  `is_advance_fund` varchar(4) DEFAULT NULL COMMENT '是否垫资',
  `global_rate` decimal(18,8) DEFAULT NULL COMMENT '综合利率',
  `pre_global_rate` decimal(18,8) DEFAULT NULL COMMENT '发票不匹配之前综合利率',
  `fee` bigint(20) DEFAULT NULL COMMENT '手续费',
  `car_dealer_subsidy` bigint(20) DEFAULT NULL COMMENT '汽车经销商厂家贴息',
  `bank_loan_cs` decimal(18,8) DEFAULT NULL COMMENT '银行贷款成数',
  `pre_bank_loan_cs` decimal(18,8) DEFAULT NULL COMMENT '发票不匹配之前银行贷款成数',
  `company_code` tinytext COMMENT '公司编号',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `apply_user_company` tinytext COMMENT '申请人就职单位',
  `apply_user_duty` tinytext COMMENT '申请人职位',
  `apply_user_ghr_relation` tinytext COMMENT '申请人与共还人关系',
  `marry_state` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `apply_user_month_income` bigint(20) DEFAULT NULL COMMENT '申请人月收入',
  `apply_user_settle_interest` bigint(20) DEFAULT NULL COMMENT '申请人结息',
  `apply_user_balance` bigint(20) DEFAULT NULL COMMENT '申请人余额',
  `apply_user_jour_show_income` tinytext COMMENT '申请人流水是否体现月收入',
  `apply_user_is_print` tinytext COMMENT '申请人是否打件',
  `gh_month_income` bigint(20) DEFAULT NULL COMMENT '共还人月收入',
  `gh_settle_interest` bigint(20) DEFAULT NULL COMMENT '共还人结息',
  `gh_balance` bigint(20) DEFAULT NULL COMMENT '共还人余额',
  `gh_jour_show_income` tinytext COMMENT '共还人流水是否体现月收入',
  `gh_is_print` tinytext COMMENT '共还人是否打件',
  `guarantor1_month_income` bigint(20) DEFAULT NULL COMMENT '担保人1月收入',
  `guarantor1_settle_interest` bigint(20) DEFAULT NULL COMMENT '担保人1结息',
  `guarantor1_balance` bigint(20) DEFAULT NULL COMMENT '担保人1余额',
  `guarantor1_jour_show_income` tinytext COMMENT '担保人1流水是否体现月收入',
  `guarantor1_is_print` tinytext COMMENT '担保人1是否打件',
  `guarantor2_month_income` bigint(20) DEFAULT NULL COMMENT '担保人2月收入',
  `guarantor2_settle_interest` bigint(20) DEFAULT NULL COMMENT '担保人2结息',
  `guarantor2_balance` bigint(20) DEFAULT NULL COMMENT '担保人2余额',
  `guarantor2_jour_show_income` tinytext COMMENT '担保人2流水是否体现月收入',
  `guarantor2_is_print` tinytext COMMENT '担保人2是否打件',
  `other_income_note` tinytext COMMENT '其他收入说明',
  `is_house_property` varchar(4) DEFAULT NULL COMMENT '房产证情况',
  `house_property` tinytext COMMENT '房产证',
  `is_house_contract` varchar(4) DEFAULT NULL COMMENT '有无购房合同',
  `house_contract` tinytext COMMENT '购房合同',
  `house_invoice` tinytext COMMENT '购房发票',
  `is_license` varchar(4) DEFAULT NULL COMMENT '营业执照情况',
  `license` tinytext COMMENT '营业执照',
  `is_site_prove` varchar(4) DEFAULT NULL COMMENT '提供场地证明',
  `site_prove` tinytext COMMENT '场地证明',
  `site_area` tinytext COMMENT '经营场地面积',
  `car_type` varchar(4) DEFAULT NULL COMMENT '现有车辆类型',
  `is_drice_license` varchar(4) DEFAULT NULL COMMENT '有无驾照',
  `drice_license` tinytext COMMENT '驾照',
  `other_property_note` tinytext COMMENT '其他资产说明',
  `apply_birth_address` tinytext COMMENT '申请人户籍地',
  `apply_now_address` tinytext COMMENT '现住地址',
  `house_type` varchar(4) DEFAULT NULL COMMENT '现住房屋类型',
  `gh_birth_address` tinytext COMMENT '共还人户籍地',
  `guarantor1_birth_address` tinytext COMMENT '担保1户籍地',
  `guarantor2_birth_address` tinytext COMMENT '担保2户籍地',
  `other_note` tinytext COMMENT '其他情况说明',
  `oil_subsidy` bigint(20) DEFAULT NULL COMMENT '油补',
  `oil_subsidy_kil` decimal(18,8) DEFAULT NULL COMMENT '油补公里数',
  `is_plat_insure` char(1) DEFAULT NULL COMMENT '是否我司续保',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS收费',
  `gps_deduct` bigint(20) DEFAULT NULL COMMENT 'GPS提成',
  `gps_fee_way` varchar(4) DEFAULT NULL COMMENT 'GPS收费方式（1转账2按揭款3返点4不收费）',
  `ly_amount` bigint(20) DEFAULT NULL COMMENT '履约保证金',
  `fx_amount` bigint(20) DEFAULT NULL COMMENT '担保风险金',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '杂费',
  `service_charge_way` varchar(4) DEFAULT NULL COMMENT '手续费收取方式',
  `service_charge` bigint(20) DEFAULT NULL COMMENT '手续费',
  `marry_divorce` tinytext COMMENT '结婚证离婚证',
  `apply_user_hkb` tinytext COMMENT '户口本(主贷本人页)',
  `bank_bill_pdf` tinytext COMMENT '银行流水',
  `single_prove_pdf` tinytext COMMENT '单身证明',
  `income_prove_pdf` tinytext COMMENT '收入证明',
  `live_prove_pdf` tinytext COMMENT '居住证明',
  `build_prove_pdf` tinytext COMMENT '自建房证明',
  `hkb_first_page` tinytext COMMENT '户口本（首页）',
  `hkb_main_page` tinytext COMMENT '户口本（户主页）',
  `gh_hkb` tinytext COMMENT '共还人户口本',
  `guarantor1_id_no` tinytext COMMENT '担保人1身份证',
  `guarantor1_hkb` tinytext COMMENT '担保人1户口本',
  `guarantor2_id_no` tinytext COMMENT '担保人2身份证',
  `guarantor2_hkb` tinytext COMMENT '担保人2户口本',
  `house_pic` tinytext COMMENT '小区外观',
  `house_unit_pic` tinytext COMMENT '单元楼照片',
  `house_door_pic` tinytext COMMENT '门牌照片',
  `house_room_pic` tinytext COMMENT '客厅照片',
  `house_customer_pic` tinytext COMMENT '主贷与住宅合影',
  `house_sale_customer_pic` tinytext COMMENT '签约员与客户在房子合影照片',
  `company_name_pic` tinytext COMMENT '企业名称照片',
  `company_place_pic` tinytext COMMENT '办公场地照片',
  `company_workshop_pic` tinytext COMMENT '生产车间照片',
  `company_sale_customer_pic` tinytext COMMENT '签约员与客户在公司合影照片',
  `second_hgz` tinytext COMMENT '二手车合格证',
  `second_odometer` tinytext COMMENT '里程表',
  `second_car_front_pic` tinytext COMMENT '车前正面照',
  `second_console_pic` tinytext COMMENT '中控台',
  `second_300_pdf` tinytext COMMENT '车300评估页',
  `second_qxb_pic` tinytext COMMENT '汽修宝截图',
  `second_car_in_pic` tinytext COMMENT '车内饰',
  `second_number` tinytext COMMENT '铭牌',
  `other_file_pdf` tinytext COMMENT '其他材料附件',
  `other_apply_note` tinytext COMMENT '申请说明事项',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `cancel_reason` tinytext COMMENT '撤销理由',
  `bank_commit_datetime` datetime DEFAULT NULL COMMENT '银行提交时间',
  `bank_commit_note` tinytext COMMENT '银行提交说明',
  `bank_fk_amount` bigint(20) DEFAULT NULL COMMENT '银行放款金额',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '银行放款时间',
  `bank_receipt_code` varchar(32) DEFAULT NULL COMMENT '收款银行',
  `bank_receipt_number` varchar(32) DEFAULT NULL COMMENT '收款银行账号',
  `bank_receipt_pdf` tinytext COMMENT '收款凭证',
  `bank_receipt_note` text COMMENT '收款说明',
  `pledge_commit_datetime` datetime DEFAULT NULL COMMENT '抵押提交时间',
  `pledge_commit_note` tinytext COMMENT '抵押提交说明',
  `pledge_contract_code` varchar(32) DEFAULT NULL COMMENT '抵押合同编号',
  `insurance_company_code` tinytext COMMENT '保险公司编号',
  `car_color` tinytext COMMENT '车辆颜色',
  `car_brand` tinytext COMMENT '车辆品牌',
  `frame_no` varchar(32) DEFAULT NULL COMMENT '车架号码',
  `engine_no` varchar(32) DEFAULT NULL COMMENT '发动机号码',
  `commerce_insurance` bigint(20) DEFAULT NULL COMMENT '商业险合计',
  `insurance_effect_datetime` datetime DEFAULT NULL COMMENT '保险生效日期',
  `insurance_bank` tinytext COMMENT '保险经办银行',
  `guarantee_contract_code` varchar(32) DEFAULT NULL COMMENT '担保合同编号',
  `reg_certificate_code` varchar(32) DEFAULT NULL COMMENT '登记证书号',
  `other_contact` tinytext COMMENT '其他联系人',
  `contact_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
  `guarantor_name` varchar(32) DEFAULT NULL COMMENT '担保人姓名',
  `guarantor_mobile` varchar(16) DEFAULT NULL COMMENT '担保人手机',
  `bank_card_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `bill_datetime` int(11) DEFAULT NULL COMMENT '对账单日',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '月还款额',
  `repay_bank_date` int(11) DEFAULT NULL COMMENT '银行还款日',
  `repay_first_month_amount` bigint(20) DEFAULT NULL COMMENT '首期还款金额',
  `repay_first_month_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `repay_month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `id_no_pic` varchar(32) DEFAULT NULL COMMENT '身份证照片',
  `file_list` tinytext COMMENT '已入档清单',
  `is_complete` varchar(4) DEFAULT NULL COMMENT '资料是否完善',
  `store_place` tinytext COMMENT '存放位置',
  `file_remark` tinytext COMMENT '入档备注',
  `operator` tinytext COMMENT '经办人',
  `operate_datetime` datetime DEFAULT NULL COMMENT '经办日期',
  `operate_department` tinytext COMMENT '经办部门',
  `makecard_remark` tinytext COMMENT '制卡备注',
  `delivery_datetime` datetime DEFAULT NULL COMMENT '提车日期',
  `is_right_invoice` varchar(4) DEFAULT NULL COMMENT '发票是否正确',
  `current_invoice_price` bigint(20) DEFAULT NULL COMMENT '现发票价',
  `invoice` tinytext COMMENT '发票',
  `certification` tinytext COMMENT '合格证',
  `force_insurance` bigint(20) DEFAULT NULL COMMENT '交强险',
  `business_insurance` bigint(20) DEFAULT NULL COMMENT '商业险',
  `motor_reg_certification` tinytext COMMENT '机动车登记证书',
  `pd_pdf` tinytext COMMENT '批单',
  `fbh_remark` tinytext COMMENT '发保合备注',
  `fbh_warn_day` int(11) DEFAULT NULL COMMENT '发保合预警天数',
  `fbh_status` varchar(4) DEFAULT NULL COMMENT '发保合状态',
  `should_back_amount` bigint(20) DEFAULT NULL COMMENT '应退按揭款',
  `should_back_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `should_back_bankcard_code` varchar(32) DEFAULT NULL COMMENT '付款银行',
  `should_back_status` varchar(4) DEFAULT NULL COMMENT '付款账号',
  `should_back_bill_pdf` tinytext COMMENT '付款凭证',
  `zf_apply_datetime` datetime DEFAULT NULL COMMENT '申请日期',
  `zf_reason` tinytext COMMENT '作废原因',
  `zf_sk_amount` bigint(20) DEFAULT NULL COMMENT '收款金额',
  `zf_sk_bankcard_code` varchar(32) DEFAULT NULL COMMENT '收款账号',
  `zf_sk_receipt_datetime` datetime DEFAULT NULL COMMENT '收款时间',
  `zf_finance_remark` tinytext COMMENT '财务备注',
  `make_card_status` varchar(4) DEFAULT NULL COMMENT '制卡状态',
  `make_card_operator` tinytext COMMENT '制卡更新人',
  `make_card_remark` tinytext COMMENT '制卡备注',
  `frozen_status` varchar(4) DEFAULT NULL COMMENT '冻结状态(0冻结 1正常)',
  `cancel_node_code` varchar(32) DEFAULT NULL COMMENT '客户申请作废时的节点编号',
  `is_submit_cancel` varchar(32) DEFAULT NULL COMMENT '是否提交作废申请',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `insurance_remind_count` int(11) DEFAULT NULL COMMENT '续保提醒次数',
  `insurance_apply_datetime` datetime DEFAULT NULL COMMENT '投保时间',
  `insurance_end_datetime` datetime DEFAULT NULL COMMENT '到期日期',
  `insurance_force_pdf` text COMMENT '交强险保单',
  `insurance_business_pdf` text COMMENT '商业险保单',
  `insurance_note` varchar(255) DEFAULT NULL COMMENT '续保说明',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_budget_order_fee`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order_fee`;
CREATE TABLE `tdq_budget_order_fee` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `effect` char(1) DEFAULT NULL COMMENT '1有效 0 失效',
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

-- ----------------------------
--  Table structure for `tdq_budget_order_fee_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order_fee_detail`;
CREATE TABLE `tdq_budget_order_fee_detail` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `remit_type` varchar(32) NOT NULL COMMENT '交款类型',
  `plat_bankcard` varchar(32) DEFAULT NULL COMMENT '平台账号',
  `remit_project` varchar(255) DEFAULT NULL COMMENT '交款项目',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `remit_user` varchar(255) DEFAULT NULL COMMENT '汇款人',
  `reach_datetime` datetime DEFAULT NULL COMMENT '到账时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  `fee_code` varchar(32) NOT NULL COMMENT '手续费编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_budget_order_gps`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_budget_order_gps`;
CREATE TABLE `tdq_budget_order_gps` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `gps_dev_no` varchar(32) DEFAULT NULL COMMENT 'gps设备号',
  `gps_type` varchar(32) DEFAULT NULL COMMENT 'gps类型',
  `az_location` varchar(32) DEFAULT NULL COMMENT '安装位置',
  `az_datetime` datetime DEFAULT NULL COMMENT '安装时间',
  `az_user` varchar(255) DEFAULT NULL COMMENT '安装人员',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(1 使用中 0 已作废)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `budget_order` varchar(32) NOT NULL COMMENT '预算单编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdq_credit`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_credit`;
CREATE TABLE `tdq_credit` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `sale_user_id` varchar(32) DEFAULT NULL COMMENT '业务员编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `loan_bank_code` varchar(32) DEFAULT NULL COMMENT '贷款银行编号',
  `shop_way` varchar(32) DEFAULT NULL COMMENT '购车途径',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `xsz_front` varchar(255) DEFAULT NULL COMMENT '行驶证正面',
  `xsz_reverse` varchar(255) DEFAULT NULL COMMENT '行驶证反面',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点编号',
  `accessory` varchar(255) DEFAULT NULL COMMENT '附件',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征信表';

-- ----------------------------
--  Table structure for `tdq_credit_user`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_credit_user`;
CREATE TABLE `tdq_credit_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '征信单编号',
  `loan_role` varchar(255) DEFAULT NULL COMMENT '贷款角色',
  `user_name` varchar(255) DEFAULT NULL COMMENT '贷款人姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与借款人关系',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `id_no` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `dkdy_count` int(11) DEFAULT NULL COMMENT '贷款抵押笔数',
  `dkdy_amount` bigint(20) DEFAULT NULL COMMENT '贷款抵押贷款余额',
  `dkdy_2year_over_times` int(11) DEFAULT NULL COMMENT '贷款抵押近两年逾期次数',
  `dkdy_max_over_amount` bigint(20) DEFAULT NULL COMMENT '贷款抵押最高逾期金额',
  `dkdy_current_over_amount` bigint(20) DEFAULT NULL COMMENT '贷款抵押当前逾期金额',
  `dkdy_6month_avg_amount` bigint(20) DEFAULT NULL COMMENT '贷款抵押近6个月平均月还',
  `hkxy_unsettle_count` int(11) DEFAULT NULL COMMENT '贷款信用未结清贷款笔数',
  `hkxy_unsettle_amount` bigint(20) DEFAULT NULL COMMENT '贷款信用未结清贷款余额',
  `hkxy_2year_over_times` int(11) DEFAULT NULL COMMENT '贷款信用近两年逾期次数',
  `hkxy_month_max_over_amount` bigint(20) DEFAULT NULL COMMENT '贷款信用单月最高逾期金额',
  `hkxy_current_over_amount` bigint(20) DEFAULT NULL COMMENT '贷款信用当前逾期金额',
  `hkxy_6month_avg_amount` bigint(20) DEFAULT NULL COMMENT '贷款信用近6个月平均月还',
  `xyk_count` int(11) DEFAULT NULL COMMENT '信用卡张数',
  `xyk_credit_amount` bigint(20) DEFAULT NULL COMMENT '信用卡授信总额',
  `xyk_6month_use_amount` bigint(20) DEFAULT NULL COMMENT '信用卡近6个月使用额',
  `xyk_2year_over_times` int(11) DEFAULT NULL COMMENT '信用卡近两年逾期次数',
  `xyk_month_max_over_amount` bigint(20) DEFAULT NULL COMMENT '信用卡单月最高逾期金额',
  `xyk_current_over_amount` bigint(20) DEFAULT NULL COMMENT '信用卡当前逾期金额',
  `out_guarantees_count` int(11) DEFAULT NULL COMMENT '对外担保笔数',
  `out_guarantees_amount` bigint(20) DEFAULT NULL COMMENT '对外担保余额',
  `out_guarantees_remark` varchar(255) DEFAULT NULL COMMENT '对外担保备注',
  `auth_pdf` varchar(255) DEFAULT NULL COMMENT '征信查询授权书',
  `interview_pic` varchar(255) DEFAULT NULL COMMENT '面签照片',
  `month_income` bigint(20) DEFAULT NULL COMMENT '月收入',
  `settle_interest` decimal(18,8) DEFAULT NULL COMMENT '结息',
  `balance` bigint(20) DEFAULT NULL COMMENT '余额',
  `jour_show_income` char(1) DEFAULT NULL COMMENT '流水是否体现月收入',
  `is_print` char(1) DEFAULT NULL COMMENT '是否打件',
  `id_no_front` varchar(255) DEFAULT NULL COMMENT '身份证正面',
  `id_no_reverse` varchar(255) DEFAULT NULL COMMENT '身份证反面',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征信人员表';

-- ----------------------------
--  Table structure for `tdq_logistics`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `tdq_req_budget`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `tdq_total_advance_fund`
-- ----------------------------
DROP TABLE IF EXISTS `tdq_total_advance_fund`;
CREATE TABLE `tdq_total_advance_fund` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1第一次打款2发票不匹配补打款3发票不匹配收回款)',
  `company_code` varchar(32) DEFAULT NULL COMMENT '业务公司编号',
  `total_advance_fund` bigint(20) DEFAULT NULL COMMENT '垫资总金额',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '付款金额',
  `make_bill_note` varchar(255) DEFAULT NULL COMMENT '制单意见说明',
  `pay_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_bankcard_code` varchar(32) DEFAULT NULL COMMENT '付款账号编号',
  `bill_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证（水单）',
  `pay_note` varchar(255) DEFAULT NULL COMMENT '付款意见说明',
  `collection_amount` bigint(20) DEFAULT NULL COMMENT '收款金额',
  `collection_datetime` datetime DEFAULT NULL COMMENT '收款时间',
  `collection_bankcard_code` varchar(32) DEFAULT NULL COMMENT '收款银行（收款账号编号）',
  `collection_bill_pdf` varchar(255) DEFAULT NULL COMMENT '收款凭证（水单）',
  `collection_note` varchar(255) DEFAULT NULL COMMENT '收款意见说明',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态（0待打款给分公司 1已打款给分公司）',
  PRIMARY KEY (`code`) COMMENT '垫资汇总表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tdqt_repoint`
-- ----------------------------
DROP TABLE IF EXISTS `tdqt_repoint`;
CREATE TABLE `tdqt_repoint` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `effect` char(1) DEFAULT NULL COMMENT '1有效 0 失效',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '汽车经销商编号',
  `bankcard_code` varchar(32) DEFAULT NULL COMMENT '收款账号编号',
  `total_amount` bigint(20) DEFAULT NULL COMMENT '总金额',
  `reason` varchar(255) DEFAULT NULL COMMENT '缘由',
  `company_code` varchar(32) DEFAULT NULL COMMENT '申请公司编号',
  `apply_user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `pay_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_bankcard_code` varchar(32) DEFAULT NULL COMMENT '付款账号编号',
  `bill_pdf` varchar(255) DEFAULT NULL COMMENT '水单',
  `pay_remark` varchar(255) DEFAULT NULL COMMENT '付款备注',
  `settle_type` varchar(255) DEFAULT NULL COMMENT '结算方式',
  `cur_node_code` varchar(255) DEFAULT NULL COMMENT '节点（0待打款1已打款）',
  PRIMARY KEY (`code`) COMMENT '返点表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='返点表';

-- ----------------------------
--  Table structure for `tdqt_repoint_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tdqt_repoint_detail`;
CREATE TABLE `tdqt_repoint_detail` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `budget_code` varchar(32) NOT NULL COMMENT '预算单编号',
  `repoint_code` varchar(32) DEFAULT NULL COMMENT '返点编号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `car_dealer_code` varchar(255) DEFAULT NULL COMMENT '汽车经销商编号',
  `company_code` varchar(45) DEFAULT NULL COMMENT '业务公司编号',
  `car_type` varchar(32) DEFAULT NULL COMMENT '车辆型号',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行实际利率',
  `benchmark_rate` decimal(18,8) DEFAULT NULL COMMENT '基准利率',
  `fee` bigint(20) DEFAULT NULL COMMENT '服务费',
  `use_money_purpose` varchar(255) DEFAULT NULL COMMENT '用款用途（1应退按揭款2协议内返点3协议外返点）',
  `repoint_amount` bigint(20) DEFAULT NULL COMMENT '返点金额（退按揭款金额）',
  `account_code` varchar(32) DEFAULT NULL COMMENT '账号编号（公司或车行的收款账号编号）',
  `mortgage_account_no` varchar(45) DEFAULT NULL COMMENT '收款账号（用于客户不垫资，手动输入的应退按揭款的收款账号 ）',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '节点(0待制单1已制单待打款2已打款)',
  `type` VARCHAR(4) DEFAULT NULL COMMENT '类型（1正常数据2发票不匹配产生的新数据）',
  PRIMARY KEY (`code`) COMMENT '返点明细表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='返点明细表（用款用途）';

-- ----------------------------
--  Table structure for `tht_brand`
-- ----------------------------
DROP TABLE IF EXISTS `tht_brand`;
CREATE TABLE `tht_brand` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `letter` varchar(32) DEFAULT NULL COMMENT '字母序号',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `description` text COMMENT '品牌介绍',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '品牌'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tht_car`
-- ----------------------------
DROP TABLE IF EXISTS `tht_car`;
CREATE TABLE `tht_car` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `series_code` varchar(32) DEFAULT NULL COMMENT '车系编号',
  `series_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `original_price` bigint(32) DEFAULT NULL COMMENT '原价',
  `sale_price` bigint(32) DEFAULT NULL COMMENT '参考价',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `location` int(11) DEFAULT NULL COMMENT 'UI位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'UI次序',
  `slogan` text COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `pic` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `description` text COMMENT '图文描述',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '车型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tht_car_order`
-- ----------------------------
DROP TABLE IF EXISTS `tht_car_order`;
CREATE TABLE `tht_car_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `user_mobile` varchar(16) DEFAULT NULL COMMENT '申请人手机号',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `series_code` varchar(32) DEFAULT NULL COMMENT '车系编号',
  `series_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `car_code` varchar(32) DEFAULT NULL COMMENT '车型编号',
  `car_name` varchar(255) DEFAULT NULL COMMENT '车型名称',
  `price` bigint(20) DEFAULT NULL COMMENT '车辆总价',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `periods` int(11) DEFAULT NULL COMMENT '分期期数',
  `create_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `sale_desc` text COMMENT '计算器信息',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `handler` varchar(32) DEFAULT NULL COMMENT '处理人',
  `handle_datetime` datetime DEFAULT NULL COMMENT '处理时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '购车意向'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tht_series`
-- ----------------------------
DROP TABLE IF EXISTS `tht_series`;
CREATE TABLE `tht_series` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `brand_code` varchar(32) DEFAULT NULL COMMENT '品牌编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `slogan` text COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `price` bigint(20) DEFAULT NULL COMMENT '价格区间',
  `location` int(11) DEFAULT NULL COMMENT 'UI位置',
  `order_no` int(11) DEFAULT NULL COMMENT 'UI次序',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最新修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最新修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '车系'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_category`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_category`;
CREATE TABLE `tmall_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父节点',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`code`) COMMENT '分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_order`;
CREATE TABLE `tmall_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `bankcard_code` varchar(32) DEFAULT NULL COMMENT '银行卡编号',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收件人姓名',
  `re_mobile` varchar(32) DEFAULT NULL COMMENT '收件人电话',
  `re_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '下单人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '下单嘱咐',
  `apply_datetime` datetime DEFAULT NULL COMMENT '下单时间',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `yunfei` bigint(20) DEFAULT NULL COMMENT '运费',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(32) DEFAULT NULL COMMENT '支付编号',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '支付金额',
  `deliverer` varchar(32) DEFAULT NULL COMMENT '发货人',
  `delivery_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `logistics_company` varchar(32) DEFAULT NULL COMMENT '物流公司编号',
  `logistics_code` varchar(32) DEFAULT NULL COMMENT '物流单号',
  `pdf` varchar(255) DEFAULT NULL COMMENT '物流单',
  `signer` varchar(32) DEFAULT NULL COMMENT '签收人',
  `sign_datetime` datetime DEFAULT NULL COMMENT '签收时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_product`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product`;
CREATE TABLE `tmall_product` (
  `code` varchar(32) NOT NULL COMMENT '商品编号',
  `category` varchar(32) DEFAULT NULL COMMENT '大类',
  `type` varchar(32) DEFAULT NULL COMMENT '小类',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `slogan` varchar(255) DEFAULT NULL COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `sale_status` varchar(255) DEFAULT NULL COMMENT '销售状态',
  `pic` text COMMENT 'pic',
  `description` text COMMENT '图文描述',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `price` bigint(20) DEFAULT NULL COMMENT '价格（人民币）',
  `credit_score` bigint(20) DEFAULT NULL COMMENT '最低购买信用分',
  `location` varchar(32) DEFAULT NULL COMMENT '位置(0 普通 1 热门)',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `status` varchar(4) DEFAULT NULL COMMENT '产品状态',
  `bought_count` int(11) DEFAULT NULL COMMENT '已购买数量',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '产品'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_product_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product_order`;
CREATE TABLE `tmall_product_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `order_code` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `product_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `product_specs_code` varchar(32) DEFAULT NULL COMMENT '商品参数编号',
  `product_specs_name` varchar(32) DEFAULT NULL COMMENT '商品参数名称',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` bigint(20) DEFAULT NULL COMMENT '价格',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tmall_product_specs`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product_specs`;
CREATE TABLE `tmall_product_specs` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '规格名称',
  `pic` text COMMENT 'pic',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `price` bigint(20) DEFAULT NULL COMMENT '价格（人民币）',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `quantity` int(11) DEFAULT NULL COMMENT '库存',
  `province` varchar(255) DEFAULT NULL COMMENT '发货地,精确到省份',
  `weight` decimal(18,8) DEFAULT NULL COMMENT '重量',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tp_archive`
-- ----------------------------
DROP TABLE IF EXISTS `tp_archive`;
CREATE TABLE `tp_archive` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `id_no` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `job_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `post_code` varchar(32) DEFAULT NULL COMMENT '职务岗位编号',
  `job_classes` varchar(32) DEFAULT NULL COMMENT '上班班次',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `politics` varchar(32) DEFAULT NULL COMMENT '政治面貌',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `education` varchar(32) DEFAULT NULL COMMENT '学历',
  `work_status` varchar(32) DEFAULT NULL COMMENT '状态',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `salary_card` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `five_insurance_info` varchar(255) DEFAULT NULL COMMENT '五险一金信息',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍地址',
  `residence_property` varchar(32) DEFAULT NULL COMMENT '户籍性质',
  `social_security_reg_datetime` datetime DEFAULT NULL COMMENT '社保登记日期',
  `current_address` varchar(255) DEFAULT NULL COMMENT '现住址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(11) DEFAULT NULL COMMENT '紧急联系号码',
  `contract_deadline` varchar(32) DEFAULT NULL COMMENT '合同期限',
  `contract_type` varchar(32) DEFAULT NULL COMMENT '合同类型',
  `probation_time` varchar(32) DEFAULT NULL COMMENT '试用期时间',
  `convert_datetime` datetime DEFAULT NULL COMMENT '转正日期',
  `leave_datetime` datetime DEFAULT NULL COMMENT '离职日期',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职缘由',
  `heir_people` varchar(255) DEFAULT NULL COMMENT '交接人',
  `entrance_no` varchar(32) DEFAULT NULL COMMENT '门禁号',
  `check_no` varchar(32) DEFAULT NULL COMMENT '考勤号',
  `car_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `id_no_pdf` varchar(255) DEFAULT NULL COMMENT '身份证复印件',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `wechat` varchar(32) DEFAULT NULL COMMENT '微信',
  `qq` varchar(32) DEFAULT NULL COMMENT 'QQ',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `commumication_fee_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `no_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_award` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_award` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_ward` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_award` bigint(20) DEFAULT NULL COMMENT '餐补',
  `working_years` varchar(32) DEFAULT NULL COMMENT '工龄',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人事档案';

-- ----------------------------
--  Table structure for `tp_archive_location`
-- ----------------------------
DROP TABLE IF EXISTS `tp_archive_location`;
CREATE TABLE `tp_archive_location` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '位置名称',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案存放位置';

-- ----------------------------
--  Table structure for `tp_ask_for_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_ask_for_apply`;
CREATE TABLE `tp_ask_for_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `lead_user_id` varchar(255) DEFAULT NULL COMMENT '请示领导',
  `content` varchar(255) DEFAULT NULL COMMENT '请示内容',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领导请示申请';

-- ----------------------------
--  Table structure for `tp_assert_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_assert_apply`;
CREATE TABLE `tp_assert_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT NULL COMMENT '类型(1=办公 2=固定资产)',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `is_print` char(1) DEFAULT NULL COMMENT '是否印刷品（1是 2不是）',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公用品/固定资产';

-- ----------------------------
--  Table structure for `tp_assert_goods`
-- ----------------------------
DROP TABLE IF EXISTS `tp_assert_goods`;
CREATE TABLE `tp_assert_goods` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `assert_code` varchar(32) DEFAULT NULL COMMENT '办公用品编号',
  `product_code` varchar(45) DEFAULT NULL COMMENT '品名',
  `mode` varchar(255) DEFAULT NULL COMMENT '规格',
  `quantity` varchar(32) DEFAULT NULL COMMENT '申请数量',
  `price` bigint(20) DEFAULT NULL COMMENT '出库价格',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公物品列表';

-- ----------------------------
--  Table structure for `tp_assert_user`
-- ----------------------------
DROP TABLE IF EXISTS `tp_assert_user`;
CREATE TABLE `tp_assert_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `assert_code` varchar(32) DEFAULT NULL COMMENT '办公用品编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `print_quantity` varchar(32) DEFAULT NULL COMMENT '印刷数量',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公用户列表';

-- ----------------------------
--  Table structure for `tp_car_break`
-- ----------------------------
DROP TABLE IF EXISTS `tp_car_break`;
CREATE TABLE `tp_car_break` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '违章人编号',
  `car_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `happen_datetime` datetime DEFAULT NULL COMMENT '违章时间',
  `address` varchar(255) DEFAULT NULL COMMENT '违章地点',
  `action` varchar(255) DEFAULT NULL COMMENT '违章行为',
  `score` int(11) DEFAULT NULL COMMENT '记分',
  `punish_amount` decimal(18,8) DEFAULT NULL COMMENT '罚款金额',
  `handle_note` varchar(255) DEFAULT NULL COMMENT '处理情况',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆违章处理';

-- ----------------------------
--  Table structure for `tp_check_project`
-- ----------------------------
DROP TABLE IF EXISTS `tp_check_project`;
CREATE TABLE `tp_check_project` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `check_result` varchar(255) DEFAULT NULL COMMENT '考核指标',
  `check_user` varchar(255) DEFAULT NULL COMMENT '考核人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `employ_apply_code` varchar(32) NOT NULL COMMENT '应聘岗位编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考核项目';

-- ----------------------------
--  Table structure for `tp_comp_category`
-- ----------------------------
DROP TABLE IF EXISTS `tp_comp_category`;
CREATE TABLE `tp_comp_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类别管理';

-- ----------------------------
--  Table structure for `tp_comp_product`
-- ----------------------------
DROP TABLE IF EXISTS `tp_comp_product`;
CREATE TABLE `tp_comp_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `name` varchar(255) DEFAULT NULL COMMENT '品名',
  `model` varchar(255) DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品名管理';

-- ----------------------------
--  Table structure for `tp_comp_regime`
-- ----------------------------
DROP TABLE IF EXISTS `tp_comp_regime`;
CREATE TABLE `tp_comp_regime` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1行政事务类 2 人力资源管理类 3 财务管理类 4 营销管理类 5 生产管理类)',
  `regime_code` varchar(32) DEFAULT NULL COMMENT '制度编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `scope` varchar(32) DEFAULT NULL COMMENT '授权查看范围',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司制度';

-- ----------------------------
--  Table structure for `tp_contract`
-- ----------------------------
DROP TABLE IF EXISTS `tp_contract`;
CREATE TABLE `tp_contract` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(255) DEFAULT NULL COMMENT '合同类型',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `archive_code` varchar(32) DEFAULT NULL COMMENT '档案编号',
  `contract_no` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始日期',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束日期',
  `pdf` varchar(255) DEFAULT NULL COMMENT '合同附件',
  `remark` varchar(255) DEFAULT NULL COMMENT '说明',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除 1正常',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tp_convert_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_convert_apply`;
CREATE TABLE `tp_convert_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `entry_code` varchar(32) DEFAULT NULL COMMENT '入职编号',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `work_summary` varchar(255) DEFAULT NULL COMMENT '工作总结',
  `all_evaluation` varchar(255) DEFAULT NULL COMMENT '总体评价',
  `is_full_worker` varchar(4) DEFAULT NULL COMMENT '是否转正',
  `effect_datetime` datetime DEFAULT NULL COMMENT '生效日期',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='转正申请';

-- ----------------------------
--  Table structure for `tp_day_rest`
-- ----------------------------
DROP TABLE IF EXISTS `tp_day_rest`;
CREATE TABLE `tp_day_rest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `is_rest` varchar(4) DEFAULT NULL COMMENT '是否休息',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='休息日记录';

-- ----------------------------
--  Table structure for `tp_employ_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_employ_apply`;
CREATE TABLE `tp_employ_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `position` varchar(255) DEFAULT NULL COMMENT '应聘岗位',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `contact_mobile` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `speciality` varchar(255) DEFAULT NULL COMMENT '特长技能',
  `expect_salary` bigint(20) DEFAULT NULL COMMENT '期望薪资',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(255) DEFAULT NULL COMMENT '紧急联系号码',
  `postcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `award` varchar(255) DEFAULT NULL COMMENT '受过何种奖励或专业训练',
  `is_out` char(1) DEFAULT NULL COMMENT '能否出差',
  `is_over_time` char(1) DEFAULT NULL COMMENT '能否加班',
  `is_adjust_work` char(1) DEFAULT NULL COMMENT '能否接受工作调动',
  `is_once_recruited` char(1) DEFAULT NULL COMMENT '是否曾在我公司应聘',
  `is_friend_work` char(1) DEFAULT NULL COMMENT '是否有亲属或朋友在我司工作',
  `composite` varchar(255) DEFAULT NULL COMMENT '综合',
  `quality` varchar(255) DEFAULT NULL COMMENT '素质',
  `interview_record` varchar(255) DEFAULT NULL COMMENT '面试记录',
  `employ_result` varchar(255) DEFAULT NULL COMMENT '录用结果',
  `probation` varchar(255) DEFAULT NULL COMMENT '试用期',
  `employ_salary` bigint(20) DEFAULT NULL COMMENT '薪资',
  `employ_department_code` varchar(255) DEFAULT NULL COMMENT '入职部门',
  `employ_position_code` varchar(255) DEFAULT NULL COMMENT '入职职务',
  `employ_approve_user` varchar(255) DEFAULT NULL COMMENT '审核人',
  `employ_approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `employ_approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=待面试 1=已面试通过 2已面试不通过)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应聘岗位';

-- ----------------------------
--  Table structure for `tp_entry_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_entry_apply`;
CREATE TABLE `tp_entry_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `position` varchar(255) DEFAULT NULL COMMENT '入职岗位',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(4) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(32) DEFAULT NULL COMMENT '紧急联系号码',
  `residence_property` varchar(255) DEFAULT NULL COMMENT '户籍性质',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `is_other_company_relation` varchar(32) DEFAULT NULL COMMENT '是否与其他单位存在劳动关系',
  `relative_name` varchar(255) DEFAULT NULL COMMENT '亲属从事本行姓名',
  `relative_relation` varchar(255) DEFAULT NULL COMMENT '亲属与本人关系',
  `relative_position` varchar(255) DEFAULT NULL COMMENT '亲属职务',
  `main_perform` varchar(255) DEFAULT NULL COMMENT '主要业绩及工作能力简述',
  `probation_start_datetime` datetime DEFAULT NULL COMMENT '试用期期限开始',
  `probation_end_datetime` datetime DEFAULT NULL COMMENT '试用期期限结束',
  `probation_salary` bigint(20) DEFAULT NULL COMMENT '试用期工资',
  `base_salary` bigint(20) DEFAULT NULL COMMENT '转正后基本工资',
  `perform_salary` bigint(20) DEFAULT NULL COMMENT '转正后绩效工资',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `communicate_pay_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `non_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_standard` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_standard` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_standard` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_standard` bigint(20) DEFAULT NULL COMMENT '餐补',
  `salary_card_no` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '开户行行号',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入职申请';

-- ----------------------------
--  Table structure for `tp_fee_advance_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_fee_advance_apply`;
CREATE TABLE `tp_fee_advance_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `ref_assert_code` varchar(32) DEFAULT NULL COMMENT '关联资产审批编号',
  `ref_budget_order_code` varchar(32) DEFAULT NULL COMMENT '关联车贷业务编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '预支金额',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户银行',
  `bankcard_number` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `account_name` varchar(255) DEFAULT NULL COMMENT '账户名',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `pay_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_bank` varchar(32) DEFAULT NULL COMMENT '付款银行',
  `pay_bankcard` varchar(255) DEFAULT NULL COMMENT '付款账号',
  `pay_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=待审核 1=审核通过 2=审核不通过 3=财务审核通过 4=财务审核不通过 5=确认放款)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='费用预支申请';

-- ----------------------------
--  Table structure for `tp_leave_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_leave_apply`;
CREATE TABLE `tp_leave_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `type` varchar(4) DEFAULT NULL COMMENT '请假类别',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` int(11) DEFAULT NULL COMMENT '时长',
  `pdf` varchar(32) DEFAULT NULL COMMENT '附件',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假申请';

-- ----------------------------
--  Table structure for `tp_notice`
-- ----------------------------
DROP TABLE IF EXISTS `tp_notice`;
CREATE TABLE `tp_notice` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 公司动态 2 公司文件 3 培训说明)',
  `title` varchar(255) NOT NULL COMMENT '公告标题',
  `urgent_status` varchar(4) NOT NULL COMMENT '紧急程度（1 普通 2 紧急）',
  `publish_department_code` varchar(32) NOT NULL COMMENT '发布部门',
  `scope` varchar(32) DEFAULT NULL COMMENT '公告范围',
  `content` varchar(255) NOT NULL COMMENT '公告内容',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告管理';

-- ----------------------------
--  Table structure for `tp_notice_read`
-- ----------------------------
DROP TABLE IF EXISTS `tp_notice_read`;
CREATE TABLE `tp_notice_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=未读，1=已读)',
  `notice_code` varchar(32) DEFAULT NULL COMMENT '公告编号',
  `ref_type` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告阅读记录';

-- ----------------------------
--  Table structure for `tp_overtime_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_overtime_apply`;
CREATE TABLE `tp_overtime_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加班申请';

-- ----------------------------
--  Table structure for `tp_probation_assess`
-- ----------------------------
DROP TABLE IF EXISTS `tp_probation_assess`;
CREATE TABLE `tp_probation_assess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `convert_code` varchar(32) DEFAULT NULL COMMENT '转正申请编号',
  `eval_item` varchar(255) DEFAULT NULL COMMENT '评估项目',
  `grade` decimal(18,8) DEFAULT NULL COMMENT '评估分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试用期评估';

-- ----------------------------
--  Table structure for `tp_recruit_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_recruit_apply`;
CREATE TABLE `tp_recruit_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `department_code` varchar(32) DEFAULT NULL COMMENT '申请部门编号',
  `position` varchar(255) DEFAULT NULL COMMENT '招聘岗位',
  `establish_quantity` int(11) DEFAULT NULL COMMENT '编制人数',
  `now_quantity` int(11) DEFAULT NULL COMMENT '现有人数',
  `apply_quantity` int(11) DEFAULT NULL COMMENT '申请补充人数',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `require_datetime` datetime DEFAULT NULL COMMENT '需要到岗时间',
  `replace_position` varchar(255) DEFAULT NULL COMMENT '被替代职位',
  `replace_real_name` varchar(255) DEFAULT NULL COMMENT '被替代者姓名',
  `new_apply_reason` varchar(255) DEFAULT NULL COMMENT '新申请职位原因',
  `position_now_quantity` int(11) DEFAULT NULL COMMENT '该职位现有人数',
  `position_add_reason` varchar(255) DEFAULT NULL COMMENT '该职位增加原因',
  `temp_start_datetime` datetime DEFAULT NULL COMMENT '临时聘用开始时间',
  `temp_end_datetime` datetime DEFAULT NULL COMMENT '临时聘用结束时间',
  `note` varchar(255) DEFAULT NULL COMMENT '说明',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `marry_state` varchar(255) DEFAULT NULL COMMENT '婚育情况',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `major_require` varchar(255) DEFAULT NULL COMMENT '专业资格',
  `ability_require` varchar(255) DEFAULT NULL COMMENT '能力要求',
  `experience` varchar(255) DEFAULT NULL COMMENT '相关工作经验',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用人申请';

-- ----------------------------
--  Table structure for `tp_scope_people`
-- ----------------------------
DROP TABLE IF EXISTS `tp_scope_people`;
CREATE TABLE `tp_scope_people` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `type` varchar(32) NOT NULL COMMENT '类型(所有人员=-1,分公司=1，部门=2,职位=3，具体人=4)',
  `people_code` varchar(32) DEFAULT NULL COMMENT '具体类型人员编号',
  `ref_code` varchar(32) DEFAULT NULL COMMENT '参考编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告或制度人员范围';

-- ----------------------------
--  Table structure for `tp_social_relation`
-- ----------------------------
DROP TABLE IF EXISTS `tp_social_relation`;
CREATE TABLE `tp_social_relation` (
  `code` varchar(32) NOT NULL,
  `archive_code` varchar(32) DEFAULT NULL COMMENT '人事档案编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '成员姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与本人关系',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `post` varchar(255) DEFAULT NULL COMMENT '担任职务',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除1正常',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社会关系';

-- ----------------------------
--  Table structure for `tp_storage_in`
-- ----------------------------
DROP TABLE IF EXISTS `tp_storage_in`;
CREATE TABLE `tp_storage_in` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `valid_date_start` datetime DEFAULT NULL COMMENT '有效期起',
  `valid_date_end` datetime DEFAULT NULL COMMENT '有效期止',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入库管理';

-- ----------------------------
--  Table structure for `tp_storage_out`
-- ----------------------------
DROP TABLE IF EXISTS `tp_storage_out`;
CREATE TABLE `tp_storage_out` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `storage_in_code` varchar(32) DEFAULT NULL COMMENT '入库编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库管理';

-- ----------------------------
--  Table structure for `tp_supple_sign_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_supple_sign_apply`;
CREATE TABLE `tp_supple_sign_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请';

-- ----------------------------
--  Table structure for `tp_supple_sign_apply_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tp_supple_sign_apply_detail`;
CREATE TABLE `tp_supple_sign_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `supply_sign_apply_code` varchar(32) DEFAULT NULL COMMENT '补签申请编号',
  `supple_datetime` datetime DEFAULT NULL COMMENT '漏签日期',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请明细';

-- ----------------------------
--  Table structure for `tp_transfer_position_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_transfer_position_apply`;
CREATE TABLE `tp_transfer_position_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `new_department` varchar(255) DEFAULT NULL COMMENT '新部门',
  `new_position` varchar(255) DEFAULT NULL COMMENT '新岗位',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始日期',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束日期',
  `reason` varchar(255) DEFAULT NULL COMMENT '缘由',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调岗申请';

-- ----------------------------
--  Table structure for `tp_travel_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_travel_apply`;
CREATE TABLE `tp_travel_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型(1=出差,2=公出)',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差/公出申请';

-- ----------------------------
--  Table structure for `tp_travel_apply_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tp_travel_apply_detail`;
CREATE TABLE `tp_travel_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `travel_apply_code` varchar(32) DEFAULT NULL COMMENT '出差申请编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '时长',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时间申请明细';

-- ----------------------------
--  Table structure for `tp_welfare_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tp_welfare_apply`;
CREATE TABLE `tp_welfare_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='福利发放申请';

-- ----------------------------
--  Table structure for `tp_welfare_user`
-- ----------------------------
DROP TABLE IF EXISTS `tp_welfare_user`;
CREATE TABLE `tp_welfare_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `welfare_code` varchar(255) DEFAULT NULL COMMENT '福利编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='福利关联人员';

-- ----------------------------
--  Table structure for `tp_work_experience`
-- ----------------------------
DROP TABLE IF EXISTS `tp_work_experience`;
CREATE TABLE `tp_work_experience` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父级编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '起始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '截止时间',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职原因',
  `prover` varchar(255) DEFAULT NULL COMMENT '证明人',
  `prover_mobile` varchar(255) DEFAULT NULL COMMENT '证明人联系电话',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作经历';

-- ----------------------------
--  Table structure for `tstd_account`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_account`;
CREATE TABLE `tstd_account` (
  `account_number` varchar(32) NOT NULL DEFAULT '' COMMENT '账号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '真实姓名',
  `type` varchar(4) DEFAULT NULL COMMENT '类别（B端账号，C端账号，平台账号）',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（正常/程序冻结/人工冻结）',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '余额',
  `frozen_amount` decimal(64,0) DEFAULT NULL COMMENT '冻结金额',
  `md5` varchar(32) DEFAULT NULL COMMENT 'MD5',
  `add_amount` decimal(64,0) DEFAULT '0' COMMENT '累计增加金额',
  `in_amount` decimal(64,0) DEFAULT '0' COMMENT '入金',
  `out_amount` decimal(64,0) DEFAULT '0' COMMENT '出金',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `last_order` varchar(32) DEFAULT NULL COMMENT '最近一次变动对应的流水编号',
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_address`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_address`;
CREATE TABLE `tstd_address` (
  `code` varchar(32) NOT NULL COMMENT '收件编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `addressee` varchar(64) DEFAULT NULL COMMENT '收件人姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `area` varchar(64) DEFAULT NULL COMMENT '区',
  `detail` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `is_default` char(1) DEFAULT NULL COMMENT '是否默认地址',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `tstd_bankcard`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_bankcard`;
CREATE TABLE `tstd_bankcard` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `bind_mobile` varchar(32) DEFAULT NULL COMMENT '银行卡绑定手机号',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_channel_bank`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_channel_bank`;
CREATE TABLE `tstd_channel_bank` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `bank_name` varchar(32) DEFAULT NULL COMMENT '银行名称',
  `channel_type` varchar(4) DEFAULT NULL COMMENT '渠道类型',
  `status` varchar(4) DEFAULT NULL COMMENT '状态（启用/不启用）',
  `channel_bank` varchar(32) DEFAULT NULL COMMENT '渠道给银行的代号',
  `max_order` bigint(32) DEFAULT NULL COMMENT '笔数限制',
  `order_amount` bigint(32) DEFAULT NULL COMMENT '单笔限额',
  `day_amount` bigint(32) DEFAULT NULL COMMENT '每日限额',
  `month_amount` bigint(32) DEFAULT NULL COMMENT '每月限额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_charge`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_charge`;
CREATE TABLE `tstd_charge` (
  `code` varchar(32) NOT NULL COMMENT '针对编号',
  `pay_group` varchar(32) DEFAULT NULL COMMENT '支付组号',
  `ref_no` varchar(255) DEFAULT NULL COMMENT '流水分组组号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '针对账号',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '充值金额',
  `account_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '针对户名',
  `type` varchar(4) DEFAULT NULL COMMENT '账户类型',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `biz_type` varchar(32) DEFAULT NULL,
  `biz_note` varchar(255) DEFAULT NULL,
  `pay_card_info` varchar(255) DEFAULT NULL COMMENT '支付渠道账号信息',
  `pay_card_no` varchar(255) DEFAULT NULL COMMENT '支付渠道账号',
  `status` varchar(4) NOT NULL COMMENT '状态',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `pay_user` varchar(32) DEFAULT NULL COMMENT '支付回录人',
  `pay_note` varchar(255) DEFAULT NULL COMMENT '支付渠道说明',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道',
  PRIMARY KEY (`code`) COMMENT '充值订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_cnavigate`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_cnavigate`;
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

-- ----------------------------
--  Table structure for `tstd_jour`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_jour`;
CREATE TABLE `tstd_jour` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `kind` varchar(32) DEFAULT NULL COMMENT '流水类型（余额流水、冻结流水）',
  `pay_group` varchar(255) DEFAULT NULL COMMENT '订单分组组号',
  `ref_no` varchar(255) DEFAULT NULL COMMENT '参考订单号',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道类型',
  `channel_order` varchar(255) DEFAULT NULL COMMENT '支付渠道单号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '账号',
  `trans_amount` decimal(64,0) DEFAULT NULL COMMENT '变动金额',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '真实姓名',
  `type` varchar(4) DEFAULT NULL COMMENT '账户类型',
  `currency` varchar(8) DEFAULT NULL COMMENT '币种',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `biz_note` varchar(255) DEFAULT NULL COMMENT '业务类型',
  `pre_amount` decimal(64,0) DEFAULT NULL COMMENT '变动前金额',
  `post_amount` decimal(64,0) DEFAULT NULL COMMENT '变动后金额',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `work_date` varchar(8) DEFAULT NULL COMMENT '拟对账时间',
  `check_user` varchar(32) DEFAULT NULL COMMENT '对账人',
  `check_note` varchar(255) DEFAULT NULL COMMENT '对账说明',
  `check_datetime` datetime DEFAULT NULL COMMENT '对账时间',
  `adjust_user` varchar(32) DEFAULT NULL COMMENT '调账人',
  `adjust_note` varchar(255) DEFAULT NULL COMMENT '调账说明',
  `adjust_datetime` datetime DEFAULT NULL COMMENT '调账时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_user`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_user`;
CREATE TABLE `tstd_user` (
  `user_id` varchar(32) NOT NULL COMMENT '编号',
  `kind` varchar(4) DEFAULT NULL COMMENT '用户类型',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` varchar(4) DEFAULT NULL COMMENT '登录密码强度',
  `trade_pwd` varchar(32) DEFAULT NULL COMMENT '支付密码',
  `trade_pwd_strength` varchar(4) DEFAULT NULL COMMENT '支付密码强度',
  `user_referee` varchar(32) DEFAULT NULL COMMENT '推荐人编号',
  `referee_mobile` varchar(16) DEFAULT NULL COMMENT '推荐人手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` bigint(20) DEFAULT NULL COMMENT '证件号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) COMMENT '用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_withdraw`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_withdraw`;
CREATE TABLE `tstd_withdraw` (
  `code` varchar(32) NOT NULL COMMENT '针对编号',
  `account_number` varchar(32) DEFAULT NULL COMMENT '针对账号',
  `account_name` varchar(32) DEFAULT NULL COMMENT '针对户名',
  `type` varchar(4) DEFAULT NULL COMMENT '类别（B端账号，C端账号，平台账号）',
  `amount` decimal(64,0) DEFAULT NULL COMMENT '取现金额',
  `fee` decimal(64,0) DEFAULT NULL COMMENT '手续费',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '支付渠道',
  `channel_bank` varchar(32) DEFAULT NULL COMMENT '渠道银行代号',
  `channel_order` varchar(255) DEFAULT NULL COMMENT '支付渠道编号',
  `pay_card_info` varchar(255) DEFAULT NULL COMMENT '支付渠道账号信息',
  `pay_card_no` varchar(255) DEFAULT NULL COMMENT '支付渠道账号',
  `status` varchar(4) NOT NULL COMMENT '状态',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `approve_user` varchar(32) DEFAULT NULL COMMENT '审批人',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审批说明',
  `approve_datetime` varchar(32) DEFAULT NULL COMMENT '审批时间',
  `pay_user` varchar(255) DEFAULT NULL COMMENT '支付回录人',
  `pay_note` varchar(255) DEFAULT NULL COMMENT '支付回录说明',
  `pay_group` varchar(255) DEFAULT NULL COMMENT '支付组号',
  `pay_code` varchar(255) DEFAULT NULL COMMENT '支付渠道订单编号',
  `pay_fee` decimal(64,0) DEFAULT NULL COMMENT '支付渠道手续费（矿工费）',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付回录时间',
  PRIMARY KEY (`code`) COMMENT '取现订单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`) COMMENT '业务日志跟踪表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`code`) COMMENT '部门表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`code`) COMMENT '流程'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`) COMMENT '节点流程配置'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`) COMMENT '角色节点'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

SET FOREIGN_KEY_CHECKS = 1;
