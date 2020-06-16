<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="홍길동"/>
<c:set var="age">25</c:set>
<c:set var="sum">0</c:set>
나의 이름은 <c:out value="${name}"/>입니다<br>
내 나이는 ${age }살 입니다<br>
<h3>**변수 삭제**</h3>
<c:remove var="name"/>
나의 이름은 <c:out value="${name}"/>입니다<br>
내 나이는 ${age }살 입니다<br>
<h3>**for each**</h3>
<c:forEach var="i" begin="1" end="10" step="1">
${i } &nbsp;
</c:forEach>
<br>
<c:forEach var="i" begin="1" end="10" step="1">
<c:set var="sum" value="${sum+i }"/> &nbsp;

</c:forEach>
${sum }
<br>
<c:forEach var="i" begin="1" end="10" step="1">
${11-i } &nbsp;
</c:forEach>
<h3>**문자열 분리</h3>
<c:forTokens var="car" items="소나타, 아루디, 링컨, 페라리, 벤츠" delims=",">
${car }<br>
</c:forTokens>

<h3>** jstlExam.jsp에서 넘어온 데이터 출력</h3>

<!--${requestScope.list}  -->
<!-- 향상된 for문쓰기 -->
<c:forEach var="data" items="${requestScope.list }" >

</c:forEach>

<h3>**list2의 데이터 출력</h3>
<c:forEach var="data" items="${requestScope.list2 }" varStatus="i">
index=${i.index } &emsp; count=${i.count }<br>
이름 = ${data.name } &nbsp; 나이 = ${data.getAge() }<br>
</c:forEach>

</body>
</html>