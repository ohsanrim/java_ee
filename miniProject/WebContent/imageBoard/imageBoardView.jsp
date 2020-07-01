<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>상품 정보</h4>
<form class="imageBoardView" style="width:700px;">
<table class="imageBoardViewTable">
<tr>
<td rowspan="4" width=300px; align="center"><img width=300px; src="../storage/${imageDTO.image1 }"></td>
<td class="tableHeader" align="center">상품명</td><td align="center">${imageDTO.imageName }</td>
</tr>
<tr>
<td class="tableHeader" align="center">단가</td><td align="center">${imageDTO.imagePrice }</td>
</tr>
<tr>
<td class="tableHeader" align="center">개수</td><td align="center">${imageDTO.imageQty }</td>
</tr>
<tr>
<td class="tableHeader" align="center">합계</td><td align="center">${imageboardDTO.imagePrice * imageboardDTO.imageQty }</td>
</tr>
<tr>
<td align="center" colspan="3">${imageDTO.imageContent }</td>
</tr>
<tr>
<td colspan="3" align="center"><input type="button" class="btn btn-outline-warning" value="글 수정"></td>
</tr>
</table>

</form>
