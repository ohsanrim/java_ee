<%@page import="borad.bean.BoardPaging"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="borad.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 데이터
//날짜
SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
SimpleDateFormat today = new SimpleDateFormat("HH:mm:ss");
SimpleDateFormat past = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
Date current = new Date();
String currentTime = ft.format(current);
int pg = Integer.parseInt(request.getParameter("pg"));
// db
ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
BoardDAO boardDAO = BoardDAO.getInstance();
int endNum = pg * 5;
int startNum = endNum - 4;
list=boardDAO.selectAll(startNum, endNum);

//페이징 처리 - 1페이지 당 2개의 방명록 처리
BoardPaging boardPaging = new BoardPaging();
int totalA = boardDAO.getTotalA(); // 총글수
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);
boardPaging.makePagingHTML();

response.setContentType("text/html;charset=UTF-8");

String userId = (String) session.getAttribute("memId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<Style>
table {
	border-top: 1px solid #000000;
}

th {
	background-color: gray;
}

#currentPaging {
	border: 1px red solid;
	text-decoration: underline;
}

#Paging {
	color: black;
	text-decoration: none;
}

.subjectA:link {
	color: black;
	text-decoration: none;
}

.subjectA:visited {color black;
	text-decoration: none;
}

.subjectA:hover {
	color: green;
	text-decoration: none;
}

.subjectA:active {
	color: black;
	text-decoration: none
}
</Style>
</head>
<body>
	<h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;글
		목록</h3>
	<form name="listForm">
		<table border="1" cellspacing="0" cellpadding="3" frame="hsides"
			rules="rows">
			<tr>
				<th style='width: 40px; font-size: 10px;' align='center'>글번호</th>
				<th style='width: 80px;' align='center'>아이디</th>
				<th style='width: 300px;' align='center'>제목</a></th>
				<th style='width: 100px;' align='center'>작성시간</th>
				<th style='width: 40px; font-size: 10px;' align='center'>조회수</th>
			</tr>
			<%
				if (list != null) {
				for (BoardDTO data : list) {
					int seq = data.getSeq();
					String id = data.getId();
					String name = data.getName();
					String email = data.getEmail();
					String subject = data.getSubject();
					String content = data.getContent();
					String logtime = ft.format(data.getLogtime()).equals(currentTime)
					? today.format(data.getLogtime())
					: past.format(data.getLogtime());

					int hit = data.getHit();
			%>
			<tr>
				<td align='center'><%=seq%></td>
				<td align='center'><%=id%></td>
				<td><a href="javascript:checkLogin(<%=seq%>,<%=pg%>)"><%=subject%></a></td>
				<td style="font-size: 10px;" align='center'><%=logtime%></td>
				<td align='center'><%=hit%></td>

				<%
					}
				%>
				<%
					}
				%>
			
		</table>
		<div style="width:600px; text-align:center;"><%=boardPaging.getPagingHTML()%></div>
</body>

</form>
</body>
<Script>
function checkLogin(seq,pg){
	if('<%=userId%>
	' == 'null') {
			alert("권한이 없습니다. 로그인을 먼저 해주세요!");
		} else {
			location.href = "boardView.jsp?seq=" + seq + "&pg=" + pg;
		}

	}
</Script>
</html>