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
<form action="cargarListado" method="post">
	<input type="submit" value="ver listado">
</form>

<%
 List<Consola> consolas = (List<Consola>)request.getAttribute("listAllUsers");
 System.out.println(consolas);
 pageContext.setAttribute("consola", consolas);
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
			<td>Nombre</td>
			<td>Empresa</td>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="consola1" items="${listAllUsers}">
			<tr>
				<td><c:out value="${consola1.nombre}"/> </td>
				<td><c:out value="${consola1.empresa}"/></td>
				<td><a href="filtrarConsola?empresa=${consola1.empresa}">Filtrar por esta marca</a></td>
				<td><a href="deleteConsola?nombre=${consola1.nombre}">Borrar</a></td>
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


<table border="1">
<thead>
	<tr>
		<td>Nombre</td>
		<td>Empresa</td>

	</tr>
</thead>
<tbody>
<%

if(null != consolas && !consolas.isEmpty()){
for (Consola consola2 : consolas) {
	out.println("<tr>");
	out.println("<td>");
	out.println(consola2.getNombre());
	out.println("</td>");
	out.println("<td>");
	out.println(consola2.getEmpresa());
	out.println("</td>");
	out.println("</tr>");
}

}
%>


</tbody>
</table>







</body>
</html>