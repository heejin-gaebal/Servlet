package com.kh.app.board;

import java.sql.Connection;
import java.util.List;

import com.kh.app.db.JDBCTemplate;

public class BoardService {
	BoardDao boardDao = new BoardDao();

	public int insert(BoardVo vo) throws Exception {
		//비즈니스로직
		//conn
		Connection conn = JDBCTemplate.getConn();
		//dao
		int result = boardDao.insert(conn, vo);
		//트랜잭션
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		//close
		conn.close();
		
		return result;
	}

	public List<BoardVo> selectList() throws Exception {
		//비즈니스로직
		//conn
		Connection conn = JDBCTemplate.getConn();
		//dao
		List<BoardVo> voList = boardDao.selectList(conn);
		//close
		conn.close();
		
		return voList;
	}

	
	
	
	
	
	
	
	
	
}
