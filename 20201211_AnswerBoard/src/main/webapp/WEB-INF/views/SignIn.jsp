<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="contents">
		<form action="./login.do" method="post" class="formBox" onsubmit="retrun checkVal()" id="loginform">
			<div>로그인</div>
			<div>
				<input id="user_id" name="id" type="text" maxlength="20" required="required"><br> 
				<input class="login_pw" id="user_pwd" name="pw" type="password" maxlength="20" autocomplete="off"><br>
			</div>

			<div>
				<input type="button" id="loginBtn" name="로그인" value="로그인"> 
				<input type="button" id="ser" value="회원가입" onclick="signUp()">
			</div>
		</form>
	</div>


	<script type="text/javascript">
	window.onload = function(){
		document.getElementById("loginBtn").onclick =function(){
			let id = document.getElementsByName("id")[0];
			let pw = document.getElementsByName("pw")[0];
			if(id.value == "" || pw.value == ""){
				alert("아이디/비밀번호 입력 해주세요");
			}else{
				document.forms[0].submit();
			}
		}
	}

	function checkVal(){
		alert("onsubmit");
		return false;
	}
	
	
	function signUp(){
		location.href="./signUp.do";
	}
	
	</script>
</body>
</html>