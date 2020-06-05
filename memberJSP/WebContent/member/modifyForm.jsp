<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//데이터
String name = request.getParameter("name");
String id = request.getParameter("id");
String gender = request.getParameter("gender");
String email1 = request.getParameter("email1");
String emailValue = request.getParameter("email2");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String zipcode = request.getParameter("zipcode");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>

<style>
table {
	background-color: #9ca6e4;
	border: 1px solid #6633cc;
	Font-Family: 맑은 고딕;
}

tr, td {
	border: 1px solid #6633cc;
	height: 30px;
}

input, select {
	background-color: #ccccff;
}
</style>
</head>
<body>
	<div border="1">
		<h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;회원정보수정</h3>
		<form name="modifyForm" method="post" action="modify.jsp">
			<table border="1">
				<tr>
					<td style="width: 80px; height: 30px;" align="center"><font
						color='red'>*</font>이 름</td>
					<td><input type="text" name='name' value="<%=name%>" ></td>
				</tr>
				<tr>
					<td align="center"><font color='red'>*</font>아이디</td>
					<td><input type="text" name='id' value="<%=id%>" size="10"
						onkeypress="changeId();" readonly></td>
				</tr>
				<tr>
					<td align="center"><font color='red'>*</font>비밀번호</td>
					<td><input type="password" name='pwd' size="10"></td>
				</tr>
				<tr>
					<td align="center"><font color='red'>*</font>재확인</td>
					<td><input type="password" name='repwd' size="10"></td>
				</tr>
				<tr>
					<td align="center" style="height: 30px;">성 별</td>
					<td><input type='radio' id='man' name="gender" value="0">남
					<input type='radio' id="woman" name="gender" value="1">여</td>
				</tr>
				<tr>
					<td align="center">이 메 일</td>
					<td><input type="email" name="email1" size="7"
						value="<%=email1%>">@<input type="text" id="email2"
						name="email2" list="defaultEmails"> <datalist
							id="defaultEmails">
							<option value="naver.com">
							<option value="gmail.com">
						</datalist></td>
				</tr>
				<tr>
					<td align="center">핸드폰</td>
					<td><select id="tel1" name="tel1">
							<option value="010">010</option>
							<option value="011">011</option>
					</select>-<input type="text" value="<%=tel2%>" name="tel2"
						style="width: 50px;">-<input type="text" value="<%=tel3%>"
						name="tel3" style="width: 50px;"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="zipcode" value="<%=zipcode%>"
						id="zipcode" size="7" readonly> <input type="button"
						value="우편번호검색" onclick="checkPost()"><br> <input
						type="text" name="addr1" id="addr1" value="<%=addr1%>"
						style="width: 350px;" placeholder="주소" readonly><br>
						<input type="text" name="addr2" id="addr2" value="<%=addr2%>"
						style="width: 350px;" placeholder="나머지주소"></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="button"
						value="회원정보수정" onclick="checkModifyForm()"> &emsp; <input
						type="reset" value="다시작성"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script>
window.onload = function () {
	document.modifyForm.gender['<%=gender %>'].checked = true;
	if ("<%=emailValue%>" != "") {
    document.getElementById("email2").value = "<%=emailValue%>";
	}
	if ("<%=tel1%>" != "") {
	document.getElementById("tel1").value = "<%=tel1%>";
	}
}
</script>
<script src="http://localhost:8080/memberJSP/js/member.js?ver=2"></script>

</html>