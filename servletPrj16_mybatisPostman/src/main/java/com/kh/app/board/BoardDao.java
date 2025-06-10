package com.kh.app.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {

	public int insert(SqlSession ss, BoardVo vo) {
		return ss.insert("BoardMapper.write", vo);
	}

	public List<BoardVo> selectList(SqlSession ss) {
		return ss.selectList("BoardMapper.getBoardList");
	}

	public BoardVo selectBoardbyNo(SqlSession ss, String no) {
		return ss.selectOne("BoardMapper.getBoardByNo", no);
	}
	
	//조회수 증가
	public int increaseHit(SqlSession ss, String no) {
		return ss.update("BoardMapper.increaseHit", no);
	}
	
	public int edit(SqlSession ss, BoardVo vo) {
		return ss.update("BoardMapper.updateBoard", vo);
	}

	public int delete(SqlSession ss, String no) {
		return ss.update("BoardMapper.deleteBoard", no);
	}

}
