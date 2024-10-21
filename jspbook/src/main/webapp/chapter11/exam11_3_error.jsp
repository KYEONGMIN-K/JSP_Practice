<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> 오류 발생
	<p> 예외 : <%=request.getAttribute("toStr") %>
	<p> toString() : <%=request.getAttribute("toStr") %>
	<p> getClass() : <%=request.getAttribute("clas") %>
	<p> getMessage() : <%=request.getAttribute("msg") %>
</body>
</html>