<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="jstlWrite.jsp">
<table border="1">
<tr>
<td "width:100" align="center">이름</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td "width:100" align="center">아이디</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td "width:100" align="center">비밀번호</td>
<td><input type="password" name="pwd"></td>
</tr>

<tr colspan="2">
<td "width:100" align="center"><input type="submit" value="저장">
<input type="button" value="목록" onclick="location.href='jstlList.jsp'"><input type="reset" value="취소"></td>

</tr>
</table>
</form>

</body>
</html>