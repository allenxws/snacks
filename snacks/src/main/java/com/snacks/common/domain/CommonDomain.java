package com.snacks.common.domain;

import java.util.Date;

/**
 * Created by xuwushun on 2016/10/17.
 */
public class CommonDomain {
	public static final Byte IS_DELETED_FALSE = 0;
	public static final Byte IS_DELETED_TRUE = 1;
	private Long id;
	private Byte isDeleted;
	private Date createTime;
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
