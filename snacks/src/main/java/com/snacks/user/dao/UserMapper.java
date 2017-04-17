package com.snacks.user.dao;

import com.snacks.user.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by xuwushun on 2017/4/17.
 */
@Mapper
public interface UserMapper {

	@Select({
			"select id, open_id, head_id, user_name, is_deleted, create_time, update_time" +
					" from user where is_deleted = 0 and id = #{userId} limit 1"
	})
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "open_id", property = "openId"),
			@Result(column = "head_id", property = "headId"),
			@Result(column = "user_name", property = "userName"),
			@Result(column = "is_deleted", property = "isDeleted"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime")
	})
	User getById(@Param("userId") Long userId);
}
