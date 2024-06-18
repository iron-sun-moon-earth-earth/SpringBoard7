package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {

	// 글쓰기 동작
	public void regist(BoardVO vo) throws Exception;
	
	// 글 전체 목록 조회
	public List<BoardVO> listAll() throws Exception;
	
	// 글 조회수 1증가
	public void upupdateReadCnt(int bno) throws Exception;
	
	// 특정 bno의 글 정보 가져오기
	public BoardVO getPage(int bno) throws Exception;

	// 특정 bno의 글정보 수정하기
	public void updateBoard(BoardVO vo) throws Exception;
	
}
