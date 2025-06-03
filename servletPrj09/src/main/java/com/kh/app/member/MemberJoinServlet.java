package com.kh.app.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{
	//doGet|doPost 각각 쓰레드 생성되서 실행
	//get : 회원가입 화면처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);//jsp에 포워딩해줌
	}
	
	//post : 회원가입 로직처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 동작완료!!");
		//data
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userNick = req.getParameter("userNick");
		
		//service
		int result = 1;
		
		//result
		if(result != 1) {
			req.setAttribute("errorMsg", "회원가입 실패..");
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/member/joinSuccess.jsp").forward(req, resp);
	}
}
