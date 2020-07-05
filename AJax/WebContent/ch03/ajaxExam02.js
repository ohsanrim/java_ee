/**
 * 
 */
let httpRequest = null;
function startMethod() {
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = resultProcess;
	httpRequest.open("GET", "ajaxExam02.xml", true);
	httpRequest.send("");
}
function resultProcess() {
	var item = document.getElementById("resultDisplay");
	while (item.hasChildNodes() ) {
		item.removeChild(item.firstChild);
	}

	if(httpRequest.readyState == 4){
	      if(httpRequest.status == 200){
	    	  let xmlDoc = httpRequest.responseXML;
	    	  var subjectList = xmlDoc.getElementsByTagName("subject");
	    	  let message="";
	    	  /*
	    	  for(i=0;i<subjectList.length;i++){
	              let subject = subjectList[i].childNodes;
	              console.log("개수:"+subject.length);
	              message+="<tr>";
	              for(j=0;j<subject.length;j++){
	             	 if(subject[j].firstChild!=null) {
	             		 message+= "<td>"+subject[j].firstChild.nodeValue+"</td>";
	             	 }
	              }
	              message+="</tr>";
	    	  }
	    	  */
	          for(i=0;i<subjectList.length;i++){
	              let subject = subjectList.item(i);
	              
	              let codeNumberValue = subject.getElementsByTagName("codeNumber").item(0).firstChild.nodeValue;
	              let titleNameValue = subject.getElementsByTagName("titleName").item(0).firstChild.nodeValue;
	              let roomNumberValue = subject.getElementsByTagName("roomNumber").item(0).firstChild.nodeValue;
	              
	              var trNode = document.createElement("tr");
	              trNode.setAttribute("id","trNode");
	              var tdNode1=document.createElement("td");
	              tdNode1.setAttribute("id","tdNode");
	              var tdNode2=document.createElement("td");
	              tdNode2.setAttribute("id","tdNode");
	              var tdNode3=document.createElement("td");
	              tdNode3.setAttribute("id","tdNode");
	              
	              var textNode1=document.createTextNode(codeNumberValue);
	              var textNode2=document.createTextNode(titleNameValue);
	              var textNode3=document.createTextNode(roomNumberValue);
	              
	              tdNode1.appendChild(textNode1);
	              tdNode2.appendChild(textNode2);
	              tdNode3.appendChild(textNode3);
	              
	              trNode.appendChild(tdNode1);
	              trNode.appendChild(tdNode2);
	              trNode.appendChild(tdNode3);
	              
	              //message += "<tr>"+"<td>"++"</td>"+"<td>"+titleNameValue+"</td>"+"<td>"+roomNumberValue+"</td>"+"<tr>"
	              //document.getElementById("resultDisplay").innerHTML = message;
	              
	              document.getElementById("resultDisplay").appendChild(trNode);
	      }
	}
}
}
