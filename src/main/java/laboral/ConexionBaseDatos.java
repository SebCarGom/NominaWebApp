package laboral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Sebas
 *
 */
public class ConexionBaseDatos {

	Connection conn;
	String url;
	String user;
	String pass;

	public ConexionBaseDatos(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public void conectar() throws SQLException {
		if (conn.isClosed() || conn == null) {
			try {
				Class.forName("com.oracle.jdbc.Driver");
			} catch (Exception e) {
				System.out.println("Error");
			}
			conn = DriverManager.getConnection(url, user, pass);
		}
	}

	public void desconectar() throws SQLException {
		if (!conn.isClosed() && conn != null) {
			conn.close();
		}
	}

	public Connection getConn() {
		return conn;
	}

}