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
	<form action="read1" method = "post">
		사원명 : <input type = "text" name = "name" size ="10"><br>
		부서명 : <input type = "text" name = "department" size ="10"><br>
		급여 : <input type = "text" name = "salary" size ="10"><br>
		나이 : <input type = "text" name = "age" size ="10"><br>
		혈액형 : <input type = "text" name = "blood" size ="10"><br>
		<button type = "submit" value = "전송" class = "btn btn-info" style = "width:100px; height:50px;">전송</button>
	</form>
	
	<!-- table > tr > th > td > input -->
</body>
</html>