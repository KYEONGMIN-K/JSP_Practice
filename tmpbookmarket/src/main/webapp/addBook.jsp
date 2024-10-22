<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<fmt:setLocale value='<%=request.getAttribute("language") %>'/>
<fmt:bundle basename="bundle.message">
	<!-- 제일 바깥 div -->
	<div class="container py-4">
		<%@ include file = "menu.jsp" %>
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold"><fmt:message key="title"/></h1>
				<p class="col-md-8 fs-4">BookList</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch">
			<div class="text-end">
				<a href="productsadd?language=ko">Korean</a> | <a href="productsadd?language=en">English</a>
				<a href="logout.jsp">logout</a>
			</div>
			<form name="newBook" action="product_add" method="post" class="form-horizontal" enctype="multipart/form-data">
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookId"/></label>
					<div class="col-sm-3">
						<input type="text" name="bookId" class="form-control" id="bookId">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="name"/></label>
					<div class="col-sm-3">
						<input type="text" name="name" class="form-control" id="name">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitPrice"/></label>
					<div class="col-sm-3">
						<input type="text" name="unitPrice" class="form-control" id="unitPrice">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="author"/></label>
					<div class="col-sm-3">
						<input type="text" name="author" class="form-control" >
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="publisher"/></label>
					<div class="col-sm-3">
						<input type="text" name="publisher" class="form-control" >
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="releaseDate"/></label>
					<div class="col-sm-3">
						<input type="text" name="releaseDate" class="form-control">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="description"/></label>
					<div class="col-sm-3">
						<textarea name="description" id="description" cols="50" rows="2" class="form-control" placeholder="100자 이상 적어주세요."></textarea>
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="category"/></label>
					<div class="col-sm-3">
						<input type="text" name="category" class="form-control">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitInStock"/></label>
					<div class="col-sm-3">
						<input type="text" id="unitsInStock" name="unitsInStock" class="form-control">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="condition"/></label>
					<div class="col-sm-3">
						<input type="radio" name="condition" value="New"> <fmt:message key="condition_New"/>
						<input type="radio" name="condition" value="Old"> <fmt:message key="condition_Old"/>
						<input type="radio" name="condition" value="EBook"> <fmt:message key="condition_Ebook"/>
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"> <fmt:message key="bookImage"/></label>
					<div class="col-sm-3">
						<input type="file" name="BookImage" class="form-control"> 
					</div>
				</div>
				<div class="mb-3 row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="button" class="btn btn-primary" value=" <fmt:message key="button"/>" id="addsubmit">
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="./resources/js/validation.js"></script>
</fmt:bundle>
</body>
</html>