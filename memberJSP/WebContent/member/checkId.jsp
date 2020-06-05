
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!boolean exist=false; %>
    <%
    String id = request.getParameter("id");
    MemberDAO memberDAO = MemberDAO.getInstance();
    exist=memberDAO.isExistId(id);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%if(exist) {%> <%=id %>는 사용불가능합니다.
<form name="checkId" method="post" action="checkId.jsp">
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="id"></td>
<td><input type="submit" value="검색"></td>
</tr>
</table>
</form>
<%} else {%> <%=id %>는 사용 가능합니다.
<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')">
<%} %>


</body>
<Script type="text/javascript"  src="http://localhost:8080/memberJSP/js/member.js?ver=1"> </Script>
</html>