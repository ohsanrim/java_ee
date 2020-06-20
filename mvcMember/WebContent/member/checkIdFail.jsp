<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${requestScope.id} 아이디는 사용 불가능
<form name="checkId" method="post" action="checkId.do">
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="id"></td>
<td><input type="submit" value="검색"></td>
</tr>
</table>
</form>
</body>
<script src="http://localhost:8080/mvcMember/js/member.js?ver=1"></script>
</html>