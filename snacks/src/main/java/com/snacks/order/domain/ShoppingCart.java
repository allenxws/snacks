package com.snacks.order.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/18.
 */
public class ShoppingCart extends CommonDomain {
	private Long userId;
	private Long productId;
	private Long labelId;
	private Integer number;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
