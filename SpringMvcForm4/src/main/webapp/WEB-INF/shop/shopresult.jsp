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
	<h2>상품정보출력</h2>
	<div style = "color: ${dto.color};">
		상품명:${dto.sang}
		수량:<fmt:formatNumber value="${dto.su}" pattern = "#,##0"/><br>
		단가:<fmt:formatNumber value="${dto.dan}" type = "currency"/><br>
		총금액:<fmt:formatNumber value="${dto.su*dto.dan}" type = "currency"/><br>
	</div>
</body>
</html>