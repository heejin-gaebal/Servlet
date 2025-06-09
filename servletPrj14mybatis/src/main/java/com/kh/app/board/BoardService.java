package com.kh.app.board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.mybatis.SqlSessionTemplate;

public class BoardService {
	private final BoardDao dao = new BoardDao();
	
	//mybatis와 SqlSession으로 연습
	public int insert(BoardVo vo) throws Exception {
		//conn --> ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//dao
		int result = dao.insert(ss, vo);
		//트랜잭션
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		//close
		ss.close();
		
		return result;
	}
	
//	public int insert(BoardVo vo) throws Exception {
//		//비즈니스 로직
//		//DB연결
//		Connection conn = JDBCTemplate.getConn();
//		
//		//DAO 호출
//		int result = dao.insert(conn, vo);
//		
//		//트랜잭션 처리
//		if(result == 1 ) {
//			conn.commit();
//		}else {
//			conn.rollback();
//		}
//		//자원 반납
//		conn.close();
//		
//		return result;
//	}
	
	//mybatis와 SqlSession으로 연습
	public List<BoardVo> selectlist() throws Exception {
		//conn --> sqlSession
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//dao
		List<BoardVo> voList = dao.selectList(ss);
		//close
		ss.close();
		return voList;
	}
//	public List<BoardVo> selectlist() throws Exception {
//		Connection conn = JDBCTemplate.getConn();
//		 
//		List<BoardVo> voList = dao.selectList(conn);
//		
//		conn.close();
//		
//		return voList;
//	}

}
