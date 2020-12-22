package lms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookLending {

	private Connection_To_Server conn = new Connection_To_Server();
	private Connection con;
	private static PreparedStatement preparedStatement = null;
	private int studentID;
	private int bookID;
	protected final int return_Days = 15;
	protected final double initial_Fine = .50;
	
	public BookLending() {
		con = conn.getConnectiontoDB();
	}
	
	public BookLending(int studentID, int bookID) {
		this.bookID = bookID;
		this.studentID = studentID;
		con = conn.getConnectiontoDB();
	}
	
	public Boolean issueBook() {
		try {
			int count = 0;
			String queryT = "SELECT * FROM Books_Borrowed WHERE studentID = ?";
			preparedStatement = con.prepareStatement(queryT);
			preparedStatement.setInt(1, this.studentID);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.getResultSet();
			while(rs.next()) {
				++count;
			}
			if(count < 5) {
			
				LocalDate today = LocalDate.now();
				String query = "INSERT INTO Books_Borrowed VALUES (?, ?, ?, ?, ?)";
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, this.bookID);
				preparedStatement.setInt(2, this.studentID);
				preparedStatement.setString(3, "" + today);
				preparedStatement.setString(4, "" + today.plusDays(return_Days));
				preparedStatement.setDouble(5, initial_Fine);
				preparedStatement.execute();
				return true;
			}
			else
				return false;
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}
	
	public boolean returnBook(int bookID) {
		try {
			String query = "DELETE FROM Books_Borrowed WHERE bookID = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, bookID);
			preparedStatement.execute();
			return true;
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}
}
