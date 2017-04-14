CREATE TABLE `avtivity_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `activity_id` bigint(20) NOT NULL COMMENT '关联activity.id',
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `activity_price` decimal(10,2) NOT NULL COMMENT '活动价，单位元',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除字段，0未删除1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='推广活动表'