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
		//한국어 설정
		resp.setContentType("text/html;charset=UTF-8");
//		resp.setCharacterEncoding("UTF-8");
		
		String x = req.getParameter("userNick");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<style>");
		pw.println("h1{background-color:pink}");
		pw.println("</style>");
		pw.println("</head>");

		pw.println("<body>");
		pw.println("<h1>안녕하세요</h1>");
		pw.println("<h2>" + x + " 님</h2>");
		pw.println("</body>");
		
		pw.println("</html>");
		
	}
}
