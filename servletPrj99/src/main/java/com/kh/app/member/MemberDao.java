package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	public int join(Connection conn, MemberVo memberVo) throws Exception {
		//쿼리 준비
		String sql = """
				INSERT INTO MEMBER
				(
				    NO
				    ,USER_ID
				    ,USER_PWD
				    ,USER_NICK
				)
				VALUES
				(
				    SEQ_MEMBER.NEXTVAL
				    , ?
				    , ?
				    , ?
				)
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberVo.getUserId());
		pstmt.setString(2, memberVo.getUserPwd());
		pstmt.setString(3, memberVo.getUserNick());
		
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		
		return result;
	}

	public MemberVo login(Connection conn, MemberVo memberVo) throws Exception {
		System.out.println(memberVo);
		//쿼리 준비
		String sql = """
				SELECT
			    NO
			    ,USER_ID
			    ,USER_PWD
			    ,USER_NICK
			    ,CREATED_DATE
			    ,DEL_YN
			FROM MEMBER
			WHERE USER_ID = ? 
			AND USER_PWD = ? 
			AND DEL_YN = 'N'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//쿼리 실행
		pstmt.setString(1, memberVo.getUserId());
		pstmt.setString(2, memberVo.getUserPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs->vo
		MemberVo loginMemberVo = null;
		
		if(rs.next()) {
			String no = rs.getString("NO");
			String userId = rs.getString("USER_ID");
			String userPwd = rs.getString("USER_PWD");
			String userNick = rs.getString("USER_NICK");
			String createdDate = rs.getString("CREATED_DATE");
			String delYn = rs.getString("DEL_YN");
			
			loginMemberVo = new MemberVo(no, userId, userPwd, userNick, createdDate, delYn);
		}
		
		//자원 반납
		rs.close();
		pstmt.close();
		
		return loginMemberVo;
	}

}
