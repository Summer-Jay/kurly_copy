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
	<table border = "1" style="border-collapse:collapse;">
		<tr height="40">
			<td align="center" width="120"> 글번호 </td>
			<td align="center" width="180">${bean.getNum()}</td>
			<td align="center" width="120"> 조회수 </td>
			<td align="center" width="180">${bean.getReadcount()}</td>
		</tr>
		<tr height="40">
			<td align="center" width="120"> 작성자 </td>
			<td align="center" width="180"> ${bean.getWriter()}</td>
			<td align="center" width="120"> 작성일 </td>
			<td align="center" width="180"> ${bean.getReg_date()}</td>
		</tr>
		<tr height="40">
			<td align="center" width="120"> 제목 </td>
			<td align="center" colspan="3"> ${bean.getTitle()}</td>
		</tr>
		<tr height="80">
			<td align="center" width="120"> 글 내용 </td>
			<td align="center" colspan="3"> ${bean.getContent()}</td>
		</tr>
		<tr height="40">
			<td align="center" colspan="4">
				<c:set var="viewer" value = "${sessionScope.id}"/>
				<c:set var="writer" value = "${bean.getWriter()}"/>
				<c:if test="${viewer==writer}">
					<input type="button" value="수정하기" onclick="location.href='${cp}/update.do?num=${bean.getNum()}'" >
					<input type="button" value="삭제하기" onclick="location.href='${cp}/delete.do?num=${bean.getNum()}'" >
				</c:if>
				<input type="button" value="목록보기" onclick="location.href='${cp}/showBoardListForCustomer.do'" >
			</td>
		</tr>
	</table>
</div>
</body>
</html>