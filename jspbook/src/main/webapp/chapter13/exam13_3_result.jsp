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
		String name[] = (String[])session.getAttribute("name");
		String value[] = (String[])session.getAttribute("value");		
		for(int i=0; i<2; i++){
			out.println("설정된 세션의 속성 이름["+i+"] : "+name[i]+"<br>");		
			out.println("설정된 세션의 속성 값["+i+"] : "+value[i]+"<br>");
		}
	%>
</body>
</html>