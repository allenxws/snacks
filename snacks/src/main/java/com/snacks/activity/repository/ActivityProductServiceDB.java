package com.snacks.activity.repository;

import com.google.common.collect.Lists;
import com.snacks.activity.dao.ActivityProductMapper;
import com.snacks.activity.domain.ActivityProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ActivityProductServiceDB {
	@Autowired
	ActivityProductMapper activityProductMapper;

	public List<Long> listProductIdByActivityId(Long activityId) {
		if (null == activityId) {
			return Lists.newArrayList();
		}
		return activityProductMapper.listProductIdByActivityId(activityId);
	}

	public List<ActivityProduct> listForApp(Map paramMap) {
		return activityProductMapper.listForApp(paramMap);
	}

	public ActivityProduct getByActivityIdAndProductId(Long activityId, Long productId) {
		return activityProductMapper.getByActivityIdAndProductId(activityId, productId);
	}
}
