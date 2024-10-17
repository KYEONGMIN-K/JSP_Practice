<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginform" action="formlogin" method="post">
		<p>아 이 디 : <input type="text" name="id" id="id"/>
		<p>비밀번호 : <input type="password" name="passwd" id="pw">
		<p><input type="button" value="전송" id="smt">
	</form>
	<script>
		//1. 셀렉트
		var submit = document.querySelector("#smt");
		
		//2. 할당
		submit.addEventListener("click", checkLogin);
		//3. 구현
		function checkLogin(){
			var form = document.loginform;
			console.log(form.id.value);
			var id = document.querySelector("#id").value;
			var pw = document.querySelector("#pw").value;
			if(id==""){
				alert("아이디를 입력해주세요.");
				form.id.focus();
				return false;
			}else if(pw==""){
				alert("비밀번호를 입력해주세요.");
				form.pw.focus();
				return false;
			}
			form.submit();
		}
	</script>
</body>
</html>