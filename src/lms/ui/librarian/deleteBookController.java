package lms.ui.librarian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lms.db.Book;

public class deleteBookController {

    @FXML
    private TextField bookID;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelClick(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    void onConfirmClick(ActionEvent event) {
    	Book b1 = new Book();
    	b1.deleteBook(Integer.parseInt(bookID.getText()));
    	closeWindow();
    }

    void closeWindow() {
    	System.out.println("Cancel");
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    }
}
