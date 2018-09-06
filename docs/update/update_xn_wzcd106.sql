INSERT INTO `tsys_dict` (`type`, `parent_key`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('1', 'az_location', '9', '其他', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');

ALTER TABLE `tdq_budget_order_gps` 
ADD COLUMN `az_location_remark` VARCHAR(255) NULL COMMENT '安装位置备注' AFTER `az_location`;

ALTER TABLE `tdq_credit_user` 
ADD COLUMN `court_network_results_remark` VARCHAR(255) NULL COMMENT '法院网查询结果备注' AFTER `court_network_results`;

INSERT INTO `tsys_dict` (`type`, `dkey`, `dvalue`, `updater`, `update_datetime`, `company_code`, `system_code`) VALUES ('0', 'court_network_results', '法院网查询结果', 'admin', '2018-08-15 17:32:12', 'CD-CWZCD000020', 'CD-CWZCD000020');
