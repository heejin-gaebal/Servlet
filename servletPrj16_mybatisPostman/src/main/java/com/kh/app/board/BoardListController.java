package com.kh.app.board;

import java.io.IOException;
import java.io.PrintWriter;
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
			//한글
			resp.setContentType("text/html; charset=UTF-8");
			
			BoardService boardService = new BoardService();
			List<BoardVo> voList = boardService.selectList();
			
			//포스트맨에 결과 출력
			PrintWriter out =  resp.getWriter();
			out.write(voList.toString());
			
//			req.setAttribute("voList", voList);
//			req.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/error");
		}
	}
}
