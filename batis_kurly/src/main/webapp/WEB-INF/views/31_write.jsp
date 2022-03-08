<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form method="post" action = "writePro.do" accept-charset="UTF-8">
	<table border = "1" style="border-collapse:collapse;">
		<tr height = "50">
		<c:set var="writer" value="${sessionScope.id}"/>
			<td width = "200" align="center"><b>작성자</b></td>
			<td width = "400">
				<input type = "text" value="${writer}" readonly>
				<%--<input type = "text" name ="writer" size = "20">--%>
			</td>
		</tr>
		<tr height = "50">
			<td width = "200" align="center"><b>제목</b></td>
			<td width = "400">
				<input type = "text" name ="title" size = "50">
			</td>
		</tr>
		<tr height = "150">
			<td width = "200" align="center"><b>글내용</b></td>
			<td width = "400">
				<textarea cols="50" rows="10" id="content" name = "content"></textarea>



			</td>
		</tr>
	</table>
	<br>
	<input type = "submit" value = "글쓰기">&nbsp;
	<input type = "reset" value = "다시쓰기">
</form>
</div>

<script>
    $(document).ready(function(){
    	CKEDITOR.replace( 'content' );
    });

    </script>


</body>


</html>



