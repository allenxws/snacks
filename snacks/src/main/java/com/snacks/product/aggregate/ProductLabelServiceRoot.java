package com.snacks.product.aggregate;

import com.snacks.product.domain.ProductLabel;
import com.snacks.product.repository.ProductLabelServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Service
public class ProductLabelServiceRoot {
	@Autowired
	ProductLabelServiceDB productLabelServiceDB;

	public List<ProductLabel> listAllByProductId(Long productId) {
		return productLabelServiceDB.listAllByProductId(productId);
	}

	public ProductLabel getById(Long id){
		return productLabelServiceDB.getById(id);
	}
}
