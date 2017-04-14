package com.snacks.common.exception;

import com.snacks.common.response.CommonResponse;
import com.snacks.common.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuwushun on 2016/9/30.
 */
@ControllerAdvice
public class BusinessExceptionHandler extends BaseExceptionHandler {
	@Autowired
	MessageService messageService;
	Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CommonResponse HandleBusinessException(HttpServletResponse response, BusinessException businessException) {
		setHttpHeaders(response);
		if (null == businessException) {
			return new CommonResponse();
		}
		if (!StringUtils.isEmpty(businessException.getErrorMessage())) {
			logger.debug(businessException.getErrorMessage());
		}
		if (null != businessException.getException()) {
			logger.debug(businessException.getErrorMessage(), businessException.getException());
		}
		String message = StringUtils.isEmpty(businessException.getErrorMessage()) ? messageService.getMessage(businessException.getErrorCode()) : businessException.getErrorMessage();
		logger.debug("get exception handled, errorCode=" + businessException.getErrorCode() + ", message=" + message, businessException);
		return new CommonResponse(businessException.getErrorCode(), message);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CommonResponse HandleException(HttpServletResponse response, Exception exception) {
		setHttpHeaders(response);
		String errorCode = "system.error";
		String errorMessage = "";
		if (null == exception || StringUtils.isEmpty(exception.getMessage())) {
			errorMessage = messageService.getMessage(errorCode);
		} else {
			errorMessage = exception.getMessage();
		}
		logger.debug("system error, message = " + errorMessage);
		return new CommonResponse(errorCode, errorMessage);
	}
}
