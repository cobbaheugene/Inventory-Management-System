package com.example.structinventory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Good;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private CheckBox rememberMe;

    @FXML
    private Button register;

    public void login(ActionEvent event) {
        String _username = username.getText();
        String _password = password.getText();

        try {

//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/struct", "russell", "12345");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugaventory", "root", "");


            Statement statement= connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT email, name FROM vendors WHERE username= '" + _username + "' and password= '" + _password + "'");

            if (rs.next()) {
                navigateToDashboard();
            }

            connection.close();
        }

        catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    public  void tickCheck(ActionEvent actionEvent) {

    }

    public void navigateToDashboard() throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("addproducts.fxml"));

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Struct Inventory");
        Image icon = new Image(getClass().getResource("images/Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        String css = this.getClass().getResource("addproducts.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}