package com.snacks.product.aggregate;

import com.snacks.product.domain.ProductComment;
import com.snacks.product.repository.ProductCommentServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/17.
 */
@Service
public class ProductCommentServiceRoot {
	@Autowired
	ProductCommentServiceDB productCommentServiceDB;

	public List<ProductComment> listForApp(Map paramMap) {
		return productCommentServiceDB.listForApp(paramMap);
	}
}
