<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String value[]= new String[2];
		value[0] = (String)session.getAttribute("pw");
		value[1] = (String)session.getAttribute("id");
		
		Enumeration en = session.getAttributeNames();
		int i=0;
		while(en.hasMoreElements()){
			String tmp = (String)en.nextElement();	
			out.println("설정된 세션의 속성 이름["+(i+1)+"] : "+tmp+"<br>");
			//String tmp_v = (String)session.getAttribute(tmp);
			out.println("설정된 세션의 속성 값["+(i+1)+"] : "+value[i]+"<br>");
			i++;
		}
		
		session.removeAttribute("id");
	%>
	<p>===================id 삭제================<br>
	<%
		en = session.getAttributeNames();
		i=0;
		while(en.hasMoreElements()){
			String tmp = (String)en.nextElement();	
			out.println("설정된 세션의 속성 이름["+(i+1)+"] : "+tmp+"<br>");
			String tmp_v = (String)session.getAttribute(tmp);
			out.println("설정된 세션의 속성 값["+(i+1)+"] : "+tmp_v+"<br>");
			i++;
		}
		
		
	%>
</body>
</html>