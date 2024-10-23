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
		Cookie cookies[] = (Cookie[])request.getAttribute("cookieArr");
		
		for(int i=0; i<cookies.length; i++){
			out.println("설정된 쿠키 속성 이름 ["+i+"] : "+cookies[i].getName()+"<br>");
			out.println("설정된 쿠키 속성 값 ["+i+"] : "+cookies[i].getValue()+"<br>");
			out.println("========================================<br>");
		}
	%>
</body>
</html>