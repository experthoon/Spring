<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<button type ="button" onclick = "location.href='form'">글쓰기</button>
	<c:if test="${totalCount==0 }">
		<div class = "alert alert-info">
			<b>***저장된 책정보가 없습니다.***</b>		
		</div>
	</c:if>
	
	<c:if test="${totalCount>0 }">
		<div class = "alert alert-info">
			<b>${totalCount }개의 책정보가 있습니다.</b>		
		</div>
	</c:if>
	
	<br>
	<c:forEach var = "a" items = "${list }" varStatus="i">
		<table class = "table table-bordered" style="width: 500px; float:left; margin-right: 50px;">
			<tr>
				<td>
					<c:if test="${a.bookphoto!=null }">
						<img alt ="" src = "/image/${a.bookphoto }" style = "max-width:200px;" align = "left">
					</c:if>
					<c:if test="${a.bookphoto==null }">
						<img alt ="" src = "/image/noimg.png" style = "max-width:150px;" align = "left">
					</c:if>
					
					<h3>상품명: ${a.bookname }</h3>
					<h3>저자: ${a.bookwriter }</h3>
					<h3>가격: <fmt:formatNumber value = "${a.bookprice }" type ="currency"/></h3>
					<h3>출판사: ${a.bookcompany }</h3>
					<h3>입고날짜: <fmt:formatDate value = "${a.ipgoday }" pattern = "yyyy-MM-dd FHH:mm"/> </h3>
					
				</td>
			</tr>
		</table>
		<c:if test="${i.count%2==0 }">
			<div style = "clear: both"></div><br>
		</c:if>		
	</c:forEach>
	
	
</body>
</html>