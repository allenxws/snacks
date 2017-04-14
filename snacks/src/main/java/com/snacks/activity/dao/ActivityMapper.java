package com.snacks.activity.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Mapper
public interface ActivityMapper {
	@Select({
			"select id from avtivity where status = 0 and is_deleted = 0 limit 1"
	})
	Long getActiveActivityId();
}
