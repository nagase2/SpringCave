<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>home.jsp</h2>
<sec:authorize access="!isAuthenticated()">
You are not logged in<hr>
<p><a href="<c:url value='/login'/>">Log in</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">
You already have logged in! !<hr>
</sec:authorize>
	
<p><a href="${pageContext.request.contextPath}/offers">showoffers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">createoffers</a></p>

<sec:authorize access="isAuthenticated()">
<p><a href="<c:url value='/j_spring_security_logout'/>">Log out</a><br>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<p>THis is only for admin<br>
<a href="${pageContext.request.contextPath}/admin">admin</a></p>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_MANAGER')">
This is the only message for manager.<br>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
This message is for User<br>
</sec:authorize>

</body>
</html>