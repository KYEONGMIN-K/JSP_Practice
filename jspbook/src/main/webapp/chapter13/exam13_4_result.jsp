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
		String name = (String)session.getAttribute("name");
		String value = (String)session.getAttribute("value");		
	%>
		<p> 설정된 세션 이름 userid : <%=name %> <br>
		<p> 설정된 세션 값 userpw : <%=value %> <br>	
	<%	
		session.removeAttribute("name");
	%>
	<p>-----------세션 삭제 후-----------
	<% 
		String name2 = (String)session.getAttribute("name");
	    String value2 = (String)session.getAttribute("value");			
	%>
		<p> 설정된 세션 이름 userid : <%=name2 %> <br>
		<p> 설정된 세션 값 userpw : <%=value2 %> <br>	
	<%	
	%>
</body>
</html>