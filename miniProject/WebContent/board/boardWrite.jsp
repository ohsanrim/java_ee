<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="borad.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>

	게시글이 등록되었습니다.
	<input type="button" value="메인화면" onclick="location.href='../main/index.do'">
	<input type="button" value="글 목록" onclick="checkListForm()">

</body>
<Script src="../js/board.js?ver=2"></Script>
