<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;글쓰기</h3>
	<form name="boardForm" method="post" action="boardWrite.jsp">
		<table>
			<tr>
				<td style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>제목</td>
				<td><input type="text" name="subject" id="subject"
					placeholder="제목 입력"></td>
			</tr>
			<tr>
				<td style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>내용</td>
				<td style="" word_wrap:break-word;  word-break:break-all;><textarea
						name="content" id="content" rows="12" cols="52"
						placeholder="내용을 입력"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="글작성"
					onclick="checkBoardWriteForm()"> &emsp; <input type="reset"
					value="다시작성"> &emsp; <input type="button" value="글목록"
					onclick="checkListForm()"></td>
			</tr>
		</table>
	</form>
</body>
<Script src="http://localhost:8080/memberJSP/js/board.js?ver=2">

</Script>
</html>