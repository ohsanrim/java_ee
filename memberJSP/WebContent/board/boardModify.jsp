<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    String seq=request.getParameter("seq");
    String pg=request.getParameter("pg");
    String subject=request.getParameter("subject");
    String content=request.getParameter("content");
    BoardDAO boardDAO = BoardDAO.getInstance();
    
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setSeq(Integer.parseInt(seq));
    boardDTO.setSubject(subject);
    boardDTO.setContent(content);
    //DB
    int su=boardDAO.updateBoard(boardDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(su==1){%> 
	1개의 글이 수정되었습니다!
	<input type="button" value="글목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
<%} else { %>
	수정을 실패하였습니다. 다시한번 진행해 주세요!
	<input type="button" value="글목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
<%} %>
</body>
</html>