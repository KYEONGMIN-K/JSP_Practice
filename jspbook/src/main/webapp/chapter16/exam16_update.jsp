<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.test_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		test_dto dto = (test_dto)request.getAttribute("dto");
	%>
	<form action="update" method="post">
		<p> 아이디 : <input type="text" name="id" value="<%=dto.getId()%>" readonly/>
		<p> 패스워드 : <input type="text" name="pw" value="<%=dto.getPw()%>"/>
		<p> 이름 : <input type="text" name="name" value="<%=dto.getName()%>"/>
		<p> <input type="submit" value="수정"/>
	</form>
</body>
</html>