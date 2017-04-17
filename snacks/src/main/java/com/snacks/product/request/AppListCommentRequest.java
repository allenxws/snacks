package com.snacks.product.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snacks.common.request.CommonPhoneListRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by xuwushun on 2017/4/17.
 */
public class AppListCommentRequest extends CommonPhoneListRequest {
	@JsonProperty("product_id")
	@NotNull
	private Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
