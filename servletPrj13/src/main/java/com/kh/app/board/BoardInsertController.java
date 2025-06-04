package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{

	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	//로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//한국어 설정 요청 | 응답
			req.setCharacterEncoding("UTF-8"); 
//			응답 : resp.setContentType("text/html;charset=UTF-8");
			
			//data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			System.out.println("title : " + title);
			System.out.println("content : " + content);
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			//service
			BoardService boardService = new BoardService();
			int result = boardService.insert(vo);
			
			resp.sendRedirect("/app/board/list");
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/app/error");
		}
	}
}
