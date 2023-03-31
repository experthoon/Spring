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
	<h2>resource 폴더안의 이미지 출력</h2>
	<img alt="" src="../../res/2.jpg" width="200">
	<img alt="" src="../../res/image1/1.jpg" width="200">
	
	<h2>WEB-INF/image 폴더안의 이미지 출력</h2>
	<img alt="" src="../../image/3.jpg" width = "200">
	<img alt="" src="../../image/shop/4.jpg" width = "200">
</body>
</html>