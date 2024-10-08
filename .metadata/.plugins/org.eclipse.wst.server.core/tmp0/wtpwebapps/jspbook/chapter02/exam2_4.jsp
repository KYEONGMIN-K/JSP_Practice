<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<%
		int a=2;
		int b=3;
		int sum = a+b;
		out.println("2+3 = "+ sum);
	%>
	<p><a href="index.jsp">돌아가기</a></p>
</body>
</html>