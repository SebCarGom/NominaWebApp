<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salarios Empleados</title>
</head>
<h1>Salario</h1>
<br>
<table border="1">
	<tr>
		<td>DNI</td>
		<td>SUELDO</td>

	</tr>
	<c:forEach var="salario" items="${map}">
		<tr>
			<td><c:out value="${salario.getKey()}"></c:out></td>
			<td><c:out value="${salario.getValue()}"></c:out></td>
		</tr>
	</c:forEach>
</table>
<br>
<button onclick="window.location.href='index.jsp'">Volver</button>

</body>
</html>