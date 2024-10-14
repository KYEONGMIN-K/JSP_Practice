<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>아이디 : <%=request.getAttribute("id") %></p>
	<p>비밀번호 : <%=request.getAttribute("passwd") %>
	<p>이름 : <%=request.getAttribute("name") %>
	<p>연락처 : <%
		out.println(request.getAttribute("phoneNum1")+"-"+request.getAttribute("phoneNum2")+"-"+request.getAttribute("phoneNum3"));
	%>
	<p>성별 : <%=request.getAttribute("gender") %>
	<p>취미 : 
	
	<%
		String tmp[] = (String[])request.getParameterValues("hobby");
		for(int i=0; i<tmp.length; i++){
			if(tmp[i]!=null){
				//System.out.println(tmp[i]);
				out.println(" " + tmp[i]);
			}else{
				break;
			}
		}
	%> 
	<p>가입인사 : <%=request.getAttribute("comment") %>
</body>
</html>