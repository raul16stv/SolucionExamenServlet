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
<form action="ListVideogame" method="post">
	<input type="submit" value="Show List">
</form>

<%
 List<Videogame> videogames = (List<Videogame>)request.getAttribute("listAllVideogames");
 System.out.println(videogames);
 pageContext.setAttribute("videogames", videogames);
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
			<td>Recommended Age</td>
			<td>Release Date</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="videogame1" items="${listAllVideogames}">
			<tr>
				<td><c:out value="${videogame1.name}"/> </td>
				<td><c:out value="${videogame1.recommendedAge}"/> </td>
				<td><c:out value="${videogame1.releaseDate}"/> </td>
				<td><a href="deleteVideogame?name=${videogame1.name}">Delete</a></td>
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