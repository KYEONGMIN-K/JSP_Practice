<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int data = 50; %>
	<%
		out.println("Value of the variable is: "+ data);
	%>
	<p><a href="index.jsp">돌아가기</a></p>
</body>
</html>