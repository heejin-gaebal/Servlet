package com.kh.app.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.mybatis.SqlSessionTemplate;

public class BoardService {
	private final BoardDao dao = new BoardDao();

	public int insert(BoardVo vo) throws Exception {
		//비즈니스 로직
		//DB연결
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//DAO 호출
		int result = dao.insert(ss, vo);
		//트랜잭션 처리
		if(result != 1) {
			ss.rollback();
		}else {
			ss.commit();
		}
		//자원 반납
		ss.close();

		return result;
	}

	public List<BoardVo> selectList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<BoardVo> voList = dao.selectList(ss);
		
		ss.close();
		
		return voList;
	}

	public BoardVo selectBoardbyNo(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//DAO 호출 넘버 + 조회수증가
		//조회수를 먼저 처리하고 
		int result = dao.increaseHit(ss, no);
		
		BoardVo vo = null;
		//조회수 커밋
		if(result == 1) {
			ss.commit();
			//그 후에 select
			vo = dao.selectBoardbyNo(ss, no);
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		return vo;
	}

	public int edit(BoardVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.edit(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

	public int delete(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.delete(ss,no);
		
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		return result;
	}

	

}
