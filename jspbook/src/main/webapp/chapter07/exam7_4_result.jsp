<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("name");
		String value = (String)request.getAttribute("value");
		
		String filefieldname = (String)request.getAttribute("fileFieldName");
		String filename = (String)request.getAttribute("fileName");
		String type = (String)request.getAttribute("contentType");
		long file = (long)request.getAttribute("fileSize");
	%>
	<%
		out.println(name +" = "+ value + "<br>");	

		out.println("--------------------------------<br>");
		
		out.println("요청 파라미터 이름 : " + filefieldname + "<br>");
		out.println("저장 파일 이름 : " + filename + "<br>");
		out.println("파일 콘텐츠 유형 : " + type + "<br>");

		out.println("파일 크기 : "+file);

	%>
</body>
</html>