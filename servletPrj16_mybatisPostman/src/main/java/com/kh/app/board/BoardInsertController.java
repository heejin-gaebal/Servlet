package com.kh.app.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			//한글
			req.setCharacterEncoding("UTF-8");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			BoardService boardService = new BoardService();
			int result = boardService.insert(vo);
						
			if(result != 1) {
				throw new Exception();
			}
			
//			resp.sendRedirect("/app/board/list");
			//포스트맨에 결과 출력
			PrintWriter out = resp.getWriter(); 
			out.write("result : " + result);
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/app/error");
		}
	}
}
