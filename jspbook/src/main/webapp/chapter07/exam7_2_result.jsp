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
		String name1 = (String)request.getAttribute("name1");
		String subject1 = (String)request.getAttribute("subject1");
		String name2 = (String)request.getAttribute("name2");
		String subject2 = (String)request.getAttribute("subject2");
		String name3 = (String)request.getAttribute("name3");
		String subject3 = (String)request.getAttribute("subject3");

		String filename3 = (String)request.getAttribute("filename3");
		String filename2 = (String)request.getAttribute("filename2");
		String filename1 = (String)request.getAttribute("filename1");
	%>
	<table border="1">
		<tr>
			<th width="100">이름</th>
			<th width="100">제목</th>
			<th width="100">파일</th> 
		</tr>
	<%
		out.println("<tr><td>"+ name1 + "</td>");
		out.println("<td>"+ subject1 + "</td>");
		out.println("<td>"+ filename1 + "</td></tr>\n");
		
		out.println("<tr><td>"+ name2 + "</td>");
		out.println("<td>"+ subject2 + "</td>");
		out.println("<td>"+ filename2 + "</td></tr>\n");
		
		out.println("<tr><td>"+ name3 + "</td>");
		out.println("<td>"+ subject3 + "</td>");
		out.println("<td>"+ filename3 + "</td></tr>\n");
	%>
	</table>
</body>
</html>