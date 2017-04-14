package com.snacks.product.repository;

import com.snacks.product.dao.ProductInfoMapper;
import com.snacks.product.domain.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ProductInfoServiceDB {
	@Autowired
	ProductInfoMapper productInfoMapper;

	public ProductInfo getByProductId(Long productId) {
		return productInfoMapper.getByProductId(productId);
	}
}
