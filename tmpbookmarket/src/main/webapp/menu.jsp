<%@ page session="false" %>
<%
	
	HttpSession session = request.getSession(false);
	String sessionId = null;
	if(session!=null){
		dto.Member mb = (dto.Member)session.getAttribute("member");
		if(mb != null){
			sessionId = mb.getId();
		}
	}
	
%>

<header class="d-flex pb-3 mb-4 border-bottom">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="./welcome.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<svg  width="32" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
		              <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
		              <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
		        </svg>
		        <span class="fs-4" >Home</span>
			</a>
			
			<ul class="nav nav-pills">
				    <% if(sessionId == null){ %>
						<li class="nav-item"><a class="nav-link" href="member_login">Login </a></li>
						<li class="nav-item"><a class="nav-link" href="member_add">Join</a></li>
					<%}else{ %>					
						<li style="padding-top: 7px;">[<%=sessionId%>] User</li>
						<li class="nav-item"><a href="product_cartview" class="nav-link">book Cart</a></li>
						<li class="nav-item"><a class="nav-link" href="member_logout">Logout </a></li>
						<li class="nav-item"><a class="nav-link" href="member_update">edit</a></li>
					<%}%>
				<!-- R: 전체상품 가져오기 -->
				<li class="nav-item"><a href="products" class="nav-link">bookList</a></li>
				<!-- C: 상품 입력 -->
				<li class="nav-item"><a href="productsadd" class="nav-link">book Add</a></li>
				<!-- U: 상품 수정 -->
				<li class="nav-item"><a href="productsedit" class="nav-link">book Edit</a></li>
				<!-- D: 상품 삭제 -->
				<li class ="nav-item"><a href = "BoardListAction?pageNum=1"class = "nav-link" />board</a></li>
			</ul>
		</div>
	</div>
</header>