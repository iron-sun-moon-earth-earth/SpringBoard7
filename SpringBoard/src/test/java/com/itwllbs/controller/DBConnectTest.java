package com.itwllbs.controller;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DBConnectTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DBConnectTest.class);
	
	@Inject
	private DataSource ds;
	
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void 디비연결테스트() {
		logger.debug("디비연결 테스트 실행");
		logger.info("sqlSession" + sqlSession);

//		logger.debug("ds" + ds);
//		try {
//			logger.info("" +ds.getConnection());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

	}
}
