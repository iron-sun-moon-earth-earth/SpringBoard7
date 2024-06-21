package com.itwillbs.domain;

/**
 * 페이징 처리 필요한 정보 저장객첵
 *
 */
public class PageVO {
	
	private int endPage;		// (페이지 블럭)끝 페이지 번호
	private int startPage;		// (페이지블럭)시작 페이지  번호
	private int totalCount;		// 작성된 총 글의 개수
	private boolean next;		// 다음번튼 활성화 여부(t/f)
	private boolean prev;		// 이전버튼 활성화 여부(t/f)
	
	private int pageBlock = 10;	// 페이징 블럭의 개수 1,2,3,4,...,10
	
	//private int page;			// 페이지 번호
	//private int pageSize;		// 페이지당 출력 개수
	private Criteria cri;

	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		pageCalcData();
	}
	
	private void pageCalcData() {
		// 하단 페이징 처리에 필요한 계산울 수행하는 메서드
		
		// endPage
		endPage = (int)(Math.ceil(cri.getPage() / (double)pageBlock)*pageBlock);
		
		// startPage
		startPage = (endPage - pageBlock) + 1;
		
		// endPage 재설정
		int tmpEndPage = (int)(Math.ceil((double)totalCount / cri.getPageSize()));
		
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		// next
		next = endPage * cri.getPageSize() < totalCount;
		// prev
		prev = startPage != 1;
		
		System.out.println("----------------------페이징 처리 정보 계산 완료!--------------------------------");
	}// pageCalcData
	
	

	
	// alt + shift + s -> r
	public Criteria getCri() {
		return cri;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "PageVO [endPage=" + endPage + ", startPage=" + startPage + ", totalCount=" + totalCount + ", next="
				+ next + ", prev=" + prev + ", pageBlock=" + pageBlock + ", cri=" + cri + "]";
	}
	
	
	
	
}
