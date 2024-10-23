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
		Cookie cookie_id = (Cookie)request.getAttribute("cid");
		Cookie cookie_pw = (Cookie)request.getAttribute("cpw");
	%>
	<p>쿠키가 생성되었습니다. <br>
	<%=cookie_id.getValue() %> : <%=cookie_pw.getValue() %>
</body>
</html>