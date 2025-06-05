package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.JDBCTemplate;

public class MemberService {
	private final MemberDao memberDao = new MemberDao();

	public int join(MemberVo memberVo) throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JDBCTemplate.getConn();
		
		//DAO 호출
		int result = memberDao.join(conn,memberVo);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		//자원 반납
		conn.close();
		
		return result;
	}

	public MemberVo login(MemberVo memberVo) throws Exception {
		//DB연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		MemberVo loginMember = memberDao.login(conn, memberVo);
		//자원 반납
		conn.close();
		
		return loginMember;
	}
}
