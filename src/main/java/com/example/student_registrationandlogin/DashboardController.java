package com.example.student_registrationandlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Label logoutbtn;

    @FXML
    private static Label navuser;

    @FXML
    void logout(ActionEvent event) throws IOException {
  App.sceneFactory("/com/example/student_registrationandlogin/Login");
    }

    public static void setUserName(String name){
      navuser.setText(name);
    }
}
