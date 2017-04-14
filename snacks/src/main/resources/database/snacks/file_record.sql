CREATE TABLE `file_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `file_name` varchar(64) NOT NULL COMMENT '文件名',
  `url` varchar(1000) DEFAULT NULL COMMENT '远程存储绝对路径',
  `file_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文件类型，0图片',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除字段：0未删除，1已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件记录表'