package com.snacks.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by xuwushun on 2016/10/21.
 */
@Service
public class MessageService {
	@Autowired
	@Qualifier("messageClient")
	Properties properties;

	public String getMessage(String code) {
		return properties.getProperty(code);
	}
}
