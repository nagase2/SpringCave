<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Offers.jsp</h2>

<!--  
<c:forEach var="aaa" items="${offers}">
    id : ${aaa.id}<br/>
    name : ${aaa.name}<br/>
        text : ${aaa.text}
        <hr>
</c:forEach>
-->

<table class="offers">
<tr><td>Name</td><td>Email</td><td>Offer</td></tr>

<c:forEach var="offer" items="${offers}">
	<tr>
	<td><c:out value="${offer.name}"></c:out></td>
	<td><c:out value="${offer.email}"></c:out></td>
	<td><c:out value="${offer.text}"></c:out></td>
	</tr>
</c:forEach>

</table>
<a href="./">home</a>

</body>
</html>