package laboral;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Sebas
 *
 */
public class EmpleadoBaseDatos {
	private ConexionBaseDatos conn;

	public EmpleadoBaseDatos(String url, String user, String pass) throws SQLException {
		conn = new ConexionBaseDatos(url, user, pass);

		conn.conectar();

		System.out.println(conn.getConn());
	}

	public void mostrarEmpleados() throws SQLException, ClassNotFoundException {
	
		int numEmp = 1;
		
		conn.conectar();
		
		Statement query = conn.getConn().createStatement();

		try (ResultSet rs = query.executeQuery("SELECT * from EMPLEADOS");) {

			while (rs.next()) {
				System.out.println("Empleado " + numEmp);
				
				System.out.println("Nombre: " + rs.getString(1) + ", DNI: " + rs.getString(2) + ", Sexo: "
						+ rs.getString(3) + ", Categoría: " + rs.getInt(4) + ", Años: " + rs.getInt(5));
				
				numEmp++;
			}

		} catch (SQLException e) {
			System.out.println("Error");
		}
		conn.desconectar();
	};

	public List<Empleado> devolverEmpleados() throws SQLException, DatosNoCorrectosException {

		conn.conectar();
		
		Statement query = conn.getConn().createStatement();
		
		List<Empleado> listaEmpleados = new ArrayList<>();

		try {
			
			ResultSet rs = query.executeQuery("SELECT * from EMPLEADOS");
			
			while (rs.next()) {
				
				Empleado emp = new Empleado(rs.getString(1),rs.getString(2),
						rs.getString(3).charAt(0),rs.getInt(4),rs.getInt(5));
				
				listaEmpleados.add(emp);
			}
		} catch (SQLException e) {
			System.out.println("Error");
		}
		return listaEmpleados;
	};

	public Map<String,Integer> mostrarSalario(String dniVar) throws SQLException, DatosNoCorrectosException {

		conn.conectar();
		
		Statement query = conn.getConn().createStatement();
		
		Map<String, Integer> salario = new HashMap<String, Integer>();

		try {
			
			ResultSet rs = query.executeQuery("SELECT  * from NOMINAS WHERE dni = '" + dniVar+"' ");
			
			while (rs.next()) {
				salario.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			System.out.println("Error");
		}
		return salario;
	}
	
}
