package com.snacks.activity.dao;

import java.util.Map;

/**
 * Created by xuwushun on 2017/4/14.
 */
public class ActivityProductSqlProvider {
	public String listForApp(Map paramMap) {
		StringBuilder sql = new StringBuilder();
		Long boundId = (Long) paramMap.get("boundId");
		sql.append("select product_id, activity_price, end_time");
		sql.append(" from avtivity_product");
		sql.append(" where is_deleted = 0 and activity_id = #{activityId}");
		if (null != boundId) {
			sql.append(" and id < #{boundId}");
		}
		sql.append(" order by id desc limit #{pageSize}");
		return sql.toString();
	}
}
