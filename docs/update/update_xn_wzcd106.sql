INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'az_location', '9', '其他', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');

ALTER TABLE `tdq_budget_order_gps` 
ADD COLUMN `az_location_remark` VARCHAR(255) NULL COMMENT '安装位置备注' AFTER `az_location`;

ALTER TABLE `tdq_credit_user` 
ADD COLUMN `court_network_results_remark` VARCHAR(255) NULL COMMENT '法院网查询结果备注' AFTER `court_network_results`;

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'court_network_results', '法院网查询结果', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');

ALTER TABLE `tdq_req_budget` 
ADD COLUMN `bill_pdf` VARCHAR(255) NULL COMMENT '打款凭证' AFTER `dz_datetime`;

UPDATE `tsys_node` SET `name`='财务确认收回预算款' WHERE `code`='005_05';
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('005_06', '已收回预算款', '005');
UPDATE `tsys_node` SET `name`='打款回录' WHERE `code`='005_04';

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('005', '005_05', '005_06');

UPDATE `tsys_menu` SET `name`='返回垫资款' WHERE `code`='SM201805250110582487975';
UPDATE `tsys_menu` SET `name`='打款回录' WHERE `code`='SM201805250111434718233';
UPDATE `tsys_menu` SET `name`='返回预算款' WHERE `code`='SM201805250038140313354';
UPDATE `tsys_menu` SET `name`='收取手续费' WHERE `code`='SM201805250041071059259';

DROP TABLE IF EXISTS `tdq_credit_change_record`;
CREATE TABLE `tdq_credit_change_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `now_credit_code` varchar(32) DEFAULT NULL COMMENT '现征信编号',
  `raw_credit_code` varchar(32) DEFAULT NULL COMMENT '原征信编号',
  `now_loan_bank_code` varchar(32) DEFAULT NULL COMMENT '现贷款银行编号',
  `raw_loan_bank_code` varchar(32) DEFAULT NULL COMMENT '原贷款银行编号',
  `operator` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征信银行卡变更记录';
