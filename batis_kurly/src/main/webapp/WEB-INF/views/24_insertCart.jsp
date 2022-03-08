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

	<c:if test="${empty sessionScope.id}">
		<script>
				alert("로그인 후 이용이 가능합니다.");
				history.go(-1);
		</script>
	</c:if>
	<c:if test="${!empty sessionScope.id}">
		<script>
			alert("상품을 장바구니에 담았습니다.");
			location.href="${cp}/cartInfo.do";
		</script>
	</c:if>
</body>
</html>