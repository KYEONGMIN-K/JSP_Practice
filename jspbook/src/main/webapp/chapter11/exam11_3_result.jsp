<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println(request.getAttribute("num1")+"/"+ request.getAttribute("num2")+"="+request.getAttribute("result"));
	%>
</body>
</html>