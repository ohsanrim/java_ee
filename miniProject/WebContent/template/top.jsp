<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<div class="logo">
		<img class="logoImg" src="../image/iu.jpg"/ onclick="location.href='../main/index.do'">
		<h3>MINI PROJECT</h3>
	</div>
	<div class="navBar">
		<c:if test="${sessionScope.memName==null }">
			<div>
				<a class="mainList" href="../member/writeForm.do">회원가입</a><br>
			</div>
		</c:if>
		<c:if test="${sessionScope.memName!=null }">
			<div>
				<a class="mainList" href="../member/logout.do">로그아웃</a><br>
			</div>
			<div>
				<a class="mainList" href="../member/modifyForm.do">회원정보수정</a><br>
			</div>
			<div>
				<a class="mainList" href="../board/boardWriteForm.do">글쓰기</a><br>
			</div>
		</c:if>
		<div>
			<a class="mainList" href="../board/boardList.do?pg=1">목록</a><br>
		</div>
	</div>
</div>
