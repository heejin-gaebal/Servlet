package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") //요청이 중복되면 안된다
public class HelloServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("서블릿 요청과 응답");
	//한국어 설정
	resp.setContentType("text/html;charset=UTF-8");
	
	//정수 하나 받아서 성인인지 아닌지 판단
	int age = Integer.parseInt(req.getParameter("age"));
		
	PrintWriter pw = resp.getWriter();
	
	if(age < 20) {
		pw.println("<h1>미성년자입니다.</h1>");
	}else {
		pw.println("<h1>성인입니다.</h1>");
	}
}
}
