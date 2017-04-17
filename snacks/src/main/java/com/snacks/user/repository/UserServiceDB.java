package com.snacks.user.repository;

import com.snacks.user.dao.UserMapper;
import com.snacks.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuwushun on 2017/4/17.
 */
@Service
public class UserServiceDB {
	@Autowired
	UserMapper userMapper;

	public User getById(Long userId) {
		return userMapper.getById(userId);
	}
}
