package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("서블릿 연습");
	// userId/pwd 받기
	String userId = req.getParameter("userId");
	String userPwd = req.getParameter("userPwd");
	
	// 복잡한 작업
	System.out.println("아이디, 비번이용해서 db값 조회하고 로그인 성공여부 판단");
	//admin, 1234면 로그인 성공
	
	// JSP한테 떠넘기기
	req.getRequestDispatcher("/hello.jsp").forward(req, resp);
}
}
