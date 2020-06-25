<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int seq=Integer.parseInt(request.getParameter("seq"));
    int pg=Integer.parseInt(request.getParameter("pg"));
    
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
table {
	background-color: white;
	border: 1px solid gray;
	Font-Family: 맑은 고딕;
}

tr, td {
	border: 1px solid gray;
	height: 30px;
}
</style>

</head>

<body>
	<h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;글 수정</h3>
	<form name="modifyForm" method="post" action="boardModify.jsp">
	<input type="hidden" name="pg" value="<%=pg %>">
	<input type="hidden" name="seq" value="<%=seq %>">
		<table>
			<tr>
				<td style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>제목</td>
				<td><input type="text" name="subject" id="subject" value="<%=boardDTO.getSubject()%>"
					></td>
			</tr>
			<tr>
				<td style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>내용</td>
				<td style="" word_wrap:break-word;  word-break:break-all;><textarea
						name="content" id="content" rows="12" cols="52"
						><%=boardDTO.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="글수정"> &emsp; 
				<input type="reset"
					value="다시작성"> &emsp; 
				<input type="button" value="수정취소"
					onclick="javascript:checkListForm()">
				</td>
			</tr>
		</table>
		</form>
</body>
<Script src="http://localhost:8080/memberJSP/js/board.js?ver=2"></Script>
</html>