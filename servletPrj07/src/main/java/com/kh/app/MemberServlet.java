package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("회원가입 서블릿");
		
		//data
		String userId = req.getParameter("userId"); 
		String userPwd = req.getParameter("userPwd"); 
				
		//(비즈니스)서비스로직 -> admin/1234
		String result = "";
		if(userId.equals("admin") && userPwd.equals("1234")) {
			result = "로그인 성공!";
		}else {
			result = "로그인 실패ㅠ";
		}
		
		//result
		req.setAttribute("result", result);
		req.getRequestDispatcher("/member.jsp").forward(req, resp);
	}
}
