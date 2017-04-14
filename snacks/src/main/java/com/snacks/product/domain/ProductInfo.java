package com.snacks.product.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/5.
 */
public class ProductInfo extends CommonDomain {
	private Long productId;
	private String brand;
	private String productName;
	private String qualityPeriod;
	private String produceDate;
	private String volume;
	private String packageWay;
	private String producePlace;
	private String storageWay;
	private String technology;
	private String containSugar;
	private String ingredients;
	private String producePermit;
	private String barCode;
	private String productCode;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public String getStorageWay() {
		return storageWay;
	}

	public void setStorageWay(String storageWay) {
		this.storageWay = storageWay;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getContainSugar() {
		return containSugar;
	}

	public void setContainSugar(String containSugar) {
		this.containSugar = containSugar;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getProducePermit() {
		return producePermit;
	}

	public void setProducePermit(String producePermit) {
		this.producePermit = producePermit;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
