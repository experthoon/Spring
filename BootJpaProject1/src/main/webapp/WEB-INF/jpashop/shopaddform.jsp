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
	<form action="insert" method = "post">
		<table class = "table table-bordered" style = "width:300px;">
		<caption><b>쇼핑몰 상품 정보 입력</b></caption>
			<tr>
				<th width = "100">상품명</th>
					<td>
						<input type = "text" name = "sangpum" class = "form-control" required="required">
					</td>
			</tr>
			
			<tr>
				<th width = "100">단가</th>
					<td>
						<input type = "text" name = "price" class = "form-control" required="required">
					</td>
			</tr>
			
			<tr>
				<th width = "100" >사진</th>
					<td>
						<select name = "photo" required="required">
							<option value = "1.jpg">사진1</option>
							<option value = "2.jpg">사진2</option>
							<option value = "3.jpg">사진3</option>
							<option value = "4.jpg">사진4</option>
							<option value = "5.jpg">사진5</option>
						</select>
					</td>
			</tr>
			
			<tr>
				<th width = "100">입고날짜</th>
					<td>
						<input type = "date" name = "ipgoday" class = "form-control" value = "2023-04-10" required="required">
					</td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center">
					<button type = "submit" class = "btn btn-success">서버에 전송</button>	
					<button type = "button" class = "btn btn-success" onclick="location.href='list'">목록</button>			
				</td>
			</tr>
		</table>
	</form>
</body>
</html>