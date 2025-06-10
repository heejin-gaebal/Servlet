package com.kh.app.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//한글
			resp.setContentType("text/html; charset=UTF-8");
			String no = req.getParameter("no");
			
			BoardService boardService = new BoardService();
			BoardVo vo = boardService.selectBoardbyNo(no);
			
			PrintWriter out = resp.getWriter();
			out.write(vo.toString());
			
//			req.setAttribute("vo", vo);
//			req.getRequestDispatcher("/WEB-INF/board/detail.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/error");
		}
	}
}
