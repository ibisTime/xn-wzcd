/**
 * 第一次发包后
 */
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '3', '中行总对总 手续费一次性', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');




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

INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('021_23', '公司结清出纳打款', '021');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('021_24', '公司已结清', '021');

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_23', '021_24');
UPDATE `tsys_node_flow` SET `type`='014' WHERE `id`='98';
UPDATE `tsys_node_flow` SET `type`='014' WHERE `id`='99';

