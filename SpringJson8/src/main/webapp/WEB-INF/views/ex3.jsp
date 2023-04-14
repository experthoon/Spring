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
	<input type="text" id="input-text">
	
	<div id="output"></div>

	<script>
		$(document).ready(function() {
			
			$("#input-text").keyup(function(key){
				var se = $(this).val();
				if(key.which === 13){
					
					$.ajax({
						type:"get",
						dataType:"json",
						url:"list3",
						success:function(res){
							
							var s = "";
							$.each(res,function(i,ele){
								if(ele.name === se)
								{
									s+= "이름: " + ele.name + "<br>";
									s+= "그림" + "<img src='resources/upload/" + ele.photo + "'><br>";
								}
							});
							$("#output").html(s);
						}
					   
					})
				}
			});
		});
	</script>
	
</body>
</html>