ALTER TABLE `tdh_repay_plan` 
CHANGE COLUMN `ts_bank_name` `ts_bank_code` VARCHAR(32) NULL DEFAULT NULL COMMENT '拖车开户行' ;

ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `is_logistics` VARCHAR(4) NULL COMMENT '是否在物流传递中' AFTER `team_code`;
