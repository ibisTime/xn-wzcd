UPDATE `tsys_node` SET `name`='执行结果录入' WHERE `code`='021_20';

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `bank_benchmark_rate` decimal(18,8) NULL COMMENT '银行基准利率' AFTER `bank_rate`,
ADD COLUMN `is_end` VARCHAR(4) NULL COMMENT '业务是否结束' AFTER `bank_repoint_datetime`;

ALTER TABLE `tdh_overdue_treatment` 
ADD COLUMN `collection_type` VARCHAR(4) NULL COMMENT '催收类型(0过程，1结果)' AFTER `collection_result_note`;

ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `is_implement_again` VARCHAR(4) NULL COMMENT '是否恢复执行' AFTER `judge_bill_pdf`,
ADD COLUMN `deal_result` VARCHAR(4) NULL COMMENT '处理结果' AFTER `payment_pdf`;

ALTER TABLE `tsys_table_export` 
ADD COLUMN `real_name` VARCHAR(255) NULL COMMENT '真实姓名' AFTER `operator`;


INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', '', 'pledge_print_template_id', '抵押套打模板', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
UPDATE `tsys_dict` SET `parent_key`='pledge_print_template_id' WHERE `id`='645';
UPDATE `tsys_dict` SET `parent_key`='pledge_print_template_id' WHERE `id`='650';
INSERT INTO `tsys_dict` (`parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('pledge_print_template_id', '1', '工行', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', '', 'release_print_template_id', '解除抵押套打模板', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'release_print_template_id', '1', '工行', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
UPDATE `tsys_dict` SET `parent_key`='release_print_template_id' WHERE `id`='653';
UPDATE `tsys_dict` SET `parent_key`='release_print_template_id' WHERE `id`='647';

ALTER TABLE `tdq_budget_order` 
CHANGE COLUMN `apply_birth_address` `apply_birth_address_province` TINYTEXT NULL DEFAULT NULL COMMENT '申请人户籍地省',
ADD COLUMN `apply_birth_address_city` TINYTEXT NULL COMMENT '申请人户籍地市' AFTER `apply_birth_address_province`,
ADD COLUMN `apply_birth_address_area` TINYTEXT NULL COMMENT '申请人户籍地区' AFTER `apply_birth_address_city`,
CHANGE COLUMN `apply_now_address` `apply_now_address_province` TINYTEXT NULL DEFAULT NULL COMMENT '现住地址省',
ADD COLUMN `apply_now_address_city` TINYTEXT NULL COMMENT '现住地址市' AFTER `apply_now_address_province`,
ADD COLUMN `apply_now_address_area` TINYTEXT NULL COMMENT '现住地址区' AFTER `apply_now_address_city`,
CHANGE COLUMN `gh_birth_address` `gh_birth_address_province` TINYTEXT NULL DEFAULT NULL COMMENT '共还人户籍地省',
ADD COLUMN `gh_birth_address_city` TINYTEXT NULL COMMENT '共还人户籍地市' AFTER `gh_birth_address_province`,
ADD COLUMN `gh_birth_address_area` TINYTEXT NULL COMMENT '共还人户籍地区' AFTER `gh_birth_address_city`,
CHANGE COLUMN `guarantor1_birth_address` `guarantor1_birth_address_province` TINYTEXT NULL DEFAULT NULL COMMENT '担保1户籍地省',
ADD COLUMN `guarantor1_birth_address_city` TINYTEXT NULL COMMENT '担保1户籍地市' AFTER `guarantor1_birth_address_province`,
ADD COLUMN `guarantor1_birth_address_area` TINYTEXT NULL COMMENT '担保1户籍地区' AFTER `guarantor1_birth_address_city`,
CHANGE COLUMN `guarantor2_birth_address` `guarantor2_birth_address_province` TINYTEXT NULL DEFAULT NULL COMMENT '担保2户籍地省',
ADD COLUMN `guarantor2_birth_address_city` TINYTEXT NULL COMMENT '担保2户籍地市' AFTER `guarantor2_birth_address_province`,
ADD COLUMN `guarantor2_birth_address_area` TINYTEXT NULL COMMENT '担保2户籍地区' AFTER `guarantor2_birth_address_city`,









