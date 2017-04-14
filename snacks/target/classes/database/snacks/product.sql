CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(256) NOT NULL COMMENT '产品名称',
  `introduce` varchar(1000) NOT NULL COMMENT '产品介绍',
  `number` int(11) NOT NULL COMMENT '剩余库存数量',
  `price` decimal(10,2) NOT NULL COMMENT '产品价格',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除字段，0未删除1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表'