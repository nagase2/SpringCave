<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="post" action="${pageContext.request.contextPath}/docreate">
<table>
<tr><td>Name: </td><td><input name="name" type="text"/></td></tr>
<tr><td>Email: </td><td><input name="email" type="text"/></td></tr>
<tr><td>Your Offer: </td><td><textarea name="text" rows="" cols=""></textarea></td></tr>

</table>
<input value="send" type="submit"/>

</form>

</body>
</html>