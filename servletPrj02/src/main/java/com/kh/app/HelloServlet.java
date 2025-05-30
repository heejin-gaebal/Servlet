package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
											//요청					  //응답
		System.out.println("서블릿 연습");
		//톰캣에 넣어주고 실행한다
		
		//응답내보내는 통로
		PrintWriter pw = resp.getWriter(); //응답이 적힌걸 get 가져옴
		pw.println("<html>");
		pw.println("<h1>hello!!</h1>");
		pw.println("</html>");
	}
}
