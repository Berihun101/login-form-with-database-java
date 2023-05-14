package com.example.student_registrationandlogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/com/example/student_registrationandlogin/registration"));
        scene.getStylesheets().add(getClass().getResource("/styleSheets/css.css").toExternalForm());
        stage.setTitle("Student App");
        // Image image = new Image("/images/android.png");
        // stage.getIcons().add(image);  //Set Icon for the App
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    public static void sceneFactory(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().sizeToScene();
    }
    private static Parent loadFXML(String fxml) throws IOException {
        return FXMLLoader.load(App.class.getResource(fxml+".fxml"));
    }
}