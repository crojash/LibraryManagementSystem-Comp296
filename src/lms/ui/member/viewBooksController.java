package lms.ui.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.db.Connection_To_Server;
import lms.ui.librarian.BookView;

public class viewBooksController {
	ObservableList<BookView> list;
	private Connection_To_Server conn = new Connection_To_Server();
	private static PreparedStatement preparedStatement = null;
	private Connection con;

    @FXML
    private TableView<BookView> bookView;

    @FXML
    private TableColumn<BookView, String> title;

    @FXML
    private TableColumn<BookView, Integer> bookID;

    @FXML
    private TableColumn<BookView, String> author;

    @FXML
    private TableColumn<BookView, String> publisher;

    @FXML
    private TableColumn<BookView, String> genre;

    @FXML
    private TableColumn<BookView, Boolean> availability;
    
    @FXML
    void updateOnClick(ActionEvent event) {
    	populateBookView();
    }

    private void populateBookView() {
    	try {
    		list = FXCollections.observableArrayList();
    		con = conn.getConnectiontoDB();
    		String query = "SELECT * FROM Book";
    		preparedStatement = con.prepareStatement(query);
    		preparedStatement.execute();
    		ResultSet rs = preparedStatement.getResultSet();
    		
    		while(rs.next()) {
    			BookView bv = new BookView();
    			bv.setTitle(rs.getString("Title"));
    			bv.setbookId(rs.getInt("BookId"));
    			bv.setAuthor(rs.getString("Author"));
    			bv.setPublisher(rs.getString("Publisher"));
    			bv.setGenre(rs.getString("Genre"));
    			bv.setAvailability(rs.getBoolean("availavility"));
    			list.add(bv);
    		}
    		
    		bookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
    		title.setCellValueFactory(new PropertyValueFactory<>("title"));
    		author.setCellValueFactory(new PropertyValueFactory<>("author"));
    		publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
    		genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    		availability.setCellValueFactory(new  PropertyValueFactory<>("availavility"));
    		bookView.setItems(list);
    		
    	}
    	catch(SQLException ex) {
    		System.out.println(ex.toString());
    	}
    }
}
