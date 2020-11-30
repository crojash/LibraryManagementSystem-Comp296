package lms.ui.librarian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lms.db.Student;

public class addStudentController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelClick(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    void onConfirmClick(ActionEvent event) {
    	Student st1 = new Student(firstName.getText(), lastName.getText(), email.getText());
    	st1.insertStudent();
    	closeWindow();
    }
    
    void closeWindow() {
    	System.out.println("Cancel");
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    }

}
