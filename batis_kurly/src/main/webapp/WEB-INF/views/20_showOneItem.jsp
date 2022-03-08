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
	<form method = "post" action = "insertCart.do">
	
		<table>
		<c:forEach var="one" items="${onelist}">
			<tr height="80">
				<td rowspan = "6" width = "350" align = "center" >
					<img alt="" src="${cp}/resources/img/${one.getItem_image()}" height = "350">
				</td>
				<td width = "400" colspan="2">
					<font size = "5"><b>${one.getItem_name()}</b></font><br>
					<font size = "2">${one.getItem_info()}</font>
					
				</td>
			</tr>
			<tr height="70">
				<td width = "400" colspan="2">
				<c:set var="realprice" value="${one.getItem_price() - one.getItem_price()*one.getDiscount_rate()/100}"/>
					<font size="3"><b><del><fmt:formatNumber value="${one.getItem_price()}" pattern="#,###"/>원</del></b></font> 
					→
					<font size="4" color="purple"><b><fmt:formatNumber value="${realprice}" pattern="#,###"/>원</b></font><br>
					<font size="2" color = "purple">로그인 후 적립혜택이 적용됩니다.</font>
				</td>
			</tr>
			<tr height="50">
				<td width = "100">
					<font size="2"><b>판매단위</b></font>
				</td>
				<td width = "300">
					<font size="2">1개</font>
				</td>
			</tr>
			<tr height="50">
				<td width = "100">
					<font size="2"><b>배송방법</b></font>
				</td>
				<td width = "300">
					<font size="2">샛별배송/택배배송</font>
				</td>
			</tr>
			<tr height="50">
				<td width = "100">
					<font size="2"><b>포장타입</b></font>
				</td>
				<td width = "300">
					<font size="2">상온/종이포장</font><br>
					<font size="1">택배배송은 에코포장이 스티로폼으로 대체됩니다.</font>
				</td>
			</tr>
			<tr height="50">
				<td width = "100">
					<font size="2"><b>구매수량</b></font>
				</td>
				<td width = "300">
					<input type = "number" name="buycnt" min="0" max="100" size = "100" value = "1">
				</td>
			</tr>
			<tr height="35">
				<td colspan="3" align="right">
						<input type="image" src = "${cp}/resources/img/sendcart.PNG" name="submit" value="submit" style="height:50px">
						<input type="hidden" name = "item_number" value="${one.getItem_number()}">
						<input type="hidden" name="buyer" value="${sessionScope.id}">
						<input type="hidden" name="buy_price" value="<fmt:formatNumber value="${realprice}" pattern="####"/>">
						<input type="hidden" name="item_name" value="${one.getItem_name()}">
						<input type="hidden" name="item_image" value="${one.getItem_image()}">
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>

</div>	
</body>
</html>