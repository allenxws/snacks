package com.snacks.product.aggregate;

import com.snacks.product.domain.ProductImage;
import com.snacks.product.repository.ProductImageServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ProductImageServiceRoot {
	@Autowired
	ProductImageServiceDB productImageServiceDB;

	public Long getHeadImageByProduct(Long productId) {
		return productImageServiceDB.getHeadImageByProduct(productId);
	}

	public ProductImage getByProductId(Long productId) {
		return productImageServiceDB.getByProductId(productId);
	}
}
