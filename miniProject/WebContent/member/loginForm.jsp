<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<head>
<meta charset="UTF-8">
<title >로그인</title>
<script>
function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
</script>
</head>
<body>
<div border="1">

<form name="loginForm" method="post" action="../member/login.do">  
<table class="loginFormTable" >
      <tr>
         <td style="width:80px; height:30px;" align="center"><font color='red'>*</font>아이디</td>
         <td><input type="text" name='id' placeholder="아이디 입력"></td>
      </tr>
      <tr>
         <td style="width:80px; height:30px;" align="center"><font color='red'>*</font>비밀번호</td>
         <td><input type="password" name='pwd' id="pwd" placeholder="비밀번호 입력"></td>
      </tr>
      </table>
   <div style="margin-top:10px">
   	<input class="btn btn-outline-info" type="button" value="로그인" onclick="checkLogin()">
   	<input class="btn btn-outline-info" type="button" value="회원가입" onclick="location.href='../member/writeForm.do'">
   </div>
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
   
   
</form>
</div>
</body>

<script src="../js/member.js?ver=1"></script>

