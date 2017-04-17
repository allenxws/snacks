package com.snacks.product.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/17.
 */
public class ProductComment extends CommonDomain {
	private Long userId;
	private Long productId;
	private String content;
	private Double score;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
