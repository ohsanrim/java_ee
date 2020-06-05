

function checkWriteForm(){
      if(document.writeForm.name.value == "") {
    	   alert("이름을 입력하세요.");
      	 document.writeForm.name.focus();
      } else if(document.writeForm.id.value == ""){
    	   alert("아이디를 입력하세요.");
     	 document.writeForm.id.focus();
      } else if(document.writeForm.pwd.value == "") {
    	  alert("비밀번호를 입력하세요.");
      	document.writeForm.pwd.focus();
      } else if(document.writeForm.repwd.value == ""){
    	  alert("재확인비밀번호를 입력하세요.");
      	document.writeForm.repwd.focus();
      } else if(document.writeForm.pwd.value != document.writeForm.repwd.value){
    	  alert("비밀번호가 일치하지 않습니다.");
          document.writeForm.pwd.focus();
      } else if(document.writeForm.idcheck.value=="false"){
    	  alert("중복체크 안함");
      } else if(document.writeForm.idcheck.value=="true"){
    	  document.writeForm.submit();
      } 
   }
function checkId(){
	let id=document.writeForm.id.value;
	if(id==""){
		alert("먼저 아이디를 입력해주세요")
	} else {
		window.open("checkId.jsp?id="+id,"","width=300 height=100 location=yes");
	}
}
function checkIdClose(id){
		opener.writeForm.idcheck.value="true";
		opener.writeForm.id.value=id;
		opener.writeForm.pwd.focus();
		window.close();
}
function checkPost(){
	window.open("checkPost.jsp","","width=500 height=500 scrollbars=yes");
}
function changeId(){
	document.writeForm.idcheck.value="false";
}
function checkPostClose(address, zipcode){
	opener.document.getElementById("zipcode").value=zipcode;
	opener.document.getElementById("addr1").value=address;
	opener.document.getElementById("addr2").focus();	
	window.close();
}
function checkModifyForm(){
    if(document.modifyForm.name.value == "") {
  	   alert("이름을 입력하세요.");
    	 document.modifyForm.name.focus();
    } else if(document.modifyForm.id.value == ""){
  	   alert("아이디를 입력하세요.");
   	 document.modifyForm.id.focus();
    } else if(document.modifyForm.pwd.value == "") {
  	  alert("비밀번호를 입력하세요.");
    	document.modifyForm.pwd.focus();
    } else if(document.modifyForm.repwd.value == ""){
  	  alert("재확인비밀번호를 입력하세요.");
    	document.modifyForm.repwd.focus();
    } else if(document.modifyForm.pwd.value != document.modifyForm.repwd.value){
  	  alert("비밀번호가 일치하지 않습니다.");
        document.modifyForm.pwd.focus();
    } else {
  	  document.modifyForm.submit();
    } 
 }
