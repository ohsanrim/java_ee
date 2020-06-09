<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String apple=(String)request.getAttribute("apple");
%>
아이디를 다시한번 확인해주세요!
<input type="button" value="로그인" onclick="location.href='loginForm.jsp'"><input type="submit" value="회원가입" onclick="location.href='writeForm.jsp'">