<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.*" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Locale locale = request.getLocale();
		Date currentDate = new Date();
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		NumberFormat numberformat = NumberFormat.getNumberInstance(locale);
	%>
	<h3> 현재 로케일의 국가, 날짜, 통화</h3>
	<p>국 가 : <%= locale.getDisplayCountry() %></p>
	<p>날 짜 : <%= dateformat.format(currentDate) %></p>
	<p>숫 자 : <%= numberformat.format(12345.67) %></p>
</body>
</html>