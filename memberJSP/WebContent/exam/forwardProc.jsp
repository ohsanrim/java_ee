<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setAttribute("apple", "사과");
   //페이지 이동
   RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");  //주소를 쓸 때에는 반드시 상대번지 값을 적어주어야 한다. 
   dispatcher.forward(request, response);  //제어권 넘기기
    %>
    <!--페이지 이동-->
  <%--   <jsp:forward page="forwardResult.jsp"/> --%>