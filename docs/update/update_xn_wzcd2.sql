CHANGE COLUMN `out_account_no` `account_no` VARCHAR(32) NULL DEFAULT NULL COMMENT '收款账号（外单手动填写的汽车经销商收款账号 ）' ,



ALTER TABLE `tsys_department` 
DROP COLUMN `lead_name`,
DROP COLUMN `lead_mobile`,
ADD COLUMN `lead_user_id` VARCHAR(32) NULL  COMMENT '负责人用户编号' AFTER `name`,
ADD COLUMN `order_no` int(11) NULL  COMMENT '序号' AFTER `area_no`;
