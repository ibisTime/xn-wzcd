DROP TABLE IF EXISTS `tdh_overdue_menu`;
CREATE TABLE `tdh_overdue_menu` (
  `code` varchar(32) NOT NULL COMMENT '编号',
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
  `month_datetime` int(11) DEFAULT NULL COMMENT '每期还款日期',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `ly_deposit` bigint(20) DEFAULT NULL COMMENT '履约保证金（可退）',
  `cut_ly_deposit` bigint(20) DEFAULT NULL COMMENT '扣除的履约保证金',
  `cur_node_code` varchar(32) DEFAULT NULL COMMENT '当前节点',
  
  `rest_amount` bigint(20) DEFAULT NULL COMMENT '剩余欠款',
  `rest_total_cost` bigint(20) DEFAULT NULL COMMENT '未还清收总成本',
  `overdue_total_deposit` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金总额',
  `overdue_total_deposit_income` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金总收入',
  `total_in_deposit` bigint(20) DEFAULT NULL COMMENT '额外保证金收入',
  
  `overdue_amount` bigint(20) DEFAULT NULL COMMENT '逾期总金额',
  `total_overdue_count` int(11) DEFAULT NULL COMMENT '累计逾期期数',
  `cur_overdue_count` int(11) DEFAULT NULL COMMENT '实际逾期期数',
  `black_handle_note` text COMMENT '黑名单处理结果备案',
  `is_advance_settled` varchar(255) DEFAULT NULL COMMENT '是否提前结清(0=正常结清 1=提前结清)',
  
  `settle_attach` varchar(255) DEFAULT NULL COMMENT '结清证明',
  `settle_datetime` datetime DEFAULT NULL COMMENT '结清时间',
  `release_datetime` datetime DEFAULT NULL COMMENT '解除抵押时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `deposit_way` varchar(255) DEFAULT NULL COMMENT '再次逾期保证金收取方式',
  `should_deposit` bigint(20) DEFAULT NULL COMMENT '实际可退的再次逾期保证金',
  
  `remind_count` int(11) DEFAULT NULL COMMENT '已催款次数',
  `real_repay_amount` bigint(20) DEFAULT NULL COMMENT '实际代偿金额',
  `is_repay` varchar(4) DEFAULT NULL COMMENT '代偿是否缴纳',
  `ts_car_amount` bigint(20) DEFAULT NULL COMMENT '拖车申请金额',
  `ts_bankcard_number` varchar(255) DEFAULT NULL COMMENT '拖车收款账号',
  `ts_bank_name` varchar(255) DEFAULT NULL COMMENT '拖车开户行',
  
  `ts_subbranch` varchar(255) DEFAULT NULL COMMENT '拖车开户支行',
  `tc_apply_note` varchar(255) DEFAULT NULL COMMENT '拖车申请说明',
  `remit_amount` bigint(20) DEFAULT NULL COMMENT '打款金额',
  `remit_bill_pdf` varchar(255) DEFAULT NULL COMMENT '打款水单',
  `take_car_address` varchar(255) DEFAULT NULL COMMENT '收车地点',
  
  `take_datetime` datetime DEFAULT NULL COMMENT '拖车时间',
  `take_name` varchar(255) DEFAULT NULL COMMENT '拖车人员',
  `take_location` varchar(255) DEFAULT NULL COMMENT '拖车停放位置',
  `take_note` varchar(255) DEFAULT NULL COMMENT '拖车说明',
  `jour_pdf` varchar(255) DEFAULT NULL COMMENT '流水',
  
  `house_pdf` varchar(255) DEFAULT NULL COMMENT '房产',
  `gua_name` varchar(255) DEFAULT NULL COMMENT '担保人姓名',
  `gua_id_no` varchar(255) DEFAULT NULL COMMENT '担保人身份证号',
  `gua_mobile` varchar(255) DEFAULT NULL COMMENT '担保人手机号',
  `gua_now_address` varchar(255) DEFAULT NULL COMMENT '担保人现居住地址',
  
  `gua_note` varchar(255) DEFAULT NULL COMMENT '担保赎回说明',
  `suggest` varchar(255) DEFAULT NULL COMMENT '建议(1=6个月保证金/2=已结清)',
  `suggest_note` varchar(255) DEFAULT NULL COMMENT '建议说明',
  `buy_out_amount` bigint(20) DEFAULT NULL COMMENT '团队买断扣除金额',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tdh_overdue_repay`;
CREATE TABLE `tdh_overdue_repay` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `overdue_code` varchar(32) DEFAULT NULL COMMENT '逾期名单编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='逾期名单关联表';

DROP TABLE IF EXISTS `tdh_repoint`;
CREATE TABLE `tdh_repoint` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `team_code` varchar(32) DEFAULT NULL COMMENT '团队编号',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `should_amount` bigint(20) DEFAULT NULL COMMENT '应返金额',
  `actual_amount` bigint(20) DEFAULT NULL COMMENT '实返金额',
  `account_no` varchar(32) DEFAULT NULL COMMENT '收款账号',
  `bank` varchar(255) DEFAULT NULL COMMENT '收款银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '收款支行',
  `water_bill` varchar(255) DEFAULT NULL COMMENT '水单',
  `status` char(1) DEFAULT NULL COMMENT '状态（0待返点 1已返点）',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='返点表';

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