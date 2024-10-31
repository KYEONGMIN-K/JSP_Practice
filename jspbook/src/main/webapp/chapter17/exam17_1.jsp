<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	browser 변수 값 설정
	<c:set var="browser" value="${header ['User-Agent']}"></c:set>
	<br>
	<c:out value="${browser }"/>;
	<p>browser 변수 값 제거 후
		<c:remove var="browser"/>
		<c:out value="${browser }"/>
</body>
</html>