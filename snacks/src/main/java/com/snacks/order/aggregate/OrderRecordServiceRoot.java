package com.snacks.order.aggregate;

import com.snacks.order.repository.OrderRecordServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class OrderRecordServiceRoot {
	@Autowired
	OrderRecordServiceDB orderRecordServiceDB;

	public Integer countPayedByProductId(Long productId) {
		return orderRecordServiceDB.countPayedByProductId(productId);
	}
}
