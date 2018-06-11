DROP TABLE IF EXISTS `tp_archive`;
CREATE TABLE `tp_archive` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `id_no` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `job_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `post_code` varchar(32) DEFAULT NULL COMMENT '职务岗位编号',
  `job_classes` varchar(32) DEFAULT NULL COMMENT '上班班次',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `politics` varchar(32) DEFAULT NULL COMMENT '政治面貌',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `education` varchar(32) DEFAULT NULL COMMENT '学历',
  `work_status` varchar(32) DEFAULT NULL COMMENT '状态',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `salary_card` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `five_insurance_info` varchar(255) DEFAULT NULL COMMENT '五险一金信息',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍地址',
  `residence_property` varchar(32) DEFAULT NULL COMMENT '户籍性质',
  `social_security_reg_datetime` datetime DEFAULT NULL COMMENT '社保登记日期',
  `current_address` varchar(255) DEFAULT NULL COMMENT '现住址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(11) DEFAULT NULL COMMENT '紧急联系号码',
  `contract_deadline` varchar(32) DEFAULT NULL COMMENT '合同期限',
  `contract_type` varchar(32) DEFAULT NULL COMMENT '合同类型',
  `probation_time` varchar(32) DEFAULT NULL COMMENT '试用期时间',
  `convert_datetime` datetime DEFAULT NULL COMMENT '转正日期',
  `leave_datetime` datetime DEFAULT NULL COMMENT '离职日期',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职缘由',
  `heir_people` varchar(255) DEFAULT NULL COMMENT '交接人',
  `entrance_no` varchar(32) DEFAULT NULL COMMENT '门禁号',
  `check_no` varchar(32) DEFAULT NULL COMMENT '考勤号',
  `car_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `id_no_pdf` varchar(255) DEFAULT NULL COMMENT '身份证复印件',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `wechat` varchar(32) DEFAULT NULL COMMENT '微信',
  `qq` varchar(32) DEFAULT NULL COMMENT 'QQ',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `commumication_fee_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `no_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_award` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_award` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_ward` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_award` bigint(20) DEFAULT NULL COMMENT '餐补',
  `working_years` varchar(32) DEFAULT NULL COMMENT '工龄',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人事档案';

DROP TABLE IF EXISTS `tp_archive_location`;
CREATE TABLE `tp_archive_location` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '位置名称',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案存放位置';

DROP TABLE IF EXISTS `tp_ask_for_apply`;
CREATE TABLE `tp_ask_for_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `lead_user_id` varchar(255) DEFAULT NULL COMMENT '请示领导',
  `content` varchar(255) DEFAULT NULL COMMENT '请示内容',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领导请示申请';

DROP TABLE IF EXISTS `tp_assert_apply`;
CREATE TABLE `tp_assert_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT NULL COMMENT '类型(1=办公 2=固定资产)',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `is_print` char(1) DEFAULT NULL COMMENT '是否印刷品（1是 2不是）',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公用品/固定资产';

DROP TABLE IF EXISTS `tp_assert_goods`;
CREATE TABLE `tp_assert_goods` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `assert_code` varchar(32) DEFAULT NULL COMMENT '办公用品编号',
  `product_code` varchar(45) DEFAULT NULL COMMENT '品名',
  `mode` varchar(255) DEFAULT NULL COMMENT '规格',
  `quantity` varchar(32) DEFAULT NULL COMMENT '申请数量',
  `price` bigint(20) DEFAULT NULL COMMENT '出库价格',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公物品列表';

