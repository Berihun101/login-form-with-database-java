package com.example.student_registrationandlogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class registrationController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}