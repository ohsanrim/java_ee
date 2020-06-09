<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setAttribute("apple", "사과");
    //페이지 이동
    	response.sendRedirect("sendResult.jsp");
    
    //URLEncoder.encode(name, "UTF-8") 라고 해주면 자동으로 인코딩해서 암호화 해준 후 들어가게 된다. 
    //response.sendRedirect("loginOk.jsp?name="+URLEncoder.encode(name,"UTF-8")+"&id="+id);
    %>
