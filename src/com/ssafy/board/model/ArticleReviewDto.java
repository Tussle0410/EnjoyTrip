package com.ssafy.board.model;

import java.sql.Date;

public class ArticleReviewDto {
	private int reviewNo;
	private int articleNo;
	private String content;
	private Date registtime;
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
	public Date getRegisttime() {
		return registtime;
	}
	public void setRegisttime(Date registtime) {
		this.registtime = registtime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ArticleReviewDto [reviewNo=" + reviewNo + ", articleNo=" + articleNo + ", content=" + content
				+ ", registtime=" + registtime + ", email=" + email + "]";
	}
	
}
