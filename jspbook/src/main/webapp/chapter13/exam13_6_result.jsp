<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>설정된 세션 이름 id: <%=session.getAttribute("id") %><br>
	<p>설정된 세션 값 pw: <%=session.getAttribute("pw") %><br>
	<%
		if(request.isRequestedSessionIdValid()==true){
			out.println("세션이 유효합니다.<br>");
		}else{
			out.println("세션이 유효하지 않습니다.<br>");
		}
	
		session.invalidate();
	%>
	<p>============ 세션 삭제 후===========<br>
	<%
		if(request.isRequestedSessionIdValid()==true){
			out.println("세션이 유효합니다.");
		}else{
			out.println("세션이 유효하지 않습니다.");
		}
	%>
</body>
</html>