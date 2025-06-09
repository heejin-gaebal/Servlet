package com.kh.app.board;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.MybatisTemplate;

public class BoardService {
	private final BoardDao dao = new BoardDao();
	public int insert(BoardVo vo) throws Exception {
		SqlSession ss = MybatisTemplate.getSqlSession();
		
		int result = dao.insert(ss, vo);
		
		ss.commit();
		
		ss.close();
		
		return result;
	}

}
