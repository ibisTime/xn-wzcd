DELETE FROM `tsys_node` WHERE `code`='021_12';
DELETE FROM `tsys_node` WHERE `code`='021_13';
DELETE FROM `tsys_node` WHERE `code`='021_14';
DELETE FROM `tsys_node` WHERE `code`='021_15';
DELETE FROM `tsys_node` WHERE `code`='021_16';
DELETE FROM `tsys_node` WHERE `code`='021_17';
DELETE FROM `tsys_node` WHERE `code`='021_18';
DELETE FROM `tsys_node` WHERE `code`='021_19';
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_12','出纳打款','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_13','受理','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_14','开庭','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_15','判决','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_16','诉讼结果录入','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_17','重新申请执行','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_18','财务收款','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_19','司法诉讼完成','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_20','坏账','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_21','赎回财务审核','021',NULL);
INSERT INTO `tsys_node` (`code`,`name`,`type`,`remark`) VALUES ('021_22','转卖财务审核','021',NULL);

UPDATE `tsys_node_flow` SET `next_node`='021_12' WHERE `id`='92';
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_16', '021_17');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('021', '021_18', '021_19');

ALTER TABLE `tdh_judge` 
ADD COLUMN `pay_amount_prove` tinytext NULL COMMENT '打款证明' AFTER `case_pdf`,
ADD COLUMN `acceptance_time` datetime NULL COMMENT '受理时间' AFTER `pay_amount_prove`,
ADD COLUMN `court_address` varchar(255) NULL COMMENT '开庭地点' AFTER `court_datetime`,
ADD COLUMN `handle_judge` varchar(255) NULL COMMENT '经办法官' AFTER `court_address`,
ADD COLUMN `hear_case_number` varchar(255) NULL COMMENT '审理案号' AFTER `handle_judge`,
ADD COLUMN `judge_result` varchar(255) NULL COMMENT '判决结果' AFTER `judge_datetime`,
ADD COLUMN `judge_pdf_delivery_time` datetime NULL COMMENT '判决书送达时间' AFTER `judge_pdf`,
ADD COLUMN `effective_time` datetime NULL COMMENT '生效时间' AFTER `judge_pdf_delivery_time`;

UPDATE `tsys_menu` SET `name`='银行返佣' WHERE `code`='';
UPDATE `tsys_menu` SET `name`='应收银行返佣' WHERE `code`='SM201807241624080938516';

INSERT INTO `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`) VALUES ('RO201800000000000001', 'SM201808091633548934541', 'U201808031956004721377', '2018-08-08 02:36:46');
INSERT INTO `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`) VALUES ('RO201800000000000001', 'SM201808091634300896647', 'U201808031956004721377', '2018-08-08 02:36:46');
INSERT INTO `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`) VALUES ('RO201800000000000001', 'SM201808091634577197277', 'U201808031956004721377', '2018-08-08 02:36:46');
INSERT INTO `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`) VALUES ('RO201800000000000001', 'SM201808091635215548948', 'U201808031956004721377', '2018-08-08 02:36:46');
INSERT INTO `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`) VALUES ('RO201800000000000001', 'SM201808091618111629813', 'U201808031956004721377', '2018-08-08 02:36:46');
INSERT INTO `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`) VALUES ('RO201800000000000001', 'SM201808092045589215519', 'U201808031956004721377', '2018-08-08 02:36:46');
DELETE FROM `tsys_node` WHERE `code`='005_03';
UPDATE `tsys_node` SET `code`='005_03' WHERE `code`='005_04';
UPDATE `tsys_node` SET `code`='005_04' WHERE `code`='005_05';
UPDATE `tsys_node` SET `code`='005_05' WHERE `code`='005_06';

INSERT INTO `tsys_node_flow` (`current_node`, `next_node`) VALUES ('014_01', '014_02');
INSERT INTO `tsys_node_flow` (`current_node`, `next_node`, `back_node`) VALUES ('014_02', '014_03', '014_01');

UPDATE `tstd_cnavigate` SET `pic`='FtqaSR_osmL6F-Y5ag8x8LUOnQw_' WHERE `code`='DH201711271342486662078';
UPDATE `tstd_cnavigate` SET `pic`='FtqaSR_osmL6F-Y5ag8x8LUOnQw_' WHERE `code`='DH201711271344255452496';
UPDATE `tstd_cnavigate` SET `pic`='FtqaSR_osmL6F-Y5ag8x8LUOnQw_' WHERE `code`='DH201711271344255452497';

INSERT INTO `tp_archive` (`code`, `real_name`, `id_no`, `mobile`, `job_no`, `entry_datetime`, `department_code`, `post_code`, `job_classes`, `birthday`, `gender`, `nation`, `native_place`, `marry_status`, `politics`, `major`, `education`, `work_status`, `health`, `salary_card`, `residence_address`, `residence_property`, `probation_time`, `traffic_award`, `mobile_award`, `taxi_ward`, `meal_award`, `updater`, `update_datetime`,`is_delete`,`user_id`) VALUES ('RA201800000000001', 'admin', '150606199710040501', '18736182541', '1', '2018-08-09 00:00:00', 'DP201807170504370111263', 'DP201807170508487789432', '1', '2018-08-09 00:00:00', '1', '汉', '籍贯', '1', '1', '专业', '1', '1', '健康状况', '', '户籍所在地', '1', '1', '0', '0', '0', '0', 'USYS201800000000001', '2018-08-09 11:17:29','1','USYS201800000000001');

ALTER TABLE `tb_bank` 
DROP COLUMN `rate18`;

ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `release_apply_datetime` datetime NULL COMMENT '解除抵押申请时间' AFTER `release_apply_note`;

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'back_advance_fund_type', '收回垫资款类型', 'admin', '2018-07-08 07:34:21', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'back_advance_fund_type', '1', '客户作废', 'admin', '2018-07-08 07:34:21', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'back_advance_fund_type', '2', '垫资款退回', 'admin', '2018-07-08 07:34:21', 'CD-CWZCD000020', 'CD-CWZCD000020');

UPDATE `tsys_menu` SET `order_no`='3' WHERE `code`='SM201805081710209032086';
UPDATE `tsys_menu` SET `order_no`='4' WHERE `code`='SM201806190005143218771';
UPDATE `tsys_menu` SET `name`='录入催收过程' WHERE `code`='SM201808031644380795299';
UPDATE `tsys_menu` SET `name`='录入催收结果' WHERE `code`='SM201808031645062405626';

DELETE FROM `tsys_menu` WHERE `code`='SM201805250101085488247';

/*-----------------------------------------------------------------------------------------*/

UPDATE `tsys_menu` SET `name`='预算单流转中' WHERE `code`='SM201806292245140079435';
UPDATE `tb_car_dealer` SET `cur_node_code`='006_03' WHERE `code`='CD201807081628275712800';

ALTER TABLE `tp_archive` 
DROP COLUMN `is_delete`;

ALTER TABLE `tp_social_relation` 
DROP COLUMN `is_delete`;

ALTER TABLE `tp_social_relation` 
ADD COLUMN `status` VARCHAR(4) NULL COMMENT '状态（0删除1正常）' AFTER `contact`;

DELETE FROM `tsys_menu` WHERE `code`='SM201805170038079738669';

insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('0',NULL,'emergency_contact_relation','紧急联系人关系','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','1','丈夫','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','2','妻子','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','3','父亲','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','4','母亲','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','5','岳父','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','6','岳母','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','7','朋友','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');

