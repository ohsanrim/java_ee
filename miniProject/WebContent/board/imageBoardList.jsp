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
			<td width='100' align=center>번호</td>
			<td width='300' align=center>이미지</td>
			<td width='100' align=center>상품명</td>
			<td width='100' align=center>단가</td>
			<td width='100' align=center>개수</td>
			<td width='100' align=center>합계</td>
		</tr>
		
		<c:forEach var="imageboardDTO" items="${list }">
			<tr>
				<th align=center style="text-align:center;">${imageboardDTO.seq }</th>
				<td align=center style="width:200px;">
					<img class="productImage" src="../storage/${imageboardDTO.image1 }">
				</td>
				<td align=center>${imageboardDTO.imageName }</td>
				<td align=center><fmt:formatNumber value="${imageboardDTO.imagePrice }" pattern="#,###" /></td>
				<td align=center><fmt:formatNumber value="${imageboardDTO.imageQty }" pattern="#,###" /></td>
				<td align=center><fmt:formatNumber value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }" pattern="#,###원" /></td>
			</tr>
		</c:forEach>
	</table>
	<div style="width: 600px; text-align: center;">${boardPaging.getPagingHTML() }</div>
</form>
</body>
<script>
function boardPaging(pg){
		location.href="imageBoardList.do?pg="+encodeURI(pg);
}
</script>
</html>