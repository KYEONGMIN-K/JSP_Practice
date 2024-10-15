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
		String filename = (String)request.getAttribute("filename");
		out.println("업로드 된 파일명 : "+filename);
	%>
	<img src=<%=filename %>>
</body>
</html>