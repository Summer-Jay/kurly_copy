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
	<div id="cart" align="center">


	<h2>장바구니</h2>
	<hr size="2" color="purple" width = "300">
	
		<c:if test="${cnt==0}">
		<h3>장바구니에 담겨있는 상품이 없습니다.</h3>
	</c:if>
	<c:if test="${cnt>0 }">
	<c:set var="number" value="${0}"/>
	<c:forEach var = "cart" items="${mycartlist}">
	<form method="post" action="${cp}/deleteCart.do">
		<table>
				<tr height="40">
					<td width="50" align="center">
						<c:set var="number" value="${number+1}"/>
		  				<c:out value="${number}"/>
					</td>
					<td width = "100" align = "center">
						<img src = "${cp}/resources/img/${cart.getItem_image()}" height="40">
					</td>
					<td width = "300">
						<font size = "3"> <b>${cart.getItem_name()}</b></font>
					</td>
					<td width = "100" align = "center">
						<font size = "3"> <b>${cart.getBuy_count()}</b></font>
					</td>
					<td width = "100">
						<font size = "3"> <b>${cart.getBuy_price()*cart.getBuy_count()}원</b></font>
					</td>
					<td width = "40" align = "center">
					<input type = "image" src = "${cp}/resources/img/delete.png" onclick="deleteCart.do?cart_number=${cart.getCart_number()}'">
					<input type = "hidden" name = "cart_number" value="${cart.getCart_number()}">
						<%--<button type="button" onclick="location.href='21_deleteCart.jsp?cart_number=<%=bean.getCart_number()%>'" style="height:18px">
							<img src ="img/delete.png"> 
						</button> --%>
					</td>
				</tr>
				
			</table>
		</form>
		
		
		
		
		<hr size="1" color="gray" width="680">
		<c:set var="total" value="${total + cart.getBuy_count()*cart.getBuy_price()}"/>
		<c:set var="deliveryfee" value="4000"/>
	</c:forEach>
	<form method="post" action="${cp}/order.do">
		<table>
			<tr height = "30">
				<td align="right" width = "480" align="right">
					<h4>총 상품금액 </h4>
				</td>
				<td align="right" width = "200" align="right">
					<h4>${total}원</h4>
				</td>
			</tr>
			<tr height = "30">
				<td align="right" width = "480" align="right">
					<h4>배송비 </h4>
				</td>
				<td align="right" width = "200" align="right">
				<c:if test="${total<40000 }">
					<h4>${deliveryfee}원</h4>
					<font size="2" color="purple">
						${40000-total}원 추가주문 시, 무료배송
					</font>
				</c:if>
				<c:if test="${total>=40000 }">
					<h4>0원</h4>
				</c:if>
				</td>
			</tr>
			<tr height = "40">
				<td align="right" width = "480" align="right">
					<h3>총 결제금액 </h3>
				</td>
				<td align="right" width = "200" align="right">
					<c:set var="deleveryfee" value="3000"/>
					<c:if test="${total<40000 }">
						<c:set var="finalPrice" value="${total + deliveryfee}"/>
						<h3><b>${finalPrice}원</b></h3>
					</c:if>
					<c:if test="${total>=40000 }">
						<c:set var="finalPrice" value="${total}"/>
						<h3><b>${finalPrice}원</b></h3>
					</c:if>
				</td>
			</tr>
			<tr height = "30">
				<td align="right" colspan="2">
					<input type="image" src="${cp}/resources/img/order.PNG" name="submit" value="submit" style="height:50px">
					<input type="hidden" name="total" value="${finalPrice}">
					 <input type="hidden" name="buyer" value="${sessionScope.id}">
				</td>
			</tr>
		</table>
		</form>
	</c:if>
	</div>
</body>
</html>