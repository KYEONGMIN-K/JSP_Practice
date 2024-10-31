<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>    
<%
	//get은 return이 반드시 있다. return을 받을 변수를 준비해야한다.
	//request에 set()으로 넣을때는 데이터 타입이 unknown으로 바뀌게 됨. 그래서 casting을 해줘야한다
	//BookRepository dao = BookRepository.getRepository();
	System.out.println(logTime.timeReturn.getTime() +" #v_edit booksedit.jsp View 이동 완료");	

	ArrayList<Book> listOfBooks = (ArrayList<Book>)request.getAttribute("arr");
		
%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/tmpbookmarket/resources/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>도서목록</title>
</head>
<body>
	<!-- 가장 바깥 div -->
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서편집</h1>
				<p class="col-md-8 fs-4">BookEditing</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch text-center">
			<!-- for문으로 만드는 것이 많음. 게시판, 목록 등 -->
			<!-- for()문 영역 START -->
			<%
				for(int i=0; i<listOfBooks.size(); i++){
					//out.println(listOfBooks.size());
					Book book = listOfBooks.get(i);
			%>
				<div class="col-md-4">
					<div class="h-100 p-2">
						<img src="./resources/images/<%= book.getFilename() %>" style="width:250; height:350">
						<h5><b><%= book.getName() %></b></h5>
						<p><%=book.getAuthor() %></p>
						<br><%= book.getPublisher() %> : <%= book.getUnitPrice() %>원
						<p><%=book.getDescription() %></p>
						<p><%=book.getUnitPrice() %>원</p>
						<a href="productsedit_select?edit=update&id=<%=book.getBookId()%>" class="btn btn-secondary" role="button">수정 &raquo;</a>
						<a href="#" onclick="deleteConfirm('<%=book.getBookId()%>')" class="btn btn-secondary" role="button">삭제 &raquo;</a>
						   <!--
						    <p><a href="productsedit_select?edit=update&id=<%=book.getBookId()%>" class="btn btn-secondary" role="button">수정 &raquo;</a>
						   <a href="productsedit_select?edit=delete&id=<%=book.getBookId()%>" class="btn btn-secondary" role="button">삭제 &raquo;</a></p>
						    -->
					</div>
				</div>
			<%
				}
			%>
			<!-- for()문 영역 END -->
		</div>
		<%@ include file="footer.jsp" %>	
			
	</div>
	<script type="text/javascript" src="/tmpbookmarket/resources/js/validation.js"></script>
</body>
</html>