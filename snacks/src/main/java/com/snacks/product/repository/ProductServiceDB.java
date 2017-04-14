package com.snacks.product.repository;

import com.snacks.product.dao.ProductMapper;
import com.snacks.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ProductServiceDB {
	@Autowired
	ProductMapper productMapper;

	public Product getById(Long id) {
		return productMapper.selectByPrimaryKey(id);
	}
}
