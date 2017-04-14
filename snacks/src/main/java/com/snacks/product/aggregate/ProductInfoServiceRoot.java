package com.snacks.product.aggregate;

import com.snacks.product.domain.ProductInfo;
import com.snacks.product.repository.ProductInfoServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ProductInfoServiceRoot {
	@Autowired
	ProductInfoServiceDB productInfoServiceDB;

	public ProductInfo getByProductId(Long productId) {
		return productInfoServiceDB.getByProductId(productId);
	}
}
