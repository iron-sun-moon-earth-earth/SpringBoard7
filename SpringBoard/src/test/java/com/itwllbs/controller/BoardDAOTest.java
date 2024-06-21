package com.itwllbs.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	// DAO 객체 주입
	@Autowired
	private BoardDAO bdao;
	
	@Test
	public void 글쓰기테스트() throws Exception {
		logger.debug("글쓰기 테스트 동작 실행");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트글1");
		vo.setContent("테스트 내용 11111");
		vo.setWriter("테스트1");
		
		bdao.create(vo);

	}
	
	// @Test
	public void 게시판페이징처리1_test() throws Exception{
		
		// 페이지 정보
		int page = 1;
		
		// DAO 페이징 처리 동작 호출
		 List<BoardVO> boardList = bdao.listPage(page);
		
		// 글번호 : 제목
		for(BoardVO vo : boardList)
			logger.debug(vo.getBno()+"//"+vo.getTitle());
	}
	
	@Test
	public void 게시판페이징처리2_test() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPageSize(10);
				
		// DAO 페이징 처리 동작 호출
		List<BoardVO> boardList = bdao.listPage(cri);
		
		// 글번호 : 제목
		for(BoardVO vo : boardList)
			logger.debug(vo.getBno()+"//"+vo.getTitle());
	}		
	
}
