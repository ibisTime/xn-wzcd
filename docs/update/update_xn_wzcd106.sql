/**
 * 第一次发包后
 */
ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `payment_bank` VARCHAR(32) NULL COMMENT '付款银行' AFTER `settle_datetime`,
ADD COLUMN `payment_pdf` tinytext NULL COMMENT '付款凭证' AFTER `payment_bank`;

DROP TABLE IF EXISTS `tdh_company_clearance`;
CREATE TABLE `tdh_company_clearance` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `repaybiz_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司结清记录';
