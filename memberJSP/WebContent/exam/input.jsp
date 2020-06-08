<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td{
border:1px solid gray;
}
</style>
</head>
<body>
<form method="get" action="sum.jsp">
<table>
<tr>
<td align="center" style="width:50px;">x</td>
<td><input type="text" name="x" style="width:100px;"></td>
</tr>
<tr>
<td align="center">y</td>
<td><input type="text" name="y" style="width:100px;"></td>
</tr>
<tr><td colspan="2" align="center"><input type="submit" value="합구하기" ><input type="reset" value="취소"></td></tr>
</table>
</form>
</body>
</html>