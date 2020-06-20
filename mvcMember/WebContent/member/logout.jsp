<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //세션
    session.removeAttribute("memName");
    session.removeAttribute("memId");
    session.invalidate();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function(){
	alert("로그아웃");
	location.href="loginForm.do";
}
</script>
</html>