<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/static/css/common.css">

	<!--저장소에 ${alertMsg}가 null 인지 비어있는지 검사 
		비어있지 않으면 통과 -->
	<c:if test="${not empty alertMsg}">
		<script>
			alert('${alertMsg}');	
		</script>
	</c:if>
	<%session.removeAttribute("alertMsg");%>
	
	<header>
		<div>
			<div></div>
			<div>
				<a href="/home"><h1>🎀</h1></a>
			</div>
			<div id="login-area">
				<!-- 로그인 여부 - loginMember가 빈값이면 해당 form 등장 -->
				<c:if test="${empty loginMember}"> 
					<form action="/member/login" method="post">
						<input type="text" name="userId" placeholder="아이디">
						<input type="button" value="회원가입" onclick="location.href='/member/join'">
						<input type="password" name="userPwd" placeholder="비밀번호">
						<input type="submit" value="로그인">
					</form>
				</c:if>
				<!-- 로그인 여부 - loginMember에 값이 있으면 해당 form 등장 -->
				<c:if test="${not empty loginMember}">
					<h3>${loginMember.userNick}</h3>
					<a href="member/logout">로그아웃</a>
				</c:if>
			</div>
		</div>
	
		<nav>
			<a href="/board/list">게시글</a>
			<a href="/notice/list">공지사항</a>
			<a href="/gallery/list">갤러리</a>
			<a href="/member/mypage">마이페이지</a>
		</nav>
	</header>