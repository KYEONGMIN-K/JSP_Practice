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
		String message= (String)request.getAttribute("msg");
				
		if(message.equals("데이터베이스 연결 성공!")){
			out.println(message);
		}else{
			String message2 = (String)request.getAttribute("msg2");
			out.println(message+"<br>"+message2);
		}
	%>
</body>
</html>