package com.snacks.user.aggregate;

import com.snacks.user.domain.User;
import com.snacks.user.repository.UserServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/17.
 */
@Service
public class UserServiceRoot {
	@Autowired
	UserServiceDB userServiceDB;

	public User getById(Long userId) {
		return userServiceDB.getById(userId);
	}
}
