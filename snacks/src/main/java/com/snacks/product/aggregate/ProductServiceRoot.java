package com.snacks.product.aggregate;

import com.snacks.product.domain.Product;
import com.snacks.product.repository.ProductServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ProductServiceRoot {
	@Autowired
	ProductServiceDB productServiceDB;

	public Product getById(Long id) {
		return productServiceDB.getById(id);
	}
}
