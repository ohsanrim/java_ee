<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="UTF-8"/>
<style>
.productImage{
	width:150px;
	height:150px;
}
</style>
<form name="imageboardListForm" method="post" action="#">
	<table class="imageBoardListTable" border="1" cellspacing="0" cellpadding="3" frame="hsides" rules="rows">
		<tr>
			<td width='100' align=center><input type="checkbox" id="all" name="all" onclick="checkAll()">번호</td>
			<td width='300' align=center>이미지</td>
			<td width='100' align=center>상품명</td>
			<td width='100' align=center>단가</td>
			<td width='100' align=center>개수</td>
			<td width='100' align=center>합계</td>
		</tr>
		
		<c:forEach var="imageboardDTO" items="${list }">
			<tr>
				<th align=center style="text-align:center;"><input type="checkbox" name="seqCheck" value="${imageboardDTO.seq }" class="itemCheck" onclick="uncheck()">${imageboardDTO.seq }</th>
				<td align=center style="width:200px;">
					<img class="productImage" src="../storage/${imageboardDTO.image1 }" onclick="checkImageBoardLogin(${imageboardDTO.seq },${param.pg })">
				</td>
				<td align=center>${imageboardDTO.imageName }</td>
				<td align=center><fmt:formatNumber value="${imageboardDTO.imagePrice }" pattern="#,###" /></td>
				<td align=center><fmt:formatNumber value="${imageboardDTO.imageQty }" pattern="#,###" /></td>
				<td align=center><fmt:formatNumber value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }" pattern="#,###원" /></td>
			</tr>
		</c:forEach>
	</table>
	<div style="display:flex; justify-content:center;">
		<c:if test="${sessionScope.memId=='admin' }"><div style="text-align: left;"><input type="button" value="선택삭제" onclick="choiceDelete()" ></div></c:if><div style="width: 760px; text-align: center;">${boardPaging.getPagingHTML() }</div>
	</div>
	
</form>
</body>
<script>
function boardPaging(pg){
		location.href="imageBoardList.do?pg="+encodeURI(pg);
}
function checkImageBoardLogin(seq,pg){
	location.href = "imageBoardView.do?seq=" + seq + "&pg=" + pg;
}
function checkAll(){
	   if(document.getElementById("all").checked==true){
	         for(var i=0;i<3;i++) document.getElementsByName("seqCheck")[i].checked=true;
	      }
	      if(document.getElementById("all").checked==false){
	         for(var i=0;i<3;i++) document.getElementsByName("seqCheck")[i].checked=false;
	      }
	}
function uncheck(){
	for(var i=0;i<3;i++){
		if(document.getElementsByName("seqCheck")[i].checked==false){
				document.getElementById("all").checked=false;
		}
	}
}
function choiceDelete(){
	var arr = new Array();
	for(var i=0;i<3;i++){
		if(document.getElementsByName("seqCheck")[i].checked==true){
			arr.push(document.getElementsByName("seqCheck")[i].value);
		}
	}
	if(arr.length>0){
		if(confirm('삭제하시겠습니까?')){
			location.href="ImageBoardListDelete.do?seq="+arr;
		} else {
			alert("삭제 취소");
		}
	} else {
		alert("삭제할 항목을 선택해주세요");
	}
}
</script>
</html>