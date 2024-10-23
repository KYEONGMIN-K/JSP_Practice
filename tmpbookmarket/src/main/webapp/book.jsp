<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.BookRepository" %>
<%@ page import="dto.Book" %>
<%@ page errorPage="exceptionNoBookId.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<title>도서 정보</title>
</head>
<body>

	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서정보</h1>
				<p class="col-md-8 fs-4">BookInfo</p>
			</div>
		</div>
		
		<%
			String id = request.getParameter("id");
			BookRepository bookRepo = (BookRepository)request.getAttribute("bookrepo");
			Book book = bookRepo.getBookById(id);
		%>
		<div class="row align-item-md-stretch">
				<div class="col-md-5">
					<img src="./resources/images/<%=book.getFilename() %>" style="width:70%">
				</div>
			<div class="col-md-6">
					<h3><b><%= book.getName() %></b></h3>
					<p><%=book.getDescription() %></p>
					<p><b>도서 코드 : </b><span class="badge text-bg-danger"><%=book.getBookId() %></span></p>
					<p><b>저자</b> : <%=book.getAuthor() %></p>
					<p><b>출판사</b> : <%= book.getPublisher() %> : <%= book.getUnitPrice() %>원
					<p><b>출판일</b> : <%=book.getReleaseDate() %></p>
					<p><b>분류</b> : <%=book.getCategory() %></p>
					<p><b>재고 수</b> : <%=book.getUnitsInStock() %></p>
					<h4><%=book.getUnitPrice() %>원</h4>
					<form name="addForm" action="#">
						<p><a href="product_addCart?id=<%= book.getBookId()%>" class="btn btn-info" onclick="addToCart()">도서주문 &raquo;</a></p>
						<a href="product_cartview" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="products" class="btn btn-warning">도서 목록 &raquo;</a>
					</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
	<script src="./resources/js/validation.js"></script>
</body>
</html>