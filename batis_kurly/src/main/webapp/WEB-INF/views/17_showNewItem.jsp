<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h2>신상품</h2>
	<c:set var="i" value="0" />
 	<c:set var="j" value="3" />
	<table>
		<c:forEach var="item" items="${itemlist}">
			<c:if test = "${i%j==0}">
				<tr height="250" >
			</c:if>
			<td width = "300" align="center">
			<a href="${cp}/showOneItem.do?item_num=${item.getItem_number()}">
				<img src="${cp}/resources/img/${item.getItem_image()}" width="280">
			</a>
			<p>
			<font size = "5"><b>${item.getItem_name()}</b></font></p>
			<c:if test="${item.getItem_stock()>0}">
				<c:set var="price" value="${item.getItem_price()}"/>
				<c:set var="realprice" value="${item.getItem_price() - item.getItem_price()*item.getDiscount_rate()/100}"/>
				<c:if test="${price>realprice}">
					<p><font size = "3"><del><fmt:formatNumber value="${item.getItem_price()}" pattern="#,###"/>원</del></font>
						→				
					<font size = "4" color = "purple"><b><fmt:formatNumber value="${realprice}" pattern="#,###"/>원</b></font></p>
				</c:if>
				<c:if test="${price==realprice}">
					<p><font size = "4"><fmt:formatNumber value="${item.getItem_price()}" pattern="#,###"/>원</font></p>
				</c:if>
			</c:if>
			<c:if test="${item.getItem_stock()==0}">
				<p><font size = "3" color = "red"><b>품절</b></font></p>
			</c:if>
			</td>
			<c:set var="i" value="${i+1}"/>
		</c:forEach>
	</table>
	</div>
</body>
</html>