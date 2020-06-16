<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <sql:query var="rs" dataSource="jdbc/oracle">
    	select * from usertable
    </sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>

<c:forEach var="colName" items="${rs.columnNames }"> <th width="100" align="center">${colName}</th></c:forEach>
<th width="100" align="center">비고</th>
</tr>
<c:forEach var="row" items="${rs.rowsByIndex}">
<tr>
<c:forEach var="col" items="${row }">

<td align="center" name=>

${col }</td>
</c:forEach>
<td><input type="button" value="수정" onclick="location.href='jstlModifyForm.jsp?id=${row[1]}'">
<input type="button" value="삭제" onclick="location.href='jstlDelete.jsp?id=${row[1]}'"></td>

</c:forEach>
</tr>
</table>

</body>
</html>