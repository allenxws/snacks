package com.snacks.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by xuwushun on 2017/4/18.
 */
public class AppListCartProductResponse {
	@JsonProperty("product_id")
	private Long productId;
	private String name;
	@JsonProperty("label_name")
	private String labelName;
	@JsonProperty("old_price")
	private Double oldPrice;
	@JsonProperty("new_price")
	private Double newPrice;
	private Integer number;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
