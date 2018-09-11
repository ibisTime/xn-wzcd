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


SET SQL_SAFE_UPDATES = 0;
update tdq_budget_order set force_insurance = 0;
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tdq_budget_order` 
CHANGE COLUMN `force_insurance` `force_insurance` BIGINT(20) NULL DEFAULT NULL COMMENT '交强险' ,
ADD COLUMN `force_insurance_pdf` TINYTEXT NULL COMMENT '交强险图片' AFTER `force_insurance`;

ALTER TABLE `tdh_overdue_menu` 
ADD COLUMN `not_mate_result` varchar(4) NULL COMMENT '不匹配原因（0信息不匹配，1一卡多贷）' AFTER `status`;

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`) VALUES ('0', 'fund_source', '金额来源');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`) VALUES ('1', 'fund_source', '1', '财务部');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`) VALUES ('1', 'fund_source', '2', '预支款');

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'approve_note', '审核说明', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'approve_note', '1', '审核通过', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'approve_note', '2', '审核不通过', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'approve_note', '99', '其他', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');

ALTER TABLE `tdq_budget_order` 
DROP COLUMN `fbh_warn_day`;

