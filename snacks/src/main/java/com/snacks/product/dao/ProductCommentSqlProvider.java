package com.snacks.product.dao;

import java.util.Map;

/**
 * Created by xuwushun on 2017/4/17.
 */
public class ProductCommentSqlProvider {
	public String listForApp(Map paramMap) {
		Long boundId = (Long) paramMap.get("boundId");
		StringBuilder sql = new StringBuilder();
		sql.append("select id, user_id, content, score, create_time");
		sql.append(" from product_comment");
		sql.append(" where is_deleted = 0 and product_id = #{productId}");
		if (null != boundId) {
			sql.append(" and id < #{boundId}");
		}
		sql.append(" order by id desc limit #{pageSize}");
		return sql.toString();
	}
}
