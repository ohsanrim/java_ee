<%@page import="com.jstl.PersonDTO"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //자바 파일 대신으로 보삼
    ArrayList <String> list = new ArrayList<String>();
    list.add("호랑이");
    list.add("사자");
    list.add("기린");
    list.add("코끼리");
    list.add("타조");
    list.add("코알라");
    list.add("여우");
    
    PersonDTO aa = new PersonDTO("홍길동",25);
    PersonDTO bb = new PersonDTO("프로도",32);
    PersonDTO cc = new PersonDTO("라이언",12);
    
    ArrayList<PersonDTO> list2 = new ArrayList<PersonDTO>();
    list2.add(aa);
    list2.add(bb);
    list2.add(cc);
    
    request.setAttribute("list",list);
    request.setAttribute("list2",list2);
    //페이지 이동
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("jstlTest.jsp");
    requestDispatcher.forward(request, response);
    //response.sendRedirect("jstlTest.jsp");
    %>
    <!--포워드 방식  -->
    <%-- <jsp:forward page="jstlTest.jsp"/> --%>
   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>