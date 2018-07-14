ALTER TABLE `tdq_budget_order` 
ADD COLUMN `gh_id_picz` tinytext NULL  COMMENT '共还人身份证照片正' AFTER `gh_id_no`,
ADD COLUMN `gh_id_picf` tinytext NULL  COMMENT '共还人身份证照片反' AFTER `gh_id_picz`,
ADD COLUMN `guarantor1_id_picz` tinytext NULL  COMMENT '担保人1身份证照片正' AFTER `guarantor1_id_no`,
ADD COLUMN `guarantor1_id_picf` tinytext NULL  COMMENT '担保人1身份证照片反' AFTER `guarantor1_id_picz`,
ADD COLUMN `guarantor2_id_picz` tinytext NULL  COMMENT '担保人2身份证照片正' AFTER `guarantor2_id_no`,
ADD COLUMN `guarantor2_id_picf` tinytext NULL  COMMENT '担保人2身份证照片反' AFTER `guarantor2_id_picz`,
CHANGE COLUMN `id_no_pic` `id_no_picz` tinytext NULL COMMENT '身份证照片正' ,
ADD COLUMN `id_no_picf` tinytext NULL  COMMENT '身份证照片反' AFTER `id_no_picz`;

ALTER TABLE `tdq_credit_user`
ADD COLUMN `is_first_audit` VARCHAR(4) NULL DEFAULT NULL COMMENT '是否一审' AFTER `jour_show_income`;