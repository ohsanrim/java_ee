<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%//데이터 받기
    request.setCharacterEncoding("UTF-8");
    String subject = request.getParameter("subject");
	String content = request.getParameter("content"); 
	String id=(String)session.getAttribute("memId");
	String name=(String)session.getAttribute("memName");
	String email=(String)session.getAttribute("memEmail")+"@"+(String)session.getAttribute("memEmail2");
	
	Map<String, String>map = new HashMap<String,String>();
	map.put("id",id);
	map.put("name",name);
	map.put("email",email);
	map.put("subject",subject);
	map.put("content",content);
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setSeq(boardDAO.seq());
	boardDTO.setId(id);
	boardDTO.setName(name);
	boardDTO.setEmail(email);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	boardDTO.setLev(0);
	boardDTO.setStep(0);
	boardDTO.setPseq(0);
	boardDTO.setReply(0);
	boardDTO.setHit(0);
	//데이터 전송
	int su = boardDAO.insertBoard(boardDTO);
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(su==0){%>
	게시글이 등록되지 않았습니다.
<%} else { %>
	게시글이 등록되었습니다.
	<input type="button" value="메인화면" onclick="location.href='../member/index.jsp'">
	<input type="button" value="글 목록" onclick="checkListForm()">
<%} %>
</body>
<Script src="http://localhost:8080/memberJSP/js/board.js?ver=2"></Script>
</html>