CREATE TABLE `product_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint(20) NOT NULL COMMENT '关联product.id',
  `label_name` varchar(128) NOT NULL COMMENT '标签名称',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除字段，0未删除1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品标签表'