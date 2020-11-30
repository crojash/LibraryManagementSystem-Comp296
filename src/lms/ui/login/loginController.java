package lms.ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lms.db.checkUsernamePassword;
import java.io.IOException;


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
    		if(username.getText().equalsIgnoreCase("Admin")){
    			try {
    				
					Parent librarian_root = FXMLLoader.load(getClass().getResource("/lms/ui/librarian/librarian.fxml"));
					Scene librarian_page = new Scene(librarian_root);
					Stage Main_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					Main_stage.setScene(librarian_page);
					Main_stage.centerOnScreen();
					Main_stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	if(userANDpassword.check() == true) {
    		System.out.println("nice");
    		if(username.getText().equalsIgnoreCase("Member")){
    			try {
					Parent member_root = FXMLLoader.load(getClass().getResource("/lms/ui/member/member.fxml"));
					Scene member_page = new Scene(member_root);
					Stage Main_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					Main_stage.setScene(member_page);
					Main_stage.centerOnScreen();
					Main_stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	else {
    		System.out.println("Incorret");
    	}

    }
    

}


