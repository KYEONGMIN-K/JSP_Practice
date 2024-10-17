<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="login_8_4" method="post">
		<p>아 이 디 : <input type="text" name="id"/>
		<p>비밀번호 : <input type="password" name="passwd" />
		<p><input type="button" value="전송" id="smt"/>
	</form>
	<script>
		//1. 셀렉트
		var sub = document.querySelector("#smt");
		var form = document.loginForm;
		//2. 이벤트 할당
		sub.addEventListener("click", checkLogin);
		//3. 기능구현
		function checkLogin(){
			for(i=0; i<form.id.value.lenght;i++){
				var ch = form.id.value.charAt(i);
					//97~122            //65~90            //48~57
				if((ch<'a'||ch>'z')&&(ch>'A'|| ch<'Z')&&(ch<'9'||ch>'0')){
					alert("아이디는 영문 소문자만 입력 가능합니다.");
					form.id.focus();
					return;
				}
			}
			
			if(isNaN(form.passwd.value)){
				alert("비밀번호는 숫자만 입력 가능합니다.");
				form.passwd.select();
				return;
			}
			console.log(form.id.value);
			console.log(form.passwd.value);
			
			form.submit();
		}
	</script>
</body>
</html>