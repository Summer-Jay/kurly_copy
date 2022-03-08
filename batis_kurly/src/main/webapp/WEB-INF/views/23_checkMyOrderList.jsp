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
	<div id="checkOrder" align="center">
		<h2>주문내역 확인</h2>
		<hr size="2" color="purple" width = "300">
		<c:if test="${cnt == 0}">
	    	<h3>최근 구매한 상품이 없습니다.</h3>
  		</c:if>
		
		<c:if test="${cnt >0}">
		<table>
		<tr height="50">
			<td width="50" align="center">
				<font size = "3" color="purple">번호</font>
			</td>
			<td width="50" align="center">
				<font size = "3" color="purple"></font>
			</td>
			<td width="100" align="center">
				<font size = "3" color="purple">상품명</font>
			</td>
			<td width="50" align="center">
				<font size = "3" color="purple">수량</font>
			</td>
			<td width="100" align="center">
				<font size = "3" color="purple">가격</font>
			</td>
			<td width="200" align="center">
				<font size = "3" color="purple">주문일</font>
			</td>
			<td width="150" align="center">
				<font size = "3" color="purple">결제수단</font>
			</td>
		</tr>
		<tr height="10">
			<td colspan="7">
				<hr size="2" color="gray" width="800">
			</td>
		</tr>
		<c:set var="number" value="${0}"/>
		<c:forEach var = "buy" items="${buylist}">
			<tr height="50">
			<td width="50" align="center">
				<font size="2">
					<c:set var="number" value="${number+1}"/>
		  			<c:out value="${number}"/>
				</font>
			</td>
			<td width="50" align="center">
				<img src="${cp}/resources/img/${buy.getItem_image()}" height="50">
			</td>
			<td width="100" align="center">
				<font size = "2">${buy.getItem_name()}</font>
			</td>
			<td width="50" align="center">
				<font size = "2">${buy.getBuy_count()}</font>
			</td>
			<td width="100" align="center">
				<font size = "2" >${buy.getBuy_price()*buy.getBuy_count()}</font>
			</td>
			<td width="200" align="center">
				<font size = "2">${buy.getBuy_date()}</font>
			</td>
			<td width="150" align="center">
				<font size = "2">${buy.getHowpay()}</font>
			</td>
		</tr>
		</c:forEach>
		</table>
	</c:if>
	</div>
</body>
</html>