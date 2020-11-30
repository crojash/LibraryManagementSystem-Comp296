package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("/lms/ui/login/login.fxml"));
			//root.getStylesheets().add("/application/test.css");
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			//primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("Login Screen");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
