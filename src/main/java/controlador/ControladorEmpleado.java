package controlador;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoBaseDatos;
import excepcion.DatosNoCorrectosException;
import modulo.Empleado;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Controller")
public class ControladorEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1234567L;

	public ControladorEmpleado() {
		super();
	}

	public void init() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String respuesta = request.getParameter("opcion");

		switch (respuesta) {
		case "MostrarEmpleados": {

			try {
				List<Empleado> listaEmpleados = new ArrayList<>();

				EmpleadoBaseDatos empbd = new EmpleadoBaseDatos();

				listaEmpleados = empbd.devolverEmpleados();

				request.setAttribute("listaEmpleados", listaEmpleados);

				RequestDispatcher requesDispatcher = request.getRequestDispatcher("webs/MostrarEmpleados.jsp");

				requesDispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error en la base de datos");
			} catch (DatosNoCorrectosException e) {
				System.out.println("Error: datos del emmpleados no correctos");
			}
			break;
		}

		case "BuscaEmpleadoDNI": {

			RequestDispatcher requesDispatcher = request.getRequestDispatcher("webs/BuscaEmpleadoDNI.jsp");

			requesDispatcher.forward(request, response);

			break;

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + respuesta);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String respuesta = request.getParameter("opcion");

		switch (respuesta) {
		case "MuestraEmpleadoDNI": {

			String dniVar = request.getParameter("dniVar");

			EmpleadoBaseDatos empbd = new EmpleadoBaseDatos();

			Empleado e;
			try {
				e = empbd.mostrarSalario(dniVar);
				
				request.setAttribute("empleado", e);
				
				int sueldo = EmpleadoBaseDatos.getSueldo(dniVar);
				request.setAttribute("sueldo", sueldo);
				
				

			} catch (SQLException | DatosNoCorrectosException e1) {
				e1.printStackTrace();
			}


			RequestDispatcher requesDispatcher = request.getRequestDispatcher("webs/MuestraEmpleadoDNI.jsp");

			requesDispatcher.forward(request, response);

			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + respuesta);
		}

	}
}
