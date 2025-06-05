package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			
			MemberVo memberVo = new MemberVo();
			memberVo.setUserId(userId);
			memberVo.setUserPwd(userPwd);
			
			System.out.println("CCC : " + memberVo);
			
			//service
			MemberService memberService = new MemberService();
			MemberVo loginMember = memberService.login(memberVo);
			
			if(loginMember == null) {
				throw new Exception();
			}
			
			//result 세션에 attr 담아주기
			req.getSession().setAttribute("alertMsg", "로그인 성공!!");
			req.getSession().setAttribute("loginMember", loginMember);
			resp.sendRedirect("/home");
		}catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/error");
		}
	}
}
