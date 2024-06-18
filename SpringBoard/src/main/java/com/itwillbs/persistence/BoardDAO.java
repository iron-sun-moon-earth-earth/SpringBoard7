package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	// 게시판 글 작성
	public void create(BoardVO vo) throws Exception;
	
	// 게시판 리스트(ALL)
	public List<BoardVO> listAll() throws Exception;

	// 글 조회수 1 증가
	public void updateReadCnt(int bno) throws Exception;

	// 본문 내용 가져오기
	public BoardVO getPage(int bno) throws Exception;

	// 수정하기
	public void updateBoard(BoardVO vo) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
