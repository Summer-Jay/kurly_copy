<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="loginForm" align="center">
	<form method="post" action = "loginPro.do">
	<table>
		<tr height="70">
			<td width="300" align="center">
				<h2>로그인</h2>
			</td>
		</tr>
		<tr height = "50">
			<td width = "300" align="center">
				<input type="text" name = "id" placeholder="아이디를 입력하세요"  style="width:300px; height:30px">
			</td>
		</tr>
		
		<tr height = "50">
			<td width = "300" align="center">
				<input type="password" name = "pw" placeholder="비밀번호를 입력하세요" style="width:300px; height:30px">
			</td>
		</tr>
		
		<tr height = "50">
			<td width="300">
				<input type="image" src="${cp}/resources/img/login.PNG" id = "submit" value="submit" style="width : 320px">
			</td>
		</tr>
		<tr height = "50">
			<td width="300">
				<img src="${cp}/resources/img/join.PNG" onclick="location.href='join.do'" width = "320">
			</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>