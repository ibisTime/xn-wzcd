INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('0', NULL,'customer_type', '客户类型', 'admin', '2018-07-08 07:34:21', NULL,'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('1', 'customer_type', '1', '个人', 'admin', '2018-07-08 07:34:21', NULL,'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('1', 'customer_type', '2', '企业', 'admin', '2018-07-08 07:34:21', NULL,'CD-CWZCD000020', 'CD-CWZCD000020');


DELETE FROM `tsys_menu` WHERE `code`='SM201805170038079738669';

insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('0',NULL,'emergency_contact_relation','紧急联系人关系','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','1','丈夫','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','2','妻子','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','3','父亲','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','4','母亲','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','5','岳父','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','6','岳母','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');
insert into `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) values('1','emergency_contact_relation','7','朋友','admin','2018-07-08 07:34:21',NULL,'CD-CWZCD000020','CD-CWZCD000020');

DROP TABLE IF EXISTS `tb_gps_supplier`;
CREATE TABLE `tb_gps_supplier` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `contacts` varchar(255) DEFAULT NULL COMMENT '联系人',
  `contacts_mobile` varchar(32) DEFAULT NULL COMMENT '联系人手机号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='gps供应商';

DROP TABLE IF EXISTS `tsys_bonuses`;
CREATE TABLE `tsys_bonuses` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `is_self_develop` varchar(4) DEFAULT NULL COMMENT '是否自主开发',
  `unit_price` bigint(20) DEFAULT NULL COMMENT '提成单价',
  `month_rate` decimal(18,8) DEFAULT NULL COMMENT '本月比例',
  `retain_months` int(11) DEFAULT NULL COMMENT '留存月数',
  `start_amount` bigint(20) DEFAULT NULL COMMENT '起始金额',
  `end_amount` bigint(20) DEFAULT NULL COMMENT '结束金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖金提成配置';

INSERT INTO `tsys_bonuses` (`is_self_develop`, `unit_price`, `month_rate`, `retain_months`, `start_amount`, `end_amount`, `remark`) VALUES ('0', '180', '0.8', '6', '300001', '2000000', '30万以上');
INSERT INTO `tsys_bonuses` (`is_self_develop`, `unit_price`, `month_rate`, `retain_months`, `start_amount`, `end_amount`, `remark`) VALUES ('0', '150', '0.8', '6', '100001', '300000', '10万--30万');
INSERT INTO `tsys_bonuses` (`is_self_develop`, `unit_price`, `month_rate`, `retain_months`, `start_amount`, `end_amount`, `remark`) VALUES ('0', '120', '0.8', '6', '20000', '100000', '10万以下');
INSERT INTO `tsys_bonuses` (`is_self_develop`, `unit_price`, `month_rate`, `retain_months`, `start_amount`, `end_amount`, `remark`) VALUES ('1', '200', '0.8', '6', '20000', '10000000', '笔数*提成单价*本月比例');

ALTER TABLE `tb_gps` 
ADD COLUMN `supplier_code` VARCHAR(32) NULL COMMENT '供应商编号' AFTER `biz_code`;

INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('gps_apply', 'PERSONAL_APPLICATION_LIMIT', '10', 'admin', '2018-08-15 17:33:30', 'GPS个人申领上限', 'CD-CWZCD000020', 'CD-CWZCD000020');

DROP TABLE IF EXISTS `tdq_bonuses_list`;
CREATE TABLE `tdq_bonuses_list` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `month` varchar(32) DEFAULT NULL COMMENT '月份',
  `sale_user` varchar(32) DEFAULT NULL COMMENT '业务员',
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `is_self_develop` varchar(4) DEFAULT NULL COMMENT '是否自主开发',
  `self_develop_amount` bigint(20) DEFAULT NULL COMMENT '自主开发奖金',
  `not_self_develop_amount` bigint(20) DEFAULT NULL COMMENT '非自主开发奖金',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `is_loan_bank` VARCHAR(4) DEFAULT NULL COMMENT '是否已放款',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖金提成';

ALTER TABLE `tdq_advance_fund` 
ADD COLUMN `apply_user` VARCHAR(32) NULL COMMENT '申请人' AFTER `type`;


DROP TABLE IF EXISTS `tdq_performance_bond`;
CREATE TABLE `tdq_performance_bond` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `budget_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `customer_name` varchar(32) DEFAULT NULL COMMENT '客户姓名',
  `car_dealer_code` varchar(32) DEFAULT NULL COMMENT '汽车经销商',
  `sale_user` varchar(32) DEFAULT NULL COMMENT '业务员',
  `loan_bank_code` varchar(32) DEFAULT NULL COMMENT '贷款银行',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `ly_amount` bigint(20) DEFAULT NULL COMMENT '履约保证金',
  `bank_fk_datetime` datetime DEFAULT NULL COMMENT '放款日期',
  `print_number` varchar(32) DEFAULT NULL COMMENT '收款打印单号',
  `print_datetime` datetime DEFAULT NULL COMMENT '收款打印日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='履约保证金开票';

INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('0', NULL,'shop_way', '购车途径', 'admin', '2018-07-08 07:34:21', NULL,'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('1', 'shop_way', '0', '新车', 'admin', '2018-07-08 07:34:21', NULL,'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('1', 'shop_way', '1', '二手车', 'admin', '2018-07-08 07:34:21', NULL,'CD-CWZCD000020', 'CD-CWZCD000020');

ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `company_code` VARCHAR(32) NULL COMMENT '业务公司编号' AFTER `ref_code`;

UPDATE `tsys_dict` SET `dvalue`='车辆抵押 （本地）' WHERE `id`='509';
UPDATE `tsys_dict` SET `dvalue`='车辆抵押（外地）' WHERE `id`='510';
UPDATE `tsys_dict` SET `dvalue`='返点支付' WHERE `id`='511';
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'node_type', '014', '收回垫资款', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');

UPDATE `tsys_node` SET `type`='007' WHERE `code`='007_09';

UPDATE `tsys_dict` SET `dvalue`='汽车经销商' WHERE `id`='504';
UPDATE `tsys_dict` SET `dvalue`='请款预算单' WHERE `id`='503';
DELETE FROM `tsys_dict` WHERE `id`='422';
UPDATE `tsys_dict` SET `dvalue`='银行放款 ' WHERE `id`='508';


ALTER TABLE `dev_xn_wzcd`.`tdq_budget_order` 
ADD COLUMN `bank_benchmark_rate` DECIMAL(18,8) NULL DEFAULT NULL COMMENT '银行基准利率' AFTER `bank_rate`,
ADD COLUMN `is_self_develop` VARCHAR(4) NULL DEFAULT NULL COMMENT '是否自主开发（1是0否）' AFTER `bank_fk_datetime`,
ADD COLUMN `sale_user_bonus` BIGINT(20) NULL DEFAULT NULL COMMENT '业务员奖金提成' AFTER `is_self_develop`;


