package com.ssafy.board.model;

public class ArticleImgDto {
	private int articleNo;
	private String img;
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "ArticleImgDto [articleNo=" + articleNo + ", img=" + img + "]";
	}
	
}
