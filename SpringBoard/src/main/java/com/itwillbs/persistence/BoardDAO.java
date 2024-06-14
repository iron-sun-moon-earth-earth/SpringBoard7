package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	// 게시판 글 작성
	public void create(BoardVO vo) throws Exception;
	
	// 게시판 리스트(ALL)
	public List<BoardVO> listAll() throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
