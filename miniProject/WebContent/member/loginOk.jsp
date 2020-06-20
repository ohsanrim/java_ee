<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title >로그인</title>
</head>
<body>
<img src="../image/iu.jpg" onclick="location.href='index.jsp'"><br>
${memName } 님이 로그인 하셨습니다.<br>
<input type="button" value="로그아웃" onclick="location.href='/miniProject/member/logout.do'">
<input type="button" value="회원정보수정" onclick="location.href='/miniProject/member/modifyForm.do'">
</body>
</html>   