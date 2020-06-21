<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<h4>글 목록</h4><br>
	<form name="listForm" action="boardSearch.do?pg=1">
		<table class="listTable" cellspacing="0" cellpadding="3" frame="hsides"
			rules="rows">
			<tr>
				<td class="listTh" style='width: 40px; font-size: 10px;' align='center'>글번호</td>
				<td class="listTh" style='width: 80px;' align='center'>아이디</tdh>
				<td class="listTh" style='width: 300px;' align='center'>제목</a></td>
				<td class="listTh" style='width: 100px;' align='center'>작성시간</td>
				<td class="listTh" style='width: 40px; font-size: 10px;' align='center'>조회수</td>
			</tr>
			<c:if test="${list!=null }">
				<c:forEach var="data" items="${list }">
					<tr>
						<c:set var="logtime"
							value="${ft.format(data.getLogtime()).equals(currentTime)
					? today.format(data.getLogtime())
					: past.format(data.getLogtime())}" />

						<td align='center'>${data.seq }</td>
						<td align='center'>${data.id }</td>
						<td><a
							href="javascript:checkBoardLogin(${data.seq },${param.pg })">${data.subject }</a></td>
						<td style="font-size: 10px;" align='center'>${data.logtime }</td>
						<td align='center'>${data.hit }</td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
		<div style="width: 600px; text-align: center;">${boardPaging.getPagingHTML() }</div>
		<div style="margin:10px;">
			<select id="searchOption" name="searchOption">
				<option value="제목">제목</option>
				<option value="작성자">작성자</option>
			</select> 
			<input type="text" name="keyword" value="${param.keyword }"> 
			<input type="submit" value="검색">
		</div>
</body>
</form>
</body>
<script src="../js/member.js?ver=1"></script>
<Script src="../js/board.js?ver=1"></Script>
<script>
function checkBoardLogin(seq,pg){
	if(${memName==null}) {
			alert("권한이 없습니다. 로그인을 먼저 해주세요!");
			location.href = "../main/index.do";
		} else {
			location.href = "boardView.do?seq=" + seq + "&pg=" + pg;
		}
}

window.onload = function () {
	if ("${searchOption }" != "") {
		document.getElementById("searchOption").value = "${searchOption }";
	}
}
</script>
