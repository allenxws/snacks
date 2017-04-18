package com.snacks.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by xuwushun on 2017/4/12.
 */
public class AppListActivityProductResponse {
	private Long id;
	@JsonProperty("product_id")
	private Long productId;
	private String name;
	@JsonProperty("img_url")
	private String imgUrl;
	@JsonProperty("new_price")
	private Double newPrice;
	@JsonProperty("old_price")
	private Double oldPrice;
	@JsonProperty("end_time")
	private Date endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
