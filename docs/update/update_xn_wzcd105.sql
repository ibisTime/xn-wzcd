
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
INSERT INTO `tsys_bonuses` (`is_self_develop`, `unit_price`, `month_rate`, `retain_months`, `start_amount`, `end_amount`, `remark`) VALUES ('0', '150', '0.8', '6', '100001', '300001', '10万--30万');
INSERT INTO `tsys_bonuses` (`is_self_develop`, `unit_price`, `month_rate`, `retain_months`, `start_amount`, `end_amount`, `remark`) VALUES ('0', '120', '0.8', '6', '20000', '100001', '10万以下');
INSERT INTO `tsys_bonuses` (`is_self_develop`, `unit_price`, `month_rate`, `retain_months`, `start_amount`, `end_amount`, `remark`) VALUES ('1', '200', '0.8', '6', '20000', '100001', '笔数*提成单价*本月比例');

ALTER TABLE `tb_gps` 
ADD COLUMN `supplier_code` VARCHAR(32) NULL COMMENT '供应商编号' AFTER `biz_code`;

INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('gps_apply', 'PERSONAL_APPLICATION_LIMIT', '10', 'admin', '2018-08-15 17:33:30', 'GPS个人申领上限', 'CD-CWZCD000020', 'CD-CWZCD000020');

