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