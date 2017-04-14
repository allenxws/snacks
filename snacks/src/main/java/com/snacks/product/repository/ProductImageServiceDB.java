package com.snacks.product.repository;

import com.snacks.product.dao.ProductImageMapper;
import com.snacks.product.domain.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ProductImageServiceDB {
	@Autowired
	ProductImageMapper productImageMapper;

	public Long getHeadImageByProduct(Long productId) {
		return productImageMapper.getHeadImageByProduct(productId);
	}

	public ProductImage getByProductId(Long productId) {
		return productImageMapper.getByProductId(productId);
	}
}
