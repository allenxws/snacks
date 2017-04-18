package com.snacks.product.repository;

import com.snacks.product.dao.ProductLabelMapper;
import com.snacks.product.domain.ProductLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Service
public class ProductLabelServiceDB {
	@Autowired
	ProductLabelMapper productLabelMapper;

	public List<ProductLabel> listAllByProductId(Long productId) {
		return productLabelMapper.listAllByProductId(productId);
	}

	public ProductLabel getById(Long id) {
		return productLabelMapper.getById(id);
	}
}
