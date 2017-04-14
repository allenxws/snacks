CREATE TABLE `receive_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '关联user.id',
  `is_default` tinyint(1) NOT NULL COMMENT '是否默认收货地址,0否1是',
  `contact_name` varchar(128) NOT NULL COMMENT '联系人姓名',
  `sex` tinyint(1) NOT NULL COMMENT '性别，0男1女',
  `province` varchar(64) NOT NULL COMMENT '省',
  `city` varchar(64) NOT NULL COMMENT '市',
  `area` varchar(128) NOT NULL COMMENT '小区写字楼等',
  `address` varchar(256) NOT NULL COMMENT '详细地址',
  `house_number` varchar(256) NOT NULL COMMENT '门牌号',
  `type` tinyint(1) DEFAULT NULL COMMENT '地址类型，0家1公司2学校',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除字段，0未删除1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收货地址表'