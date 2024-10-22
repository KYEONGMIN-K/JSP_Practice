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
		String msg = (String)request.getAttribute("msg");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
	%>
	<p> <%= msg %>
	<p> 입력된 id 값 : <%= id %>
	<p> 입력된 pw 값 : <%= passwd %>
</body>
</html>