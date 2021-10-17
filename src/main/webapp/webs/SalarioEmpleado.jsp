<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salario Empleado</title>
</head>
<body>
	<h1>Introduzca el dni del empleado para visualizar su salario</h1>

	<form action="Controller?opcion=MostrarSalario" method="post">
		DNI: <input type="text" name="dniVar" /> <br> <input
			type="submit">
	</form>
	<br>
	<table border="1">
		<tr>
			<td>DNI</td>
			<td>SUELDO</td>

		</tr>
		<c:forEach var="salario" items="${salario}">
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