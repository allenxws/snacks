package com.snacks.common.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snacks.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by xuwushun on 2016/10/9.
 */
@Service
public class JsonService {
	@Autowired
	ObjectMapper objectMapper;

	public String toJson(Object object) {
		String json;
		try {
			json = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new BusinessException("json.serialize.error", e);
		}
		return json;
	}

	public Object toObject(String json, Class clazz) {
		Object object;
		try {
			object = objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new BusinessException("json.deserialize.error", e);
		}
		return object;
	}
}
