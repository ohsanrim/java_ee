<%@page import="board.dao.BoardDAO"%>
<%@page import="borad.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
window.onload=function(){
	alert("1개의 글이 수정되었습니다.");
	location.href="boardList.do"
}
</script>