DROP TABLE IF EXISTS `tp_assert_user`;
CREATE TABLE `tp_assert_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `assert_code` varchar(32) DEFAULT NULL COMMENT '办公用品编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `print_quantity` varchar(32) DEFAULT NULL COMMENT '印刷数量',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公用户列表';

DROP TABLE IF EXISTS `tp_car_break`;
CREATE TABLE `tp_car_break` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '违章人编号',
  `car_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `happen_datetime` datetime DEFAULT NULL COMMENT '违章时间',
  `address` varchar(255) DEFAULT NULL COMMENT '违章地点',
  `action` varchar(255) DEFAULT NULL COMMENT '违章行为',
  `score` int(11) DEFAULT NULL COMMENT '记分',
  `punish_amount` decimal(18,8) DEFAULT NULL COMMENT '罚款金额',
  `handle_note` varchar(255) DEFAULT NULL COMMENT '处理情况',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆违章处理';

DROP TABLE IF EXISTS `tp_check_project`;
CREATE TABLE `tp_check_project` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `check_result` varchar(255) DEFAULT NULL COMMENT '考核指标',
  `check_user` varchar(255) DEFAULT NULL COMMENT '考核人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `employ_apply_code` varchar(32) NOT NULL COMMENT '应聘岗位编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考核项目';

DROP TABLE IF EXISTS `tp_comp_category`;
CREATE TABLE `tp_comp_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类别管理';

DROP TABLE IF EXISTS `tp_comp_product`;
CREATE TABLE `tp_comp_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `name` varchar(255) DEFAULT NULL COMMENT '品名',
  `model` varchar(255) DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品名管理';

DROP TABLE IF EXISTS `tp_comp_regime`;
CREATE TABLE `tp_comp_regime` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1行政事务类 2 人力资源管理类 3 财务管理类 4 营销管理类 5 生产管理类)',
  `regime_code` varchar(32) DEFAULT NULL COMMENT '制度编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `scope` varchar(32) DEFAULT NULL COMMENT '授权查看范围',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司制度';

DROP TABLE IF EXISTS `tp_contract`;
CREATE TABLE `tp_contract` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(255) DEFAULT NULL COMMENT '合同类型',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `archive_code` varchar(32) DEFAULT NULL COMMENT '档案编号',
  `contract_no` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始日期',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束日期',
  `pdf` varchar(255) DEFAULT NULL COMMENT '合同附件',
  `remark` varchar(255) DEFAULT NULL COMMENT '说明',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除 1正常',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tp_convert_apply`;
CREATE TABLE `tp_convert_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `entry_code` varchar(32) DEFAULT NULL COMMENT '入职编号',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `work_summary` varchar(255) DEFAULT NULL COMMENT '工作总结',
  `all_evaluation` varchar(255) DEFAULT NULL COMMENT '总体评价',
  `is_full_worker` varchar(4) DEFAULT NULL COMMENT '是否转正',
  `effect_datetime` datetime DEFAULT NULL COMMENT '生效日期',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='转正申请';

DROP TABLE IF EXISTS `tp_day_rest`;
CREATE TABLE `tp_day_rest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `is_rest` varchar(4) DEFAULT NULL COMMENT '是否休息',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='休息日记录';

DROP TABLE IF EXISTS `tp_employ_apply`;
CREATE TABLE `tp_employ_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `position` varchar(255) DEFAULT NULL COMMENT '应聘岗位',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `contact_mobile` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `speciality` varchar(255) DEFAULT NULL COMMENT '特长技能',
  `expect_salary` bigint(20) DEFAULT NULL COMMENT '期望薪资',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(255) DEFAULT NULL COMMENT '紧急联系号码',
  `postcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `award` varchar(255) DEFAULT NULL COMMENT '受过何种奖励或专业训练',
  `is_out` char(1) DEFAULT NULL COMMENT '能否出差',
  `is_over_time` char(1) DEFAULT NULL COMMENT '能否加班',
  `is_adjust_work` char(1) DEFAULT NULL COMMENT '能否接受工作调动',
  `is_once_recruited` char(1) DEFAULT NULL COMMENT '是否曾在我公司应聘',
  `is_friend_work` char(1) DEFAULT NULL COMMENT '是否有亲属或朋友在我司工作',
  `composite` varchar(255) DEFAULT NULL COMMENT '综合',
  `quality` varchar(255) DEFAULT NULL COMMENT '素质',
  `interview_record` varchar(255) DEFAULT NULL COMMENT '面试记录',
  `employ_result` varchar(255) DEFAULT NULL COMMENT '录用结果',
  `probation` varchar(255) DEFAULT NULL COMMENT '试用期',
  `employ_salary` bigint(20) DEFAULT NULL COMMENT '薪资',
  `employ_department_code` varchar(255) DEFAULT NULL COMMENT '入职部门',
  `employ_position_code` varchar(255) DEFAULT NULL COMMENT '入职职务',
  `employ_approve_user` varchar(255) DEFAULT NULL COMMENT '审核人',
  `employ_approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `employ_approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=待面试 1=已面试通过 2已面试不通过)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应聘岗位';

