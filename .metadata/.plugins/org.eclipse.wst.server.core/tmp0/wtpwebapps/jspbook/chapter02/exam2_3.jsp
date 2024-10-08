<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<%! String makeItLower(String data){
		return data.toLowerCase();
	}
	
	%>
	
	<%
		out.println(makeItLower("Hello world!"));
	%>
	<p><a href="index.jsp">돌아가기</a></p>
</body>
</html>