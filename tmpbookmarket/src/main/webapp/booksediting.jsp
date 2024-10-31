<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	System.out.println(logTime.timeReturn.getTime() +" #v_editing booksediting.jsp View 이동 완료");
	Book book = (Book)request.getAttribute("book");
%>

 <!--
<fmt:setLocale value='<%=request.getAttribute("language") %>'/>
-->
<fmt:bundle basename="bundle.message">
 
	<!-- 제일 바깥 div -->
	<div class="container py-4">
		<%@ include file = "menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서 수정</h1>
				<p class="col-md-8 fs-4">BookEditing</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch">
			<div class="col-md-5">
				<img src="./resources/images/<%=book.getFilename() %>" alt="image" style="width:100%">
			</div>
			<div class="col-md-7">
				<form name="newBook" action="product_update" method="post" class="form-horizontal" enctype="multipart/form-data">
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="bookId"/></label>
						<div class="col-sm-5">
							<input type="text" name="bookId" class="form-control" id="bookId" value="<%= book.getBookId()%>" readonly>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="name"/></label>
						<div class="col-sm-5">
							<input type="text" name="name" class="form-control" id="name" value="<%= book.getName() %>">
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="unitPrice"/></label>
						<div class="col-sm-5">
							<input type="text" name="unitPrice" class="form-control" id="unitPrice" value="<%= book.getUnitPrice()%>">
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="author"/></label>
						<div class="col-sm-5">
							<input type="text" name="author" class="form-control" value="<%= book.getAuthor()%>">
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="publisher"/></label>
						<div class="col-sm-5">
							<input type="text" name="publisher" class="form-control"  value="<%= book.getPublisher()%>">
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="releaseDate"/></label>
						<div class="col-sm-5">
							<input type="text" name="releaseDate" class="form-control" value="<%= book.getReleaseDate()%>">
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="description"/></label>
						<div class="col-sm-8">
							<textarea name="description" id="description" cols="50" rows="2" class="form-control" ><%= book.getDescription()%></textarea>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="category"/></label>
						<div class="col-sm-5">
							<input type="text" name="category" class="form-control" value="<%= book.getCategory()%>">
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="unitInStock"/></label>
						<div class="col-sm-5">
							<input type="text" id="unitsInStock" name="unitsInStock" class="form-control" value="<%= book.getUnitsInStock()%>">
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"><fmt:message key="condition"/></label>
						<div class="col-sm-8">
							<% String status = book.getCondition();%> 
							
							<input type="radio" name="condition" value="new" <%if(status.equals("new")){out.println("checked");} %>> <fmt:message key="condition_New"/>
							<input type="radio" name="condition" value="old" <%if(status.equals("old")){out.println("checked");} %>> <fmt:message key="condition_Old"/>
							<input type="radio" name="condition" value="eBook" <%if(status.equals("eBook")){out.println("checked");} %>> <fmt:message key="condition_Ebook"/>
							
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2"> <fmt:message key="bookImage"/></label>
						<div class="col-sm-8">
							<input type="file" name="BookImage" class="form-control"> 
						</div>
					</div>
					<div class="mb-3 row">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" class="btn btn-primary" value="수정" id="addsubmit" <fmt:message key="button"/>>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	

<script type="text/javascript" src="/tmpbookmarket/resources/js/validation.js"></script>
</fmt:bundle> 


</body>
</html>