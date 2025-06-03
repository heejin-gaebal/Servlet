package com.kh.app.board;

import java.sql.Connection;

import com.kh.app.db.JDBCTemplate;

public class BoardService {
	private BoardDao boardDao = new BoardDao();

	public int insert(BoardVo vo) throws Exception {
		Connection conn = null;
		int result = 0;
		
		conn = JDBCTemplate.getConn();
		result = boardDao.insert(conn, vo);
		
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		
		return result;	
	}
}
