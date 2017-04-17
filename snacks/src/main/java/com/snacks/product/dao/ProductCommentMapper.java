package com.snacks.product.dao;

import com.snacks.product.domain.ProductComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/17.
 */
@Mapper
public interface ProductCommentMapper {
	@SelectProvider(type = ProductCommentSqlProvider.class, method = "listForApp")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "user_id", property = "userId"),
			@Result(column = "content", property = "content"),
			@Result(column = "score", property = "score"),
			@Result(column = "create_time", property = "createTime")
	})
	List<ProductComment> listForApp(Map paramMap);
}
