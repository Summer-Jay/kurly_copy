<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<html>
<head>
	<style>
	a{
	 color : black;
	 text-decoration : none;
	
	}
	a:hover{
		color : purple;
	}
	#auth{
		position : absolute;
		right:10px;
		top:30px;
	}
</style>
</head>
<body>
<div id="header" >
  		<div id="top" class="box" align="center" >
		    <a href= "${cp}/index.do">
		    	<img id="logo" src="${cp}/resources/img/logo.png" height="80"/>
		    </a>
  		</div>
    		<c:if test="${type == 0}">
  				<div id="auth" class="box">
      				<jsp:include page="02_managerLogin.jsp"/>
      			</div>
      			<div id = "mainmenudiv" align = "center">
					<table>
						<tr height="50">
							<td width = "180" align = "center" id="dropdown">
								<font size="3" color="black"><a href = "${cp}/managerMain.do"><b>관리자 메인</b></a></font>
							</td>
							<td width="10" align = "center">
								<img alt="" src="${cp}/resources/img/top1.jpg">
							</td>
							
							<td width = "180" align = "center">
								<font size="3" color="black"><a href = "${cp}/addNewItem.do"><b>신상품등록</b></a></font>
							</td>
							<td width="10" align = "center">
								<img alt="" src="${cp}/resources/img/top1.jpg">
							</td>
							
							<td width = "180" align = "center">
								<font size="3" color="black"><a href = "${cp}/itemListForManager.do"><b>상품 수정/삭제</b></a></font>
							</td>
							<td width="10" align = "center">
								<img alt="" src="${cp}/resources/img/top1.jpg">
							</td>
							<td width = "180" align = "center">
								<font size="3" color="black"><a href = "${cp}/checkOrderList.do"><b>주문현황</b></a></font>
							</td>
							<td width="10" align = "center">
								<img alt="" src="${cp}/resources/img/top1.jpg">
							</td>
							<td width = "180" align = "center">
								<font size="3" color="black"><a href = "${cp}/adminShowBoardList.do"><b>Q&A</b></a></font>
							</td>			
						</tr>
					</table>
				</div>
    		</c:if>
    		<c:if test="${type == 1}">
    			<div id="auth" class="box">
     				<jsp:include page="00_topMenu.jsp"/>
     			</div>
     			<div id = "mainmenudiv" align = "center">
					<table>
						<tr height="50">
							<td width = "180" align = "center" id="dropdown">
								<font size="3" color="black"><a href = "${cp}/showAllItem.do"><b>전체상품 보기</b></a></font>
							</td>
							<td width="10" align = "center">
								<img alt="" src="${cp}/resources/img/top1.jpg">
							</td>
							
							<td width = "180" align = "center">
								<font size="3" color="black"><a href = "${cp}/showNewItem.do"><b>신상품</b></a></font>
							</td>
							<td width="10" align = "center">
								<img alt="" src="${cp}/resources/img/top1.jpg">
							</td>
							
							<td width = "180" align = "center">
								<font size="3" color="black"><a href = "${cp}/showBestItem.do"><b>베스트</b></a></font>
							</td>
							<td width="10" align = "center">
								<img alt="" src="${cp}/resources/img/top1.jpg">
							</td>
							<td width = "180" align = "center">
								<font size="3" color="black"><a href = "${cp}/showDiscountedItem.do"><b>알뜰쇼핑</b></a></font>
							</td>
											
						</tr>
					</table>
				</div>
    		</c:if>
  		</div>
  		
<div id="content" class="box2">
  <jsp:include page="${cont}"/>
</div>
<div id = "footer" align="center">
		<hr color = "lightgray" size="1">
	<table>
		<tr height="50">
			<td align="center" width="50">
				<img alt="" src="${cp}/resources/img/bottom(1).png" width="40" height="40">
			</td>
			<td width="250">
				<font size="1" color="gray">
				[인증범위]마켓컬리 쇼핑몰 서비스 개발ㆍ운영<br>
				[유효기간]2019.04.01~2022.03.31
				</font>
			</td>
			
			<td align="center" width="50">
				<img alt="" src="${cp}/resources/img/bottom(3).png" width="40" height="40">
			</td>
			<td width="250">
				<font size="1" color="gray">
				개인정보보호 우수 웹사이트<br>
				개인정보처리시스템 인증(ePRIVACY PLUS)
				</font>
			</td>
			
			<td align="center" width="150">
				<img alt="" src="${cp}/resources/img/bottom(2).png" width="150" >
			</td>
			<td width="350">
				<font size="1" color="gray">
				고객님의 안전거래를 위해 현금 등으로 결제 시 저희 쇼핑몰에서 가입한 <br/>
				토스 페이먼츠 구매안전(에스크로) 서비스를 이용하실 수 있습니다.
				</font>
			</td>
			
		</tr>
	</table>
	</div>
</body>
</html>