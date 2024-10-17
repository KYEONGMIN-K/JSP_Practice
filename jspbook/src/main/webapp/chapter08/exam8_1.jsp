<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>validation</title>
</head>
<body>
	<form name="loginForm" action="#">
		<p>아 이 디 : <input type="text" name="id" id="id"/>
		<p>비밀번호 : <input type="password" name="psswd" id="pw">
		<p><input type="submit" value="전송" id="smt">
	</form>
	
<script type="text/javascript">
		//1. 선택 (어떤 요소를 선택할 것인가. 목적을 알아야한다.)
		var submit = document.querySelector("#smt");
		//2. 할당 (선택했다면 어떤 이벤트를 할당할 것인가.)
		submit.addEventListener("click", checkForm);
		//3. 기능구현 (할당하려는 이벤트에 맞는 함수를 구현.)
		/*
		* Function name : checkForm () 
		* Params : 없음
		* Return : 없음
		* - 사용자가 입력한 id와 pw를 가져와 alert() 함수로 입력된 내용을 출력하는 함수.
		*/
		function checkForm(){
			var id = document.querySelector("#id").value;
			var pwd = document.querySelector("#pw").value;
			
			alert("아이디 : "+ id +"\n비밀번호 : "+ pwd);
		}
</script>	
</body>
</html>