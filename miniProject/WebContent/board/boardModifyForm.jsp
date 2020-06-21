<%@page import="borad.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
	<h4>글 수정</h4>
	<form name="modifyForm" method="post" action="boardModify.do">
	<input type="hidden" name="pg" value="${pg }">
	<input type="hidden" name="seq" value="${seq }">
		<table class="modifyFormTable">
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>제목</td>
				<td><input type="text" name="subject" id="subject" value="${boardDTO.getSubject() }"
					></td>
			</tr>
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>내용</td>
				<td style="" word_wrap:break-word;  word-break:break-all;><textarea
						name="content" id="content" rows="12" cols="52"
						>${boardDTO.getContent()}</textarea></td>
			</tr>
			</table>
			<div style="margin-top:10px;">
				<input class="btn btn-outline-warning" type="submit" value="글수정"> &emsp; 
				<input class="btn btn-outline-warning" type="reset"
					value="다시작성"> &emsp; 
				<input class="btn btn-outline-warning" type="button" value="수정취소"
					onclick="javascript:checkListForm()">
			</div>
				
				
		
		</form>
</body>
<Script src="../js/board.js?ver=2"></Script>
