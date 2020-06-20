<%@page import="board.dao.BoardDAO"%>
<%@page import="borad.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1개의 글이 수정되었습니다!
	<input type="button" value="글목록" onclick="location.href='boardList.do?pg=${param.pg}'">

</body>
</html>