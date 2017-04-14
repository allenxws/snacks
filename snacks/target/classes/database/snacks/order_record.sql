CREATE TABLE `order_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(128) NOT NULL COMMENT '订单号',
  `product_id` bigint(20) NOT NULL COMMENT '商品id，关联product.id',
  `address_id` bigint(20) NOT NULL COMMENT '收货地址id，关联receive_address.id',
  `buyer_id` bigint(20) NOT NULL COMMENT '购买者，关联user.id',
  `amount` double(20,4) NOT NULL COMMENT '交易金额，以元为单位',
  `status` tinyint(1) NOT NULL COMMENT '交易状态，0待支付1支付成功，待发货2已发货，待收货3交易成功',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除字段：0未删除，1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易订单表'