<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.test_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<test_dto> arr = (ArrayList<test_dto>)request.getAttribute("arr");
		
	%>
	<table border="1">
	<tr>
		<td>아이디</td>
		<td>패스워드</td>
		<td>이름</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<%	
		for(int i=0; i<arr.size();i++){
			test_dto dto = arr.get(i);
	%>
		<tr>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPw() %></td>
			<td><%=dto.getName() %></td>
			<td><a href="readone?id=<%=dto.getId() %>">수정</a></td>
			<td><a href="delete?id=<%=dto.getId() %>">삭제</a></td>
		</tr>
	<%		
		}
	%>
	</table>
</body>
</html>