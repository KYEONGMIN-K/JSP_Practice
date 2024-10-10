<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="date" class="java.util.Date"/>
	<p>
		<%
			out.println("오늘의 날짜 및 시각 ");
		%>	
	</p>
	<p><%= date %></p>
</body>
</html>