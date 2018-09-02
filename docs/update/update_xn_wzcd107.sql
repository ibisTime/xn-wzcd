UPDATE `tsys_node` SET `name`='执行结果录入' WHERE `code`='021_20';

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `bank_benchmark_rate` decimal(18,8) NULL COMMENT '银行基准利率' AFTER `bank_rate`,
ADD COLUMN `is_end` VARCHAR(4) NULL COMMENT '业务是否结束' AFTER `bank_repoint_datetime`;

ALTER TABLE `tdh_overdue_treatment` 
ADD COLUMN `collection_type` VARCHAR(4) NULL COMMENT '催收类型(0过程，1结果)' AFTER `collection_result_note`;

ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `is_implement_again` VARCHAR(4) NULL COMMENT '是否恢复执行' AFTER `judge_bill_pdf`;


INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', '', 'pledge_print_template_id', '抵押套打模板', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
UPDATE `tsys_dict` SET `parent_key`='pledge_print_template_id' WHERE `id`='645';
UPDATE `tsys_dict` SET `parent_key`='pledge_print_template_id' WHERE `id`='650';
INSERT INTO `tsys_dict` (`parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('pledge_print_template_id', '1', '工行', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', '', 'release_print_template_id', '解除抵押套打模板', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'release_print_template_id', '1', '工行', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
UPDATE `tsys_dict` SET `parent_key`='release_print_template_id' WHERE `id`='653';
UPDATE `tsys_dict` SET `parent_key`='release_print_template_id' WHERE `id`='647';
