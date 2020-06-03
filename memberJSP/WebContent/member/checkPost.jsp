<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, tr{
	background-color:#fffce3;
	border:1px solid #6633cc;
	Font-Family: 궁서체;
	color:#6633cc;
	font-size:10pt;
}
input, select{
	 background-color:#faf6d4;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th style="width:100px;">시도</th>
			<th style="width:100px;">
			<select style="width:100px;" name="sido">
					<option value="">직접입력</option>
					<option value="서울">서울</option>
					<option value="인천">인천</option> 
					<option value="대전">대전</option>
					<option value="대구">대구</option>
					<option value="울산">울산</option>
					<option value="세종">세종</option>
					<option value="광주">광주</option>
					<option value="경기">경기</option>
					<option value="강원">강원</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="경남">경남</option>
					<option value="경북">경북</option>
					<option value="충남">충남</option>
					<option value="충북">충북</option>
					<option value="부산">부산</option>
					<option value="제주">제주</option>
			</select></th>
			<th style="width:100px;" >시.군.구</th>
			<th><input type="text" name="sigungu"></th>
		</tr>
		<tr>
			<th style="width:100px;">도로명</th>
			<th align="left"colspan="3"><input type="text" name="roadname"><input type="button" value="검색"></th>
		</tr>
		<tr>
			<th style="width:100px;">우편번호</th>
			<th colspan="3"  name="zipcode"> 주소 </th>
		</tr>
	</table>
</body>

</html>