<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
    
<!DOCTYPE html>
<html>
<style>
	#lStatus a{
		font-size:0.8em;
	}


</style>
<c:if test="${empty sessionScope.id}">
  <div id="lStatus">
  
 		<a href = "join.do" style="text-decoration: none">회원가입</a>&nbsp;
			<img alt="" src="${cp}/resources/img/top1.jpg"> &nbsp;
		<a href = "login.do" style="text-decoration: none">로그인</a>&nbsp; 
  </div>
</c:if>
<c:if test="${!empty sessionScope.id}">
  <div id="lStatus">
     <a href = "#"> ${sessionScope.id}님</a>  &nbsp;
     <img alt="" src="${cp}/resources/img/top1.jpg"> &nbsp;
     <a href = "${cp}/logout.do" style="text-decoration: none">로그아웃</a>&nbsp;
     <img alt="" src="${cp}/resources/img/top1.jpg"> &nbsp;
     <a href = "${cp}/cartInfo.do?id=${sessionScope.id}" style="text-decoration: none">장바구니</a>&nbsp;
     <img alt="" src="${cp}/resources/img/top1.jpg"> &nbsp;
     <a href = "${cp}/checkMyOrderList.do?id=${sessionScope.id}" style="text-decoration: none">구매내역</a>&nbsp;
     <img alt="" src="${cp}/resources/img/top1.jpg"> &nbsp;
     <a href = "${cp}/showBoardListForCustomer.do?id=${sessionScope.id}" style="text-decoration: none">고객센터</a>&nbsp;
  </div>
</c:if> 