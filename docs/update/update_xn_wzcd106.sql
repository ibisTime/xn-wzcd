/**
 * 第一次发包后
 */
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '3', '中行总对总 手续费一次性', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '4', '中国银行  抵押', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '5', '中行 传统', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '6', '中行解除抵押\r ', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '7', '中行总对总 手续费一次性', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '8', '中行总对总-附加费\r', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '9', '建设银行-抵押', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '10', '建设银行-服务费', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '11', '建设银行-附加贷', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '12', '建设银行-解除', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '13', '建设银行-信用+担保', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');




ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `payment_bank` VARCHAR(32) NULL COMMENT '付款银行' AFTER `settle_datetime`,
ADD COLUMN `judge_receipt_bank_code` VARCHAR(32) NULL COMMENT '司法诉讼收款银行编号' AFTER `judge_receipt_amount`,
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


ALTER TABLE `tdh_judge` 
ADD COLUMN `acceptance_fee` bigint(20) NULL COMMENT '受理费' AFTER `acceptance_time`,
ADD COLUMN `summons_delivery_time` datetime NULL COMMENT '传票等送达日期' AFTER `court_address`,
ADD COLUMN `apply_datetime` datetime NULL COMMENT '被执行人' AFTER `exe_apply_user`,
ADD COLUMN `be_exe_user` varchar(255) NULL COMMENT '被执行人' AFTER `apply_datetime`,
ADD COLUMN `recovery_datetime` datetime NULL COMMENT '恢复时间' AFTER `execute_mark_amount`,
ADD COLUMN `notice_datetime` datetime NULL COMMENT '有关公告时间' AFTER `sale_datetime`,
ADD COLUMN `adjudication_deadline` datetime NULL COMMENT '查封裁定到期时间' AFTER `notice_datetime`,
ADD COLUMN `remark` varchar(255) NULL COMMENT '备注' AFTER `update_datetime`;

ALTER TABLE `tdh_repay_plan` 
DROP COLUMN `real_repay_amount`;

INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('car_periods', '36', '12.5', 'admin', '2018-08-15 17:33:30', '车贷期数管理的期数和利率', 'CD-CWZCD000020', 'CD-CWZCD000020');
DELETE FROM `tsys_menu` WHERE `code`='SM201808092134147313197';

UPDATE `tsys_node` SET `name`='司法诉讼' WHERE `code`='021_09';
UPDATE `tsys_node` SET `name`='案件受理' WHERE `code`='021_10';
UPDATE `tsys_node` SET `name`='送达' WHERE `code`='021_13';
UPDATE `tsys_node` SET `name`='判决' WHERE `code`='021_14';
UPDATE `tsys_node` SET `name`='生效' WHERE `code`='021_15';
UPDATE `tsys_node` SET `name`='申请执行' WHERE `code`='021_16';
UPDATE `tsys_node` SET `name`='案件受理' WHERE `code`='021_17';
UPDATE `tsys_node` SET `name`='拍卖' WHERE `code`='021_18';
UPDATE `tsys_node` SET `name`='公告' WHERE `code`='021_19';
UPDATE `tsys_node` SET `name`='诉讼结果录入' WHERE `code`='021_20';
UPDATE `tsys_node` SET `name`='恢复执行' WHERE `code`='021_21';  
UPDATE `tsys_node` SET `name`='财务收款' WHERE `code`='021_22';
UPDATE `tsys_node` SET `name`='录入查封裁定到期时间' WHERE `code`='021_23';
UPDATE `tsys_node` SET `name`='司法诉讼完成' WHERE `code`='021_24';
INSERT INTO tsys_node` (`code`, `name`, `type`) VALUES ('021_25', '坏账', '021');
INSERT INTO tsys_node` (`code`, `name`, `type`) VALUES ('021_26', '赎回财务审核', '021');
INSERT INTO tsys_node` (`code`, `name`, `type`) VALUES ('021_27', '转卖财务审核', '021');
INSERT INTO tsys_node` (`code`, `name`, `type`) VALUES ('021_28', '公司结清出纳打款', '021');
INSERT INTO tsys_node` (`code`, `name`, `type`) VALUES ('021_29', '公司已结清', '021');

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_09', '021_10');
UPDATE `tsys_node_flow` SET `back_node`='021_09' WHERE `id`='91';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_17', '021_18');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_19', '021_20');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_20', '021_21');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_21', '021_17');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_22', '021_23');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_28', '021_29');
UPDATE `tsys_node_flow` SET `back_node`='020_09' WHERE `id`='80';
UPDATE `tsys_node_flow` SET `back_node`='020_10' WHERE `id`='81';
UPDATE `tsys_node_flow` SET `back_node`='' WHERE `id`='77';
UPDATE `tsys_node_flow` SET `back_node`='' WHERE `id`='78';

