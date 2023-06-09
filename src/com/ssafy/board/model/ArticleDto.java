package com.ssafy.board.model;

import java.util.Date;
import java.util.List;

public class ArticleDto {
	private int articleNo;
	private String title;
	private String content;
	private String articleCategory;
	private String email;
	private int hit;
	private Date registTime;
	private int heart;
	private boolean heartFlag;
	public boolean isHeartFlag() {
		return heartFlag;
	}
	public void setHeartFlag(boolean heartFlag) {
		this.heartFlag = heartFlag;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getArticleCategory() {
		return articleCategory;
	}
	public void setArticleCategory(String articleCategory) {
		this.articleCategory = articleCategory;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String imgs) {
		this.email = imgs;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	public void plusHit() {
		this.hit += 1;
	}
	@Override
	public String toString() {
		return "ArticleDto [articleNo=" + articleNo + ", title=" + title + ", content=" + content + ", articleCategory="
				+ articleCategory + ", email=" + email + ", hit=" + hit + ", registTime=" + registTime + ", heart="
				+ heart + ", heartFlag=" + heartFlag + "]";
	}
	
	
}
