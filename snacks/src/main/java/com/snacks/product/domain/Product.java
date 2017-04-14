package com.snacks.product.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/3/20.
 */
public class Product extends CommonDomain {
	private String name;
	private String introduce;
	private Integer number;
	private Double price;
	private Integer stock;

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
