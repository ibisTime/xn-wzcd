
/*
 * 平台用户（菜单、角色）系统参数（数据字典、系统参数） tsys_ 柴
 * C端用户+账户 tstd_  郑
 * 商品分期 tmall_
 * 车贷意向 车贷分期 还款业务 tht_
 * 
 * */

/*意向收集*/
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


/*商品分期*/
CREATE TABLE `tmall_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父节点',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`code`) COMMENT '分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tmall_product` (
  `code` varchar(32) NOT NULL COMMENT '商品编号',
  `category` varchar(32) DEFAULT NULL COMMENT '大类',
  `type` varchar(32) DEFAULT NULL COMMENT '小类',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `slogan` varchar(255) DEFAULT NULL COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `sale_status` varchar(255) DEFAULT NULL COMMENT '销售状态',
  `pic` text DEFAULT NULL COMMENT 'pic',
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

CREATE TABLE `tmall_product_specs` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '规格名称',
  `pic` text DEFAULT NULL COMMENT 'pic',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `price` bigint(20) DEFAULT NULL COMMENT '价格（人民币）',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `quantity` int(11) DEFAULT NULL COMMENT '库存',
  `province` varchar(255) DEFAULT NULL COMMENT '发货地,精确到省份',
  `weight` DECIMAL(18,8) DEFAULT NULL COMMENT '重量',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tmall_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
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

/*车贷分期*/
CREATE TABLE `tht_loan_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(64) DEFAULT NULL COMMENT '证件号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` varchar(64) DEFAULT NULL COMMENT '银行卡号',
  `car_code` varchar(32) DEFAULT NULL COMMENT '车型编号',
  `car_price` bigint(20) DEFAULT NULL COMMENT '车辆总价',
  `sf_rate` decimal(18,8) DEFAULT NULL COMMENT '首付比例',
  `sf_amount` bigint(20) DEFAULT NULL COMMENT '首付金额',
  `loan_bank` varchar(32) DEFAULT NULL COMMENT '贷款银行',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `bank_rate` decimal(18,8) DEFAULT NULL COMMENT '银行利率',
  `loan_start_datetime` datetime DEFAULT NULL COMMENT '贷款时间起点',
  `loan_end_datetime` datetime DEFAULT NULL COMMENT '贷款时间终点',
  `fk_datetime` datetime DEFAULT NULL COMMENT '放款日期',
  `fx_deposit` bigint(20) DEFAULT NULL COMMENT '风险保证金',
  `other_fee` bigint(20) DEFAULT NULL COMMENT '杂费',
  `gps_fee` bigint(20) DEFAULT NULL COMMENT 'GPS收费',
  `first_repay_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `first_repay_amount` bigint(20) DEFAULT NULL COMMENT '首期月供金额',
  `month_datetime` int(11) DEFAULT NULL COMMENT '每期还款日期',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `ly_deposit` bigint(20) DEFAULT NULL COMMENT '履约保证金',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tht_repay_biz` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `bankcard_code` varchar(32) DEFAULT NULL COMMENT '还款卡编号',
  `ref_type` varchar(4) DEFAULT NULL COMMENT '关联类型',
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
  `fx_deposit` bigint(20) DEFAULT NULL COMMENT '风险保证金',
  `first_repay_datetime` datetime DEFAULT NULL COMMENT '首期还款日期',
  `first_repay_amount` bigint(20) DEFAULT NULL COMMENT '首期月供金额',
  `month_datetime` int(11) DEFAULT NULL COMMENT '每期还款日期',
  `month_amount` bigint(20) DEFAULT NULL COMMENT '每期月供金额',
  `ly_deposit` bigint(20) DEFAULT NULL COMMENT '履约保证金（可退）',
  `cut_ly_deposit` bigint(20) DEFAULT NULL COMMENT '扣除的履约保证金',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `rest_amount` bigint(20) DEFAULT NULL COMMENT '剩余欠款',
  `rest_total_cost` bigint(20) DEFAULT NULL COMMENT '未还清收总成本',
  `total_in_deposit` bigint(20) DEFAULT NULL COMMENT '额外保证金收入',
  `overdue_amount` bigint(20) DEFAULT NULL COMMENT '逾期总金额',
  `total_overdue_count` int(11) DEFAULT NULL COMMENT '累计逾期期数',
  `cur_overdue_count` int(11) DEFAULT NULL COMMENT '实际逾期期数',
  `black_handle_note` text COMMENT '黑名单处理结果备案',
  `updater` varchar(255) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tht_repay_plan` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_biz_code` varchar(32) DEFAULT NULL COMMENT '还款业务编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '借款人编号',
  `periods` int(11) DEFAULT NULL COMMENT '总期数',
  `cur_periods` int(11) DEFAULT NULL COMMENT '当前期数',
  `repay_datetime` datetime DEFAULT NULL COMMENT '还款时间',
  `repay_capital` bigint(20) DEFAULT NULL COMMENT '本期本金',
  `repay_interest` decimal(18,8) DEFAULT NULL COMMENT '本期利息',
  `payed_amount` bigint(20) DEFAULT NULL COMMENT '已还金额',
  `overdue_amount` bigint(20) DEFAULT NULL COMMENT '逾期金额',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `overdue_handler` varchar(255) DEFAULT NULL COMMENT '逾期处理人',
  `overdue_handle_datetime` datetime DEFAULT NULL COMMENT '逾期处理时间',
  `overdue_handle_note` text COMMENT '逾期处理说明',
  `total_fee` bigint(20) DEFAULT NULL COMMENT '清收费用总额',
  `payed_fee` bigint(20) DEFAULT NULL COMMENT '已缴纳清收费用总额',
  `overdue_deposit` bigint(20) DEFAULT NULL COMMENT '再次逾期保证金',
  `deposit_way` varchar(255) DEFAULT NULL COMMENT '再次逾期保证金收取方式',
  `should_deposit` bigint(20) DEFAULT NULL COMMENT '实际可退的再次逾期保证金',
  `remind_count` int(11) DEFAULT NULL COMMENT '已催款次数',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tht_cost` (
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

CREATE TABLE `tht_remind_log` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  `way` varchar(255) DEFAULT NULL COMMENT '催收方式',
  `to_user` varchar(255) DEFAULT NULL COMMENT '催收对象姓名',
  `content` text COMMENT '催收文本',
  `create_datetime` datetime DEFAULT NULL COMMENT '催收时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*C端用户*/
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
  `jf_amount` bigint(20) DEFAULT NULL COMMENT '积分余额',
  `amount` bigint(20) DEFAULT NULL COMMENT '账户余额',
  `creditscore` bigint(20) DEFAULT NULL COMMENT '信用分',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) COMMENT '用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `tstd_bankcard` (
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '户名',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行行别',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `bankcard_number` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*账户*/
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

/*系统*/
CREATE TABLE `tsys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `login_pwd` varbinary(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` char(1) DEFAULT NULL COMMENT '登录密码强度',
  `create_datetme` datetime DEFAULT NULL COMMENT '注册时间',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `updater` varbinary(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `tsys_role` (
  `code` varchar(96) DEFAULT NULL,
  `name` varchar(96) DEFAULT NULL,
  `level` varchar(6) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tsys_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(96) DEFAULT NULL,
  `menu_code` varchar(96) DEFAULT NULL,
  `updater` varchar(96) DEFAULT NULL,
  `update_datetime` datetime DEFAULT NULL,
  `remark` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1635 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;




