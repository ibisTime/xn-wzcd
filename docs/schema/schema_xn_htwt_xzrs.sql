/*公告管理(确定)*/
DROP TABLE IF EXISTS `tp_notice`;
CREATE TABLE `tp_notice` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `type` VARCHAR(4) NOT NULL COMMENT '类型(1 公司动态 2 公司文件 3 培训说明)',
  `title` VARCHAR(255) NOT NULL COMMENT '公告标题',
  `urgent_status` VARCHAR(4) NOT NULL COMMENT '紧急程度（1 普通 2 紧急）',
  `publish_department_code` VARCHAR(32) NOT NULL COMMENT '发布部门',
  `scope` VARCHAR(32) NOT NULL COMMENT '公告范围',
  
  `content` VARCHAR(255) NOT NULL COMMENT '公告内容',
  `publish_datetime` DATETIME NULL COMMENT '发布时间',
  `status` VARCHAR(32) NULL COMMENT '状态',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '公告管理';

/*公司制度(确定)*/
DROP TABLE IF EXISTS `tp_comp_regime`;
CREATE TABLE `tp_comp_regime` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `type` VARCHAR(4) NOT NULL COMMENT '类型(1行政事务类 2 人力资源管理类 3 财务管理类 4 营销管理类 5 生产管理类)',
  `regime_code` VARCHAR(32) NULL COMMENT '制度编号',
  `name` VARCHAR(32) NULL COMMENT '名称',
  `scope` VARCHAR(32) NOT NULL COMMENT '授权查看范围',
  
  `content` VARCHAR(255) NULL COMMENT '内容',
  `status` VARCHAR(32) NULL COMMENT '状态',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '公司制度';

/*类别管理(确定)*/
DROP TABLE IF EXISTS `tp_comp_category`;
CREATE TABLE `tp_comp_category` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `name` VARCHAR(32) NULL COMMENT '名称',
  `status` VARCHAR(32) NULL COMMENT '状态',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '类别管理';

/*品名管理(确定)*/
DROP TABLE IF EXISTS `tp_comp_product`;
CREATE TABLE `tp_comp_product` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `category_code` VARCHAR(32) NULL COMMENT '类别编号',
  `name` VARCHAR(255) NULL COMMENT '品名',
  `model` VARCHAR(255) NULL COMMENT '规格型号',
  `unit` VARCHAR(32) NULL COMMENT '单位',
  
  `status` VARCHAR(32) NULL COMMENT '状态',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '品名管理';

