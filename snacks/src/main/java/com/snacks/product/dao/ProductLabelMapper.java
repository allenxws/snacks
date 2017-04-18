package com.snacks.product.dao;

import com.snacks.product.domain.ProductLabel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Mapper
public interface ProductLabelMapper {
	@Select({
			"select id, product_id, label_name, is_deleted, create_time, update_time" +
					" from product_label where is_deleted = 0 and product_id = #{productId}"
	})
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "product_id", property = "productId"),
			@Result(column = "label_name", property = "labelName"),
			@Result(column = "is_deleted", property = "isDeleted"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime")
	})
	List<ProductLabel> listAllByProductId(@Param("productId") Long productId);

	@Select({
			"select id, product_id, label_name, is_deleted, create_time, update_time" +
					" from product_label where is_deleted = 0 and id = #{id}"
	})
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "product_id", property = "productId"),
			@Result(column = "label_name", property = "labelName"),
			@Result(column = "is_deleted", property = "isDeleted"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime")
	})
	ProductLabel getById(@Param("id") Long id);
}
