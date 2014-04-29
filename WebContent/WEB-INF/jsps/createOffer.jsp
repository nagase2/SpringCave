<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
<table>
<tr><td>Name: </td><td><sf:input class="control" name="name" path="name" type="text"/><br/><sf:errors path="name" cssClass="error"></sf:errors></td></tr>
<tr><td>Email: </td><td><sf:input  class="control" name="email" path="email" type="text"/><br/><sf:errors id="aaa" path="email" cssClass="error"></sf:errors></td></tr>
<tr><td>Your Offer: </td><td><sf:textarea  class="control" name="text" path="text" rows="" cols=""></sf:textarea><br/><sf:errors path="text" cssClass="error"></sf:errors></td></tr>

</table>
<input  class="control" value="send" type="submit"/>

</sf:form>

</body>
</html>