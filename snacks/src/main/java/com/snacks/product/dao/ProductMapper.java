package com.snacks.product.dao;

import com.snacks.product.domain.Product;
import org.apache.ibatis.annotations.*;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Mapper
public interface ProductMapper {
	@Select({
			"select id, name, introduce, number, price, stock, is_deleted, create_time, update_time" +
					" from product where is_deleted and id = #{id} limit 1"
	})
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "name", property = "name"),
			@Result(column = "introduce", property = "introduce"),
			@Result(column = "number", property = "number"),
			@Result(column = "price", property = "price"),
			@Result(column = "stock", property = "stock"),
			@Result(column = "is_deleted", property = "isDeleted"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime")
	})
	Product selectByPrimaryKey(@Param("id") Long id);
}
