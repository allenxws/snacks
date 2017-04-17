package com.snacks.user.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/12.
 */
public class ReceiveAddress extends CommonDomain {
	private Long userId;
	private Byte isDefault;
	private String contactName;
	private Byte sex;
	private String province;
	private String city;
	private String area;
	private String address;
	private String houseNumber;
	private Byte type;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Byte getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Byte isDefault) {
		this.isDefault = isDefault;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}
}
