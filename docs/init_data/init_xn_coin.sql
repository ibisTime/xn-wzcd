
INSERT INTO `tstd_user` (`user_id`,`login_name`,`login_pwd`,`login_pwd_strength`,`kind`,`level`,`role_code`,`status`,`create_datetime`,`remark`,`company_code`,`system_code`) VALUES ('UCOIN201700000000000001','admin','21218cca77804d2ba1922c33e0151105','1','P','0','COINSR201700000000000000','0',now(),'管理端系统方','CD-COIN000017','CD-COIN000017');
/*
-- Query: SELECT * FROM std_account.tstd_account where user_id = 'CD-COIN000017'
-- Date: 2016-12-29 15:08
*/
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`company_code`,`system_code`) VALUES ('SYS_ACOUNT_ETH','SYS_USER_ETH','平台ETH盈亏账户','P','0','ETH',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`company_code`,`system_code`) VALUES ('SYS_ACOUNT_ETH_COLD','SYS_USER_ETH_COLD','平台ETH冷钱包','P','0','ETH',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-COIN000017','CD-COIN000017');

/*
-- Query: SELECT * FROM coin_xn_coin_dev.tcoin_market
-- Date: 2017-11-20 10:07
*/
INSERT INTO `tcoin_market` (`coin`,`refer_currency`,`origin`,`last_price`,`bid`,`ask`,`mid`,`low`,`high`,`volume`,`update_datetime`) VALUES ('ETH','CNY','bitfinex',2364.7634,2364.7634,2366.0226,2365.3930,2275.1569,2458.8767,'334291.04556696',now());
INSERT INTO `tcoin_market` (`coin`,`refer_currency`,`origin`,`last_price`,`bid`,`ask`,`mid`,`low`,`high`,`volume`,`update_datetime`) VALUES ('BTC','CNY','bitfinex',53154.8168,53154.1540,53154.8168,53154.4854,50701.9050,53883.2010,'39982.7165797',now());
INSERT INTO `tcoin_market` (`coin`,`refer_currency`,`origin`,`last_price`,`bid`,`ask`,`mid`,`low`,`high`,`volume`,`update_datetime`) VALUES ('ETH','CNY','okex',2369.4028,2369.4028,2370.0655,2369.7341,2273.3011,2480.8807,'14841.66',now());
INSERT INTO `tcoin_market` (`coin`,`refer_currency`,`origin`,`last_price`,`bid`,`ask`,`mid`,`low`,`high`,`volume`,`update_datetime`) VALUES ('BTC','CNY','okex',53068.4578,53068.3916,53068.4578,53068.4247,50766.3262,53684.3037,'1946.88',now());

/*
-- Query: SELECT * FROM coin_xn_coin_dev.tcoin_currency_rate
-- Date: 2017-11-20 10:08
*/
INSERT INTO `tcoin_currency_rate` (`currency`,`refer_currency`,`origin`,`rate`,`update_datetime`) VALUES ('HKD','CNY','juhe',0.8487,now());
INSERT INTO `tcoin_currency_rate` (`currency`,`refer_currency`,`origin`,`rate`,`update_datetime`) VALUES ('USD','CNY','juhe',6.6277,now());

/*
-- Query: select `type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code` from tsys_config
-- Date: 2017-08-23 10:21
*/
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_access_key','OugFobOQxavLzefKuIHCjGT6Gpsv0SCszdWrlQ39','admin',now(),'七牛云key1','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_secret_key','J4RqFulrTWdRs79lM_HFde_K4gtb3FwWEYn8xHic','admin',now(),'七牛云key1','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_bucket','beicoin','admin',now(),'存储空间','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('qiniu','qiniu_domain','ozfszueqz.bkt.clouddn.com','admin',now(),'访问域名','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('tencent_im','tx_app_code','1400050575','admin','2017-11-16 19:40:03','应用编号','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('tencent_im','tx_app_admin','admin','admin','2017-11-16 19:40:03','账号管理员','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('tencent_im','tx_access_key','-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAETVy+sF6PGdpX7iQ+fY6uheR7O02p\nVMUnX+/GDN5Bk3GGZA1wASLOhd/XyRb+FSnjMSafJSKD6FVzDtPdfy8h7w==\n-----END PUBLIC KEY-----','admin','2017-11-16 19:40:03','公钥','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('tencent_im','tx_secret_key','-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgft/yZF5jXWYcXNbI\noHE9ftdVfC1f8SQ0mWrs6EdjW8ChRANCAARNXL6wXo8Z2lfuJD59jq6F5Hs7TalU\nxSdf78YM3kGTcYZkDXABIs6F39fJFv4VKeMxJp8lIoPoVXMO091/LyHv\n-----END PRIVATE KEY-----','admin','2017-11-16 19:40:03','私钥','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('tencent_im','tx_account_type','19287','admin','2017-11-16 19:40:03','账号类型','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('sys_txt','about_us','关于我们','admin',now(),'关于我们','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('sys_txt','telephone','0571-89000000','admin',now(),'服务热线','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('sys_txt','time','09:00:00 - 17:30:00','admin',now(),'服务时间','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('sys_txt','questions','常见问题','admin',now(),'常见问题','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('sys_txt','reg_protocol','注册协议','admin',now(),'注册协议','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('sys_txt','reg_url','http://hy.hichengdai.com','admin',now(),'注册链接','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('collection_rule','collection_limit','1','admin',now(),'当账户达到该数量时进行自动归集','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('withdraw_rule','withdraw_fee','0.01','admin',now(),'取现手续费','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('trade_rule','trade_fee_rate','0.01','admin',now(),'交易手续费率','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'user_status','用户状态','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_status','0','正常','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_status','1','程序锁定','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_status','2','人工锁定','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'id_kind','证件类型','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','id_kind','1','身份证','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'role_level','角色等级','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','role_level','1','运维','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','role_level','2','运营','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','role_level','3','客户','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'res_type','资源类型','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','res_type','1','菜单','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','res_type','2','按钮','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'lock_direction','锁定方向','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','lock_direction','1','锁定','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','lock_direction','2','解锁','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'user_kind','针对人群','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_kind','C','C端用户','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_kind','B','B端用户','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','user_kind','P','平台用户','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'notice_status','公告状态','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','0','未发布','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','1','已发布','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','notice_status','2','已下架','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0','','banner_location','banner位置','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','banner_location','trade','交易首页','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','banner_location','market','行情首页','admin',now(),NULL,'CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'currency','货币','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','currency','CNY','人民币','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','currency','USD','美元','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','currency','HKD','港币','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'coin','货币','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','coin','BTC','比特币','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','coin','ETH','以太币','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'account_type','账户类型','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_type','C','C端用户','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_type','P','平台用户','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'account_status','账户状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_status','0','正常','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_status','1','程序锁定','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','account_status','2','人工锁定','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'jour_status','流水状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','0','刚生成待回调','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','1','已回调通过待对账','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','2','回调不通过','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','3','已对账且账不平','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','4','账不平待调账','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','5','已调账','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','9','无需对账','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','6','待审批','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','7','审批通过','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_status','8','审批不通过','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'channel_type','渠道类型','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','ETH','以太坊','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','0','内部账','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','90','人工线下','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','9','调账','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','channel_type','10','轧账','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'jour_biz_type_user','用户流水业务类型','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','charge','充值','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','withdraw','取现','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','buy','交易买入','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','sell','交易卖出','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','tradefee','交易手续费','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','withdrawfee','取现手续费','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','invite','邀请好友收入','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','hc','红冲','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_user','lb','蓝补','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'jour_biz_type_cold','盈亏账户流水业务类型','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_cold','income','收入','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_cold','pay','支出','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_cold','hc','红冲','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_cold','lb','蓝补','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'jour_biz_type_plat','盈亏账户流水业务类型','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat','tradefee','交易手续费收入','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat','withdrawfee','取现手续费收入','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat','mfee','取现矿工费','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat','wfee','归集矿工费','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat','hc','红冲','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','jour_biz_type_plat','lb','蓝补','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'charge_status','充值状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','charge_status','1','待支付','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','charge_status','2','支付失败','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','charge_status','3','支付成功','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'withdraw_status','取现状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','1','待审批','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','2','审批不通过','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','3','审批通过待广播','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','4','广播中','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','5','广播失败','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','withdraw_status','6','广播成功','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'collection_status','归集状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','collection_status','1','广播中','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','collection_status','2','广播失败','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','collection_status','3','广播成功','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'pay_type','支付方式','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','pay_type','0','支付宝','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','pay_type','1','微信','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','pay_type','2','银联转账','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'trade_order_status','交易订单状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_status','0','待支付','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_status','1','已支付待释放','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_status','2','已释放待评价','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_status','3','已完成','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_status','4','已取消','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_status','5','仲裁中','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'trade_order_type','交易订单类型','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_type','buy','购买订单','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_order_type','sell','出售订单','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'ads_status','广告状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','ads_status','0','草稿','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','ads_status','1','待交易','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','ads_status','2','交易中','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','ads_status','3','已下架','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'arbitrate_status','仲裁订单状态','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','arbitrate_status','0','待处理','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','arbitrate_status','1','已处理','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','arbitrate_status','2','已取消','admin',now(),'','CD-COIN000017','CD-COIN000017');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('0',NULL,'trade_time_out','交易超时时间','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_time_out','10','10','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_time_out','15','15','admin',now(),'','CD-COIN000017','CD-COIN000017');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','trade_time_out','20','20','admin',now(),'','CD-COIN000017','CD-COIN000017');

/*
-- Query: SELECT code,name,type,url,order_no,'admin' updater, now() as update_datetime,remark,parent_code,system_code FROM tsys_menu
-- Date: 2017-11-20 10:15
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201612071021105964','财务管理','1','#','3','admin',now(),'','COINSM201700000000000000','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710215035834','账户查询','1','#','1','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201612071022206883','外部账对账','1','#','5','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710225078473','内部账对账','1','#','6','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710233232137','平台账户','1','#','2','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710242555432','线下取现','1','#','3','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201612071029309117','账户查询','1','/finance/account.htm','1','admin',now(),'','COINSM2016120710215035834','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710341064879','流水查询','1','/finance/ledger.htm','2','admin',now(),'','COINSM2016120710215035834','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710421392861','充币对账','1','/finance/autoReconControl.htm','1','admin',now(),'','COINSM201612071022206883','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710443551388','提币对账','1','/finance/roughHand.htm','2','admin',now(),'','COINSM201612071022206883','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710470696888','买入对账','1','/finance/twoRoll.htm','1','admin',now(),'','COINSM2016120710225078473','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710484209132','卖出对账','1','/finance/inRoughHand.htm','2','admin',now(),'','COINSM2016120710225078473','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120710583381112','平台账户','1','/finance/breakBalance.htm','1','admin',now(),'','COINSM2016120710233232137','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120711021944714','线下充值','1','/finance/offlineRecharge.htm','1','admin',now(),'','COINSM201707251143314118180','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120711034365344','线下取现','1','/finance/lineUnder.htm','2','admin',now(),'','COINSM2016120710242555432','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120714062949665','流水','2','/flow','1','admin',now(),'','COINSM201612071029309117','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120714343212111','详情','2','/detail','1','admin',now(),'','COINSM2016120710341064879','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120816125733948','对账','2','/edit','1','admin',now(),'','COINSM2016120710421392861','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120816133940523','详情','2','/detail','2','admin',now(),'','COINSM2016120710421392861','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120911033945882','对账','2','/edit','1','admin',now(),'','COINSM2016120710443551388','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120911042060088','详情','2','/detail','2','admin',now(),'','COINSM2016120710443551388','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201612091114505291','对账','2','/edit','1','admin',now(),'','COINSM2016120710470696888','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120911160661084','详情','2','/detail','2','admin',now(),'','COINSM2016120710470696888','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120911293120195','对账','2','/examine','1','admin',now(),'','COINSM2016120710484209132','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016120911301231346','详情','2','/detail','2','admin',now(),'','COINSM2016120710484209132','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122219561180130','导出','2','/export','9','admin',now(),'','COINSM201612071029309117','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122219573703627','导出','2','/export','9','admin',now(),'','COINSM2016120710341064879','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122219590218515','导出','2','/export','9','admin',now(),'','COINSM2016120710470696888','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122220000572417','导出','2','/export','9','admin',now(),'','COINSM2016120710484209132','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122317321369746','代申请','2','add','1','admin',now(),'','COINSM2016120711021944714','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122317325464966','代申请','2','add','2','admin',now(),'','COINSM2016120711034365344','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122317590316953','流水','2','/flow','1','admin',now(),'','COINSM2016120710583381112','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122412144574736','导出','2','export','9','admin',now(),'','COINSM2016120710583381112','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122413510161245','审核','2','/examine','2','admin',now(),'','COINSM2016120711021944714','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2016122413512505485','审核','2','/examine','2','admin',now(),'','COINSM2016120711034365344','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700000000000000','根目录','1','#','1','admin',now(),'','','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000001','系统管理','1','#','1','admin',now(),'','COINSM201700000000000000','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000002','运维管理','1','#','2','admin',now(),NULL,'COINSM201700001000000001','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000003','菜单管理','1','/system/menu.htm','1','admin',now(),NULL,'COINSM201700001000000002','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000004','新增','2','/add','1','admin',now(),'','COINSM201700001000000003','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017022412460281492','平台流水','1','/finance/platform_ledger.htm','2','admin',now(),'','COINSM2016120710233232137','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017022412472301488','详情','2','/detail','1','admin',now(),'','COINSM2017022412460281492','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017022412482059354','导出','2','/export','2','admin',now(),'','COINSM2017022412460281492','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017022413014074915','导出','2','/export','3','admin',now(),'','COINSM2016120710443551388','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017022413024043573','导出','2','/export','3','admin',now(),'','COINSM2016120710421392861','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017032911200961325','修改','2','/edit','2','admin',now(),'','COINSM201700001000000003','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017033020005366333','banner管理','1','/public/banner.htm','1','admin',now(),'','COINSM201707251006045006005','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017033020015631166','新增','2','/add','1','admin',now(),'','COINSM2017033020005366333','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017033020021094115','修改','2','/edit','2','admin',now(),'','COINSM2017033020005366333','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017033020022649991','删除','2','/delete','3','admin',now(),'','COINSM2017033020005366333','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017033020024827112','详情','2','/detail','4','admin',now(),'','COINSM2017033020005366333','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017040616442519963','详情','2','/detail1','3','admin',now(),'','COINSM2016120711021944714','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017040616443747740','详情','2','/detail1','3','admin',now(),'','COINSM2016120711034365344','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017050810454898238','导出','2','/export','4','admin',now(),'','COINSM2016120711034365344','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017051511323094138','回录','2','/huilu','21','admin',now(),'','COINSM2016120711034365344','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201705151132544318','导出','2','/export','5','admin',now(),'','COINSM2016120711021944714','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017052014005252645','取现规则','1','/rules/enchashmentRule.htm','1','admin',now(),'','COINSM2016120710242555432','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017052014013690196','修改','2','/edit','1','admin',now(),'','COINSM2017052014005252645','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201707251006045006005','广告位管理','1','#','5','admin',now(),'','COINSM201700001000000001','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201707251143314118180','充币管理','1','#','3','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201707251147233303780','取现查询','1','/finance/lineUnder.htm','3','admin',now(),'','COINSM2016120710242555432','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201707251148117352030','充值查询','1','/finance/offlineRecharge.htm','2','admin',now(),'','COINSM201707251143314118180','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201707251320494186231','导出','2','/export','5','admin',now(),'','COINSM201707251147233303780','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201707251331497821971','导出','2','/export','5','admin',now(),'','COINSM201707251148117352030','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201708241024194086655','删除','2','/delete','3','admin',now(),'','COINSM201700001000000003','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201708241027280514724','服务热线','1','/public/hotline_addedit.htm','2','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201708241027559375318','服务时间','1','/public/serviceTime_addedit.htm','3','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201708241036442974134','业务管理','1','#','2','admin',now(),'','COINSM201700000000000000','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201708241037322072730','统计分析','1','#','4','admin',now(),'','COINSM201700000000000000','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716241339082','运营管理','1','#','1','admin',now(),'','COINSM201700001000000001','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716253866426','角色管理','1','/system/role.htm','1','admin',now(),'','COINSM2017101716241339082','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716261754674','会员查询','1','/system/user.htm','2','admin',now(),'','COINSM2017101716241339082','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716450533995','分配菜单','2','/change','4','admin',now(),'','COINSM2017101716253866426','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101717551955993','新增','2','/add','1','admin',now(),'','COINSM2017101716253866426','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101717560118734','修改','2','/edit','2','admin',now(),'','COINSM2017101716253866426','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101717563661357','删除','2','/delete','3','admin',now(),'','COINSM2017101716253866426','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719082391126','新增','2','/add','1','admin',now(),'','COINSM2017101716261754674','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719094151894','重置密码','2','/reset','2','admin',now(),'','COINSM2017101716261754674','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719100760088','注销','2','/rock','4','admin',now(),'','COINSM2017101716261754674','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719110981215','设置角色','2','/assign','5','admin',now(),'','COINSM2017101716261754674','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017112911152991684','消息推送','1','#','3','admin',now(),'','COINSM201700001000000001','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017112911280249973','公告管理','1','/public/notice.htm','1','admin',now(),'','COINSM2017112911152991684','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017112914292031228','新增','2','/add','1','admin',now(),'','COINSM2017112911280249973','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017112914295002950','修改','2','/edit2','2','admin',now(),'','COINSM2017112911280249973','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017112914322481897','发布/撤下','2','/push','3','admin',now(),'','COINSM2017112911280249973','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017112914325471772','详情','2','/detail','5','admin',now(),'','COINSM2017112911280249973','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017120610552303416','激活','2','/active','3','admin',now(),'','COINSM2017101716261754674','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017121215543215610','文章管理','1','#','4','admin',now(),'','COINSM201700001000000001','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017121216045274832','关于我们','1','/public/aboutus_addedit.htm','1','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711071719583941706','客户管理','1','#','1','admin',now(),'','COINSM201708241036442974134','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711071721131644746','用户管理','1','/user/customer.htm','1','admin',now(),'','SM201711071719583941706','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711071732196251623','账户查询','2','/account','1','admin',now(),'','SM201711071721131644746','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711071741562566376','禁止登录','2','/rock','2','admin',now(),'','SM201711071721131644746','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711071742227377285','允许登录','2','/active','3','admin',now(),'','SM201711071721131644746','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711071742467608972','详情','2','/detail','4','admin',now(),'','SM201711071721131644746','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711071743219033850','添加备注','2','/remark','5','admin',now(),'','SM201711071721131644746','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081111547852084','手续费管理','1','/rules/handsFee.htm','3','admin',now(),'','COINSM2016120710233232137','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081400404895487','修改','2','/edit','1','admin',now(),'','SM201711081111547852084','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081404308124201','会员账户','1','#','2','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081409307984995','分发地址','1','/finance/diviAddress.htm','1','admin',now(),'','SM201711081404308124201','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081410356859335','流水查询','2','/diviLedger','1','admin',now(),'','SM201711081409307984995','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081416278853402','提币管理','1','#','3','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081417503013352','提币规则','1','/rules/TBRule.htm','1','admin',now(),'','SM201711081416278853402','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081418173353867','修改','2','/edit','1','admin',now(),'','SM201711081417503013352','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081421358326980','提币地址','1','/finance/TBAddress.htm','2','admin',now(),'','SM201711081416278853402','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081423308601904','生成','2','/add','1','admin',now(),'','SM201711081421358326980','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081424358887020','线下提币','1','/finance/TBunderline.htm','3','admin',now(),'','SM201711081416278853402','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081425019933095','待申请','2','/add','1','admin',now(),'','SM201711081424358887020','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081426026276170','批量审核','2','/multiCheck','2','admin',now(),'','SM201711081424358887020','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081426421228978','提币广播','2','/sp','3','admin',now(),'','SM201711081424358887020','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081431005882968','归集管理','1','#','4','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081431436371130','归集规则','1','/rules/GJRule.htm','1','admin',now(),'','SM201711081431005882968','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081435280411458','修改','2','/edit','1','admin',now(),'','SM201711081431436371130','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081436354534709','归集地址','1','/finance/GJAddress.htm','2','admin',now(),'','SM201711081431005882968','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081437069726688','导入','2','/import','1','admin',now(),'','SM201711081436354534709','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081437452861020','弃用','2','/dele','2','admin',now(),'','SM201711081436354534709','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081442278817722','归集查询','1','/finance/GJQuery.htm','3','admin',now(),'','SM201711081431005882968','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081443284653211','申请归集','2','/add','1','admin',now(),'','SM201711081442278817722','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711081444203473881','归集','2','/GJ','2','admin',now(),'','SM201711081442278817722','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091113070529521','不平账处理','1','#','6','admin',now(),'','COINSM201612071021105964','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091346241039616','不平账处理','1','/finance/unfairOutAccount.htm','1','admin',now(),'','SM201711091113070529521','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091347287638130','审核','2','/exam','1','admin',now(),'','SM201711091346241039616','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091347562977987','详情','2','/detail','2','admin',now(),'','SM201711091346241039616','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091348223364368','导出','2','/export','3','admin',now(),'','SM201711091346241039616','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091636299534636','本地账户','1','/biz/locationAccount.htm','2','admin',now(),'','SM201711071719583941706','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091636598886982','流水查询','2','/ledger','1','admin',now(),'','SM201711091636299534636','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091638097956060','交易管理','1','#','2','admin',now(),'','COINSM201708241036442974134','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091639383748993','购买交易','1','/biz/buyTrade.htm','1','admin',now(),'','SM201711091638097956060','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091640072325860','详情','2','/detail','1','admin',now(),'','SM201711091639383748993','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091640445089127','卖给他','2','/sole','2','admin',now(),'','SM201711091639383748993','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091641382614985','出售交易','1','/biz/soleTrade.htm','2','admin',now(),'','SM201711091638097956060','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091642028999956','详情','2','/detail','1','admin',now(),'','SM201711091641382614985','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091642346081414','收买','2','/buy','2','admin',now(),'','SM201711091641382614985','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091710574389258','订单管理','1','#','3','admin',now(),'','COINSM201708241036442974134','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091711202133779','活动管理','1','#','5','admin',now(),'','COINSM201708241036442974134','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091711390371362','行情资讯','1','#','6','admin',now(),'','COINSM201708241036442974134','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091712271962290','进行中订单','1','/biz/order.htm','1','admin',now(),'','SM201711091710574389258','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091712492468382','详情','2','/detail','1','admin',now(),'','SM201711091712271962290','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091719313133524','已完成订单','1','/biz/finishOrder.htm','2','admin',now(),'','SM201711091710574389258','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091719507483488','详情','2','/detail','1','admin',now(),'','SM201711091719313133524','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091723009493989','邀请好友','1','/biz/shareFriend.htm','1','admin',now(),'','SM201711091711202133779','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091724462495772','ETH行情','1','/biz/eth.htm','1','admin',now(),'','SM201711091711390371362','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091725035119209','修改','2','/edit','1','admin',now(),'','SM201711091724462495772','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091725583336338','BTC行情','1','/biz/btc.htm','2','admin',now(),'','SM201711091711390371362','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091726534627002','法币汇率','1','/biz/fbRate.htm','3','admin',now(),'','SM201711091711390371362','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091727245016992','修改','2','/edit','1','admin',now(),'','SM201711091726534627002','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091728365155392','资讯管理','1','/biz/information.htm','4','admin',now(),'','SM201711091711390371362','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091729039813895','新增','2','/add','1','admin',now(),'','SM201711091728365155392','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091729369582783','修改','2','/edit','2','admin',now(),'','SM201711091728365155392','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711091730354633453','详情','2','/detail','6','admin',now(),'','SM201711091728365155392','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711151745051751013','仲裁订单','1','/biz/zcOrder.htm','2','admin',now(),'','SM201711181351035579061','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711151745572859074','详情','2','/detail','1','admin',now(),'','SM201711151745051751013','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711151747477561668','处理订单','2','/resolve','2','admin',now(),'','SM201711151745051751013','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711171350455423428','上架','2','/up','3','admin',now(),'','SM201711091728365155392','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711171351069262405','下架','2','/down','4','admin',now(),'','SM201711091728365155392','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181154357386481','导出','2','/export','2','admin',now(),'','SM201711091712271962290','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181155140535753','导出','2','/export','2','admin',now(),'','SM201711091719313133524','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181155445002845','导出','2','/export','2','admin',now(),'','SM201711151745051751013','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181218447587419','常见问题','1','/public/question_addedit.htm','4','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181220013316605','服务条款','1','/public/service_addedit.htm','5','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181221122323114','如何注册','1','/public/zc_addedit.htm','6','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181221480766596','如何充值','1','/public/cz_addedit.htm','7','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181222331323776','认证与安全','1','/public/safe_addedit.htm','8','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181223242037562','如何交易','1','/public/trade_addedit.htm','9','admin',now(),'','COINSM2017121215543215610','CD-COIN000017');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201711181351035579061','仲裁管理','1','#','4','admin',now(),'','COINSM201708241036442974134','CD-COIN000017');

/*
-- Query: SELECT `code`,`name`,`level`,'admin' as `updater`,now() as 'update_datetime',`remark`,`system_code` FROM tsys_role where system_code = 'CD-COIN000017'
LIMIT 0, 10000

-- Date: 2017-03-31 10:33
*/
INSERT INTO `tsys_role` (`code`,`name`,`level`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','超级管理员','1','admin',now(),'','CD-COIN000017');

/*
-- Query: SELECT `role_code`,`menu_code`,`updater`,now() as `update_datetime`,`remark`,`system_code` FROM tsys_menu_role where system_code = 'CD-COIN000017'
-- Date: 2017-11-20 10:16
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201700000000000000','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201612071021105964','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201612071022206883','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120710421392861','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120816125733948','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120816133940523','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017022413024043573','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120710443551388','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120911033945882','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120911042060088','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017022413014074915','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120710225078473','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120710470696888','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201612091114505291','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120911160661084','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016122219590218515','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120710484209132','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120911293120195','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120911301231346','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016122220000572417','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120710233232137','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016120710583381112','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016122317590316953','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2016122412144574736','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017022412460281492','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017022412472301488','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017022412482059354','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081111547852084','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081400404895487','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201707251143314118180','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201707251148117352030','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201707251331497821971','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081404308124201','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081409307984995','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081410356859335','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081416278853402','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081417503013352','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081418173353867','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081421358326980','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081423308601904','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081424358887020','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081425019933095','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081426026276170','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081426421228978','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081431005882968','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081431436371130','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081435280411458','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081436354534709','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081437069726688','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081437452861020','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081442278817722','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081443284653211','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711081444203473881','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091113070529521','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091346241039616','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091347287638130','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091347562977987','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091348223364368','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201700001000000001','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201700001000000002','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201700001000000003','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201700001000000004','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017032911200961325','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201708241024194086655','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201707251006045006005','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017033020005366333','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017033020015631166','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017033020021094115','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017033020022649991','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017033020024827112','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101716241339082','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101716253866426','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101716450533995','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101717551955993','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101717560118734','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101717563661357','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101716261754674','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101719082391126','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101719094151894','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101719100760088','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017101719110981215','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017120610552303416','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017112911152991684','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017112911280249973','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017112914292031228','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017112914295002950','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017112914322481897','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017112914325471772','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017121215543215610','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201708241027280514724','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201708241027559375318','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM2017121216045274832','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181218447587419','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181220013316605','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181221122323114','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181221480766596','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181222331323776','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181223242037562','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','COINSM201708241036442974134','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711071719583941706','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711071721131644746','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711071732196251623','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711071741562566376','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711071742227377285','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711071742467608972','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711071743219033850','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091636299534636','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091636598886982','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091638097956060','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091639383748993','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091640072325860','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091640445089127','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091641382614985','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091642028999956','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091642346081414','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091710574389258','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091712271962290','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091712492468382','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181154357386481','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091719313133524','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091719507483488','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181155140535753','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091711202133779','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091723009493989','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091711390371362','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091724462495772','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091725035119209','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091725583336338','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091726534627002','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091727245016992','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091728365155392','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091729039813895','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091729369582783','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711091730354633453','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711171350455423428','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711171351069262405','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181351035579061','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711151745051751013','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711151745572859074','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711151747477561668','admin',now(),NULL,'CD-COIN000017');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('COINSR201700000000000000','SM201711181155445002845','admin',now(),NULL,'CD-COIN000017');







