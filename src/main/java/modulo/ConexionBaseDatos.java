/**
 * 
 */
package modulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fjdl
 * DriverManager para la conexión a la base de datos
 */

public class ConexionBaseDatos {
	

	private static Connection con = null;
    private static String url = "jdbc:oracle:thin:@localhost:1521/XE";
    private static String username = "Sebas";
    private static String password = "1234";

	public static Connection conectar() {
		try {
			if (con == null) {
				try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
				} catch (ClassNotFoundException e) {
					// TODO: handle exception
				}
				con = DriverManager.getConnection(url, username, password);
				System.out.println("Conexión realizada correctamente");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	public static void close() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}