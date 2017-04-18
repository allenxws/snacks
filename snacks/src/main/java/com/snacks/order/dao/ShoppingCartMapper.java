package com.snacks.order.dao;

import com.snacks.order.domain.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Mapper
public interface ShoppingCartMapper {
	@Select({
			"insert into shopping_cart (user_id, product_id, label_id, number)" +
					" values (#{userId}, #{productId}, #{labelId}, #{number})"
	})
	void addShoppingCart(ShoppingCart shoppingCart);

	@Select({
			"select id, user_id, product_id, label_id, number, is_deleted, create_time, update_time" +
					" from shopping_cart where is_deleted = 0 and user_id = #{userId}"
	})
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "user_id", property = "userId"),
			@Result(column = "product_id", property = "productId"),
			@Result(column = "label_id", property = "labelId"),
			@Result(column = "number", property = "number"),
			@Result(column = "is_deleted", property = "isDeleted"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime")
	})
	List<ShoppingCart> listAllByUserId(@Param("userId") Long userId);
}
