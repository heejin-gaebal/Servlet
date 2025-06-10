package com.kh.app.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/edit")
public class BoardEditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//한글
			req.setCharacterEncoding("UTF-8");
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			
			BoardService boardService = new BoardService();
			int result = boardService.edit(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result :" + result);
//			resp.sendRedirect("/app/board/detail?no=" + no);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
