UPDATE `tsys_node` SET `name`='风控总监理审核' WHERE `code`='020_03';
UPDATE `tsys_node` SET `name`='财务审核' WHERE `code`='020_04';
UPDATE `tsys_node` SET `name`='确认付款' WHERE `code`='020_05';
UPDATE `tsys_node` SET `name`='风控经理审核' WHERE `code`='020_08';
UPDATE `tsys_node` SET `name`='打印岗打印' WHERE `code`='020_09';
UPDATE `tsys_node` SET `name`='寄送银行材料' WHERE `code`='020_10';
UPDATE `tsys_node` SET `name`='驻行人员提交材料' WHERE `code`='020_11';
UPDATE `tsys_node` SET `name`='抵押完成' WHERE `code`='020_12';
DELETE FROM `tsys_node` WHERE `code`='020_13';
DELETE FROM `tsys_node` WHERE `code`='020_14';


ALTER TABLE `tdq_budget_order` 
ADD COLUMN `contract_sign_date` datetime COMMENT '合同签订日' AFTER `bank_contract_code`;

ALTER TABLE `tdq_logistics` 
ADD COLUMN `is_bank_point_part_supt` varchar(4) COMMENT '是否为银行驻点补件' AFTER `receipt_datetime`;
