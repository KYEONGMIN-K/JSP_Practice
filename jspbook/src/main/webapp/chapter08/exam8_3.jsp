<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="login_8_3" method="post">
		<p>아 이 디 : <input type="text" name="id"/>
		<p>비밀번호 : <input type="password" name="passwd" />
		<p><input type="button" value="전송" id="smt"/>
	</form>
	<script>
		//1. 셀렉트
		var submit = document.querySelector("#smt");
		var form = document.loginForm;
		
		//2. 할당
		submit.addEventListener("click", checkLogin);
		
		//3. 구현
		console.log(submit.id);
		
		
		function checkLogin(){
		/*
		* Function name : checkLogin ()
		* Params : none 
		* Return : none
		* 이 함수는 사용자가 ID, PW를 입력하고 전송 버튼을 눌렀을 때 동작하며 먼저 ID가 숫자로 시작하는지 판별.
		* 숫자로 시작한다면 다시 입력을 요구하게 되고, 숫자가 아닌 문자로 시작하였을 경우 ID의 길이를 판별.
		* 길이는 4~12자 이내로 입력하였다면 PASS , 아니면 재입력을 요구.
		* 비밀번호는 숫자로만 이루어져 있는지를 판별하고 문자가 섞여 있을 경우 숫자만 입력할 것을 요구.
		* 숫자만 입력했을 때 다음으로 비밀번호의 길이가 최소 4자이상인지를 판별.
		* 4자 이상일 경우 PASS, 아니면 재입력을 요구
		*/
			if(!isNaN(form.id.value.substr(0,1))){	// ID의 시작이 숫자인지 판별
				alert("아이디는 숫자로 시작할 수 없습니다.")
				document.form.id.select();
			}else{									// ID의 시작이 숫자가 아닐경우
				if(form.id.value.length <4 || form.id.value.length> 12){ 	// ID의 길이가 4~12자 이내인지 판별
					alert("아이디는 4~12자 이내로 입력 가능합니다!");
					form.id.focus();
					return;
				}
			}
			
			if(isNaN(form.passwd.value)){
				alert("비밀번호는 숫자만 입력 가능합니다.");
				form.passwd.select();
			}else{
				if(form.passwd.value.length<4){
					alert("비밀번호는 4자 이상으로 입력해야 합니다.");
					form.passwd.focus();
					return;
				}
			}
			
			form.submit();
		}

	</script>
</body>
</html>