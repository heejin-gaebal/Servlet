package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardSelectServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data : 게시글 번호
		String bno = req.getParameter("bno");
		//DB 가서 select
		BoardVo vo = new BoardVo("1","제목01", "내용111");
		
		//result : 게시글
		req.setAttribute("vo", vo); //vo 객체를 전달 | setAttribute를 이용해 데이터 전달
		req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
	}
}
