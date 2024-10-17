<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>입력 성공 !</p>
	<p> 아이디: <%= request.getAttribute("id") %>
	<p> 패스워드: <%= request.getAttribute("pw") %>
</body>
</html>