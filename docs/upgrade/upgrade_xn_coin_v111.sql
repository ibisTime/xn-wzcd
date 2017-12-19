
/*添加分成比例字段*/
ALTER TABLE `tstd_user` 
CHANGE COLUMN `div_rate` `div_rate1` DECIMAL(18,8) NULL DEFAULT NULL COMMENT '分成比例1' ,
ADD COLUMN `div_rate2` DECIMAL(18,8) NULL COMMENT '分成比例2' AFTER `div_rate1`;
/*默认设置分成比例*/
UPDATE `tstd_user` SET `div_rate1`='0.001', `div_rate2`='0.01' WHERE `kind`='C';



