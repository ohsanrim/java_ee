<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>**메인화면**</h3>
<%if(session.getAttribute("memName")==null){ %>
<a href="http://localhost:8080/memberJSP/member/writeForm.jsp">회원가입</a>
<a href="../member/loginForm.jsp">로그인</a>
<%} else { %>
<a href="../member/modifyForm.jsp">회원정보수정</a>
<a href="../member/logout.jsp">로그아웃</a>
<a href="../board/boardWriteForm.jsp">글쓰기</a>
<%} %>
<a href="../board/boardList.jsp?pg=1">목록</a>
</body>
</html>