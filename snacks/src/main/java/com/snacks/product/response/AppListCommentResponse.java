package com.snacks.product.response;

import java.util.Date;

/**
 * Created by xuwushun on 2017/4/17.
 */
public class AppListCommentResponse {
	private String headImage;
	private String userName;
	private Date commentTime;
	private Double score;
	private String content;

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
