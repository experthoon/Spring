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
	<a href = "samsung/list"></a>
	<button type = "button" class = "btn btn-info" style = "width:200px;"
	onclick = "location.href='samsung/list'">차량입고</button>
	
	<button type = "button" class = "btn btn-info" style = "width: 200px;"
	onclick = "location.href='member/list'">고객명단</button>
	<%-- <c:redirect url = "samsung/list" /> --%>
	
	<button type = "button" class = "btn btn-info" style = "width: 200px;"
	onclick = "location.href='sawon/list'">사원명단</button>
</body>
</html>