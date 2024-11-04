<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<%@ page import="dto.*" %>
<%
	HttpSession session = request.getSession(false);
	if(session ==null){
		System.out.println("writeForm : 세션 없음");
	}
	
	Member mb = (Member)session.getAttribute("member");
	String name = mb.getName();
%>
<html>
<head>
<link rel="stylesheet" href="/tmpbookmarket/resources/css/bootstrap.min.css" />
<title>Board</title>
</head>
<script type="text/javascript">
	function checkForm() {
		if (!document.newWrite.name.value) {
			alert("성명을 입력하세요.");
			return false;
		}
		if (!document.newWrite.subject.value) {
			alert("제목을 입력하세요.");
			return false;
		}
		if (!document.newWrite.content.value) {
			alert("내용을 입력하세요.");
			return false;
		}		
	}
</script>
<body>
<div class="container py-4">
	<jsp:include page="menu.jsp" />
	
	 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">게시판</h1>
        <p class="col-md-8 fs-4">Board</p>      
      </div>
    </div>

	<div class="row align-items-md-stretch   text-center">	 	

		<form name="newWrite" action="BoardWriteForm"  method="post" onsubmit="return checkForm()">
			<input name="id" type="hidden" class="form-control"
				value="${sessionId}">
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >성명</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" value="<%=name %>"		placeholder="name">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">

					<input name="subject" type="text" class="form-control"	placeholder="subject">
				</div>
			</div>
		<div class="mb-3 row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8">
					<textarea name="content" cols="50" rows="5" class="form-control"placeholder="content"></textarea>
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10 ">
				 <input type="submit" class="btn btn-primary " value="등록 ">				
				<input type="reset" class="btn btn-primary " value="취소 ">
				</div>
			</div>
		</form>
		
	</div>
	<jsp:include page="footer.jsp" />
	</div>
</body>
</html>



