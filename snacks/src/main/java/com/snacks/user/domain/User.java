package com.snacks.user.domain;

import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2017/4/5.
 */
public class User extends CommonDomain {
	private String openId;
	private Long headId;
	private String userName;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Long getHeadId() {
		return headId;
	}

	public void setHeadId(Long headId) {
		this.headId = headId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
