<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>답글 쓰기</h4><br>
	<form name="boardForm" method="post" action="boardReply.do">
		<table class="boardFormTable">
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>제목</td>
					<input type="hidden" name="pg" value="${pg}">
					<input type="hidden" name="pseq" value="${pseq }">
				<td><input type="text" name="subject" id="subject"
					placeholder="제목 입력"></td>
			</tr>
			<tr>
				<td  class="tableHeader" style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>내용</td>
				<td style="" word_wrap:break-word;  word-break:break-all;><textarea
						name="content" id="content" rows="12" cols="52"
						placeholder="내용을 입력"></textarea></td>
			</tr>
			</table>
			<div style="margin-top:10px;">
				<input class="btn btn-outline-warning" type="submit" value="댓글작성"> &emsp; 
				<input class="btn btn-outline-warning" type="reset"
					value="다시작성">
			</div>
				
				
		
	</form>

</body>
<script>
function checkReplyForm(){
	if(document.writeForm.name.value == "")
}
</script>
</html>