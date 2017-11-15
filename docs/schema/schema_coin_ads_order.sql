
#广告
CREATE TABLE `tcoin_ads_sell` (
  `code` varchar(32) NOT NULL COMMENT '编号',
#   `type` varchar(32) NOT NULL COMMENT '类型 0 = 买币、1=卖币',
  `user_id` varchar(32) NOT NULL COMMENT '发布用户编号',
  `trade_currency` varchar(8) NOT  NULL COMMENT '交易币种',
  `trade_coin` varchar(8) NOT  NULL COMMENT '数字货币类型',
  `only_trust` VARCHAR(2) NOT NULL  COMMENT '是否只有信任的人可以交易',
  `premium_rate` decimal(6,4) NOT NULL COMMENT '溢价率',

  `total_amount` DECIMAL(64,0) NOT NULL COMMENT '广告的交易总额',
  `left_amount` DECIMAL(64,0) NOT NULL COMMENT '剩余可交易',

  `market_price` DECIMAL(32,3) NOT NULL COMMENT '行情价格',
  `protect_price` DECIMAL(32,3) NOT NULL COMMENT '保护单价',
  `min_trade` DECIMAL(32,3) DEFAULT NULL COMMENT '单笔最小交易额',
  `max_trade` DECIMAL(32,3) DEFAULT NULL COMMENT '单笔最大交易额',

  `pay_type` varchar(32) NOT NULL COMMENT '付款方式',
  `pay_limit` int(11) DEFAULT NULL COMMENT '付款超时时间（分钟）',
  `status` varchar(4) NOT NULL COMMENT '状态 0=草稿、1=上架中、2=下架',
  `leave_message` text NOT NULL COMMENT '广告留言',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#广告可见时间
CREATE TABLE `tcoin_ads_display_time` (
  `id` INTEGER NOT NULL AUTO_INCREMENT COMMENT '主键',
  `adsCode` varchar(32) NOT NULL COMMENT '编号',
  `week` CHAR(1) NOT NULL COMMENT '周几',
  `start_time` INTEGER NOT NULL COMMENT '开始时间',
  `end_time` INTEGER NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY ads_week(`adsCode`,`week`)  USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#订单
CREATE TABLE `tcoin_trade_order` (
  `code` varchar(32) NOT NULL COMMENT '订单编号',
  `type` varchar(32) DEFAULT NULL COMMENT '订单类型',
  `ads_code` varchar(32) DEFAULT NULL COMMENT '广告编号',
  `buy_user` varchar(32) DEFAULT NULL COMMENT '买方',
  `sell_user` varchar(32) DEFAULT NULL COMMENT '卖方',
  `leave_message` text COMMENT '广告留言',
  `trade_currency` varchar(32) DEFAULT NULL COMMENT '交易币种',
  `trade_price` decimal(32,3) DEFAULT NULL COMMENT '交易单价',
  `trade_amount` decimal(32,3) DEFAULT NULL COMMENT '交易总额',
  `fee` decimal(64,0) DEFAULT NULL COMMENT '手续费',
  `count` decimal(64,0) DEFAULT NULL COMMENT '交易数字货币数量',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '付款方式',
  `invalid_datetime` datetime DEFAULT NULL COMMENT '支付超时时间',
  `status` varchar(4) DEFAULT NULL COMMENT '订单状态',
  `sb_comment` varchar(32) DEFAULT NULL COMMENT '卖方对买方的评价',
  `bs_comment` varchar(32) DEFAULT NULL COMMENT '买方对卖方的评价',
  `mark_datetime` datetime DEFAULT NULL COMMENT '标记打款时间',
  `release_datetime` datetime DEFAULT NULL COMMENT '币释放时间',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '最后更新人',
  `update_datatime` datetime DEFAULT NULL COMMENT '最后更新时间',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