DROP TABLE IF EXISTS `tp_archive`;
CREATE TABLE `tp_archive` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `real_name` VARCHAR(255) NULL COMMENT '姓名',
  `id_no` VARCHAR(18) NULL COMMENT '身份证号码',
  `mobile` VARCHAR(11) NULL COMMENT '手机号码',
  `job_no` VARCHAR(32) NULL COMMENT '工号',
  `entry_datetime` DATETIME NULL COMMENT '入职时间',
  `department_code` VARCHAR(32) NULL COMMENT '部门编号',
  `post_code` VARCHAR(32) NULL COMMENT '职务岗位编号',
  `job_classes` VARCHAR(32) NULL COMMENT '上班班次',
  `birthday` VARCHAR(32) NULL COMMENT '出生年月',
  `gender` CHAR(1) NULL COMMENT '性别',
  `nation` VARCHAR(255) NULL COMMENT '民族',
  `native_place` VARCHAR(255) NULL COMMENT '籍贯',
  `marry_status` VARCHAR(32) NULL COMMENT '婚姻状况',
  `politics` VARCHAR(32) NULL COMMENT '政治面貌',
  `major` VARCHAR(255) NULL COMMENT '专业',
  `education` VARCHAR(32) NULL COMMENT '学历',
  `work_status` VARCHAR(32) NULL COMMENT '状态',
  `health` VARCHAR(32) NULL COMMENT '健康状况',
  `salary_card` VARCHAR(32) NULL COMMENT '工资卡账号',
  `bank_name` VARCHAR(255) NULL COMMENT '银行',
  `subbranch` VARCHAR(255) NULL COMMENT '开户支行',
  `five_insurance_info` VARCHAR(255) NULL COMMENT '五险一金信息',
  `residence_address` VARCHAR(255) NULL COMMENT '户籍地址',
  `residence_property` VARCHAR(32) NULL COMMENT '户籍性质',
  `social_security_reg_datetime` DATETIME NULL COMMENT '社保登记日期',
  `current_address` VARCHAR(255) NULL COMMENT '现住址',
  `emergency_contact` VARCHAR(255) NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` VARCHAR(11) NULL COMMENT '紧急联系号码',
  `contract_deadline` VARCHAR(32) NULL COMMENT '合同期限',
  `contract_type` VARCHAR(32) NULL COMMENT '合同类型',
  `probation_time` VARCHAR(32) NULL COMMENT '试用期时间',
  `convert_datetime` DATETIME NULL COMMENT '转正日期',
  `leave_datetime` DATETIME NULL COMMENT '离职日期',
  `leave_reason` VARCHAR(255) NULL COMMENT '离职缘由',
  `heir_people` VARCHAR(255) NULL COMMENT '交接人',
  `entrance_no` VARCHAR(32) NULL COMMENT '门禁号',
  `check_no` VARCHAR(32) NULL COMMENT '考勤号',
  `car_no` VARCHAR(32) NULL COMMENT '车牌号',
  `id_no_pdf` VARCHAR(255) NULL COMMENT '身份证复印件',
  `photo` VARCHAR(255) NULL COMMENT '照片',
  `wechat` VARCHAR(32) NULL COMMENT '微信',
  `qq` int(20) NULL COMMENT 'QQ',
  `perform_salary_standard` VARCHAR(255) NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` VARCHAR(255) NULL COMMENT '季度奖考核标准',
  `commumication_fee_standard` VARCHAR(255) NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` VARCHAR(255) NULL COMMENT '省会住宿报销标准',
  `no_provincial_bed_standard` VARCHAR(255) NULL COMMENT '非省会住宿报销标准',
  `traffic_award` BIGINT NULL COMMENT '市内交通现金补助',
  `mobile_award` BIGINT NULL COMMENT '电话现金补贴',
  `taxi_ward` BIGINT NULL COMMENT '出租车',
  `meal_award` BIGINT NULL COMMENT '餐补',
  `working_years` VARCHAR(32) NULL COMMENT '工龄',
  `status` VARCHAR(32) NULL COMMENT '状态',
  `updater` VARCHAR(255) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '人事档案';

DROP TABLE IF EXISTS `tp_social_relation`;
CREATE TABLE `tp_social_relation` (
  `code` VARCHAR(32) NOT NULL,
  `archive_code` VARCHAR(32) NULL COMMENT '人事档案编号',
  `real_name` VARCHAR(255) NULL COMMENT '成员姓名',
  `relation` VARCHAR(255) NULL COMMENT '与本人关系',
  `company_name` VARCHAR(255) NULL COMMENT '工作单位',
  `post` VARCHAR(255) NULL COMMENT '担任职务',
  `contact` VARCHAR(255) NULL COMMENT '联系方式',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '社会关系';

DROP TABLE IF EXISTS `tp_recruit_apply`;
CREATE TABLE `tp_recruit_apply` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `department_code` VARCHAR(32) NULL COMMENT '申请部门编号',
  `position` VARCHAR(255) NULL COMMENT '招聘岗位',
  `establish_quantity` int(11) NULL COMMENT '编制人数',
  `now_quantity` int(11) NULL COMMENT '现有人数',
  
  `apply_quantity` int(11) NULL COMMENT '申请补充人数',
  `apply_datetime` DATETIME NULL COMMENT '申请时间',
  `require_datetime` DATETIME NULL COMMENT '需要到岗时间',
  `replace_position` VARCHAR(255) NULL COMMENT '被替代职位',
  `replace_real_name` VARCHAR(255) NULL COMMENT '被替代者姓名',
  
  `new_apply_reason` VARCHAR(255) NULL COMMENT '新申请职位原因',
  `position_now_quantity` int(11) NULL COMMENT '该职位现有人数',
  `position_add_reason` VARCHAR(255) NULL COMMENT '该职位增加原因',
  `temp_start_datetime` DATETIME NULL COMMENT '临时聘用开始时间',
  `temp_end_datetime` DATETIME NULL COMMENT '临时聘用结束时间',

  `gender` VARCHAR(32) NULL COMMENT '性别',
  `age` VARCHAR(255) NULL COMMENT '年龄',
  `marry_state` VARCHAR(255) NULL COMMENT '婚育情况',
  `education` VARCHAR(255) NULL COMMENT '文化程度',
  `major` VARCHAR(255) NULL COMMENT '专业',
  
  `major_require` VARCHAR(255) NULL COMMENT '专业资格',
  `ability_require` VARCHAR(255) NULL COMMENT '能力要求',
  `experience` VARCHAR(255) NULL COMMENT '相关工作经验',
  `status` VARCHAR(32) NULL COMMENT '状态',
  `updater` VARCHAR(255) NULL COMMENT '更新人',
  
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '用人申请';

DROP TABLE IF EXISTS `tp_employ_apply`;
CREATE TABLE `tp_employ_apply` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `real_name` VARCHAR(255) NULL COMMENT '真实姓名',
  `gender` VARCHAR(32) NULL COMMENT '性别',
  `birthday` VARCHAR(255) NULL COMMENT '出生年月',
  `native_place` VARCHAR(255) NULL COMMENT '籍贯',
  
  `nation` VARCHAR(255) NULL COMMENT '民族',
  `position` VARCHAR(255) NULL COMMENT '应聘岗位',
  `education` VARCHAR(255) NULL COMMENT '文化程度',
  `id_no` VARCHAR(255) NULL COMMENT '身份证号码',
  `contact_mobile` VARCHAR(255) NULL COMMENT '联系电话',
  
  `residence_address` VARCHAR(255) NULL COMMENT '户籍所在地',
  `speciality` VARCHAR(255) NULL COMMENT '特长技能',
  `expect_salary` bigint(20) NULL COMMENT '期望薪资',
  `now_address` VARCHAR(255) NULL COMMENT '现居住地址',
  `emergency_contact` VARCHAR(255) NULL COMMENT '紧急联系人',
  
  `emergency_contact_mobile` VARCHAR(255) NULL COMMENT '紧急联系号码',
  `postcode` VARCHAR(255) NULL COMMENT '邮编',
  `award` VARCHAR(255) NULL COMMENT '受过何种奖励或专业训练',
  `is_out` char(1) NULL COMMENT '能否出差',
  `is_adjust_work` char(1) NULL COMMENT '能否接受工作调动',
  
  `is_once_recruited` VARCHAR(255) NULL COMMENT '是否曾在我公司应聘',
  `is_friend_work` VARCHAR(255) NULL COMMENT '是否有亲属或朋友在我司工作',
  `composite` VARCHAR(255) NULL COMMENT '综合',
  `quality` VARCHAR(255) NULL COMMENT '素质',
  `interview_record` VARCHAR(255) NULL COMMENT '面试记录',
  
  `employ_result` VARCHAR(255) NULL COMMENT '录用结果',
  `probation` VARCHAR(255) NULL COMMENT '试用期',
  `employ_salary` bigint(20) NULL COMMENT '薪资',
  `employ_department_code` VARCHAR(255) NULL COMMENT '入职部门',
  `employ_position_code` VARCHAR(255) NULL COMMENT '入职职务',
  
  `employ_approve_user` VARCHAR(255) NULL COMMENT '审核人',
  `employ_approve_datetime` DATETIME NULL COMMENT '审核时间',
  `employ_approve_note` VARCHAR(255) NULL COMMENT '审核说明',
  `status` VARCHAR(32) NULL COMMENT '状态(0=待面试 1=已面试通过 2已面试不通过)',
  
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '应聘岗位';

DROP TABLE IF EXISTS `tp_work_experience`;
CREATE TABLE `tp_work_experience` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `parent_code` VARCHAR(32) NULL COMMENT '父级编号',
  `start_datetime` DATETIME NULL COMMENT '起始时间',
  `end_datetime` DATETIME NULL COMMENT '截止时间',
  `company_name` VARCHAR(255) NULL COMMENT '工作单位',
  
  `position` VARCHAR(255) NULL COMMENT '职位',
  `leave_reason` VARCHAR(255) NULL COMMENT '离职原因',
  `prover` VARCHAR(255) NULL COMMENT '证明人',
  `prover_mobile` VARCHAR(255) NULL COMMENT '证明人联系电话',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '工作经历';

DROP TABLE IF EXISTS `tp_check_project`;
CREATE TABLE `tp_check_project` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `name` VARCHAR(255) NULL COMMENT '项目名称',
  `check_result` VARCHAR(255) NULL COMMENT '考核指标',
  `check_user` VARCHAR(255) NULL COMMENT '考核人',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  
  `employ_apply_code` VARCHAR(32) NOT NULL COMMENT '应聘岗位编号',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '考核项目';

DROP TABLE IF EXISTS `tp_entry_apply`;
CREATE TABLE `tp_entry_apply` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `position` VARCHAR(255) NULL COMMENT '入职岗位',
  `entry_datetime` DATETIME NULL COMMENT '入职时间',
  `real_name` VARCHAR(255) NULL COMMENT '姓名',
  `gender` VARCHAR(4) NULL COMMENT '性别',
  `birthday` DATETIME NULL COMMENT '出生年月',
  `education` VARCHAR(255) NULL COMMENT '文化程度',
  `nation` VARCHAR(255) NULL COMMENT '民族',
  `native_place` VARCHAR(255) NULL COMMENT '籍贯',
  `health` VARCHAR(32) NULL COMMENT '健康状况',
  `marry_status` VARCHAR(32) NULL COMMENT '婚姻状况',
  `id_no` VARCHAR(32) NULL COMMENT '身份证号码',
  `mobile` VARCHAR(32) NULL COMMENT '手机号码',
  `emergency_contact` VARCHAR(255) NULL COMMENT '紧急联系人',
  `emergency_contact_mobile` VARCHAR(32) NULL COMMENT '紧急联系号码',
  `residence_property` VARCHAR(255) NULL COMMENT '户籍性质',
  `photo` VARCHAR(255) NULL COMMENT '照片',
  `residence_address` VARCHAR(255) NULL COMMENT '户籍所在地',
  `now_address` VARCHAR(255) NULL COMMENT '现居住地址',
  `is_other_company_relation` VARCHAR(32) NULL COMMENT '是否与其他单位存在劳动关系',
  `relative_name` VARCHAR(255) NULL COMMENT '亲属从事本行姓名',
  `relative_relation` VARCHAR(255) NULL COMMENT '亲属与本人关系',
  `relative_position` VARCHAR(255) NULL COMMENT '亲属职务',
  `main_perform` VARCHAR(255) NULL COMMENT '主要业绩及工作能力简述',
  `probation_start_datetime` DATETIME NULL COMMENT '试用期期限开始',
  `probation_end_datetime` DATETIME NULL COMMENT '试用期期限结束',
  `probation_salary` bigint(20) NULL COMMENT '试用期工资',
  `base_salary` bigint(20) NULL COMMENT '转正后基本工资',
  `perform_salary` bigint(20) NULL COMMENT '转正后绩效工资',
  `perform_salary_standard` VARCHAR(255) NULL COMMENT '绩效工资考核标准',
  `quarterly_award_standard` VARCHAR(255) NULL COMMENT '季度奖考核标准',
  `communicate_pay_standard` VARCHAR(255) NULL COMMENT '通讯费报销标准',
  `provincial_bed_standard` VARCHAR(255) NULL COMMENT '省会住宿报销标准',
  `non_provincial_bed_standard` VARCHAR(255) NULL COMMENT '非省会住宿报销标准',
  `traffic_standard` bigint(20) NULL COMMENT '市内交通现金补助',
  `mobile_standard` bigint(20) NULL COMMENT '电话现金补贴',
  `taxi_standard` bigint(20) NULL COMMENT '出租车',
  `meal_standard` bigint(20) NULL COMMENT '餐补',
  `salary_card_no` VARCHAR(32) NULL COMMENT '工资卡账号',
  `bank` VARCHAR(32) NULL COMMENT '工资卡账号',
  `bank_code` VARCHAR(32) NULL COMMENT '开户行行号',
  `status` VARCHAR(4) NULL COMMENT '状态',
  `updater` VARCHAR(255) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '入职申请';

DROP TABLE IF EXISTS `tp_transfer_position_apply`;
CREATE TABLE `tp_transfer_position_apply` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `archieve_code` VARCHAR(32) NULL COMMENT '申请人档案编号',
  `new_department` VARCHAR(255) NULL COMMENT '新部门',
  `new_position` VARCHAR(255) NULL COMMENT '新岗位',
  `start_datetime` DATETIME NULL COMMENT '开始日期',
  `end_datetime` DATETIME NULL COMMENT '结束日期',
  `reason` VARCHAR(255) NULL COMMENT '缘由',
  `status` VARCHAR(4) NULL COMMENT '状态',
  `updater` VARCHAR(255) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '调岗申请';


--入职申请（编号，入职岗位，入职时间，姓名，性别，出生年月，文化程度，民族，籍贯，健康状况，婚姻状况，身份证号码，联系电话，紧急联系人，紧急联系号码，户籍所在地，户籍性质，照片，现居住地址，是否与其他单位存在劳动关系，是否有亲属从事本行业工作，姓名，与本人关系，职务，主要业绩及工作能力简述，试用期期限开始，试用期期限结束，试用期工资，转正后基本工资，转正后绩效工资，绩效工资考核标准，季度奖考核标准，通讯费报销标准，省会住宿报销标准，非省会住宿报销标准，出租车，市内交通现金补助，电话现金补贴，餐补，工资卡账号，开户行，开户行行号）
--entry_apply(code,position,entry_datetime,name,gender,birthday,education_status,nation,native_place,health_status,marriage_status,idcard_no,mobile,emergency_contact,emergency_contact_mobile,residence_address,photo,current_address,is_exist_labor_relation,is_relatives_here,relative_name,relative_relation,relative_position,award_training,probation_start_datetime,probation_end_datetime,probation_salary,base_salary,perform_salary,perform_salary_assess,quarterly_award_assess,communicate_reimburse,provincial_bed_reimburse,non_provincial_bed_reimburse,taxi_reimburse,traffic_reimburse,mobile_reimburse,meal_reimburse,salary_card_no,bank,bank_code)
--
--转正申请（编号，入职编号，申请人，申请时间，工作总结，总体评价，是否转正，生效日期，备注）
--conversion_apply(code,entry_code,apply_user_code,apply_datetime,work_summary,over_evaluation,is_conversion,effect_datetime,remark)
--
--试用期评估（编号，转正申请编号，评估项目，评估分数）
--probation_assess(code,conversion_code,assess_item,assess_grade)
--
--调岗申请（编号，申请人档案编号，新部门，新岗位，开始日期，结束日期，缘由，备注，更新人，更新时间）
--transfer_position_apply(code,archive_code,new_position,start_datetime,end_datetime,reason,remark,updater,update_datetime)

/*入库管理(确定)*/
DROP TABLE IF EXISTS `tp_storage_in`;
CREATE TABLE `tp_storage_in` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `category_code` VARCHAR(32) NULL COMMENT '类别编号',
  `product_code` VARCHAR(255) NULL COMMENT '产品编号',
  `quantity` int(11) NULL COMMENT '数量',
  `price` DECIMAL(18,8) NULL COMMENT '单价',
  
  `total_price` DECIMAL(18,8) NULL COMMENT '总价',
  `valid_date_start` DATETIME NULL COMMENT '有效期起',
  `valid_date_end` DATETIME NULL COMMENT '有效期止',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '入库管理';

/*出库管理(确定)*/
DROP TABLE IF EXISTS `tp_storage_out`;
CREATE TABLE `tp_storage_out` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `category_code` VARCHAR(32) NULL COMMENT '类别编号',
  `product_code` VARCHAR(255) NULL COMMENT '产品编号',
  `quantity` int(11) NULL COMMENT '数量',
  `price` DECIMAL(18,8) NULL COMMENT '单价',
  
  `total_price` DECIMAL(18,8) NULL COMMENT '总价',
  `storage_in_code` VARCHAR(32) NULL COMMENT '入库编号',
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '出库管理';

/*请假申请(确定)*/
DROP TABLE IF EXISTS `tp_leave_apply`;
CREATE TABLE `tp_leave_apply` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `apply_user` VARCHAR(32) NULL COMMENT '申请人编号',
  `apply_datetime` DATETIME NULL COMMENT '申请时间',
  `type` VARCHAR(4) NULL COMMENT '请假类别',
  `reason` VARCHAR(255) NULL COMMENT '事由',
  
  `start_datetime` DATETIME NULL COMMENT '开始时间',
  `end_datetime` DATETIME NULL COMMENT '结束时间',
  `total_hour` int(11) NULL COMMENT '时长',
  `pdf` VARCHAR(32) NULL COMMENT '附件',
  `status` VARCHAR(4) NULL COMMENT '状态',
  
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '请假申请';

/*补签申请(确定)*/
DROP TABLE IF EXISTS `tp_supple_sign_apply`;
CREATE TABLE `tp_supple_sign_apply` (
  `code` VARCHAR(32) NOT NULL COMMENT '编号',
  `apply_user` VARCHAR(32) NULL COMMENT '申请人编号',
  `apply_datetime` DATETIME NULL COMMENT '申请时间',
  `reason` VARCHAR(255) NULL COMMENT '事由',
  `status` VARCHAR(4) NULL COMMENT '状态',
  
  `updater` VARCHAR(32) NULL COMMENT '更新人',
  `update_datetime` DATETIME NULL COMMENT '更新时间',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '补签申请';

/*补签申请明细(确定)*/
DROP TABLE IF EXISTS `tp_supple_sign_apply_detail`;
CREATE TABLE `tp_supple_sign_apply_detail` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '序号',
  `supply_sign_apply_code` VARCHAR(32) NULL COMMENT '补签申请编号',
  `supple_datetime` DATETIME NULL COMMENT '漏签日期',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '补签申请明细';
