package lms.ui.librarian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lms.db.Book;

public class addBookController {

    @FXML
    private TextField title;

    @FXML
    private TextField ISBN;

    @FXML
    private TextField genre;

    @FXML
    private TextField publisher;

    @FXML
    private TextField author;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelClick(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    void onConfirmClick(ActionEvent event) {
    	Book b1 = new Book(title.getText(), ISBN.getText(), author.getText(), genre.getText(), publisher.getText());
    	b1.insertBook();
    	closeWindow();
    }

    void closeWindow() {
    	System.out.println("Cancel");
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    }
}
