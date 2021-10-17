package controlador;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import laboral.Empleado;
import laboral.EmpleadoBaseDatos;
import laboral.DatosNoCorrectosException;

@WebServlet("/Controller")
public class ControladorEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1234567L;
	EmpleadoBaseDatos empBD;

	public ControladorEmpleado() {
		super();
	}

	public void init() throws ServletException {
		String url = getServletContext().getInitParameter("url");

		String user = getServletContext().getInitParameter("user");

		String pass = getServletContext().getInitParameter("pass");

		try {
			empBD = new EmpleadoBaseDatos(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String respuesta = request.getParameter("opcion");

		switch (respuesta) {
		case "MostrarEmpleados":
			try {
				List<Empleado> listaEmpleados = new ArrayList<>();

				listaEmpleados = empBD.devolverEmpleados();

				request.setAttribute("listaEmpleados", listaEmpleados);

				RequestDispatcher requesDispatcher = request.getRequestDispatcher("webs/MostrarEmpleados.jsp");

				requesDispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error");
			} catch (DatosNoCorrectosException e) {
				System.out.println("Error");
			}
			break;
		case "MostrarSalario":
			try {
				String dniVar = request.getParameter("dniVar");

				Map<String, Integer> salario = new HashMap<String, Integer>();

				salario = empBD.mostrarSalario(dniVar);
				
				request.setAttribute("salario", salario);

				RequestDispatcher requesDispatcher = request.getRequestDispatcher("webs/MostrarSalario.jsp");

				requesDispatcher.forward(request, response);

			} catch (SQLException e) {
				System.out.println("Error");
			} catch (DatosNoCorrectosException e) {
				System.out.println("Error");
			}
			break;
		case "SalarioEmpleado":
			try {
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("webs/SalarioEmpleado.jsp");

				requesDispatcher.forward(request, response);
			} catch (Exception e) {
				System.out.println("Error");
			}
			break;

		default:
			break;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
