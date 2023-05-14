package com.example.student_registrationandlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class registrationController {

    @FXML
    private Hyperlink loginLink;

    @FXML
    private TextField yearOfStud;

    @FXML
    private TextField nameOfStud;

    @FXML
    private TextField depOfStud;

    @FXML
    private TextField idOfStud;

    @FXML
    private Button registerbtn;

    @FXML
    private Hyperlink createAccount;

    @FXML
    private Label successlbl;
    @FXML
    void toLoginPage(ActionEvent event) throws IOException {
        App.sceneFactory("/com/example/student_registrationandlogin/login");
    }
    @FXML
    void toCreateAccountPage(ActionEvent event) throws IOException {
        App.sceneFactory("/com/example/student_registrationandlogin/CreateAccount");
    }
    @FXML
    void registerStudent(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
      String name = nameOfStud.getText();
      int id = Integer.parseInt(idOfStud.getText());
      String department = depOfStud.getText();
      int year =Integer.parseInt(yearOfStud.getText());

      String query = "insert into studentinfo (Name, ID, Department, year) values('\"+name+\"', \"+id+\", '\"+department+\"', \"+year+\" )\";" ;
      DatabaseConnection value = new DatabaseConnection(query);
      if(value.DatabaseConnection(query) == 1){
          successlbl.setText("Registered successfully!");
      }else{
          successlbl.setText("Error in creating the database!");
      }
    }
}
