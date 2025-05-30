package com.kh.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		System.out.println("zzz");

		//http 방식 통신 준비
		//Stream 준비
		//패킷 규칙에 맞게 해석, 생성
		
		//클라이언트의 요청이 서버로 넘어온 상태
	}
}
