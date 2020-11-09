package lms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {

	private Connection_To_Server conn = new Connection_To_Server();
	private static PreparedStatement preparedStatement = null;
	private Connection con;
	private String title;
	private String ISBN;
	private String author;
	private String genre;
	private String publisher;

	public Book(){
		con = conn.getConnectiontoDB();
	}
	
	public Book(String title, String ISBN, String author, String genre, String publisher) {
		this.title = title;
		this.ISBN = ISBN;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		con = conn.getConnectiontoDB();
	}
	
	public Boolean insertBook() {
		try {
			String query = "INSERT INTO Books (book_title, ISBN, isAvail) VALUES (?, ?, ?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, this.title);
			preparedStatement.setString(2, this.ISBN);
			preparedStatement.setBoolean(3, true);
			preparedStatement.execute();
			insertAuthor(this.author);
			insertGenre(this.genre);
			insertPublisher(this.publisher);
			return true;
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}
	
	public Boolean insertAuthor(String Author) {
		try {
			String query = "INSERT INTO Authors (author_Name) VALUES(?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, Author);
			preparedStatement.execute();
			insertAuthorMTM(Author);
			return true;
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}

	public Boolean insertAuthorMTM(String author){
		try{
			String query = "SELECT * FROM Authors WHERE author_name = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, author);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.getResultSet();
			int authorID = 0;
			while(rs.next()) {
				authorID = rs.getInt(1);
			}
			query = "SELECT * FROM books WHERE book_title = ? AND ISBN = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, this.title);
			preparedStatement.setString(2, this.ISBN);
			preparedStatement.execute();
			ResultSet rx = preparedStatement.getResultSet();
			int bookID = 0;
			while(rx.next()){
				bookID = rx.getInt(1);
			}
			query = "INSERT INTO book_authors VALUES(?, ?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, bookID);
			preparedStatement.setInt(2, authorID);
			preparedStatement.execute();
			
			return true;
		}
		catch(SQLException ex){
			System.out.println(ex.toString());
		}
		return false;
	}

	public Boolean insertGenre(String Genre) {
		try {
			String query = "INSERT INTO genres (genre) VALUES(?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, Genre);
			preparedStatement.execute();
			return true;
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}

	public boolean insertPublisher(String Publisher){
		try{
			String query = "INSERT INTO publishers (pub_name) VALUES(?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, Publisher);
			preparedStatement.execute();
			return true;
		}
		catch(SQLException ex){
			System.out.println(ex.toString());
		}
		return false;
	}
	//still needs Work
	public Boolean deleteBook(int bookID) {
		try{
			String query = "DELETE FROM Books WHERE bookID = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, bookID);
			preparedStatement.execute();
			return true;
		}
		catch(SQLException ex){
			System.out.println(ex.toString());
		}
		return false;
	}
		
}
