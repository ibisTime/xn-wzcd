ALTER TABLE `tht_brand` 
ADD COLUMN `brand_id` INT NULL COMMENT '品牌标识' AFTER `code`,
ADD COLUMN `type` varchar(4) NULL COMMENT '品牌类型（1接口导入,2用户新增）' AFTER `brand_id`;

ALTER TABLE `tht_series` 
ADD COLUMN `brand_id` INT NULL COMMENT '品牌标识' AFTER `code`,
ADD COLUMN `series_id` INT NULL COMMENT '车系标识' AFTER `brand_id`,
ADD COLUMN `type` varchar(4) NULL COMMENT '车系类型（1接口导入,2用户新增）' AFTER `series_id`,
ADD COLUMN `maker_type` varchar(255) NULL COMMENT '制造商类型' AFTER `type`,
ADD COLUMN `series_group_name` varchar(255) NULL COMMENT '系列组名' AFTER `name`;

ALTER TABLE `tht_car` 
ADD COLUMN `series_id` INT NULL COMMENT '车系标识' AFTER `code`,
ADD COLUMN `model_id` INT NULL COMMENT '车型标识' AFTER `series_id`,
ADD COLUMN `type` varchar(4) NULL COMMENT '车型类型（1接口导入,2用户新增）' AFTER `model_id`,
ADD COLUMN `model_year` varchar(32) NULL COMMENT '年款' AFTER `sale_price`,
ADD COLUMN `min_reg_year` varchar(32) NULL COMMENT ' 最小上牌年份' AFTER `model_year`,
ADD COLUMN `max_reg_year` varchar(32) NULL COMMENT '最大上牌年份' AFTER `min_reg_year`,
ADD COLUMN `liter` varchar(255) NULL COMMENT '排量' AFTER `max_reg_year`,
ADD COLUMN `gear_type` varchar(255) NULL COMMENT '变速箱' AFTER `liter`,
ADD COLUMN `discharge_standard` varchar(255) NULL COMMENT '排放标准' AFTER `gear_type`,
ADD COLUMN `seat_number` varchar(32) NULL COMMENT '座位数' AFTER `discharge_standard`;

ALTER TABLE `tht_car` 
CHANGE COLUMN `sale_price` `sale_price` VARCHAR(255) NULL DEFAULT NULL COMMENT '参考价' ;



INSERT INTO `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`, `company_code`, `system_code`) VALUES ('car_refresh', 'url', 'http://api.che300.com/service', 'admin', '2018-08-15 17:33:30', '车辆刷新url', 'CD-CWZCD000020', 'CD-CWZCD000020');

UPDATE `tsys_config` SET `cvalue`='storage' WHERE `id`='3';
UPDATE `tsys_config` SET `cvalue`='http://pi8arp14o.bkt.clouddn.com' WHERE `id`='4';
UPDATE `tsys_config` SET `cvalue`='vD0zZvIefnOy4MyX2IF1AG6-qClmvFbqT-aYFnsy' WHERE `id`='2';
UPDATE `tsys_config` SET `cvalue`='xjDbsm1LJCwQy4NxRcP3hmrOjqFmFVQHxgQl_7Mu' WHERE `id`='1';

DROP TABLE IF EXISTS `tdh_city_list`;
CREATE TABLE `tdh_city_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `city_id` int(11) DEFAULT NULL COMMENT '城市ID',
  `city_name` varchar(32) DEFAULT NULL COMMENT '城市名称',
  `prov_id` int(11) DEFAULT NULL COMMENT '所属省份ID',
  `prov_name` varchar(32) DEFAULT NULL COMMENT '所属省份名称',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市列表';

DROP TABLE IF EXISTS `tdh_basic_valuation`;
CREATE TABLE `tdh_basic_valuation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `model_id` varchar(32) DEFAULT NULL COMMENT '车型标识',
  `reg_date` varchar(32) DEFAULT NULL COMMENT '待估车辆的上牌时间',
  `mile` double DEFAULT NULL COMMENT '待估车辆的公里数(单位万公里)',
  `zone` varchar(32) DEFAULT NULL COMMENT '城市标识',
  `eval_price` varchar(32) DEFAULT NULL COMMENT '评估价格',
  `low_price` varchar(32) DEFAULT NULL COMMENT '最低价',
  `good_price` varchar(32) DEFAULT NULL COMMENT '最优价',
  `high_price` varchar(32) DEFAULT NULL COMMENT '最高价',
  `dealer_buy_price` varchar(32) DEFAULT NULL COMMENT '车商收购价',
  `individual_price` varchar(32) DEFAULT NULL COMMENT '个人交易价',
  `dealer_price` varchar(32) DEFAULT NULL COMMENT '车商零售价',
  `url` varchar(255) DEFAULT NULL COMMENT '地址',
  `price` varchar(32) DEFAULT NULL COMMENT '新车售价',
  `discharge_standard` varchar(32) DEFAULT NULL COMMENT '排放标准',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `car_logo_url` varchar(255) DEFAULT NULL COMMENT '汽车标志网址',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础估值';


INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'tongdun_type', '同盾类型', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'tongdun_type', 'mobile', '三要素核验', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'tongdun_type', 'online', '在网时长', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'tongdun_type', 'card', '银行卡四要素', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'tongdun_type', 'police', '自然人识别', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'tongdun_type', 'home_address', '家庭地址核验', 'USYS201800000000001', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `card_number` varchar(255) NULL COMMENT '卡号' AFTER `bank_card_number`;
