<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join 회원가입</title>
</head>
<body>

	<h1>회원가입</h1>				 <!-- 아이디 비밀번호 유출X post 방식으로 -->
	<form action="http://127.0.0.1:8080/app/member/join" method="POST">
		<input type="text" name="userId" placeholder="아이디"><br>
		<input type="password" name="userPwd" placeholder="비밀번호"><br>
		<input type="text" name="userNick" placeholder="닉네임"><br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>