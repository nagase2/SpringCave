<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hi there! Session:
	<%=session.getAttribute("name")%><br> Request:
	<%=request.getAttribute("name")%><p />

	Request(using EL): ${name}
	<br>
Age : ${age}<br>
ABC :${abc}<br>
TEST : ${test}<br>

<c:out value="${name}"></c:out>

<sql:query var="rs" dataSource="jdbc/spring">
select id, name, email, text from offers
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    id ${row.id}<br/>
    name ${row.name}<br/>
    text${row.text}
</c:forEach>


</body>
</html>