package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비 연결정보 -> 주입
	@Inject
	private SqlSession sqlSession;
	
	// mapper의 NAMESPACE 정보 저장
	public static final String NAMESPACE="com.itwillbs.mapper.BoardMapper.";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		logger.debug("연결된 mapper에 SQL 구문 실행");
		sqlSession.insert(NAMESPACE+"create", vo);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		logger.debug(" listAll() 실행 ");
		// mapper에 설정된 SQL구문을 실행(+DB 연결)
		
		// List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+"listAll");
		// return boardList;
		
		return sqlSession.selectList(NAMESPACE+"listAll");
	}

	@Override
	public void updateReadCnt(int bno) throws Exception {
		logger.debug("upupdateReadCnt(int bno) 실행");
		
		sqlSession.update(NAMESPACE+"updateReadCnt", bno);
	}

	@Override
	public BoardVO getPage(int bno) throws Exception {
		logger.debug("getPage(int bno) 실행");
		
		return sqlSession.selectOne(NAMESPACE+"getPage", bno);
		
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		logger.debug("updateBoard(BoardVO vo) 실행");
		sqlSession.update(NAMESPACE+"updateBoard", vo);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		logger.debug("deleteBoard(int bno) 실행");
		sqlSession.delete(NAMESPACE+"deleteBoard", bno);
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		logger.debug("listPage(int page) 실행");
		
		// 페이징 처리정보 계산
		// 1p(0~9)/ 2p(10~19)/ 3p(20~29)....
		if(page <= 0) {	// 잘못된 페이지 정보 입력시 처리
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return sqlSession.selectList(NAMESPACE+"listPage", page);
	}

	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		logger.debug("listPage(Criteria cri) 실행");
		
		return sqlSession.selectList(NAMESPACE+"listPage2", cri);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"totalCount");
	}
	
	
	
	
	
	
	
	
	
	
	

}
