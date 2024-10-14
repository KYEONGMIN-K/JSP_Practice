<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>아이디 : <%=request.getAttribute("uid") %></p>
	<p>비밀번호 : <%=request.getAttribute("upw") %></p>
</body>
</html>