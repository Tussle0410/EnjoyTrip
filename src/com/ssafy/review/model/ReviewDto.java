package com.ssafy.review.model;

import java.sql.Date;

public class ReviewDto {
	private int reviewNo;
	private int articleNo;
	private String content;
	private Date registTime;
	private String email;
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ReviewDto [reviewNo=" + reviewNo + ", articleNo=" + articleNo + ", content=" + content + ", registTime="
				+ registTime + ", email=" + email + "]";
	}
}
