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


DROP TABLE IF EXISTS `tdp_supplement_reason`;
CREATE TABLE `tdp_supplement_reason` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `logistics_code` varchar(32) DEFAULT NULL COMMENT '物流单编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `reason` tinytext COMMENT '原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补件原因';

ALTER TABLE `dev_xn_wzcd`.`tdq_budget_order` 
ADD COLUMN `enter_file_status` VARCHAR(4) NULL COMMENT '入档状态（0待入档1待补录2已入档）' AFTER `type`;
