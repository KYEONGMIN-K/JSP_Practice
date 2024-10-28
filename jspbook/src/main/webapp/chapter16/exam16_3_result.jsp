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
		
		String message= (String)request.getAttribute("msg");
				
		if(message.equals("DB 데이터 삽입 성공!")){
			out.println(message+"<br>");
			for(int i=0; i<arr.size();i++){
				test_dto dto = arr.get(i);
				out.println("id : "+ dto.getId()+"<br>");
				out.println("pw : "+ dto.getPw()+"<br>");
				out.println("name : "+ dto.getName()+"<br>");
			}
		}else{
			String message2 = (String)request.getAttribute("msg2");
			out.println(message+"<br>"+message2);
		}
	%>
</body>
</html>