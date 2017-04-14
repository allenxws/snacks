package com.snacks.common.exception;

/**
 * Created by xuwushun on 2016/9/30.
 */
public class BusinessException extends RuntimeException {
	private String errorCode;
	private String errorMessage;
	private Exception exception;

	public BusinessException() {

	}

	public BusinessException(String errorCode) {
		this.errorCode = errorCode;
	}

	public BusinessException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BusinessException(String errorCode, Exception exception) {
		this.errorCode = errorCode;
		this.exception = exception;
	}

	public BusinessException(String errorCode, String errorMessage, Exception exception) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
