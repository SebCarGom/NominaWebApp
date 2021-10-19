package dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import excepcion.DatosNoCorrectosException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modulo.ConexionBaseDatos;
import modulo.Empleado;

/**
 * 
 * @author Sebas
 *
 */
public class EmpleadoBaseDatos {

	public void mostrarEmpleados() throws SQLException, ClassNotFoundException {

		int numEmp = 1;

		Statement query = ConexionBaseDatos.conectar().createStatement();

		try (ResultSet rs = query.executeQuery("SELECT * from EMPLEADOS");) {

			while (rs.next()) {
				System.out.println("Empleado " + numEmp);

				System.out.println("Nombre: " + rs.getString(1) + ", DNI: " + rs.getString(2) + ", Sexo: "
						+ rs.getString(3) + ", Categoría: " + rs.getInt(4) + ", Años: " + rs.getInt(5));

				numEmp++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	};

	public List<Empleado> devolverEmpleados() throws SQLException, DatosNoCorrectosException {

		Connection conn = ConexionBaseDatos.conectar();
		Statement query = conn.createStatement();

		List<Empleado> listaEmpleados = new ArrayList<>();

		ResultSet rs = query.executeQuery("SELECT * from EMPLEADOS");

		while (rs.next()) {

			Empleado emp = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4),
					rs.getInt(5));

			listaEmpleados.add(emp);

		}

		return listaEmpleados;

	};

	public Empleado mostrarSalario(String dniVar) throws SQLException, DatosNoCorrectosException {

		Statement query = ConexionBaseDatos.conectar().createStatement();

		ResultSet rs = query.executeQuery("SELECT  * from Empleados WHERE dni = '" + dniVar + "' ");
		Empleado emp = null;

		while (rs.next()) {

			 emp = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4),
					rs.getInt(5));


		}

		return emp;
	}

	public static int getSueldo(String dni) throws SQLException {
		Connection con = ConexionBaseDatos.conectar();

		int sueldo = -1;

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT sueldo from NOMINAS WHERE dni = '" + dni + "'");
		
		while (rs.next()) {
			sueldo = rs.getInt(1);
		}
		
		return sueldo;
	}
}
