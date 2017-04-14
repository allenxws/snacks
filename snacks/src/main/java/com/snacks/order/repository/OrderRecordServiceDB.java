package com.snacks.order.repository;

import com.snacks.order.dao.OrderRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class OrderRecordServiceDB {
	@Autowired
	OrderRecordMapper orderRecordMapper;

	public Integer countPayedByProductId(Long productId){
		return orderRecordMapper.countPayedByProductId(productId);
	}
}
