package com.snacks.activity.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/12.
 */
public class Activity extends CommonDomain {
	public static final Byte STATUS_ACTIVE = 0;
	public static final Byte STATUS_EXPIRE = 1;
	private String name;
	private Byte status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
}
