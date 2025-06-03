<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Page</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	
	<!-- voList를 가져오기위해 자바로 리스트 속성, <BoardVo>객체 가져오기 (List)형변환-->
	<% List<BoardVo> voList = (List)request.getAttribute("voList"); %>
	
	<!-- 리스트 반복 -->
	<% for(BoardVo vo : voList){%>
	<h2><%= vo.getContent() %></h2>
	<% } %>
</body>
</html>