DROP TABLE IF EXISTS `tp_entry_apply`;
CREATE TABLE `tp_entry_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `position` varchar(255) DEFAULT NULL COMMENT '入职岗位',
  `department_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `entry_datetime` datetime DEFAULT NULL COMMENT '入职时间',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(4) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `health` varchar(32) DEFAULT NULL COMMENT '健康状况',
  `marry_status` varchar(32) DEFAULT NULL COMMENT '婚姻状况',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` varchar(32) DEFAULT NULL COMMENT '紧急联系号码',
  `residence_property` varchar(255) DEFAULT NULL COMMENT '户籍性质',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `residence_address` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `now_address` varchar(255) DEFAULT NULL COMMENT '现居住地址',
  `is_other_company_relation` varchar(32) DEFAULT NULL COMMENT '是否与其他单位存在劳动关系',
  `relative_name` varchar(255) DEFAULT NULL COMMENT '亲属从事本行姓名',
  `relative_relation` varchar(255) DEFAULT NULL COMMENT '亲属与本人关系',
  `relative_position` varchar(255) DEFAULT NULL COMMENT '亲属职务',
  `main_perform` varchar(255) DEFAULT NULL COMMENT '主要业绩及工作能力简述',
  `probation_start_datetime` datetime DEFAULT NULL COMMENT '试用期期限开始',
  `probation_end_datetime` datetime DEFAULT NULL COMMENT '试用期期限结束',
  `probation_salary` bigint(20) DEFAULT NULL COMMENT '试用期工资',
  `base_salary` bigint(20) DEFAULT NULL COMMENT '转正后基本工资',
  `perform_salary` bigint(20) DEFAULT NULL COMMENT '转正后绩效工资',
  `perform_salary_standard` varchar(255) DEFAULT NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` varchar(255) DEFAULT NULL COMMENT '季度奖考核标准',
  `communicate_pay_standard` varchar(255) DEFAULT NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '省会住宿报销标准',
  `non_provincial_bed_standard` varchar(255) DEFAULT NULL COMMENT '非省会住宿报销标准',
  `traffic_standard` bigint(20) DEFAULT NULL COMMENT '市内交通现金补助',
  `mobile_standard` bigint(20) DEFAULT NULL COMMENT '电话现金补贴',
  `taxi_standard` bigint(20) DEFAULT NULL COMMENT '出租车',
  `meal_standard` bigint(20) DEFAULT NULL COMMENT '餐补',
  `salary_card_no` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank` varchar(32) DEFAULT NULL COMMENT '工资卡账号',
  `bank_code` varchar(32) DEFAULT NULL COMMENT '开户行行号',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户支行',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入职申请';

DROP TABLE IF EXISTS `tp_fee_advance_apply`;
CREATE TABLE `tp_fee_advance_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `ref_assert_code` varchar(32) DEFAULT NULL COMMENT '关联资产审批编号',
  `ref_budget_order_code` varchar(32) DEFAULT NULL COMMENT '关联车贷业务编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '预支金额',
  `subbranch` varchar(255) DEFAULT NULL COMMENT '开户银行',
  `bankcard_number` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `account_name` varchar(255) DEFAULT NULL COMMENT '账户名',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `pay_datetime` datetime DEFAULT NULL COMMENT '付款时间',
  `pay_bank` varchar(32) DEFAULT NULL COMMENT '付款银行',
  `pay_bankcard` varchar(255) DEFAULT NULL COMMENT '付款账号',
  `pay_pdf` varchar(255) DEFAULT NULL COMMENT '付款凭证',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=待审核 1=审核通过 2=审核不通过 3=财务审核通过 4=财务审核不通过 5=确认放款)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='费用预支申请';

