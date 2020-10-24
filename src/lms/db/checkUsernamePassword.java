package lms.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkUsernamePassword {
	private Connection_To_Server conn = new Connection_To_Server();
	private Connection con;
	private String username;
	private String password;

	public checkUsernamePassword(String username, String password) {
		this.username = username;
		this.password = password;
		con = conn.getConnectiontoDB();
	}
	//Still working on Password
	public Boolean check() {
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Users WHERE "
					+ "username = '" + username + "' AND password1 = PASSWORD('" + password + "')");
			while(rs.next()) {
				if(username.equalsIgnoreCase(rs.getString("username"))) {
					return true;
				}
				else
					System.out.println("Not Found");
			}
			//or if(rs.next())
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
	return false;
	}
}
