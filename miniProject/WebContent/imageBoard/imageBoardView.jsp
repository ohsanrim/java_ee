<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>상품 정보</h4>
<form class="imageBoardView" style="width:700px;">
<table class="imageBoardViewTable">
<tr>
<td rowspan="4" width=300px; align="left"><img id="bigImg" width="20"  height="20" src="../image/view.png"><img id="imgView" width=300px; src="../storage/${imageDTO.image1 }"></td>
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
<script>
$(document).ready(function(){
	$('#bigImg').click(function(){
		let url = $('#imgView').attr('src');
		let imgWindow = window.open(url, "", "width=500 height=500");
		$(imgWindow.document).find($('img')).css('width','500');
		//$(imgWindow.document.body).find($('img')).attr('src',url);
		//$(imgWindow.document.body).html('<img width="500" height="500" src="'+url+'">');
		 //let temp = imgWindow.document.getElementById("imgView");
		// temp.attr("src",url);
		//imgWindow.document.body.innerHTML='<img width="500" height="500" src="'+url+'">';
		//imgWindow.document.body.innerHTML="<div>왜 안돼나 화딱지나게</div>";
		console.log(imgWindow.document.getElementById("ddd").value);
	});
});

</script>

</form>
