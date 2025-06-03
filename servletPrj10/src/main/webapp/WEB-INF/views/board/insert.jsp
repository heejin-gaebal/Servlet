<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Page</title>
</head>
<body>
	<h1>게시글 작성</h1>

    <!-- 최상단 경로로 작성 [톰캣 context root : /app]-->
    <form action="/app/board/insert" method="post">
        <input type="text" name="title" placeholder="제목"> <br>
        <textarea name="content" placeholder="내용"></textarea> <br>
        <input type="submit" value="게시글 작성"> 
    </form>
</body>
</html>