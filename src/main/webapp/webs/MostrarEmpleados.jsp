<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de empleados</h1>

	<br>
	<table border="1">
		<tr>
			<td>NOMBRE</td>
			<td>DNI</td>
			<td>SEXO</td>
			<td>CATEGORIA</td>
			<td>AÑOS</td>
		</tr>
		<c:forEach var="empleado" items="${listaEmpleados}">
			<tr>
				<td><c:out value="${empleado.nombre}"></c:out></td>
				<td><c:out value="${empleado.dni}"></c:out></td>
				<td><c:out value="${empleado.sexo}"></c:out></td>
				<td><c:out value="${empleado.categoria}"></c:out></td>
				<td><c:out value="${empleado.anyos}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<button onclick="window.location.href='index.jsp'">Volver</button>
</body>
</html>