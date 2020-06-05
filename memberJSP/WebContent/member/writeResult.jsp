<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
    <%//데이터
    request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String repwd = request.getParameter("repwd");
	String gender = request.getParameter("gender");
	String email1=request.getParameter("email1");
	String email2=request.getParameter("email2");
	String tel1=request.getParameter("tel1");
	String tel2=request.getParameter("tel2");
	String tel3=request.getParameter("tel3");
	String zipcode=request.getParameter("zipcode");
	String addr1=request.getParameter("addr1");
	String addr2=request.getParameter("addr2");
	//응답
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(name);
	memberDTO.setId(id);
	memberDTO.setPwd(pwd);
	memberDTO.setRepwd(repwd);
	memberDTO.setGender(gender);
	memberDTO.setEmail1(email1);
	memberDTO.setEmail2(email2);
	memberDTO.setTel1(tel1);
	memberDTO.setTel2(tel2);
	memberDTO.setTel3(tel3);
	memberDTO.setZipcode(zipcode);
	memberDTO.setAddr1(addr1);
	memberDTO.setAddr2(addr2);
	
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