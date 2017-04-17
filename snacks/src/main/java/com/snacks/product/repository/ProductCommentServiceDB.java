package com.snacks.product.repository;

import com.snacks.product.dao.ProductCommentMapper;
import com.snacks.product.domain.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/17.
 */
@Service
public class ProductCommentServiceDB {
	@Autowired
	ProductCommentMapper productCommentMapper;

	public List<ProductComment> listForApp(Map paramMap) {
		return productCommentMapper.listForApp(paramMap);
	}
}
