<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.LoginDTO"%>
<%@page import="member.dao.LoginDAO"%>
    <%//데이터
    String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	MemberDTO memberDTO = new MemberDTO();
    %>
    <%//DB
    LoginDAO loginDAO = LoginDAO.getInstance();
    
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
if(memberDTO==null||memberDTO.getName()==null) {
	out.println("로그인에 실패하셨습니다.");
	out.println("<input type='button' value='회원가입' onclick='writeForm()'>");
} else {
	out.println(memberDTO.getName()+"님이 로그인 하셨습니다.");%>
	<form method="get" action="modifyForm.jsp?">
	<input type="hidden" name="name" value="<%=memberDTO.getName()%>">
	<input type="hidden" name="id" value="<%=memberDTO.getId()%>">
	<input type="hidden" name="gender" value="<%=memberDTO.getGender()%>">
	<input type="hidden" name="email1" value="<%=memberDTO.getEmail1()%>">
	<input type="hidden" name="email2" value="<%=memberDTO.getEmail2()%>">
	<input type="hidden" name="tel1" value="<%=memberDTO.getTel1()%>">
	<input type="hidden" name="tel2" value="<%=memberDTO.getTel2()%>">
	<input type="hidden" name="tel3" value="<%=memberDTO.getTel3()%>">
	<input type="hidden" name="zipcode" value="<%=memberDTO.getZipcode()%>">
	<input type="hidden" name="addr1" value="<%=memberDTO.getAddr1()%>">
	<input type="hidden" name="addr2" value="<%=memberDTO.getAddr2()%>">
	
	<table>
	<tr>
         <td colspan="2" align="center"><input type="button" value="로그아웃" onclick="">
   <input type="submit" value="회원정보수정"></td>
      </tr></table></form>
      
<%}%>

</body><script> </script>
<script>function writeForm(){ window.open('http://localhost:8080/memberJSP/member/writeForm.jsp'}</script>
</html>