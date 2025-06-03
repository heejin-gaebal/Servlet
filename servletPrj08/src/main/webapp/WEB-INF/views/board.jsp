<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views board</title>
</head>
<body>

	<%-- ${} EL(Expression Language) --%>
	<%-- JSP에서의 주석 --%>
	<h1>BOARD</h1>
	<h2>${vo.no}</h2>
	<h2>${vo.title}</h2>
	<h2>${vo.content}</h2>
	
</body>
</html>