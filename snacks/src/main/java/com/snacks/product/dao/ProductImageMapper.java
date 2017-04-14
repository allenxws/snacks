package com.snacks.product.dao;

import com.snacks.product.domain.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Mapper
public interface ProductImageMapper {
	@Select({
			"select head_iamge from product_image where is_deleted = 0 and product_id = #{productId} limit 1"
	})
	Long getHeadImageByProduct(@Param("productId") Long productId);

	@Select({
			"select id, product_id, head_iamge, content_images, is_deleted, create_time, update_time" +
					" from product_image where is_deleted = 0 and product_id = #{productId} limit 1"
	})
	ProductImage getByProductId(@Param("productId") Long productId);
}
