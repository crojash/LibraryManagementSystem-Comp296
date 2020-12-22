package lms.ui.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lms.db.BookLending;
import lms.db.Connection_To_Server;

public class memberController {
	
	private Connection_To_Server conn = new Connection_To_Server();
	private static PreparedStatement preparedStatement = null;
	private Connection con;

    @FXML
    private TextField studentID;

    @FXML
    private TextField bookID;

    @FXML
    private TextField returnBookID;

    @FXML
    void issueBookOnCLick(ActionEvent event) {
    	BookLending bl1 = new BookLending(Integer.parseInt(studentID.getText()), Integer.parseInt(bookID.getText()));
    	if(!bl1.issueBook()) {
    		System.out.println("Not Nice");
    	}
    	else {
    		System.out.println("Nice");
    	} 
    	studentID.clear();
    	bookID.clear();
    }

    @FXML
    private void returnBookOnClick(ActionEvent event) {
    	try {
    		con = conn.getConnectiontoDB();
    		String query = "SELECT bb_date, return_date FROM Books_Borrowed WHERE bookID = ?";
    		preparedStatement = con.prepareStatement(query);
    		preparedStatement.setInt(1, Integer.parseInt(returnBookID.getText()));
    		preparedStatement.execute();
    		ResultSet rs = preparedStatement.getResultSet();
    		while(rs.next()) {
    			if(rs.getDate("return_date").compareTo(rs.getDate("bb_date")) < 0) {
    			System.out.println("Not Nice");
    		}
    		else {
    			BookLending bl2 = new BookLending();
    			bl2.returnBook(Integer.parseInt(returnBookID.getText()));
    			System.out.println("Nice");
    			returnBookID.clear();
    		}
    		}

    	}
    	catch(SQLException ex) {
    		System.out.println(ex.toString());
    	}
    	
    }

    @FXML
    void viewBookOnClick(ActionEvent event) {
    	openWindow("/lms/ui/member/viewBooks.fxml");
    	//viewBooksController.populateBookView();
    }

    @FXML
    void viewStudentOnClick(ActionEvent event) {
    	openWindow("/lms/ui/member/viewStudents.fxml");
    }

    @FXML
    void viewTransactionOnClick(ActionEvent event) {

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

}
