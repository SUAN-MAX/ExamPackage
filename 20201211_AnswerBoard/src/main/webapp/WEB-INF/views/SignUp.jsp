<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUpPage</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$('#idchk').keyup(function() {
		var idLength = $(this).val().length;
		var id = '';
		id = $(this).val();
		if(id.indexOf(" ") != -1) {
			$('#result').css("color", "red");
			$('#result').html('공백이 포함된 아이디를 사용하실 수 없습니다.<br>');
			$('#chkval').val('0');
		} else if(idLength <= 4 && idLength >= 20) {
			$('#result').css("color", "red");
			$('#result').html('아이디는 4~20자리만 입력해주세요<br>');
			$('#chkval').val('0');
		} else if(idLength > 4) {
			// Ajax 처리
			jQuery.ajax({
				type: "post",
				url: "./idCheck.do",
				data: "id="+$(this).val(),
				async: true,
				success: function(msg) {
					if (msg.isc == 'true') {
						$('#chkval').val('0');
						$('#result').html('사용 불가능한 아이디 입니다.<br>');
						$('#result').css('color', 'red');
						$('#btn001').attr('disabled', true);
					} else {
						$('#chkval').val('1');
						$('#result').html('사용 가능한 아이디 입니다.<br>');
						$('#result').css('color', 'green');
						$('#btn001').attr('disabled', false);
					} 
				},
				error: function() {
					alert("에러발생");
				}
			});
		} else {
			$('#result').css('color', 'red');
			$('#result').html('5자리 이상만 사용 가능합니다.');
			$('#chkval').val('0');
		}
	});
});
		
	function checkForm(){
		var namechk = document.getElementById("namechk").value;
		var idchk = document.getElementById("idchk").value;
		var pwchk1 = document.getElementById("pwchk1").value;
		var pwchk2 = document.getElementById("pwchk2").value;
		
		if(namechk == "" || idchk == "" || pwchk1 != pwchk2){
			alert("이름이 공백이거나 id가 null이거나 pw가 다릅니다");
		}else{
			alert("회원가입 성공");
			var form = document.forms[0];
			form.action = "./SignUpResult.do";
			form.method = "post";
			form.submit();
		}
	}
	
</script>
<body>
	<form>
		<input type="hidden" id="chkval" value="1">
		<input type="text" id="namechk" name="name" placeholder="이름"/><br>
		<input type="text" id="idchk" name="id" placeholder="아이디"/>
		<br>
		<span id="result"></span>
		<input type="text" id="pwchk1" name="pw" placeholder="비밀번호"/><br>
		<input type="text" id="pwchk2" name="pw2" placeholder="비밀번호 확인 "/><br>
		<input type = "button" id="btn001" onclick="checkForm()" value="회원가입">
	</form>
	
</body>
</html>