import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class copy {
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
