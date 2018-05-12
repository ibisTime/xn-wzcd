/*C端用户*/
CREATE TABLE `tstd_user` (
  `user_id` varchar(32) NOT NULL COMMENT '编号',
  `kind` varchar(4) DEFAULT NULL COMMENT '用户类型',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `login_pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` varchar(4) DEFAULT NULL COMMENT '登录密码强度',
  `trade_pwd` varchar(32) DEFAULT NULL COMMENT '支付密码',
  `trade_pwd_strength` varchar(4) DEFAULT NULL COMMENT '支付密码强度',
  `user_referee` varchar(32) DEFAULT NULL COMMENT '推荐人编号',
  `referee_mobile` varchar(16) DEFAULT NULL COMMENT '推荐人手机号',
  `id_kind` varchar(4) DEFAULT NULL COMMENT '证件类型',
  `id_no` bigint(20) DEFAULT NULL COMMENT '证件号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `jf_amount` bigint(20) DEFAULT NULL COMMENT '积分余额',
  `amount` bigint(20) DEFAULT NULL COMMENT '账户余额',
  `creditscore` bigint(20) DEFAULT NULL COMMENT '信用分',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) COMMENT '用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tstd_address` (
  `code` varchar(32) NOT NULL COMMENT '收件编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `addressee` varchar(64) DEFAULT NULL COMMENT '收件人姓名',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `area` varchar(64) DEFAULT NULL COMMENT '区',
  `detail` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `is_default` char(1) DEFAULT NULL COMMENT '是否默认地址',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

