<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복체크</title>
</head>
<body>
	<div>
		<form action="./IdChk.do" method="post"> 
<!-- 		 -->
			<table>
				<tr>
					<td>
						아이디는 4-15자리 영문으로 시작해야 합니다.
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" id="id" name="id" placeholder="사용 아이디 입력">
						<input type="submit" value="중복 확인">
						<input type="button" value="사용" onclick="useId()" style="display:none;">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<script type="text/javascript">
		var val = document.getElementById("id").value;
		if(val !=""){
			var doc= document.querySelectorAll("input[type=button]")[0];
			doc.style.display ="block";
		}
		

	</script>
</body>
</html>