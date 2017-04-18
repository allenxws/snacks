package com.snacks.product.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/18.
 */
public class ProductLabel extends CommonDomain {
	private Long productId;
	private String labelName;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
}
