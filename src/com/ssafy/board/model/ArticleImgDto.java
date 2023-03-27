package com.ssafy.board.model;

public class ArticleImgDto {
	private int articleNo;
	private String img;
	private String extension;
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
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@Override
	public String toString() {
		return "ArticleImgDto [articleNo=" + articleNo + ", img=" + img + ", extension=" + extension + "]";
	}
	
}
