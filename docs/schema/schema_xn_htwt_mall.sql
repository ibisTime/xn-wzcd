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

/*商品 */
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

/*商品规格 */
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