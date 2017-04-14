package com.snacks.product.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/14.
 */
public class ProductImage extends CommonDomain {
	private Long productId;
	private Long headImage;
	private String contentImages;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getHeadImage() {
		return headImage;
	}

	public void setHeadImage(Long headImage) {
		this.headImage = headImage;
	}

	public String getContentImages() {
		return contentImages;
	}

	public void setContentImages(String contentImages) {
		this.contentImages = contentImages;
	}
}
