<%@page import="Modelo.Consola"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,Modelo.Consola" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="cargarConsola" method="post">
	<input type="submit" value="ver listado">
</form>

<%
 List<Consola> Consola = (List<Consola>)request.getAttribute("listAllConsola");
 out.println(Consola);
 pageContext.setAttribute("consola", Consola);
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
		<c:forEach var="consola1" items="${listAllConsola}">
			<tr>
				<td><c:out value="${consola1.nombre}"/> </td>
				<td><c:out value="${consola1.empresa}"/> </td>

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

if(null != Consola && !Consola.isEmpty()){
for (Consola consola2 : Consola) {
	out.println("<tr>");
	out.println("<td>");
	out.println(consola2.getNombre());
	out.println("</td>");
	out.println("<td>");
	out.println(consola2.getEmpresa());
	out.println("</td>");
	out.println("<td>");

}

}
%>
</tbody>
</table>







</body>
</html>