package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8"); //한글
			//data
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			String userNick = req.getParameter("userNick");
			
			MemberVo memberVo = new MemberVo();
			memberVo.setUserId(userId);
			memberVo.setUserPwd(userPwd);
			memberVo.setUserNick(userNick);
			
			//service
			MemberService memberService = new MemberService();
			int result = memberService.join(memberVo);
			
			//result
			if(result != 1) {
				throw new Exception();
			}
			//세션에 attr 담아주기
			req.getSession().setAttribute("alertMsg", "회원가입 성공!!!");
			resp.sendRedirect("/home");
		}catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/error");
		}
	}
}
