
CREATE TABLE `tstd_blacklist` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `type` varchar(32) DEFAULT NULL COMMENT '拉黑类型',
  `status` varchar(4) DEFAULT NULL COMMENT '状态 0-已删除 1-已生效',
  `create_datetime` datetime DEFAULT NULL COMMENT '拉黑时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` varchar(45) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `tstd_user` 
ADD COLUMN `user_referee_level` VARCHAR(4) NULL COMMENT '推荐人等级' AFTER `user_referee`;
ADD COLUMN `last_login` DATETIME NULL COMMENT '最后一次登录时间' AFTER `system_code`;
ADD COLUMN `google_secret` VARCHAR(64) NULL COMMENT '谷歌验证秘钥' AFTER `trade_pwd_strength`;



INSERT INTO `tstd_cpassword` (`code`,`system_code`,`company_code`,`type`,`account`,`password`,`remark`) VALUES ('COIN000017001','CD-COIN000017','CD-COIN000017','2','app_private_key','MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK43D3dC8N12nNhOtJZ9T4hk0mrr4LrmSUCXhvdQ6glLepXPc3ACJe/kR5DUtyd4F4DS3HrGXAN9X2IwM0+LT1Xl0oW1DaVTh6l0f0nvCEuZN7aLic7gr1COiMHNvQBA31Pj5prf6hoIScTEvPAcUgQlii8WldBu8eYsQl6QtiPlAgMBAAECgYEAqR/ercKYngY2AW92tNl1yk1GUHIouogw+LmhVpqAeQGDQcggos4TEi2kpB88pt5YwsDxNWc3kFO3s1Rjm4b8PidM3uZxvloyPEDedxfbUDndkoBrBxFYMLAE31qT7ZTBkyafaCrGAW8LWLVrIinK27nI0FnT+Hnl+M7R9qnMgckCQQDViMgA/A1QjPpEXTJfchqlOmHY9GYghIH9nGoiu2Y46sp9sYmNe/00c1gZa/5UI4RBK5JPQgSvNelyAu33ICS7AkEA0NyAxz5PizrH9kCf4HBHasOOX9ERTf/4Qm/6etQdzHBnmUx/t6CLr6Ds7XvOqrcsOCRnce8GA3wUNQByI1Kf3wJBAMWgrXLz1KLbh3kkRE2//lczvIGeWLL50JFXZYe1p3tAGp7QZL10prkXk88beyyGHo5udCA0ur8qh1+ExJc2wacCQFXcsFw4c37rVVUY0CD2R4XOivM9AX4tYqP9YN2p4e4vr4dH+aFFsOcsovomUZnA377cyGIAP1qjYbNAUavPxcUCQG0V3oZdBBKGlZwawR3DSIdJYRXdVPyg6pIbfaLDKzlSaK7BCkTh1wP7nleat4Qp9JcN/ed8zp4FaUqAQcpYG8w=','应用私钥');
INSERT INTO `tstd_cpassword` (`code`,`system_code`,`company_code`,`type`,`account`,`password`,`remark`) VALUES ('COIN000017002','CD-COIN000017','CD-COIN000017','2','url','https://zmopenapi.zmxy.com.cn/openapi.do','芝麻信用网关');
INSERT INTO `tstd_cpassword` (`code`,`system_code`,`company_code`,`type`,`account`,`password`,`remark`) VALUES ('COIN000017003','CD-COIN000017','CD-COIN000017','2','app_id','1004013','应用ID');
INSERT INTO `tstd_cpassword` (`code`,`system_code`,`company_code`,`type`,`account`,`password`,`remark`) VALUES ('COIN000017004','CD-COIN000017','CD-COIN000017','2','zhima_public_key','MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCC9FLi1VuB60MNtuqvYlSzVsrpz/vac3APuqrQEpmzR1AjhHlMiq6mPX2ZCi5ujCkCoQ4Rf6shw/mBJj74POVY38N0KasSsRgOU2Sf2dYzv9TUqGbIgQbIfW4QY8XtcnK8y1ldisWuDHOsOwR4LIMlerA3uydw7Redr+svmIzzMwIDAQAB','芝麻公钥');
INSERT INTO `tstd_cpassword` (`code`,`system_code`,`company_code`,`type`,`account`,`password`,`remark`) VALUES ('COIN000017005','CD-COIN000017','CD-COIN000017','2','merchant_id','268821000000049622222','商户ID');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'user_level','用户等级','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_level','1','普通交易者','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_level','2','代理人','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

