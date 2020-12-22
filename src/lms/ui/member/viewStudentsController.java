package lms.ui.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.db.Connection_To_Server;

public class viewStudentsController {
	ObservableList<studentView> list;
	private Connection_To_Server conn = new Connection_To_Server();
	private static PreparedStatement preparedStatement = null;
	private Connection con;

    @FXML
    private TableView<studentView> studentView;

    @FXML
    private TableColumn<studentView, Integer> studentID;

    @FXML
    private TableColumn<studentView, String> firstName;

    @FXML
    private TableColumn<studentView, String> lastName;

    @FXML
    private TableColumn<studentView, String> email;

    @FXML
    private TableColumn edit;
    
    @FXML
    void updateOnClick(ActionEvent event) {
    	populateStudentView();
    }

    private void populateStudentView() {
    	try {
    		list = FXCollections.observableArrayList();
    		con = conn.getConnectiontoDB();
    		String query = "SELECT * FROM students";
    		preparedStatement = con.prepareStatement(query);
    		preparedStatement.execute();
    		ResultSet rs = preparedStatement.getResultSet();
    		
    		while(rs.next()) {
    			studentView st = new studentView();
    			st.setStudentID(rs.getInt("studentID"));
    			st.setFirstName(rs.getString("student_first_name"));
    			st.setLastName(rs.getString("student_last_name"));
    			st.setEmail(rs.getString("student_email"));
    			list.add(st);
    		}
    		
    		studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
    		firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    		lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    		email.setCellValueFactory(new PropertyValueFactory<>("email"));
    		studentView.setItems(list);
    	}catch(SQLException ex) {
    		System.out.println(ex.toString());
    	}
    	
    }
}
