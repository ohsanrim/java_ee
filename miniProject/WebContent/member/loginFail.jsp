<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title >로그인</title>
</head>
<body>
아이디를 다시한번 확인해주세요!
<input type="button" value="로그인" onclick="location.href='/miniProject/member/loginForm.do'">
<input type="submit" value="회원가입" onclick="location.href='/miniProject/member/writeForm.do'">
</body>
<script type="text/javascript">
window.onload=function(){
	alert("로그인이 실패하셨습니다.");
}
</script>
</html>