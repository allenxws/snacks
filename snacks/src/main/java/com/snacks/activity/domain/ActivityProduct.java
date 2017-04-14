package com.snacks.activity.domain;

import com.snacks.common.domain.CommonDomain;

import java.util.Date;

/**
 * Created by xuwushun on 2017/4/12.
 */
public class ActivityProduct extends CommonDomain {
	private Long activityId;
	private Long productId;
	private Double activityPrice;
	private Date endTime;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(Double activityPrice) {
		this.activityPrice = activityPrice;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
