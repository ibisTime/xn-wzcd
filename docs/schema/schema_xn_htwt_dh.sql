/**/
DROP TABLE IF EXISTS `tdh_overdue_menu`;
CREATE TABLE `tdh_overdue_menu` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `real_name` VARCHAR(255) NULL COMMENT '客户姓名',
  `id_no` VARCHAR(32) NULL COMMENT '证件号',
  `loan_bank_name` VARCHAR(255) NULL COMMENT '贷款银行名称',
  `loan_amount` BIGINT(11) NULL COMMENT '贷款金额',
  `periods` INT(11) NULL COMMENT '总期数',
  `remain_amount` BIGINT(11) NULL COMMENT '剩余金额',
  `fk_datetime` DATETIME NULL COMMENT '放款日期',
  `overdue_amount` BIGINT(11) NULL COMMENT '逾期金额',
  `overdue_datetime` DATETIME NULL COMMENT '逾期日期',
  `import_datetime` DATETIME NULL COMMENT '导入日期',
  `import_note` VARCHAR(255) NULL COMMENT '导入说明',
  `status` VARCHAR(4) NULL COMMENT '状态(0 待处理 1 已处理)',
  `handle_note` VARCHAR(255) NULL COMMENT '处理说明',
  `budget_order_code` VARCHAR(32) NULL COMMENT '准入单编号',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '导入逾期名单';
