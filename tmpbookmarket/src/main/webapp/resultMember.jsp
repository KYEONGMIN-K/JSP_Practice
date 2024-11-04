<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Member" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="/tmpbookmarket/resources/css/bootstrap.min.css" />
<title>회원 정보</title>
</head>
<body>

<div class="container py-4">
   <jsp:include page="/menu.jsp" />

 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
      <%
			String msg = request.getParameter("msg");
      		if (msg.equals("0")||msg.equals("2")){
      %>
        <h1 class="display-5 fw-bold">회원 정보</h1>
        <p class="col-md-8 fs-4">Membership Info</p>    
        <% }
      		else if (msg.equals("1")){
        %>  
         <h1 class="display-5 fw-bold">회원 가입</h1>
        <p class="col-md-8 fs-4">Membership Joining</p>    
         <% }%>
      </div>
    </div>
	

	 <div class="row align-items-md-stretch   text-center">
		<%
			

			if (msg != null) {
				if (msg.equals("0"))
					out.println(" <h2 class='alert alert-danger'>회원정보가 수정되었습니다.</h2>");
				else if (msg.equals("1"))
					out.println(" <h2 class='alert alert-danger'>회원가입을 축하드립니다.</h2>");
				else if (msg.equals("2")) {
					HttpSession session = request.getSession();
					session = request.getSession(false);
					Member mb = (Member)session.getAttribute("member");
					System.out.println(mb.getName());
					out.println(" <h2 class='alert alert-danger'>" + mb.getName() + "님 환영합니다</h2>");
				}				
			} else {
				out.println("<h2 class='alert alert-danger'>회원정보가 삭제되었습니다.</h2>");
			}
		%>
	</div>	
</div>	
</body>
</html>