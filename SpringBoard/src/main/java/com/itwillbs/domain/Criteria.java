package com.itwillbs.domain;

import lombok.Data;

/**
 * 페이징 처리를 위해 생성된 객체
 * -> 페이징 정보, 개수 저장
 */
public class Criteria {
	
	private int page;
	private int pageSize;
	
	public Criteria() {
		this.page = 1;
		this.pageSize = 10;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}	
		
		this.page = page;
		//this.page = (page-1) * 10;	// 페이징처리- 시작하는 위치(페이지 X)
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 100) {
			this.pageSize = 10;
			return;
		}			
		this.pageSize = pageSize;
	}

	// 페이징 처리에서 필요한 시작위치 계산(mapper에서만 사용 가능)
	public int getPageStart() {
		
		return (this.page - 1) * this.pageSize;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
}
