<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	background-color: #9ca6e4;
	border: 1px solid #6633cc; #
	ccccff Font-Family: 맑은 고딕;
}

tr, td {
	border: 1px solid #6633cc;
}
</style>
</head>
<body>
	<form method="post" action="jstlResult.jsp">
		<table border="1">
			<tr>
				<td style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>이 름</td>
				<td style="width: 310px;"><input type="text" name='name'
					size="10" placeholder="이름입력"></td>
			</tr>
			<tr>
				<td align="center">나 이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td align="center" style="height: 30px;">색 깔</td>
				<td><select name="color">
						<option value="red">빨강</option>
						<option value="green">초록</option>
						<option value="blue">파랑</option>
						<option value="magenta">보라</option>
						<option value="cyan">하늘</option>
				</select></td>
			</tr>
			<tr>
				<td align="center" style="height: 30px;">취 미</td>
				<td><input type="checkbox" name='hobby' value="독서">독서 <input
					type="checkbox" name='hobby' value="음악">음악 <input
					type="checkbox" name='hobby' value="게임">게임 <input
					type="checkbox" name='hobby' value="운동">운동 <input
					type="checkbox" name='hobby' value="영화">영화</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="SEND"> &emsp; <input type="reset" value="CANCEL"></td>
			</tr>

		</table>
	</form>

</body>
</html>