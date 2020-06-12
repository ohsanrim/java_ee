<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //쿠키
//특정 쿠키를 얻어오지 못하고 모든 쿠키 얻어오기
/*
Cookie[] ar = request.getCookies();
if(ar!=null){
	for(int i=0;i<ar.length;i++){
		if(ar[i].getName().equals("memName")){
			ar[i].setMaxAge(0);
			response.addCookie(ar[i]);
		} else if(ar[i].getName().equals("memId")){
			ar[i].setMaxAge(0);
			response.addCookie(ar[i]);
		}
	}
}
    */
    //세션
    session.removeAttribute("memName");
    session.removeAttribute("memId");
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
	location.href="index.jsp";
}
</script>
</html>