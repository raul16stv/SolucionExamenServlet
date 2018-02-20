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
<form action="ListCompany" method="post">
	<input type="submit" value="Show List">
</form>

<%
 List<Company> companies = (List<Company>)request.getAttribute("listAllCompanies");
 System.out.println(companies);
 pageContext.setAttribute("companies", companies);
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
		<c:forEach var="company" items="${listAllCompanies}">
			<tr>
				<td><c:out value="${company.name}"/> </td>
				<td><c:out value="${company.creationDate}"/> </td>
				<td><c:out value="${company.id}"/> </td>
				<td><a href="deleteConsole?nombre=${company.name}">Delete</a></td>
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