package com.kh.app.board;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {

	public int insert(SqlSession ss, BoardVo vo) {
		return ss.insert("BoardMapper.write", vo);
	}
}
