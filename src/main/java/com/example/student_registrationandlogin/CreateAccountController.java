/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import java.io.IOException;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mekdem's
 */
public class CreateAccountController implements Initializable {
    static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/sims";
    static String DB_USER = "root";
    static String DB_PASS = "";
    @FXML
    private Hyperlink goBackToLogin;
    @FXML
    private PasswordField tfConfirmPassword, tfPassword;
    @FXML
    private TextField tfUsername;
    @FXML
    Button btnCreate, btnClear;
    @FXML
    Label lblErrorMessage, lblSuccessMessage;
    
    
    @FXML
    public void addUser() throws IOException, SQLException, ClassNotFoundException{
        String key = tfUsername.getText();
        if(checkPassword() == true){                
             if(searchUser(key) == false){
                    String username = tfUsername.getText();
                    String password = tfPassword.getText();
                    Class.forName(DB_DRIVER);
                    Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                    PreparedStatement st = con.prepareStatement("insert into user (username, password) values (?, ?)");
                    st.setString(1, username);
                    st.setString(2, password);
                    lblErrorMessage.setText("");
                    lblSuccessMessage.setText("");
                    lblSuccessMessage.setText("User Succesfully added!");
                    st.executeUpdate();
                    st.close();
                    con.close();
            } 
            else {
                 System.out.println("User Exists!");
                 lblErrorMessage.setText("");
            lblSuccessMessage.setText("");
            lblErrorMessage.setText("A user with the same name already exists in the system.");
            tfUsername.clear();
            tfPassword.clear();
            tfConfirmPassword.clear();
            }
        } 
        else {
   
            
            lblErrorMessage.setText("");
                lblSuccessMessage.setText("");
                lblErrorMessage.setText("The two Passwords do not match!"); 
        }
    }
    @FXML
    public void clear() {
        tfUsername.setText("");
        tfPassword.setText("");
        tfConfirmPassword.setText("");
    }
       
    public static boolean searchUser(String key) throws ClassNotFoundException, SQLException {
        boolean userExists = false;
        Class.forName(DB_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        PreparedStatement st = con.prepareStatement("select * from user where username = ?");
        st.setString(1, key);
        ResultSet result = st.executeQuery();
        if (result.next())
            userExists = true;
        else 
            userExists = false;
        st.close();
        con.close();
        return userExists;
    }  
    public boolean checkPassword() {
        boolean isCorrect = false;
        if(tfPassword.getText().equals(tfConfirmPassword.getText()))
            isCorrect = true;           
        return isCorrect;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    } 
    
}
