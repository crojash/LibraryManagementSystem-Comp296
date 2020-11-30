package lms.ui.librarian;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lms.db.Connection_To_Server;

public class librarianController {
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
    private TableColumn edit;

    @FXML
    void addBookOnAction(ActionEvent event) {
    	openWindow("/lms/ui/librarian/addBook.fxml");
    }

    @FXML
    void addStudentOnACtion(ActionEvent event) {
    	openWindow("/lms/ui/librarian/addStudent.fxml");
    }

    @FXML
    void deleteBookOnAction(ActionEvent event) {
    	openWindow("/lms/ui/librarian/deleteBook.fxml");
    }

    @FXML
    void deleteStudentOnAction(ActionEvent event) {
    	openWindow("/lms/ui/librarian/deleteStudent.fxml");
    }
    @FXML
    void updateOnClick(ActionEvent event) {
    	populateBookView();
    }
    void openWindow(String path){
    	try {
    		Parent root = FXMLLoader.load(Main.class.getResource(path));
    		Stage stage = new Stage();
    		stage.initModality(Modality.APPLICATION_MODAL);
    		stage.centerOnScreen();
    		stage.setScene(new Scene(root));
    		//stage.showAndWait();
    		stage.show();
    	} catch (IOException e) {
			e.printStackTrace();
		}
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
				bv.setbookId(rs.getInt("BookId"));
				bv.setTitle(rs.getString("Title"));
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
			availability.setCellValueFactory(new PropertyValueFactory<>("availavility"));
			bookView.setItems(list);
		}
		catch(SQLException ex) {
			System.out.println(ex.toString());
		}
	}

}
