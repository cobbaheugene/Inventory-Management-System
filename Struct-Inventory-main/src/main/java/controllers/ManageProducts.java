package controllers;

import controllers.MySqlConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Good;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ManageProducts implements Initializable {

    @FXML
    private TableView<Good> table;
    @FXML
    private TableColumn<Good, String> column_category;
    @FXML
    private TableColumn<Good, String> column_name;
    @FXML
    private TableColumn<Good, String> column_buyingPrice;
    @FXML
    private TableColumn<Good, String> column_sellingPrice;
    @FXML
    private TableColumn<Good, String> column_grossPrice;
    @FXML
    private TableColumn<Good, String> column_quantity;

    ObservableList<Good> oblist = FXCollections.observableArrayList();

    @Override
    public  void initialize(URL location, ResourceBundle resourceBundle) {

        try {
            Connection connection = MySqlConnector.getConnection();

            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM goods");

            while (rs.next()) {
                oblist.add(new Good(rs.getString("category"),rs.getString("name"), rs.getInt("quantity"), Double.parseDouble(rs.getString("buyingPrice")), Double.parseDouble(rs.getString("sellingPrice")), Double.parseDouble(rs.getString("grossPrice"))));
            }
        }

        catch (Exception e) {

        }

            column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            column_buyingPrice.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
            column_sellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
            column_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
             column_category.setCellValueFactory(new PropertyValueFactory<>("category"));
            column_grossPrice.setCellValueFactory(new PropertyValueFactory<>("grossPrice"));

            table.setItems(oblist);

    }
}
