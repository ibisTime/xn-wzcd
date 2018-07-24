UPDATE `tsys_node` SET `name`='总公司寄送银行材料' WHERE `code`='007_02';
UPDATE `tsys_node` SET `name`='改成寄件岗寄件' WHERE `code`='007_05';


DROP TABLE IF EXISTS `tdq_contract_import`;
CREATE TABLE `tdq_contract_import` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `contract_code` varchar(32) NOT NULL COMMENT '合同号',
  `budget_order_code` varchar(32) DEFAULT NULL COMMENT '预算单编号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '银行',
  `bill_datetime` int(11) DEFAULT NULL COMMENT '账单日',
  `repay_bank_date` int(11) DEFAULT NULL COMMENT '还款日',
  `bank_card_number` varchar(32) DEFAULT NULL COMMENT '信用卡号',
  `contract_sign_date` datetime DEFAULT NULL COMMENT '合同签订日',
  `import_datetime` datetime DEFAULT NULL COMMENT '导入日期',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `operator` varchar(32) DEFAULT NULL COMMENT '操作人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`) COMMENT '银行合同导入'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行合同导入';

