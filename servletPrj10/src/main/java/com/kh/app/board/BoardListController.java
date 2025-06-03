package com.kh.app.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{

	//게시글 목록 화면 - 할일은 하나, 데이터 노출방지 필요없으므로 service 메서드 사용
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//service.객체.selectList();
		
		List<BoardVo> voList = new ArrayList<>();
		voList.add(new BoardVo ("제목01", "내용오옹1"));
		voList.add(new BoardVo ("제목02", "내용오옹2"));
		voList.add(new BoardVo ("제목03", "내용오옹3"));
		voList.add(new BoardVo ("제목04", "내용오옹4"));
		voList.add(new BoardVo ("제목05", "내용오옹5"));
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
	}
}
