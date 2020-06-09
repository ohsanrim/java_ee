<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.LoginDTO"%>
<%@page import="member.dao.LoginDAO"%>
    <%//데이터
    String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
    %>
    <%//DB
    LoginDAO loginDAO = LoginDAO.getInstance();
    MemberDTO memberDTO = new MemberDTO(); 
    %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%
//String name = loginDAO.checkLogin(id,pwd);
memberDTO = loginDAO.checkLogin(id,pwd);
System.out.println(memberDTO.getName());
if(memberDTO==null||memberDTO.getName()==null) {
	response.sendRedirect("loginFail.jsp");
} else {
    request.getSession().setAttribute("name", memberDTO.getName());
    request.getSession().setAttribute("id", memberDTO.getId());
    request.getSession().setAttribute("pwd", memberDTO.getPwd());
  	response.sendRedirect("loginOk.jsp");%>
  		
	<form method="get" action="modifyForm.jsp?">
	<table>
	<tr>
    <td colspan="2" align="center"><input type="button" value="로그아웃" ><input type="submit" value="회원정보수정"> </td>
    </tr>
    </table>
    </form>
      
<%}%>

</body><script> </script>
<script>function writeForm(){ window.open('http://localhost:8080/memberJSP/member/writeForm.jsp'}</script>
</html>