DROP TABLE IF EXISTS `tp_leave_apply`;
CREATE TABLE `tp_leave_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `type` varchar(4) DEFAULT NULL COMMENT '请假类别',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` int(11) DEFAULT NULL COMMENT '时长',
  `pdf` varchar(32) DEFAULT NULL COMMENT '附件',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假申请';

DROP TABLE IF EXISTS `tp_notice`;
CREATE TABLE `tp_notice` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) NOT NULL COMMENT '类型(1 公司动态 2 公司文件 3 培训说明)',
  `title` varchar(255) NOT NULL COMMENT '公告标题',
  `urgent_status` varchar(4) NOT NULL COMMENT '紧急程度（1 普通 2 紧急）',
  `publish_department_code` varchar(32) NOT NULL COMMENT '发布部门',
  `scope` varchar(32) DEFAULT NULL COMMENT '公告范围',
  `content` varchar(255) NOT NULL COMMENT '公告内容',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告管理';

DROP TABLE IF EXISTS `tp_notice_read`;
CREATE TABLE `tp_notice_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `status` varchar(32) DEFAULT NULL COMMENT '状态(0=未读，1=已读)',
  `notice_code` varchar(32) DEFAULT NULL COMMENT '公告编号',
  `ref_type` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告阅读记录';

DROP TABLE IF EXISTS `tp_overtime_apply`;
CREATE TABLE `tp_overtime_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加班申请';

DROP TABLE IF EXISTS `tp_probation_assess`;
CREATE TABLE `tp_probation_assess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `convert_code` varchar(32) DEFAULT NULL COMMENT '转正申请编号',
  `eval_item` varchar(255) DEFAULT NULL COMMENT '评估项目',
  `grade` decimal(18,8) DEFAULT NULL COMMENT '评估分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试用期评估';

DROP TABLE IF EXISTS `tp_recruit_apply`;
CREATE TABLE `tp_recruit_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `department_code` varchar(32) DEFAULT NULL COMMENT '申请部门编号',
  `position` varchar(255) DEFAULT NULL COMMENT '招聘岗位',
  `establish_quantity` int(11) DEFAULT NULL COMMENT '编制人数',
  `now_quantity` int(11) DEFAULT NULL COMMENT '现有人数',
  `apply_quantity` int(11) DEFAULT NULL COMMENT '申请补充人数',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `require_datetime` datetime DEFAULT NULL COMMENT '需要到岗时间',
  `replace_position` varchar(255) DEFAULT NULL COMMENT '被替代职位',
  `replace_real_name` varchar(255) DEFAULT NULL COMMENT '被替代者姓名',
  `new_apply_reason` varchar(255) DEFAULT NULL COMMENT '新申请职位原因',
  `position_now_quantity` int(11) DEFAULT NULL COMMENT '该职位现有人数',
  `position_add_reason` varchar(255) DEFAULT NULL COMMENT '该职位增加原因',
  `temp_start_datetime` datetime DEFAULT NULL COMMENT '临时聘用开始时间',
  `temp_end_datetime` datetime DEFAULT NULL COMMENT '临时聘用结束时间',
  `note` varchar(255) DEFAULT NULL COMMENT '说明',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `marry_state` varchar(255) DEFAULT NULL COMMENT '婚育情况',
  `education` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `major_require` varchar(255) DEFAULT NULL COMMENT '专业资格',
  `ability_require` varchar(255) DEFAULT NULL COMMENT '能力要求',
  `experience` varchar(255) DEFAULT NULL COMMENT '相关工作经验',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用人申请';

