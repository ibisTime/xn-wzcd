ALTER TABLE `tdh_repay_plan` 
CHANGE COLUMN `ts_bank_name` `ts_bank_code` VARCHAR(32) NULL DEFAULT NULL COMMENT '拖车开户行' ;
