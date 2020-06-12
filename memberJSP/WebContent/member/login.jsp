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
	
	//쿠키 생성
	//Cookie cookie = new Cookie("memName", memberDTO.getName());
    //cookie.setMaxAge(30*60); 
	//response.addCookie(cookie);//클라이언트에게 보내기
	//Cookie cookie2 = new Cookie("memId", memberDTO.getId());
	//cookie2.setMaxAge(30*60); 
	//response.addCookie(cookie2);//클라이언트에게 보내기
	////Cookie cookie3 = new Cookie("memPwd", memberDTO.getPwd());
	//cookie3.setMaxAge(30*60); 
	//response.addCookie(cookie3);//클라이언트에게 보내기
	//세션 생성
	session.setAttribute("memName",memberDTO.getName());
	session.setAttribute("memId",memberDTO.getId());
	session.setAttribute("memPwd",memberDTO.getPwd());
	session.setAttribute("memEmail1",memberDTO.getEmail1());
	session.setAttribute("memEmail2",memberDTO.getEmail2());
	//페이지 이동
  	//request.getSession().setAttribute("name", memberDTO.getName());
  	//request.getSession().setAttribute("id", memberDTO.getId());
  	//request.getSession().setAttribute("pwd", memberDTO.getPwd());
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
<script>function writeForm(){ window.open('http://localhost:8080/memberJSP/member/writeForm.jsp'); }</script>
</html>