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
	<h3>post 방식으로 사원폼 읽기</h3>
	<form action="process2" method = "post">
	
		상품명 : <input type = "text" name = "sang" class="form-control"><br>
		수량 : <input type = "text" name = "su" class="form-control"><br>
		단가 : <input type = "text" name = "dan" class="form-control"><br>
		색상 : <input type = "color" name = "color" class="form-control"><br>
		<button type = "submit" value = "전송" class = "btn btn-info" style = "width:100px; height:50px;">전송</button>
	
	</form>
</body>
</html>