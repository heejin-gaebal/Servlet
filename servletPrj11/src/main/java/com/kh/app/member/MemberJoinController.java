package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{
	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userNick = req.getParameter("userNick");
		
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(userNick);
		System.out.println("회원가입 완료");
		
		//service 호출
		int result = 1;
		
		//result : 회원가입 끝났으면 홈페이지로 돌아가기
		HttpSession s = req.getSession(); //세션 객체 가져와서 HttpSession타입인 변수에 담기
		s.setAttribute("msg", "회원가입 성공><");
		//req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		//새로고침할 시 마지막 요청을 계속 보내는 문제발생 - url은 넘어간 상태 [리다이렉트 처리]
		resp.sendRedirect("/app/home");
		//여기에 다시 요청하세요 (응답)상태코드300변환 
		//-> 브라우저가 톰캣에 요청할 것을 브라우저에게 응답해주는 것
	}
}
