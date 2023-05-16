package com.example.student_registrationandlogin;
import java.sql.*;
public class DatabaseConnection {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/sims";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private Connection connection;
    private Statement stmt;
    private ResultSet result;


    public DatabaseConnection(String query) {

    }

    public int DatabaseConnection(String query) throws SQLException, ClassNotFoundException{
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        stmt = connection.createStatement();
        if(stmt.executeUpdate(query) == 1){
            return 1;
        }
        else{
            return  0;
        }



    }

    public void close() throws SQLException {
        connection.close();
    }
}


//
//    ResultSet result= stmt.executeQuery(sql); //the result of the connection on the database set in the resultset class;
//
//        while(result.next()){
//                System.out.println(result.getInt(1));
//                System.out.println(result.getString(2));
//                System.out.println(result.getString(3));
//
//                }
//
////      Dagm
//
//                int id;
//                String name;
//                String Dep;
//
//                System.out.println("Enter your name?");
//                name=input.next();
//                System.out.println("Enter your ID ");
//                id=input.nextInt();
//                System.out.println("Enter your department");
//                Dep= input.next();
//
//                String query3= "insert into Student (ID, Name, Department) values("+id+", '"+name+"', '"+Dep+"')";
//                if(stmt.executeUpdate(query3) == 1){
//                System.out.println("Data created successfully!");
//                }else{
//                System.out.println("Failed to create Data!");