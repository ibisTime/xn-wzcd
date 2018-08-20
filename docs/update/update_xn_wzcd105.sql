
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


ALTER TABLE `tb_gps` 
ADD COLUMN `supplier_code` VARCHAR(32) NULL COMMENT '供应商编号' AFTER `biz_code`;
