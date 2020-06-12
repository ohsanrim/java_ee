<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
//String name=(String)request.getSession().getAttribute("name");
//String id=(String)request.getSession().getAttribute("id");
//String pwd=(String)request.getSession().getAttribute("pwd");
//request.getSession().setAttribute("name", name);
//request.getSession().setAttribute("id", id);
//request.getSession().setAttribute("pwd", pwd);
String name=null;
String id=null;
String pwd=null;
//쿠키
//특정 쿠키를 얻어오지 못하고 모든 쿠키 얻어오기
//Cookie[] ar = request.getCookies();
//if(ar!=null){
//	for(int i=0;i<ar.length;i++){
		//String cookieName= ar[i].getName();  //쿠키명
		//String cookieValue=ar[i].getValue();  //값
		//System.out.println("쿠키명"+cookieName+"\t 값"+cookieValue);
//		if(ar[i].getName().equals("memName")) name=ar[i].getValue();
//		else if(ar[i].getName().equals("memId")) id=ar[i].getValue();
//	}
//}
//세션
name=(String)session.getAttribute("memName");
id=(String)session.getAttribute("memId");
pwd=(String)session.getAttribute("memPwd");
%>
<img src="../image/iu.jpg" onclick="location.href='index.jsp'"><br>
<%=name%> 님이 로그인 하셨습니다.<br>
<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
<input type="button" value="회원정보수정" onclick="location.href='modifyForm.jsp'">