package com.example.demo.pojo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
/*
 * 1-1에는 없는 XXXDao를 등판시켰다
 * 왜냐면 hibernate, myBatis사용할 수도 있기 때문이다.
 * 공통분모가 되는 클래스를 분리해서 설계하는 것이 좋다
 * 그 밖에는 트랜잭션 처리를 일괄(스프링-자동지원)적으로 설정처리할때도 유리함
 * 트랜잭션 처리는 XXXLogic에서 여러가지 XXXDao클래스의 메소드를 호출할 수 있기 때문에
 * XXXLogic계층에서 AOP를 적용한 자동처리가 가능한 것이다.
 * 
 */
public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	public BoardDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();		
	}
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList");
		List<Map<String,Object>> bList = new ArrayList<>();
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {  
			bList = sqlSession.selectList("boardList", pMap);
			logger.info(bList.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}		 
		return bList;
	}

	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert");
		int result = 0;
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("boardInsert", pMap);			
			sqlSession.commit();//빼먹으면 물리적인테이블 반영안됨
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return result;
	}

	public int boardUpdate(Map<String, Object> pMap) {
		logger.info("boardUpdate");
		int result = 0;
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("boardUpdate", pMap);			
			sqlSession.commit();//빼먹으면 물리적인테이블 반영안됨
		} catch (Exception e) {
			logger.info(e.toString());
		}		
		return result;
	}

	public int boardDelete(Map<String, Object> pMap) {
		logger.info("boardDelete");
		int result = 0;
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int b_no = Integer.parseInt(pMap.get("b_no").toString());
			result = sqlSession.delete("boardDelete",b_no);
			sqlSession.commit();//빼먹으면 물리적인테이블 반영안됨
		} catch (Exception e) {
			logger.info(e.toString());
		}				
		return result;
	}
}
