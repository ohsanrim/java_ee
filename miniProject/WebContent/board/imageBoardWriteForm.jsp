<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>이미지 올리기</h4>
	<br>
	<form name="ImageBoardWriteForm" method="post" action="../board/imageBoardWrite.do" enctype="multipart/form-data"3>
		<!--boardWrite.do  -->
		<table class="boardFormTable">
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;"
					align="center"><font color='red'>*</font>상품코드</td>
				<td><input type="text" name="imageId" id="imageId" value="img_"></td>
			</tr>
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;"
					align="center"><font color='red'>*</font>상품명</td>
				<td><input type="text" name="imageName" id="imageName"
					placeholder="상품명 입력"></td>
			</tr>
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;"
					align="center"><font color='red'>*</font>단가</td>
				<td><input type="text" name="imagePrice" id="imagePrice"
					placeholder="단가 입력"></td>
			</tr>
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;"
					align="center"><font color='red'>*</font>갯수</td>
				<td><input type="text" name="imageQty" id="imageQty"
					placeholder="갯수 입력"></td>
			</tr>

			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;"
					align="center"><font color='red'>*</font>내용</td>
				<td style=""word_wrap:break-word;  word-break:break-all;><textarea
						name="imageContent" id="imageContent" rows="12" cols="52"
						placeholder="내용 입력"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name="image1" size="50">
				</td>
			</tr>
			<tr>
			<td colspan="2" align="center">
			<input type="button" value="이미지 등록" onclick="checkIamgeBaordForm()"><input type="reset" value="다시작성">
			</td>
			</tr>
		</table>
	</form>

</body>
<script>
function checkIamgeBaordForm(){
	document.ImageBoardWriteForm.submit();
}

</script>
</html>