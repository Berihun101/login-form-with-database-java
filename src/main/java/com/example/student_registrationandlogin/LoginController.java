/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.example.student_registrationandlogin;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author haile
 */
public class LoginController implements Initializable {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/sims";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private Connection connection;
    private Statement stmt;
    private ResultSet result;
    /**
     * Initializes the controller class.
     */
    @FXML
    private PasswordField password;

    @FXML
    private Button loginbtn;

    @FXML
    private TextField username;

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
     if (username.getText().equals("") || password.getText().equals("")){
         Shaker shaker = new Shaker(password);
         shaker.shake();
         Shaker shake1 = new Shaker(username);
         shake1.shake();

        }
     else{
         connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
      String usernameOfUser = username.getText();
      String passwordOfUser = password.getText();

    String query = "Select * from user where username = ?";
         PreparedStatement statement = connection.prepareStatement(query);
           statement.setString(1,usernameOfUser);
           ResultSet result =statement.executeQuery();
         if (result.next()) {
             String storepassword = result.getString("password");
             String storeduserName = result.getString("username");

             if(storepassword.equals(passwordOfUser) & storeduserName.equals(usernameOfUser)){
                 App.sceneFactory("/com/example/student_registrationandlogin/CreateAccount");
             }
             else{
                 Shaker shaker = new Shaker(username);
                 shaker.shake();
                 Shaker shaker1 = new Shaker(password);
                 shaker1.shake();
             }

         }
     }

     }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
