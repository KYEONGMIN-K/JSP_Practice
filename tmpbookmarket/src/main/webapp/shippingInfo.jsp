<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<div class="container py-4">
	<%@ include file="menu.jsp" %>
	<div class="p-5 mb-4 bg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">배송정보</h1>
			<p class="col-md-8 fs-4">Shipping Info</p>
		</div>
	</div>
	
	<div class="row align-items-md-stretch">
		<form action="product_shippingProcess" method="post">
			<input type="hidden" name="cartId" value='<%= request.getParameter("cartId") %>'>
			<!-- 성명 -->
			<div class="mb-3 row">
				<label class="col-sm-2">성명</label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control">
				</div>
			</div>
			<!-- 배송일 -->
			<div class="md-3 row">
				<label class="col-sm-2">배송일</label>
				<div class="col-sm-3">
					<input type="text" name="shippingDate" class="form-control">(yyyy/mm/dd)
				</div>
			</div>
			<!-- 국가명 -->
			<div class="md-3 row">
				<label class="col-sm-2">국가명</label>
				<div class="col-sm-3">
					<input type="text" name="country" class="form-control">
				</div>
			</div>
			<!-- 우편번호 -->
			<div class="md-3 row">
				<label class="col-sm-2">우편번호</label>
				<div class="col-sm-3">
					<input type="text" name="zipCode" class="form-control">
				</div>
			</div>
			<!-- 주소 -->
			<div class="mb-3 row">
				<label class="col-sm-2">주소</label>
				<div class="col-sm-5">
					<input type="text" name="addressName" class="form-control">
				</div>
			</div>
			
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10">
					<a href='product_cartview?cartId=<%= request.getParameter("cartId")%>' class="btn btn-secondary" role="button">이전</a>
					<input type="submit" class="btn btn-primary" value="등록"/>
					<a href="#" class="btn btn-secondary" role="button">취소</a> 
				</div>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>