package com.kh.app.member;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.mybatis.SqlSessionTemplate;

public class MemberService {
	private final MemberDao dao = new MemberDao();

	public int join(MemberVo vo) throws Exception {
		//ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		//dao
		int result = dao.join(ss, vo);
		
		//tx
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		//close
		ss.close();
		
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		MemberVo selectedMemberVo = dao.login(ss, vo);
		
		ss.close();
		
		return selectedMemberVo;
	}

	public int quit(MemberVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		int result = dao.quit(ss ,vo);
		
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		return result;
	}

}
