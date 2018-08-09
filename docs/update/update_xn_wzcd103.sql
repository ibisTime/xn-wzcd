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
