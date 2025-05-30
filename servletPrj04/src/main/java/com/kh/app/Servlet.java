package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//한국어 설정
		resp.setContentType("text/html;charset=UTF-8");
		
		String str = req.getParameter("userNick");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<link rel=\"stylesheet\" href=\"http://127.0.0.1:8080/app04/hello.css\">");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h1>안녕하세요</h1>");
		pw.println("<hr>");
		pw.println("<h2>" + str + " 님 환영해요</h2>");
		
		pw.println("</body>");
		
		pw.println("</html>");
	}
}
