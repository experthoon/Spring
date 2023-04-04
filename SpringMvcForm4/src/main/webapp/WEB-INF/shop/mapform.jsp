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
	<h3>시험점수입력</h3>
	<form action="process3" method = "post">
	
		학생명 : <input type = "text" name = "name" class="form-control input-sm"><br>
		자바점수 : <input type = "text" name = "java" class="form-control input-sm"><br>
		오라클점수 : <input type = "text" name = "oracle" class="form-control input-sm"><br>
		스프링점수 : <input type = "text" name = "spring" class="form-control input-sm"><br>
		<button type = "submit" value = "전송" class = "btn btn-info" style = "width:100px; height:50px;">전송</button>
	
	</form>
</body>
</html>