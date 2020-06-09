<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String name=(String)request.getSession().getAttribute("name");
String id=(String)request.getSession().getAttribute("id");
String pwd=(String)request.getSession().getAttribute("pwd");
request.getSession().setAttribute("name", name);
request.getSession().setAttribute("id", id);
request.getSession().setAttribute("pwd", pwd);
%>
<img src="../image/iu.jpg" onclick="location.href='../exam/index.jsp'">
<%=name%> 님이 로그인 하셨습니다.
<input type="button" value="회원정보수정" onclick="location.href='modifyForm.jsp'">