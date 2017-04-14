package com.snacks.product.response;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/14.
 */
public class AppGetProductDetailResponse {
	private String name;
	private String headImage;
	private String introduce;
	private Integer orderNumber;
	private Integer remainNumber;
	private Double discountPrice;
	private String brand;
	private String productName;
	private String qualityPeriod;
	private String produceDate;
	private String volume;
	private String packageWay;
	private String producePlace;
	private List<String> contentImages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getRemainNumber() {
		return remainNumber;
	}

	public void setRemainNumber(Integer remainNumber) {
		this.remainNumber = remainNumber;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQualityPeriod() {
		return qualityPeriod;
	}

	public void setQualityPeriod(String qualityPeriod) {
		this.qualityPeriod = qualityPeriod;
	}

	public String getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(String produceDate) {
		this.produceDate = produceDate;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPackageWay() {
		return packageWay;
	}

	public void setPackageWay(String packageWay) {
		this.packageWay = packageWay;
	}

	public String getProducePlace() {
		return producePlace;
	}

	public void setProducePlace(String producePlace) {
		this.producePlace = producePlace;
	}

	public List<String> getContentImages() {
		return contentImages;
	}

	public void setContentImages(List<String> contentImages) {
		this.contentImages = contentImages;
	}
}
