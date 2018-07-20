UPDATE `tsys_dict` SET `dvalue`='已收件待审核' WHERE `id`='144';
UPDATE `tsys_dict` SET `dvalue`='审核通过' WHERE `id`='145';
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','logistics_status','4','待补件','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','logistics_status','5','退件','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `green_big_code` VARCHAR(32) NULL COMMENT '绿大本编号' AFTER `bank_receipt_note`;

ALTER TABLE `tdp_supplement_reason` 
ADD COLUMN `is_part_supt` VARCHAR(4) NULL COMMENT '是否已补件' AFTER `reason`;