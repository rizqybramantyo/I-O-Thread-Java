package testCRUDIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
	private final String user = "hr";
	private final String password = "hr";
	Connection con = null;
	public Koneksi(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection open() throws SQLException {
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", user, password);
		return con;
	}
	public void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
