package lms.ui.librarian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lms.db.Student;

public class deleteStudentController {

    @FXML
    private TextField studentID;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelClick(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    void onConfirmClick(ActionEvent event) {
    	Student st1 = new Student();
    	st1.deleteStudent(Integer.parseInt(studentID.getText()));
    	closeWindow();
    }
    
    void closeWindow() {
    	System.out.println("Cancel");
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    }

}
