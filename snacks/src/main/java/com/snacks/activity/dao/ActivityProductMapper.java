package com.snacks.activity.dao;

import com.snacks.activity.domain.ActivityProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Mapper
public interface ActivityProductMapper {
	@Select({
			"select product_id from avtivity_product where is_deleted = 0 and activity_id = #{activityId}"
	})
	List<Long> listProductIdByActivityId(@Param("activityId") Long activityId);

	@SelectProvider(type = ActivityProductSqlProvider.class, method = "listForApp")
	@Results({
			@Result(column = "product_id", property = "productId"),
			@Result(column = "activity_price", property = "activityPrice"),
			@Result(column = "end_time", property = "endTime")
	})
	List<ActivityProduct> listForApp(Map paramMap);

	@Select({
			"select id, activity_id, product_id, activity_price, end_time, is_deleted, create_time, update_time" +
					" from avtivity_product where is_deleted = 0 and activity_id = #{activityId} and product_id = #{productId} limit 1"
	})
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "activity_id", property = "activityId"),
			@Result(column = "product_id", property = "productId"),
			@Result(column = "activity_price", property = "activityPrice"),
			@Result(column = "end_time", property = "endTime"),
			@Result(column = "is_deleted", property = "isDeleted"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime")
	})
	ActivityProduct getByActivityIdAndProductId(@Param("activityId") Long activityId, @Param("productId") Long productId);
}
