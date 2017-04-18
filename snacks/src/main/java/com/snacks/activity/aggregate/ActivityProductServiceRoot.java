package com.snacks.activity.aggregate;

import com.snacks.activity.domain.ActivityProduct;
import com.snacks.activity.repository.ActivityProductServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ActivityProductServiceRoot {
	@Autowired
	ActivityProductServiceDB activityProductServiceDB;
	@Autowired
	ActivityServiceRoot activityServiceRoot;

	public List<Long> listProductIdByActivityId(Long activityId) {
		return activityProductServiceDB.listProductIdByActivityId(activityId);
	}

	public List<ActivityProduct> listForApp(Map paramMap) {
		return activityProductServiceDB.listForApp(paramMap);
	}

	public ActivityProduct getByProductIdAndActivityId(Long activityId, Long productId) {
		return activityProductServiceDB.getByActivityIdAndProductId(activityId, productId);
	}

	public ActivityProduct getActiveByProductId(Long productId) {
		Long activityId = activityServiceRoot.getActiveActivityId();
		return activityProductServiceDB.getByActivityIdAndProductId(activityId, productId);
	}
}
