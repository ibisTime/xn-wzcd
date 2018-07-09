CHANGE COLUMN `out_account_no` `account_no` VARCHAR(32) NULL DEFAULT NULL COMMENT '收款账号（外单手动填写的汽车经销商收款账号 ）' ,



ALTER TABLE `tsys_department` 
DROP COLUMN `lead_name`,
DROP COLUMN `lead_mobile`,
ADD COLUMN `lead_user_id` VARCHAR(32) NULL  COMMENT '负责人用户编号' AFTER `name`,
ADD COLUMN `order_no` int(11) NULL  COMMENT '序号' AFTER `area_no`;

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `emergency_name1` tinytext NULL  COMMENT '家庭紧急联系人信息1 姓名' AFTER `reg_certificate_code`,
ADD COLUMN `emergency_relation1` tinytext NULL  COMMENT '家庭紧急联系人信息1 与申请人关系' AFTER `emergency_name1`,
ADD COLUMN `emergency_mobile1` tinytext NULL  COMMENT '家庭紧急联系人信息1 手机号码' AFTER `emergency_relation1`,
ADD COLUMN `emergency_name2` tinytext NULL  COMMENT '家庭紧急联系人信息2 姓名' AFTER `emergency_mobile1`,
ADD COLUMN `emergency_relation2` tinytext NULL  COMMENT '家庭紧急联系人信息2 与申请人关系' AFTER `emergency_name2`,
ADD COLUMN `emergency_mobile2` tinytext NULL  COMMENT '家庭紧急联系人信息2 手机号码' AFTER `emergency_relation2`;