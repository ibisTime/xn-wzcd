DROP TABLE IF EXISTS `tdh_overdue_treatment`;
CREATE TABLE `tdh_overdue_treatment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `repay_plan_code` varchar(32) DEFAULT NULL COMMENT '还款计划编号',
  `collection_way` varchar(4) DEFAULT NULL COMMENT '催收方式',
  `collection_target` varchar(4) DEFAULT NULL COMMENT '催收对象',
  `collection_process` varchar(4) DEFAULT NULL COMMENT '催收过程',
  `collection_wish` varchar(4) DEFAULT NULL COMMENT '客户意愿',
  `collection_process_note` varchar(255) DEFAULT NULL COMMENT '催收过程说明',
  `collection_result` varchar(4) DEFAULT NULL COMMENT '催收结果',
  `depositIs_provide` varchar(4) DEFAULT NULL COMMENT '是否提供押金',
  `overdue_deposit` bigint(20) DEFAULT NULL COMMENT '违约押金',
  `real_repay_amount` bigint(20) DEFAULT NULL COMMENT '实际还款金额',
  `collection_result_note` varchar(255) DEFAULT NULL COMMENT '催收结果说明',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `update_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='逾期处理';

ALTER TABLE `tdh_cost` 
ADD COLUMN `overdue_treatment_code` VARCHAR(32) NULL COMMENT '逾期处理编号' AFTER `repay_plan_code`;

ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `final_payee` VARCHAR(255) NULL COMMENT '最终收款人' AFTER `Is_logistics`;
ADD COLUMN `payee_enclosure` VARCHAR(255) NULL COMMENT '附件' AFTER `final_payee`;


