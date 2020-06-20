<%@page import="borad.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userId=(String)session.getAttribute("memId");  //접속한 사용자 아이디
    
    int seq=Integer.parseInt(request.getParameter("seq"));
    int pg=Integer.parseInt(request.getParameter("pg"));
    String subject="하하하하";
    String name="홍길동";
    int hit=1000;
    String content="wlqdprkrhtlsadssadasdasdas";
    
    //DB연동
    BoardDAO boardDAO = BoardDAO.getInstance();
    BoardDTO boardDTO = new BoardDTO();
    boardDTO=boardDAO.getBoard(seq);
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td{
border: 1px solid gray;

}
</style>
</head>
<body>
<table>
<tr>
<td align="center" style="width:80px;">제목</td><td colspan="5"><%=boardDTO.getSubject() %></td>
</tr>
<tr>
<td align="center" >글번호</td><td><%=seq %></td>
<td align="center" style="width:80px;">작성자</td><td><%=boardDTO.getName() %></td>
<td align="center"style="width:80px;" >조회수</td><td><%=boardDTO.getHit() %></td>
</tr>
<tr>
<td style='width:500px; height:80px;vertical-align:top;' colspan='6'><pre style='white-space:pre-wrap; word_wrap:break-word; word-break: break-all;'><%= boardDTO.getContent()%></pre></td>
</tr>
<tr>
<td colspan="6"><input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
<%
if(userId.equals(boardDTO.getId())){
%>
<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=seq%>&pg=<%=pg%>'"><input type="button" value="글삭제" onclick="location.href='boardList.jsp?pg=<%=pg%>'"></td>
<%} %>
</tr>
<




</table>
</body>
</html>