DROP TABLE IF EXISTS `tp_scope_people`;
CREATE TABLE `tp_scope_people` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `type` varchar(32) NOT NULL COMMENT '类型(所有人员=-1,分公司=1，部门=2,职位=3，具体人=4)',
  `people_code` varchar(32) DEFAULT NULL COMMENT '具体类型人员编号',
  `ref_code` varchar(32) DEFAULT NULL COMMENT '参考编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告或制度人员范围';

DROP TABLE IF EXISTS `tp_social_relation`;
CREATE TABLE `tp_social_relation` (
  `code` varchar(32) NOT NULL,
  `archive_code` varchar(32) DEFAULT NULL COMMENT '人事档案编号',
  `real_name` varchar(255) DEFAULT NULL COMMENT '成员姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '与本人关系',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `post` varchar(255) DEFAULT NULL COMMENT '担任职务',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `is_delete` char(1) DEFAULT NULL COMMENT '0删除1正常',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社会关系';

DROP TABLE IF EXISTS `tp_storage_in`;
CREATE TABLE `tp_storage_in` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `valid_date_start` datetime DEFAULT NULL COMMENT '有效期起',
  `valid_date_end` datetime DEFAULT NULL COMMENT '有效期止',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入库管理';

DROP TABLE IF EXISTS `tp_storage_out`;
CREATE TABLE `tp_storage_out` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category_code` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(18,8) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,8) DEFAULT NULL COMMENT '总价',
  `storage_in_code` varchar(32) DEFAULT NULL COMMENT '入库编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库管理';

DROP TABLE IF EXISTS `tp_supple_sign_apply`;
CREATE TABLE `tp_supple_sign_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请';

DROP TABLE IF EXISTS `tp_supple_sign_apply_detail`;
CREATE TABLE `tp_supple_sign_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `supply_sign_apply_code` varchar(32) DEFAULT NULL COMMENT '补签申请编号',
  `supple_datetime` datetime DEFAULT NULL COMMENT '漏签日期',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补签申请明细';

DROP TABLE IF EXISTS `tp_transfer_position_apply`;
CREATE TABLE `tp_transfer_position_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `new_department` varchar(255) DEFAULT NULL COMMENT '新部门',
  `new_position` varchar(255) DEFAULT NULL COMMENT '新岗位',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始日期',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束日期',
  `reason` varchar(255) DEFAULT NULL COMMENT '缘由',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调岗申请';

DROP TABLE IF EXISTS `tp_travel_apply`;
CREATE TABLE `tp_travel_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型(1=出差,2=公出)',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人编号',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '共计时长',
  `reason` varchar(255) DEFAULT NULL COMMENT '事由',
  `pdf` varchar(255) DEFAULT NULL COMMENT '附件',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差/公出申请';

DROP TABLE IF EXISTS `tp_travel_apply_detail`;
CREATE TABLE `tp_travel_apply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `travel_apply_code` varchar(32) DEFAULT NULL COMMENT '出差申请编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `total_hour` varchar(32) DEFAULT NULL COMMENT '时长',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时间申请明细';

DROP TABLE IF EXISTS `tp_welfare_apply`;
CREATE TABLE `tp_welfare_apply` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `apply_datetime` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '申请说明',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='福利发放申请';

DROP TABLE IF EXISTS `tp_welfare_user`;
CREATE TABLE `tp_welfare_user` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `welfare_code` varchar(255) DEFAULT NULL COMMENT '福利编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='福利关联人员';

DROP TABLE IF EXISTS `tp_work_experience`;
CREATE TABLE `tp_work_experience` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父级编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '起始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '截止时间',
  `company_name` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离职原因',
  `prover` varchar(255) DEFAULT NULL COMMENT '证明人',
  `prover_mobile` varchar(255) DEFAULT NULL COMMENT '证明人联系电话',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作经历';



