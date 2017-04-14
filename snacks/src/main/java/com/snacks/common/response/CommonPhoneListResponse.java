package com.snacks.common.response;

import java.util.List;

/**
 * Created by xuwushun on 2017/2/17.
 */
public class CommonPhoneListResponse<T> {
	private String code = "success";
	private String message = "成功";
	private List<T> data;

	public CommonPhoneListResponse() {

	}

	public CommonPhoneListResponse(List<T> t) {
		this.data = t;
	}

	public CommonPhoneListResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public CommonPhoneListResponse(String code, String message, List<T> t) {
		this.code = code;
		this.message = message;
		this.data = t;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
