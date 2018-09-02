UPDATE `tsys_node` SET `name`='执行结果录入' WHERE `code`='021_20';

ALTER TABLE `tdq_budget_order` 
ADD COLUMN `bank_benchmark_rate` decimal(18,8) NULL COMMENT '银行基准利率' AFTER `bank_rate`;

ALTER TABLE `tdh_overdue_treatment` 
ADD COLUMN `collection_type` VARCHAR(4) NULL COMMENT '催收类型(0过程，1结果)' AFTER `collection_result_note`;

ALTER TABLE `tdh_repay_biz` 
ADD COLUMN `is_implement_again` VARCHAR(4) NULL COMMENT '是否恢复执行' AFTER `judge_bill_pdf`;