package lms.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testDBandCheck {

	public static void main(String[] args) {
		Connection_To_Server conn = new Connection_To_Server();
		Connection con = conn.getConnectiontoDB();
		/*checkUsernamePassword test = new checkUsernamePassword("", "");
		test.setUsername("Admin");
		test.setPassword("1234");
		System.out.println(test.check());*/
		String username = "Admin";
		String password = "1234";
		String query = "SELECT * FROM Users WHERE "
				+ "username = '" + username + "' AND password1 = PASSWORD('" + password + "')";
		try {
			ResultSet rx = con.createStatement().executeQuery(query);
			if(rx.next()) {
				System.out.println(rx.getString("username") + " " + rx.getString("password1"));
			}
			else
				System.out.println("Not found");
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
	

	}

}
