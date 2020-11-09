package lms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {

    private Connection_To_Server conn = new Connection_To_Server();
    private static PreparedStatement preparedStatement = null;
    private Connection con;
    private String firstName;
    private String lastName;
    private String email;

    public Student(){
        con = conn.getConnectiontoDB();
    }

    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        con = conn.getConnectiontoDB();
    }

    public Boolean insertStudent(){
        try{
            String query = "INSERT INTO students (student_first_name, student_last_name, student_email) VALUES(?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, this.firstName);
            preparedStatement.setString(2, this.lastName);
            preparedStatement.setString(3, this.email);
            preparedStatement.execute();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return false;
    }

    public Boolean deleteStudent(int studentID){
        try{
            String query = "DELETE FROM Students WHERE studentID = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,studentID);
            preparedStatement.execute();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return false;
    }
}
