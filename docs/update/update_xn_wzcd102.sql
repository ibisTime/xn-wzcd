ALTER TABLE `tdq_budget_order` 
ADD COLUMN `gh_id_picz` tinytext NULL  COMMENT '共还人身份证照片正' AFTER `gh_id_no`,
ADD COLUMN `gh_id_picf` tinytext NULL  COMMENT '共还人身份证照片反' AFTER `gh_id_picz`,
ADD COLUMN `guarantor1_id_picz` tinytext NULL  COMMENT '担保人1身份证照片正' AFTER `guarantor1_id_no`,
ADD COLUMN `guarantor1_id_picf` tinytext NULL  COMMENT '担保人1身份证照片反' AFTER `guarantor1_id_picz`,
ADD COLUMN `guarantor2_id_picz` tinytext NULL  COMMENT '担保人2身份证照片正' AFTER `guarantor2_id_no`,
ADD COLUMN `guarantor2_id_picf` tinytext NULL  COMMENT '担保人2身份证照片反' AFTER `guarantor2_id_picz`,
CHANGE COLUMN `id_no_pic` `id_no_picz` tinytext NULL COMMENT '身份证照片正' ,
ADD COLUMN `id_no_picf` tinytext NULL  COMMENT '身份证照片反' AFTER `id_no_picz`;

ALTER TABLE `tdq_credit_user`
ADD COLUMN `is_first_audit` VARCHAR(4) NULL DEFAULT NULL COMMENT '是否一审' AFTER `jour_show_income`;


DROP TABLE IF EXISTS `tdp_supplement_reason`;
CREATE TABLE `tdp_supplement_reason` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `logistics_code` varchar(32) DEFAULT NULL COMMENT '物流单编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `reason` tinytext COMMENT '原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补件原因';

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `enter_file_status` VARCHAR(4) NULL COMMENT '入档状态（0待入档1待补录2已入档）' AFTER `type`,
CHANGE COLUMN `guarantor_name` `guarantor1_name` VARCHAR(32) NULL DEFAULT NULL COMMENT '担保人1姓名' ,
CHANGE COLUMN `guarantor_mobile` `guarantor1_mobile` VARCHAR(16) NULL DEFAULT NULL COMMENT '担保人1手机' ,
ADD COLUMN `guarantor2_name` VARCHAR(32) NULL COMMENT '担保人2姓名' AFTER `guarantor1_mobile`,
ADD COLUMN `guarantor2_mobile` VARCHAR(16) NULL COMMENT '担保人2手机号' AFTER `guarantor2_name`,
ADD COLUMN `create_datetime` datetime NULL COMMENT '创建时间' AFTER `other_apply_note`,
DROP COLUMN `guarant_contract_deadline`,
DROP COLUMN `guarant_month_fee_rate`,
DROP COLUMN `car_brand_model`,
ADD COLUMN `green_big_smj` tinytext NULL COMMENT '绿大本扫描件' AFTER `bank_receipt_note`;



INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('008_01', '打印岗打印', '008');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('008_02', '理件岗理件', '008');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('008_03', '寄件岗寄送银行', '008');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('008_04', '提交银行', '008');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('008_05', '待提交抵押完成', '008');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('008_06', '抵押完成', '008');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_01', '银行驻点发送抵押合同给总公司', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_02', '总公司寄送合同给分公司', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_03', '车辆抵押开始', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_04', '待提交抵押完成', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_05', '分公司寄送抵押材料给总公司', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_06', '理件岗理件', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_07', '寄件岗寄送银行', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_08', '提交银行', '009');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('009_09', '车辆抵押完成', '009');

UPDATE `dev_xn_wzcd`.`tsys_node` SET `name`='打印岗打印' WHERE `code`='007_03';
UPDATE `dev_xn_wzcd`.`tsys_node` SET `name`='理件岗理件' WHERE `code`='007_04';
UPDATE `dev_xn_wzcd`.`tsys_node` SET `name`='总公司寄送银行材料给银行驻点' WHERE `code`='007_05';
UPDATE `dev_xn_wzcd`.`tsys_node` SET `name`='分公司内勤寄送银行材料给总公司' WHERE `code`='007_01';
UPDATE `dev_xn_wzcd`.`tsys_node` SET `name`='确认提交银行' WHERE `code`='007_06';
UPDATE `dev_xn_wzcd`.`tsys_node` SET `name`='总公司寄送银行材料给打印岗' WHERE `code`='007_02';
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('007_07', '财务确认收款', '007');
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('007_08', '银行放款完成', '007');

DELETE FROM `dev_xn_wzcd`.`tsys_node_flow` WHERE `id`='1';
DELETE FROM `dev_xn_wzcd`.`tsys_node_flow` WHERE `id`='2';
DELETE FROM `dev_xn_wzcd`.`tsys_node_flow` WHERE `id`='3';
DELETE FROM `dev_xn_wzcd`.`tsys_node_flow` WHERE `id`='4';
DELETE FROM `dev_xn_wzcd`.`tsys_node_flow` WHERE `id`='5';


INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`, `file_list`) VALUES ('007', '007_01', '007_02', '材料');
INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`, `file_list`) VALUES ('007', '007_02', '007_03', '材料');
INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('007', '007_03', '007_04');
INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('007', '007_04', '007_05');
INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`, `file_list`) VALUES ('007', '007_05', '007_06', '材料');
INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('007', '007_06', '007_07');
INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('007', '007_07', '007_08');

ALTER TABLE `dev_xn_wzcd`.`tdq_budget_order` 
ADD COLUMN `pledge_cur_node_code` VARCHAR(32) NULL COMMENT '抵押流程节点编号' AFTER `cur_node_code`;

ALTER TABLE `tdq_logistics` 
DROP COLUMN `send_file_list`,
DROP COLUMN `ref_file_list`;

UPDATE `dev_xn_wzcd`.`tsys_node` SET `code`='007_01B' WHERE `code`='007_01';
INSERT INTO `dev_xn_wzcd`.`tsys_node` (`code`, `name`, `type`) VALUES ('007_01A', '业务员寄送银行材料给总公司', '007');

INSERT INTO `dev_xn_wzcd`.`tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('007', '007_01B', '007_02');
UPDATE `dev_xn_wzcd`.`tsys_node_flow` SET `current_node`='007_01A' WHERE `id`='69';

ALTER TABLE `dev_xn_wzcd`.`tsys_node_flow` 
DROP COLUMN `file_list`;

ALTER TABLE `dev_xn_wzcd`.`tdq_budget_order` 
ADD COLUMN `pre_should_back_amount` BIGINT(20) NULL DEFAULT NULL COMMENT '发票不匹配之前的应退按揭款金额' AFTER `should_back_amount`,
ADD COLUMN `should_back_user_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '退按揭款收款人姓名（个人）' AFTER `should_back_status`,
ADD COLUMN `should_back_account_no` VARCHAR(32) NULL DEFAULT NULL COMMENT '退按揭款收款人账号（个人）' AFTER `should_back_user_name`,
ADD COLUMN `should_back_open_bank_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '退按揭款收款人账户开户行（个人）' AFTER `should_back_account_no`,
ADD COLUMN `should_back_account_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '退按揭款收款人户名（个人）' AFTER `should_back_open_bank_name`;

ALTER TABLE `dev_xn_wzcd`.`tdq_budget_order` 
CHANGE COLUMN `should_back_status` `should_back_status` VARCHAR(4) NULL DEFAULT NULL COMMENT '退按揭款状态(0无需退款1银行已放款待财务退款2财务已退垫资款)' AFTER `pre_should_back_amount`,
