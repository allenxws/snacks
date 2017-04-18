package com.snacks.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by xuwushun on 2017/4/18.
 */
public class AppListProductLabelResponse {
	private Long id;
	@JsonProperty("label_name")
	private String labelName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
}
