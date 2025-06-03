<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 연결 [Plus]</title>
</head>
<body>
	 <!-- 서블릿 req 에 담긴 Attribute 중에서 키값이 요소 x 꺼내기 -->
	 
	 <!-- 자바 코드 -->
	 <%
	 	int x = (int)request.getAttribute("x");
	 	//[에러]Type mismatch: cannot convert from Object to int
	 	//getAttribute의 리턴값이 Object타입이므로 형변환 필요
	 %>
	 <h1>
	 	<!-- 문자열에 자바코드 넣기 -->
	 	<%out.println(x);%> 
	 </h1>
</body>
</html>