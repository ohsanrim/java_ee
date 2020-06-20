<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title >로그인</title>
<style>
   table {
   Font-Family: 맑은 고딕;
   }
   tr, td{
      height:30px;
   }
  </style>
</head>
<body>
<div border="1">
<form name="loginForm" method="post" action="../member/login.do">  
<table border="1" >
      <tr>
         <td style="width:80px; height:30px;" align="center"><font color='red'>*</font>아이디</td>
         <td><input type="text" name='id' placeholder="아이디 입력"></td>
      </tr>
      <tr>
         <td style="width:80px; height:30px;" align="center"><font color='red'>*</font>비밀번호</td>
         <td><input type="password" name='pwd' id="pwd" placeholder="비밀번호 입력"></td>
      </tr>
      <tr>
         <td colspan="2" align="center"><input type="button" value="로그인" onclick="checkLogin()">
   <input type="button" value="회원가입" onclick="location.href='writeForm.do'"></td>
      </tr>
   </table>
</form>
</div>
</body>

<script src="../js/member.js?ver=1"></script>

</html>