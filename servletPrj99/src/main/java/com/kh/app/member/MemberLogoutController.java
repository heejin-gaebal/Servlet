package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그아웃 - 속성제거
//		req.getSession().removeAttribute("loginMember");
		
		//로그아웃 - 세션만료 (모든 세션 삭제)
		req.getSession().invalidate();
		resp.sendRedirect("/home");
	}
}
