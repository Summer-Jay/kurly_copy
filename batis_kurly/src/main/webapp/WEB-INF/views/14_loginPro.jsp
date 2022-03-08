<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<c:if test="${check == 1}">
	<c:set var="id" value="${id}" scope="session"/>
	<script>
		location.href='index.do';
	</script>
</c:if>
<c:if test="${check!=1}">
<script>
	alert("아이디와 비밀번호를 확인해주세요");
	history.go(-1);
</script>
</c:if>
