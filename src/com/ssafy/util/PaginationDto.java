package com.ssafy.util;

public class PaginationDto {
	private int currentPage; // 현재 페이지(필수)
	private int maxPageCnt = 10;	// 화면에 보여줄 페이지 최대 개수
	private int totalPageCnt;	// 전체 페이지 개수
	private int maxViewCnt = 6;	// 화면에 보여줄 게시글 개수
	private int totalViewCnt; 	// 게시글의 총 개수(필수)
	private int pageGroup; 	// 현재 페이지가 속한 그룹번호
	private int startPage;	// 시작 페이지 번호
	private int endPage;	// 마지막 페이지 번호
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPageCnt() {
		return maxPageCnt;
	}

	public void setMaxPageCnt(int maxPageCnt) {
		this.maxPageCnt = maxPageCnt;
	}

	public int getTotalPageCnt() {
		return totalPageCnt;
	}

	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public int getMaxViewCnt() {
		return maxViewCnt;
	}

	public void setMaxViewCnt(int maxViewCnt) {
		this.maxViewCnt = maxViewCnt;
	}

	public int getTotalViewCnt() {
		return totalViewCnt;
	}

	public void setTotalViewCnt(int totalViewCnt) {
		this.totalViewCnt = totalViewCnt;
	}

	public int getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PaginationDto [currentPage=" + currentPage + ", maxPageCnt=" + maxPageCnt + ", totalPageCnt="
				+ totalPageCnt + ", maxViewCnt=" + maxViewCnt + ", totalViewCnt=" + totalViewCnt + ", pageGroup="
				+ pageGroup + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
}
