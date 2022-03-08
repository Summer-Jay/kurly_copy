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
	<div align="center">

	<table border ="1" style="border-collapse:collapse;">
	
	<tr height="50">
		<td width="50" align="center">번호</td>
		<td width="100" align="center">아이디</td>
		<td width="100" align="center">주문자명</td>
		<td width="100" align="center">상품명</td>
		<td width="100" align="center">가격</td>
		<td width="100" align="center">구매갯수</td>
		<td width="50" align="center">이미지</td>
		<td width="200" align="center">구매일자</td>
		<td width="100" align="center">결제수단</td>
		<td width="300" align="center">주소</td>
	</tr>
	<c:set var="number" value="${0}"/>
	<c:forEach var = "order" items="${orderlist}">
		<tr height="30">
			<td width = "50" align="center">
				<c:set var="number" value="${number+1}"/>
		  		<c:out value="${number}"/>	
			</td>
			<td width = "100" align="center">${order.getCustomer_id()}</td>
			<td width = "100" align="center">${order.getCustomer_name()}</td>
			<td width = "100" align="center">${order.getItem_name()}</td>
			<td width = "100" align="center">${order.getBuy_price()}원</td>
			<td width = "100" align="center">${order.getBuy_count()}개</td>
			<td width = "50" align="center">
				<img src="${cp}/resources/img/${order.getItem_image()}" height="50">
			</td>
			<td width = "200" align="center">${order.getBuy_date()}</td>
			<td width = "100" align="center">${order.getHowpay()}</td>
			<td width = "300" align="center">${order.getAddress()}</td>
		</tr>
</c:forEach>
</table>
</div>
</body>
</html>