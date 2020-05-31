function checkGuestForm() {
	if (document.getElementById("subject").value == "") {
		alert("제목을 입력하세요.");
		document.guestForm.subject.focus();
	} else if (document.getElementById("content").value == "") { 
		alert("내용을 입력하세요.");
		document.guestForm.content.focus();
	} else {
		document.guestForm.submit();
	}
}
function checkListForm(){ document.listForm.submit(); }