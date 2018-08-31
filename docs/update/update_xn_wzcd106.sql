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

UPDATE `tsys_node` SET `name`='风控内勤审核' WHERE `code`='020_03';
UPDATE `tsys_node` SET `name`='解除抵押申请' WHERE `code`='020_02';
UPDATE `tsys_node` SET `name`='理件岗理件' WHERE `code`='020_06';
UPDATE `tsys_node` SET `name`='提交结算单' WHERE `code`='020_09';
UPDATE `tsys_node` SET `name`='打印岗打印' WHERE `code`='020_05';
UPDATE `tsys_node` SET `name`='财务审核' WHERE `code`='020_12';
UPDATE `tsys_node` SET `name`='驻行人员提交材料' WHERE `code`='020_08';
UPDATE `tsys_node` SET `name`='风控经理审核' WHERE `code`='020_04';
UPDATE `tsys_node` SET `name`='风控总监审核' WHERE `code`='020_11';
UPDATE `tsys_node` SET `name`='寄送银行材料' WHERE `code`='020_07';
UPDATE `tsys_node` SET `name`='风控经理审核' WHERE `code`='020_10';
UPDATE `tsys_node` SET `name`='确认付款' WHERE `code`='020_13';
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('020_14', '已结清', '020');



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
UPDATE `tsys_node_flow` SET `back_node`='020_02' WHERE `id`='74';
UPDATE `tsys_node_flow` SET `back_node`='020_09' WHERE `id`='81';
UPDATE `tsys_node_flow` SET `back_node`='020_09' WHERE `id`='82';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('020', '020_13', '020_14');


ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `is_deposit_receipt` VARCHAR(4) NULL COMMENT '是否有押金单' AFTER `deal_enclosure`,
ADD COLUMN `deposit_receipt_lost_proof` tinytext NULL COMMENT '押金单遗失证明' AFTER `deposit_receipt`;


INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('020_15', '已结清', '020');
UPDATE `tsys_node` SET `name`='确认付款' WHERE `code`='020_14';
UPDATE `tsys_node` SET `name`='财务审核' WHERE `code`='020_13';
UPDATE `tsys_node` SET `name`='风控总监审核' WHERE `code`='020_12';
UPDATE `tsys_node` SET `name`='风控经理审核' WHERE `code`='020_11';
UPDATE `tsys_node` SET `name`='提交结算单' WHERE `code`='020_10';
UPDATE `tsys_node` SET `name`='驻行人员提交材料' WHERE `code`='020_09';
UPDATE `tsys_node` SET `name`='寄送银行材料' WHERE `code`='020_08';
UPDATE `tsys_node` SET `name`='理件岗理件' WHERE `code`='020_07';
UPDATE `tsys_node` SET `name`='打印岗打印' WHERE `code`='020_06';
UPDATE `tsys_node` SET `name`='风控总监审核' WHERE `code`='020_05';

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('020', '020_14', '020_15');
UPDATE `tsys_node_flow` SET `back_node`='020_02' WHERE `id`='75';
UPDATE `tsys_node_flow` SET `back_node`='020_10' WHERE `id`='81';
UPDATE `tsys_node_flow` SET `back_node`='020_10' WHERE `id`='82';
UPDATE `tsys_node_flow` SET `back_node`='020_10' WHERE `id`='111';
UPDATE `tsys_node_flow` SET `back_node`='' WHERE `id`='80';


ALTER TABLE `tb_bank` 
CHANGE COLUMN `rate12` `rate12` DECIMAL(18,8) NULL DEFAULT NULL COMMENT '12期' ,
CHANGE COLUMN `rate24` `rate24` DECIMAL(18,8) NULL DEFAULT NULL COMMENT '24期' ,
CHANGE COLUMN `rate36` `rate36` DECIMAL(18,8) NULL DEFAULT NULL COMMENT '36期' ;

UPDATE `tsys_dict` SET `dvalue`='执毕' WHERE `id`='556';
UPDATE `tsys_dict` SET `dvalue`='和解' WHERE `id`='557';

ALTER TABLE `tp_archive` 
ADD COLUMN `cur_node_code` VARCHAR(32) NULL COMMENT '节点' AFTER `working_years`;

/*********************************************8.31开始 jiafr*************************************************/
INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `company_code`, `system_code`) VALUES ('0', 'tc_deal_result', '收车处理结果', 'admin', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `company_code`, `system_code`) VALUES ('1', 'tc_deal_result', '1', '用户赎回', 'admin', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `company_code`, `system_code`) VALUES ('1', 'tc_deal_result', '2', '转卖', 'admin', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `company_code`, `system_code`) VALUES ('1', 'tc_deal_result', '3', '用户结清', 'admin', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `company_code`, `system_code`) VALUES ('1', 'tc_deal_result', '4', '公司结清', 'admin', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `company_code`, `system_code`) VALUES ('1', 'tc_deal_result', '5', '暂缓处理', 'admin', 'CD-CWZCD000020', 'CD-CWZCD000020');
/*********************************************jiafr*************************************************/
