package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{

	//게시글 작성 (화면) - doGet 화면 구현
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	
	//게시글 작성 (로직) - doPost 데이터 노출 방지
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data 가져오기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//service 메소드에 전송
		int result = 1; //서비스.insert(데이터)
		
		//result
		if(result != 1) {
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return; //다음 코드 실행방지 [탈출]
		}
		req.getRequestDispatcher("/WEB-INF/views/board/insertSuccess.jsp").forward(req, resp);
	}
}
