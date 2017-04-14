CREATE TABLE `product_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联product.id',
  `head_iamge` bigint(20) DEFAULT NULL COMMENT '导航图片,关联file_record.id',
  `content_images` varchar(128) DEFAULT NULL COMMENT '内容图片id列表,关联file_record.id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除字段，0未删除1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品信息表'