
/*添加分成比例字段*/
ALTER TABLE `tstd_user` 
CHANGE COLUMN `div_rate` `div_rate1` DECIMAL(18,8) NULL DEFAULT NULL COMMENT '分成比例1' ,
ADD COLUMN `div_rate2` DECIMAL(18,8) NULL COMMENT '分成比例2' AFTER `div_rate1`;
/*默认设置分成比例*/
UPDATE `tstd_user` SET `div_rate1`='0.001', `div_rate2`='0.01' WHERE `kind`='C';

/*合并待交易1和交易中2状态为上架状态1，已下架(3)状态变为2*/
UPDATE `tcoin_ads` SET `status`='1' WHERE `status` in ('2');
UPDATE `tcoin_ads` SET `status`='2' WHERE `status` in ('3');
/*更新广告状态数据字典*/
UPDATE `tsys_dict` SET `dvalue`='已上架' WHERE `parent_key`='ads_status' AND `dkey`='1';
UPDATE `tsys_dict` SET `dvalue`='已下架' WHERE `parent_key`='ads_status' AND `dkey`='2';
DELETE FROM `tsys_dict` WHERE `parent_key`='ads_status' AND `dkey`='3';



