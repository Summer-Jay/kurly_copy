<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<style>
	ul li{
		list-style: none;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.id}">
  <div id="status">
  <form method="post" action="${cp}/managerLoginPro.do">
     <ul>
        <li><label for="id">아이디</label>
            <input id="id" name="id" type="text" size="20" 
              maxlength="50" placeholder="marketkurly">
            <label for="pw">비밀번호</label>
            <input id="pw" name="pw" type="password" 
              size="20" placeholder="6~16자 숫자/문자" maxlength="16">
            <input type="submit" value="로그인">
     </ul>
     </form>
  </div>
</c:if>
<c:if test="${!empty sessionScope.id}">
  <div id="status">
  <form method="post" action="${cp}/managerLogout.do">
     <ul>
        <li>관리자님 접속중
           <input type="submit" value="로그아웃">
     </ul>
  </form>
  </div>
</c:if> 
</body>
</html>