package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Good;
import models.Vendor;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class ManageVendor implements Initializable {

    public HashMap<String, List<Vendor>> vendorInfo = new HashMap<String, List<Vendor>>();

    @FXML
    private TableView<Vendor> table;
    @FXML
    private TableColumn<Vendor, String> column_name;
    @FXML
    private TableColumn<Good, String> column_email;
    @FXML
    private TableColumn<Good, String> column_username;
    @FXML
    private TableColumn<Good, String> column_password;

    ObservableList<Vendor> oblist = FXCollections.observableArrayList();

    @Override
    public  void initialize(URL location, ResourceBundle resourceBundle) {

        try {
            Connection connection = MySqlConnector.getConnection();

            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM vendors");

            while (rs.next()) {
                oblist.add(new Vendor(rs.getString("name"),rs.getString("username"), rs.getString("email"), rs.getString("password")));
            }
        }

        catch (Exception e) {

        }

        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        column_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        column_password.setCellValueFactory(new PropertyValueFactory<>("password"));

        table.setItems(oblist);

    }
}
