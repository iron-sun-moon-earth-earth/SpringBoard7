package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	// DAO 객체 주입
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		logger.debug("연결된 DAO 메서드를 호출");
		
		bdao.create(vo);
		
		logger.debug(" 글쓰기 완료! ");
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		logger.debug("게시판 글목록 조회");
		
		return bdao.listAll();
	}

	@Override
	public void upupdateReadCnt(int bno) throws Exception {
		logger.debug("upupdateReadCnt(int bno) 실행");
		
		bdao.updateReadCnt(bno);
	}

	@Override
	public BoardVO getPage(int bno) throws Exception {
		logger.debug("getPage(int bno) 실행");
		
		return bdao.getPage(bno);
		
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		logger.debug("updateBoard(BoardVO vo) 실행");
		bdao.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		logger.debug("deleteBoard(BoardVO vo) 실행");
		bdao.deleteBoard(bno);
	}

	
}
