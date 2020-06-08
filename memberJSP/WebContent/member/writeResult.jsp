<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO" scope="session"/>
<jsp:setProperty name="memberDTO" property="*"/>
    <%//데이터
    request.setCharacterEncoding("UTF-8");
	
	MemberDAO memberDAO = MemberDAO.getInstance();
	int su = memberDAO.writeMember(memberDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(su==1) { %>
	회원가입 성공
	<input type='button' value='로그인' onclick='checkLoginForm()'>
<%} else { %>
	회원가입 실패
<% }%>
</body>
<script>function checkLoginForm(){ window.open('http://localhost:8080/memberJSP/member/loginForm.jsp')}</script>
</html>