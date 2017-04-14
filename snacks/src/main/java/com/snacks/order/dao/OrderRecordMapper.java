package com.snacks.order.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Mapper
public interface OrderRecordMapper {
	@Select({
			"select count(0) from order_record where is_deleted = 0 and (status = 1 or status = 2 or status = 3) and product_id = #{productId}"
	})
	Integer countPayedByProductId(@Param("productId") Long productId);
}
