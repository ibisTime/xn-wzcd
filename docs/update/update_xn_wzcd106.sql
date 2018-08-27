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



