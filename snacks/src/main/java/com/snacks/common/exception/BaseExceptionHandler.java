package com.snacks.common.exception;

import com.snacks.common.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuwushun on 2017/2/22.
 */
public class BaseExceptionHandler extends HandlerInterceptorAdapter {
	@Autowired
	MessageService messageService;

	public void setHttpHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
}
