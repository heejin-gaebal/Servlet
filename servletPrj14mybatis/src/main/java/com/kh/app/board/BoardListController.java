package com.kh.app.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//한국어 설정 요청 | 응답
			req.setCharacterEncoding("UTF-8"); 
			BoardService boardService = new BoardService();
			List<BoardVo> voList = boardService.selectlist();
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/app/error");
		}
		
	}
}
