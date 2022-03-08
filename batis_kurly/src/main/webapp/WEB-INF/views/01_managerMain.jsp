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
<c:if test="${empty sessionScope.id}">
  <div id="mList"><p>로그인이 필요한 페이지입니다.
  </div>
</c:if>
<c:if test="${!empty sessionScope.id}">
  <div id="mList">
  	<c:set var="member" value="${membercnt}"/>
  	<c:set var="item" value="${itemcnt}"/>
  	<c:set var="order" value="${buycnt}"/>
  	
  	<h2>#현황</h2>
    <h3>회원 수 : ${member}명</h3>
    <h3>등록된 상품 수 : ${item}개</h3>
    <h3>누적주문량 : ${order}건</h3>
    
  </div>
</c:if>   