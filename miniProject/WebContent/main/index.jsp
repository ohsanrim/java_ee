<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>miniProject</title>
<link rel="stylesheet" href="../css/member.css">
<!-- 합쳐지고 최소화된 부트스트랩 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!--Font Awesome-->
<script src="https://kit.fontawesome.com/6c7d966087.js" crossorigin="anonymous"></script>
<!--JQuery-->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!--GoogleFont-->
<link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
</head>
<body>
<table class="mainTable" cellspacing="0" width="100%" >
<tr>
<td class="indexHeader" colspan="2" align="center" style="height:100px; padding:0px auto;">
<jsp:include page="../template/top.jsp"></jsp:include>
</td>

</tr>
<tr>
<td class="indexLeft" align="center" style="width:300px;px; height:500px;" valign=top>
<c:if test="${memId==null }">
<c:choose>
<c:when test="${loginCheckTry==null}"><jsp:include page="../member/loginForm.jsp"></jsp:include><c:set var="loginCheckTry" value="true"/></c:when>
<c:otherwise><c:set var="loginCheckTry" value="false"/><jsp:include page="../member/loginFail.jsp"></jsp:include></c:otherwise>
</c:choose>
</c:if>
<c:if test="${memId!=null }"><jsp:include page="../member/loginOk.jsp"></jsp:include></c:if>
</td>

<td class="indexCenter" align="center">
<jsp:include page="${display }"/>
</td>

</tr>
<tr>
<td colspan="2" align="center" style="height:50px;">
<jsp:include page="../template/bottom.jsp"></jsp:include>
</td>
</tr>
</table>
</body>
</html>
<!-- update board set hit=hit+1 where seq=글번호;
boardView 에서 게속 f5 누르면 조회수 증가
boardList로 갔다가 boardView로 들어오면 조회수 증가
쿠키로 처리-->