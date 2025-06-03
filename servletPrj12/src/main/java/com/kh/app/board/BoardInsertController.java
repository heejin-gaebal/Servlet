package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{

	//게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	
	//게시글 작성 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		//service
		BoardService boardService = new BoardService();
		int result = 0;
		try {
			result = boardService.insert(vo);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		//result 리다이렉트 요청
		if(result != 1) {
			resp.sendRedirect("/error.jsp");
			return;
		}
		resp.sendRedirect("/app/board/list");
	}
}
