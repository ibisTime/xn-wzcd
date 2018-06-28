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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清算成本';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='催收提醒表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款业务表'

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
  `repay_amount` BIGINT(20) DEFAULT NULL COMMENT '本期还款金额',
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
  `replace_real_repay_amount` bigint(20) DEFAULT NULL COMMENT '代偿实际金额',
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
