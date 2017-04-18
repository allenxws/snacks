package com.snacks.order.request;

import javax.validation.constraints.NotNull;

/**
 * Created by xuwushun on 2017/4/18.
 */
public class AppAddProductToCartRequest {
	@NotNull
	private Long productId;
	@NotNull
	private Long labelId;
	@NotNull
	private Integer number;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getLabelId() {
		return labelId;
	}

	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
