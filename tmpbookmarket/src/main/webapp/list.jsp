<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.Board"%>
<%@ page import="dto.Member"%>
<%@ page session="false" %>
<%@ page import="java.time.*"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
	
	//List boardList = (List) request.getAttribute("boardlist");	
	int index =1;	//출력 개수 카운트
	int limit = (int)request.getAttribute("limit");
	String sessionId = null;
	String sessionName = null;
	int total_page = ((Integer) request.getAttribute("total_page")).intValue();
	int total_record = ((Integer) request.getAttribute("total_record")).intValue();
	int pageNum = ((Integer) request.getAttribute("pageNum")).intValue();
	ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("arr");
	
	HttpSession session = request.getSession(false);
	if(session != null){
		System.out.println("세션이 존재합니다.");
		Member mb = (Member)session.getAttribute("member");
		if(mb != null){
			System.out.println("mb가 존재합니다. : "+mb.getId());
			sessionId = mb.getId();
			sessionName = mb.getName();
		}
	}else{
		System.out.println("세션이 존재하지 않습니다.");
	}
%>
<html>
<head>
<link rel="stylesheet" href="/tmpbookmarket/resources/css/bootstrap.min.css" />
<title>Board</title>
<script type="text/javascript">
	function checkForm() {	
		
		if (<%= sessionId==null %>) {	// EL은 변수의 연산결과를 출력할 수 있다.
			alert("로그인 해주세요.");
			document.submit();
		}

		location.href = "BoardWriteForm?id=<%=sessionId%>"
	}
</script>
</head>
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
		<form action="/BoardListAction" method="post">
				<div class="text-end"> 
					<span class="badge text-bg-success">전체 <%=total_record%>건	</span>
				</div>		
			<div style="padding-top: 20px">
				<table class="table table-hover text-center" >
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>조회</th>
						<th>글쓴이</th>
					</tr>
					<%
					
						for (int j = 0; j < boardList.size() ; j++,index++){
							
							// 1페이지가 아니고 j:반복횟수가 처음일 때 
							if(pageNum!=1 && j==0){				//2
								j= j+(limit*(pageNum-1));		//j==5
							}
							//페이지 출력 limit개 제한
							if(index>limit){
								System.out.println("index 멈춰 : " + index);
								index=1;
								break;
							}
						//	System.out.println("j : "+j+" | pageNum : "+pageNum+" | index : "+index);
						//	System.out.println("size : "+boardList.size());
							Board notice = (Board)boardList.get(j);

					%>
					<tr>
						<td><%=notice.getNum()%></td>
						<td><a style="text-decoration-line:none" href="BoardViewAction?num=<%=notice.getNum()%>&pageNum=<%=pageNum%>"><%=notice.getSubject()%></a></td>
						<td><%
							//LocalDateTime tm = notice.getRegist_day().toLocalDateTime();
							//String tm2 = tm.format(DateTimeFormatter.ofPattern("MM-dd"));
							String tt = DateTimeFormatter.ofPattern("MM-dd").format(notice.getRegist_day().toLocalDateTime());
							out.println(tt);
						%></td>
						<td><%=notice.getHit()%></td>
						<td><%=notice.getName()%></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div align="center">
				<%for(int i=1; i<=total_page; i++){%>				
						<a style="text-decoration-line:none" href="BoardListAction?pageNum=<%=i%>"/>
						<%if(pageNum==i){%>		<!-- pageNum : 현재 페이지 -->
							<font color='4C5317'><b> [<%=i%>]</b></font>
						<%}else{%>
							<font color='4C5317'> [<%=i%>]</font>
						<%}%>
				<%}%>				
			</div>
			
			<div class="py-3" align="right">							
				<a href="#" onclick="checkForm(); return false;" class="btn btn-primary">&laquo;글쓰기</a>				
			</div>			
			<div align="left">				
				<select name="items" class="txt">
					<option value="subject">제목에서</option>
					<option value="content">본문에서</option>
					<option value="name">글쓴이에서</option>
				</select> <input name="text" type="text" /> <input type="submit" id="btnAdd" class="btn btn-primary " value="검색 " />				
			</div>
			
		</form>			
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>





