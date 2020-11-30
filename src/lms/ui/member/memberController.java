package lms.ui.member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lms.db.BookLending;

public class memberController {

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
    void returnBookOnClick(ActionEvent event) {
    	BookLending bl2 = new BookLending();
    	bl2.returnBook(Integer.parseInt(returnBookID.getText()));
    	System.out.println("Nice");
    	returnBookID.clear();
    }

    @FXML
    void viewBookOnClick(ActionEvent event) {

    }

    @FXML
    void viewStudentOnClick(ActionEvent event) {

    }

    @FXML
    void viewTransactionOnClick(ActionEvent event) {

    }

}
