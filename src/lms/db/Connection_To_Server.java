package lms.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_To_Server {

	private String Host = "com.mysql.jdbc.Driver";
	private Connection conn;
	
	public void Connection_to_Server(){
		LoadClass();
	}
	
	private void LoadClass() {
		try {
			Class.forName(Host);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public Connection getConnectiontoDB() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/LMS", "root", "");
			//System.out.println("Database connected\n");
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		return conn;
	}
	
}
