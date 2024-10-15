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
		String namet[] = (String[])request.getAttribute("namet");
		String value[] = (String[])request.getAttribute("value");
		
		String namef = (String)request.getAttribute("namef");
		String filename = (String)request.getAttribute("filename");
		String original = (String)request.getAttribute("original");
		String type = (String)request.getAttribute("type");
		File file = (File)request.getAttribute("file");
	%>
	<%
	for(int i=0; i<namet.length; i++){
		out.println(namet[i] +" = "+ value[i] + "<br>");	
	}

		out.println("--------------------------------<br>");
		
		out.println("요청 파라미터 이름 : " + namef + "<br>");
		out.println("실제 파일 이름 : " + filename + "<br>");
		out.println("저장 파일 이름 : " + original + "<br>");
		out.println("파일 콘텐츠 유형 : " + type + "<br>");
			
		if(file != null){
			out.println("파일 크기 : "+file.length());
			out.println("<br>");
		}
	%>
</body>
</html>