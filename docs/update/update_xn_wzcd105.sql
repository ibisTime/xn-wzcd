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

ALTER TABLE `tsys_bonuses` 
ADD COLUMN `updater` VARCHAR(32) NULL COMMENT '最近更新人' AFTER `end_amount`,
ADD COLUMN `updater_datetime` datetime NULL COMMENT '更新时间' AFTER `updater`;

INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'guarant_print_template_id', '2', '中行总对总-手续费分期', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');


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


ALTER TABLE `tdq_budget_order` 
ADD COLUMN `bank_benchmark_rate` DECIMAL(18,8) NULL DEFAULT NULL COMMENT '银行基准利率' AFTER `bank_rate`,
ADD COLUMN `is_self_develop` VARCHAR(4) NULL DEFAULT NULL COMMENT '是否自主开发（1是0否）' AFTER `bank_fk_datetime`,
ADD COLUMN `sale_user_bonus` BIGINT(20) NULL DEFAULT NULL COMMENT '业务员奖金提成' AFTER `is_self_develop`;


UPDATE `tb_car_dealer` SET `cur_node_code`='006_03' WHERE `code`='CD201807081628275712800';
UPDATE `tb_car_dealer` SET `cur_node_code`='006_03' WHERE `code`='CD201807151436370142124';
UPDATE `tb_car_dealer` SET `agreement_status`='1' WHERE `code`='CD201807081628275712800';


INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808212018582291309','详情','2','/detail','1','U201808211719148055876','2018-08-21 20:18:58','垫资超过1天未放款客户','SM201806141644169953362');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808212256257194444','供应商管理','1','/administrative/gpsSupplier.htm','0','U201808211719148055876','2018-08-21 23:16:55','GPS设备管理','SM201806082250402178394');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808212256512252866','新增','2','/add','1','U201808211719148055876','2018-08-21 22:56:51','供应商管理','SM201808212256257194444');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808212257099531748','修改','2','/edit','2','U201808211719148055876','2018-08-21 22:57:09','供应商管理','SM201808212256257194444');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808220020593349520','GPS个人申领上限','1','/administrative/manageGpsUpperLimit.htm','5','U201808211719148055876','2018-08-22 00:20:59','GPS设备管理','SM201806082250402178394');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808221749117394418','奖金提成配置','1','/basis/bonusesConfigure.htm','991','U201808211719148055876','2018-08-22 20:17:17','基础数据','SM201804301415107007680');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808221749361887071','新增','2','/add','1','U201808211719148055876','2018-08-22 17:49:36','奖金提成配置','SM201808221749117394418');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808221749483515328','修改','2','/edit','2','U201808211719148055876','2018-08-22 17:49:48','奖金提成配置','SM201808221749117394418');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808221750113614366','删除','2','/delete','3','U201808211719148055876','2018-08-22 17:50:11','奖金提成配置','SM201808221749117394418');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808231437540491016','详情','2','/detail','1','U201808211719148055876','2018-08-23 14:37:54','预打款统计','SM201805280243436213237');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808231438208056477','详情','2','/detail','1','U201808211719148055876','2018-08-23 14:38:20','今日已垫资','SM201805280245050776374');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808231444275606179','详情','2','/detail','1','U201808211719148055876','2018-08-23 14:44:27','进度表','SM201806141642458892878');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`) VALUES ('SM201808241738579695673','打印收据','2','/printing','1','U201808211719148055876','2018-08-24 17:38:57','履约保证金开票','SM201805280239530695286');


INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805311013495606615','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','HTWTSM201800000000000000','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','HTWTSM201800001000000001','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','HTWTSM201800001000000003','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','HTWTSM201800001000000004','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804242138443236748','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804242141231816698','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804242142138278448','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804242144385705547','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804242145538683194','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804251644341488287','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804251731271739441','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804251904256377856','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804301415107007680','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805081705114533419','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805151427368418325','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805241734391869799','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805241958046303089','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242149128061059','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242150539508842','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242154333815189','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242157301002711','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242201065685882','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242207393916404','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242214033638620','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242220529537941','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242253176813841','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250039359733936','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250042171115649','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250044219874308','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250047063755380','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250049335439886','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250056093969052','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250100006756591','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250104344345708','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250106430426854','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250111434718233','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805261643194308775','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271704254168514','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271749355004354','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805280239530695286','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805280243436213237','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805281639340333002','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291117032851555','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291502587573139','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291708274282750','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805301425463367046','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310058392132131','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310243421577470','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310300329564489','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310301356257728','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310347593975131','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310512170534911','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310512368386251','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806042259475308530','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051420554466474','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051421258276525','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051428237651580','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051431342607799','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051434201484754','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051435413562649','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051558518131784','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806061748572982697','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071708381719538','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071710405804529','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071711202672020','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082258364384563','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082259536645110','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806092051499615034','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806110031132186057','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141534595565154','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141536009438835','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141623226267969','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141627593333711','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141642458892878','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806151457272407137','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806181538230247700','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182003052278371','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182327385527794','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182328116763899','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182343005735767','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190149518787204','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190639041558027','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806200141572736238','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806200243226829592','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806291613077739263','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806291742520534140','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806291745046434904','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292245403723906','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292245535149451','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292308248647004','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292308486233301','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806301523001944443','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807012229003566181','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807012229355431622','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807012230093704160','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807012230376103823','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807021626002719074','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141644173396353','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141651015006530','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141653334766680','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141654243163857','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141656064321336','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141704259655464','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807161733227999309','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807191945293796987','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807241624080938516','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807252205109665385','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807302212213699070','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031644380795299','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061809180775151','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061926493993798','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808091618464324636','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808092045589215519','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808092134147313197','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807011601590401010','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141346575036875','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141531382288620','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','HTWTSM201800001000000002','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804241904336827315','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804241905224096392','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804251646149125308','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805081705485635544','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805151428123357430','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242153397971186','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242157586324708','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242202004906992','USYS201800000000001','2018-08-25 00:31:03',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242208144536567','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242215077638952','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242221204783390','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242226196623911','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242254290865864','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250038140313354','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250042334313003','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250044485963562','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250047247591734','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250100335999494','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250105013137079','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250109243234781','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805261643379684212','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271704117862206','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271704439014417','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271749539042357','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805280245050776374','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805281640155713673','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291503275987360','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310058543412057','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310244109985100','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310300555272813','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310301586821716','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310512554765085','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806042300129597474','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051559106975018','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806061749121844857','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806061750193716532','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806070028011916511','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071709471593110','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071717477267977','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071718477698370','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082259103138937','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082300058567560','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806101101457084745','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141536201709208','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141601477126562','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141623526969750','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141630327473396','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141644169953362','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806171643383675704','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806181630539257889','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182004264791616','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182328309319851','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182343112578149','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190150422658486','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190350205773047','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806200117013685540','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806200244365451286','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806262159196994483','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292245140079435','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806301523519729197','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141646233698103','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141652174524535','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141655155819402','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807161724479683063','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807191248033163738','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807191312245849741','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807201122587522956','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807211417290619053','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807242005272144457','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807281602414524431','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031645062405626','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808041636087875294','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061530163153279','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061808345201487','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061809294035123','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061927067115376','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808062200341735161','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808092134331123727','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804251647429608504','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804251721516584466','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805081710209032086','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805160026263651871','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805241959283647720','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242145368808348','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242151369213111','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242157014447871','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242203148998334','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242208338252004','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242216118846815','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242222515884848','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242227002562570','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242229446635630','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242254527006078','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250041071059259','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250112514279630','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805261644083552854','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805262327157553966','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271705018596567','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271750079792488','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805281640354631279','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291503579801856','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310513080348085','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806042300273383652','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051411362126806','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051559357096164','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071718080653911','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071719052792329','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806101102051493363','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141536452157081','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141603354926630','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141632121984652','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806152210494461185','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806172237024343982','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806181539334278645','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182004429656382','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182328431472260','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190349101714733','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806200142227491786','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806200245207736099','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806262202033396143','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806301524257017897','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141648044957251','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807151218056091557','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807191327375537803','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807302103549607629','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061927224224585','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808071426441645958','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808091633548934541','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808092134538943965','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804242145538681651','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804261916138008548','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804301417154135904','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805241733524603349','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805241959570673358','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242200264189130','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242210336473799','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242223410193990','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242227167615616','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242229133521704','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242255152523164','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250043443168813','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250051257209180','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250056340836398','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250109440041591','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805280238334583085','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805281641016214469','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291504194957789','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310242423914884','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310347411931086','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806041128375806577','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806051559483974315','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806070023189526060','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071718250834284','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071719302093741','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082250402178394','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141633195292242','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806152211120409187','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806181630131923846','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190005143218771','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190352274735585','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806262203102688764','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806301525151555709','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807141649454641790','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807302032144892983','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061927388442471','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808091634300896647','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804262141502085147','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804271801337258756','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242151548536481','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242204505121085','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242229595375554','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250045554256481','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250052562332719','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250056477565799','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805261643019946733','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805280128096684231','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291709085021548','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310313196555261','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071710581441805','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806071712156312004','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806082301163207610','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141634160306973','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182342199132541','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190353007713237','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806301526128117545','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807241623140274264','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201807302349551913660','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808061926094761452','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808091634577197277','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804251546303774373','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242213093506497','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250048445013436','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250053097978431','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805280227334652108','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805280242447832720','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291055307456089','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291709410526538','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805301426338849454','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805310351574072000','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806041132346191499','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141635182028445','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806182001097986372','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808091635215548948','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242218412284383','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250055062803007','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805271749230046555','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291121432585610','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805301429024449260','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141604269041642','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141639008434859','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190640028923710','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804271806010518814','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242216438832175','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242225549063562','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250058105536176','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805301429178387519','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141531231898060','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141640206102881','USYS201800000000001','2018-08-25 00:31:04',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806190640431486807','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292305598663680','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201804271806335389896','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242217017701105','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242228210349002','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250103500421452','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806110040495257708','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806141641067999998','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292257311805790','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806292307189008458','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806092050389193535','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250105570448392','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291030239333610','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808091618111629813','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805242252041961446','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805250110582487975','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291032194718466','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806301738211719910','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291033129682833','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201806301513114713693','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291034405409203','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291035342036590','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201805291037383171866','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031912103874298','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031914103903519','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031914348997842','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031915020905001','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031915242825882','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031915551348665','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031917425458129','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031918098491671','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031920077875100','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031920278053664','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031920443167418','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031921003766920','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031921116764732','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031922053904811','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031922172385564','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031922362341506','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031922464477887','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031922569895700','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031923092294507','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031924413421996','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031924527447103','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031925109722753','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031925235928123','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031925338062612','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031925464485760','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031926001116248','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031926102075823','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031926230026640','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031926330857570','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031926437314687','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031926555014770','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031927046397039','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031927139139125','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031927251833102','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031927336103752','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031927478366865','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031927588438907','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031928101013879','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031928375313087','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031928473875079','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031928592345578','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031929083492279','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031929177688070','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031929287087676','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031929433284714','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031930025244813','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031930246263039','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031930367809629','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031930567978180','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031931149479974','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031931238171470','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031931344909505','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031931472607347','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031932140262828','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031932225955789','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031932347971324','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031932478702667','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031932589918821','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031933084224871','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031933196645454','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031933396545156','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031933490459145','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031933582433375','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031934079202371','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031934262201337','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031934407122753','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031935052667021','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031935215119940','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031935579459173','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031936310604200','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031936406804933','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031940257252698','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031941313999485','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031941418462036','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031941568091339','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031943069681647','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031943314186240','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031943432095329','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031943530411602','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031944055058845','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031944146041484','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031944267185443','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031944376904651','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031944540478676','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031945043859735','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031945129605084','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031945255179947','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031945353087270','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031948303697590','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031953394847910','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808031953534537980','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808241738579695673','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808212256257194444','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808212256512252866','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808212257099531748','USYS201800000000001','2018-08-25 00:31:05',NULL);
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES ('RO201800000000000001','SM201808220020593349520','USYS201800000000001','2018-08-25 00:31:05',NULL);
