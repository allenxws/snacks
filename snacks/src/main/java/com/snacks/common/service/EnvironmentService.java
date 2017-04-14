package com.snacks.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by xuwushun on 2016/12/16.
 */
@Service
public class EnvironmentService {
	@Autowired
	@Qualifier("environmentClient")
	Properties properties;

	public String getConfig(String key) {
		return properties.getProperty(key);
	}
}
