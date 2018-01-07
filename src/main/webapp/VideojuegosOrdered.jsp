<%@page import="Modelo.Consola"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,Modelo.Videojuego" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ordenarPorFecha" method="post">
	<input type="submit" value="ver listado">
</form>

<%
 List<Videojuego> Videojuego = (List<Videojuego>)request.getAttribute("OrdenarVideojuegosFecha");
 out.println(Videojuego);
 pageContext.setAttribute("videojuego", Videojuego);
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
			<td>Titulo</td>
			<td>Fecha</td>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="game1" items="${OrdenarVideojuegosFecha}">
			<tr>
				<td><c:out value="${game1.Titulo}"/> </td>
				<td><c:out value="${game1.FechaLanzamiento}"/> </td>

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

if(null != Videojuego && !Videojuego.isEmpty()){
for (Videojuego videojuego2 : Videojuego) {
	out.println("<tr>");
	out.println("<td>");
	out.println(videojuego2.getTitulo());
	out.println("</td>");
	out.println("<td>");
	out.println(videojuego2.getFechaLanzamiento());
	out.println("</td>");
	out.println("<td>");

}

}
%>
</tbody>
</table>







</body>
</html>