package com.ssafy.attraction.model.dto;

import java.util.Date;

public class AttractionDetailDto {
	
	private int contentId;
	private String cat1;
	private String cat2;
	private String cat3;
	private Date createdTime;
	private Date modifiedTime;
	private String bookTour;
	
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getCat1() {
		return cat1;
	}
	public void setCat1(String cat1) {
		this.cat1 = cat1;
	}
	public String getCat2() {
		return cat2;
	}
	public void setCat2(String cat2) {
		this.cat2 = cat2;
	}
	public String getCat3() {
		return cat3;
	}
	public void setCat3(String cat3) {
		this.cat3 = cat3;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getBookTour() {
		return bookTour;
	}
	public void setBookTour(String bookTour) {
		this.bookTour = bookTour;
	}
	
	@Override
	public String toString() {
		return "AttractionDetailDto [contentId=" + contentId + ", cat1=" + cat1 + ", cat2=" + cat2 + ", cat3=" + cat3
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", bookTour=" + bookTour + "]";
	}
}
