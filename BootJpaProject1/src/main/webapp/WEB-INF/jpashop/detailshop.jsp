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
	<h3>상세페이지</h3>
	
	<table class = "table table-bordered" style = "width:700px;">
		<caption><b>상품정보 목록</b></caption>
		<tr bgcolor="#ddd">
			<th width = "60">상품명</th>
			<th width = "100">가격</th>
			<th width = "120">입고일</th>
			<th width = "100">사진</th>
		</tr>
		<tr>
			<td>${dto.sangpum}</td>
			<td>${dto.price }</td>
			<td>${dto.ipgoday }</td>
			<td><img src = "/image/${dto.photo }"></td>
		
			<td>
				<button type = "button" class = "btn btn-success btn-xs" onclick = "location.href = 'updateform?num=${dto.num}'">수정</button>
				<button type = "button" class = "btn btn-danger btn-xs" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				<button type = "button" class = "btn btn-success btn-xs" onclick="location.href='list'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>