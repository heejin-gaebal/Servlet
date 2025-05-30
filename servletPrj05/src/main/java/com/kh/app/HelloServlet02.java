package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello02") //요청이 중복되면 안된다
public class HelloServlet02 extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("복잡한 자바코드 작업!!");
	//한국어 설정
	resp.setContentType("text/html;charset=UTF-8");
	
	//문자열 내보내기
	req.getRequestDispatcher("/servletTest.jsp").forward(req, resp); // JSP경로넣기
}
}
