package com.java.pagenation.dto;

public class PaginationDto {
	private int page;
	private int countList;
	private int countPage;
	private int totalCount;
	private int totalPage;
	private int startPage;
	private int endPage;
	
	public PaginationDto() {}

	public PaginationDto(int page, int countList, int countPage, int totalCount, int totalPage, int startPage,
			int endPage) {
		super();
		this.page = page;
		this.countList = countList;
		this.countPage = countPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
		return "PaginationDto [page=" + page + ", countList=" + countList + ", countPage=" + countPage + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
}
