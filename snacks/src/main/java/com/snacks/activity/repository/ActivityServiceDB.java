package com.snacks.activity.repository;

import com.snacks.activity.dao.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ActivityServiceDB {
	@Autowired
	ActivityMapper activityMapper;

	public Long getActiveActivityId() {
		return activityMapper.getActiveActivityId();
	}
}
