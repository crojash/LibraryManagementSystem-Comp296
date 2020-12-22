package lms.ui.member;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentView {
	
	private final IntegerProperty studentID = new SimpleIntegerProperty();
	private final StringProperty firstName = new SimpleStringProperty();
	private final StringProperty lastName = new SimpleStringProperty();
	private final StringProperty email = new SimpleStringProperty();
	
	public int getStudentID() {
		return studentID.get();
	}
	
	public void setStudentID(int value) {
		studentID.set(value);
	}
	
	public IntegerProperty studentIDProperty() {
		return studentID;
	}
	
	public String getFirstName() {
		return firstName.get();
	}
	
	public void setFirstName(String value) {
		firstName.set(value);
	}
	
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName.get();
	}
	
	public void setLastName(String value) {
		lastName.set(value);
	}
	
	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	public String getEmail() {
		return email.get();
	}
	
	public void setEmail(String value) {
		email.set(value);
	}
	
	public StringProperty emailProperty() {
		return email;
	}
}
