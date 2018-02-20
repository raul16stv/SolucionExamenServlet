<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ListConsole" method="post">
	<input type="submit" value="Show List">
</form>

<%
 List<Console> consoles = (List<Console>)request.getAttribute("listAllConsoles");
 System.out.println(consoles);
 pageContext.setAttribute("consoles", consoles);
%>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<table border="1">
	<thead>
		<tr>
			<td>Name</td>
			<td>Company</td>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="console1" items="${listAllConsoles}">
			<tr>
				<td><c:out value="${console1.name}"/> </td>
				<td><c:out value="${console1.companyId}"/> </td>
				<td><a href="deleteConsole?nombre=${console1.name}">Delete</a></td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>




</body>
</html>