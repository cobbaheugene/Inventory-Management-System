package controllers;
import java.sql.*;

public class MySqlConnector {

    public static  Connection getConnection()  throws SQLException {
        String url = "http://localhost/phpmyadmin/index.php?route=/database/structure&db=Tugaventory";//"jdbc:mysql://localhost:3306/struct";
//        String username ="";
//        String password ="12345";russell

//        Connection connection = DriverManager.getConnection(url, username, password);
        Connection connection = DriverManager.getConnection(url);

        return  connection;
    }
}

