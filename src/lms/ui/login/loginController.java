package lms.ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lms.db.checkUsernamePassword;
import application.Main;

public class loginController {

	private checkUsernamePassword userANDpassword;
	
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    
    @FXML
    private Button cancelButton;

    @FXML
    void onCancelClick(ActionEvent event) {
    	System.out.println("Cancel");
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void onLoginClick(ActionEvent event) {
    	userANDpassword = new checkUsernamePassword(username.getText(), password.getText());
    	if(userANDpassword.check() == true) {
    		System.out.println("nice");
    	}
    	else
    		System.out.println("Incorret");
    }
    

}


