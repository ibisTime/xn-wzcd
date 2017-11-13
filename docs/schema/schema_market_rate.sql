
#行情
CREATE TABLE `tcoin_market` (

  `id` INT AUTO_INCREMENT NOT NULL,
  `coin` VARCHAR(10) NOT NULL COMMENT '数字货币',
  `refer_currency` VARCHAR(10) NOT NULL COMMENT '参照法币币种',
  `origin` VARCHAR(32) NOT NULL COMMENT '行情来源',
  `last_price` DECIMAL(15,4) NOT NULL COMMENT '最新成交价格',
  `bid` DECIMAL(15,4) DEFAULT NULL COMMENT '买家期望价格',
  `ask` DECIMAL(15,4) DEFAULT NULL COMMENT '卖家期望价格',
  `mid` DECIMAL(15,4) NOT NULL COMMENT '中间价格',
  `low` DECIMAL(15,4) NOT NULL COMMENT '最低价格',
  `high` DECIMAL(15,4) NOT NULL COMMENT '最高价格',
  `volume` VARCHAR(32) DEFAULT NULL COMMENT '交易量',
  `update_datetime` DATETIME NOT NULL  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`origin`,`coin`) USING BTREE

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#汇率
CREATE TABLE `tcoin_currency_rate` (

  `currency` VARCHAR(10) NOT NULL COMMENT '币种',
  `refer_currency` VARCHAR(10) NOT NULL COMMENT '参照币种 为CNY',
  `origin` VARCHAR(32) NOT NULL COMMENT '汇率来源',
  `rate` DECIMAL(8,4) NOT NULL COMMENT '汇率',
  `update_datetime` DATETIME NOT NULL  COMMENT '更新时间',
   PRIMARY KEY (`currency`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

