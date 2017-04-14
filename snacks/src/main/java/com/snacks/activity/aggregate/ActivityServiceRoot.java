package com.snacks.activity.aggregate;

import com.snacks.activity.repository.ActivityServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ActivityServiceRoot {
	@Autowired
	ActivityServiceDB activityServiceDB;

	public Long getActiveActivityId() {
		return activityServiceDB.getActiveActivityId();
	}
}
