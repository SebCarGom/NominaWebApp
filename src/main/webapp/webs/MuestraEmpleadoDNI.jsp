<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salario Empleado</title>
</head>
<body>
	<h1>Introduzca el dni del empleado para visualizar su salario</h1>

	<br>
	<table border="1">
		<tr>
			<td>DNI</td>
			<td>SUELDO</td>

		</tr>
		
			<tr>
				<td><c:out value="${empleado.dni}"></c:out></td>
				<td><c:out value="${sueldo}"></c:out></td>
			</tr>
	</table>
	<br>
	<button onclick="window.location.href='index.jsp'">Volver</button>

</body>
</html>