module com.example.student_registrationandlogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.student_registrationandlogin to javafx.fxml;
    exports com.example.student_registrationandlogin;
}