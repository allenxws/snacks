package com.snacks.common.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;

/**
 * Created by xuwushun on 2016/11/7.
 */
public class CommonPhoneListRequest {
	@JsonProperty("bound_id")
	private Long boundId;
	@JsonProperty("page_size")
	@Min(1)
	private Integer pageSize = 20;

	public Long getBoundId() {
		return boundId;
	}

	public void setBoundId(Long boundId) {
		this.boundId = boundId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
