package com.snacks.product.dao;

import com.snacks.product.domain.ProductInfo;
import org.apache.ibatis.annotations.*;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Mapper
public interface ProductInfoMapper {
	@Select({
			"select id, product_id, brand, product_name, quality_period, produce_date, volume, package_way" +
					", produce_place, storage_way, technology, contain_sugar, ingredients, produce_permit" +
					", bar_code, product_code, is_deleted, create_time, update_time" +
					" from product_info where is_deleted = 0 and product_id = #{productId} limit 1"
	})
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "product_id", property = "productId"),
			@Result(column = "brand", property = "brand"),
			@Result(column = "product_name", property = "productName"),
			@Result(column = "quality_period", property = "qualityPeriod"),
			@Result(column = "produce_date", property = "produceDate"),
			@Result(column = "volume", property = "volume"),
			@Result(column = "package_way", property = "packageWay"),
			@Result(column = "produce_place", property = "producePlace"),
			@Result(column = "storage_way", property = "storageWay"),
			@Result(column = "technology", property = "technology"),
			@Result(column = "contain_sugar", property = "containSugar"),
			@Result(column = "ingredients", property = "ingredients"),
			@Result(column = "produce_permit", property = "producePermit"),
			@Result(column = "bar_code", property = "barCode"),
			@Result(column = "product_code", property = "productCode"),
			@Result(column = "is_deleted", property = "isDeleted"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime")
	})
	ProductInfo getByProductId(@Param("productId") Long productId);
}
