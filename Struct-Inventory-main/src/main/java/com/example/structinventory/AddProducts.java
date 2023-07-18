package com.example.structinventory;

import controllers.ManageGoods;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Good;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class AddProducts implements Initializable {
    @FXML
    private DatePicker date;

    @FXML
    private TextField productName1;
    @FXML
    private TextField quantity1;
    @FXML
    private TextField buyingPrice1;
    @FXML
    private TextField sellingPrice1;
    @FXML
    private TextField grossPrice1;
    @FXML
    private TextField productName2;
    @FXML
    private TextField quantity2;
    @FXML
    private TextField buyingPrice2;
    @FXML
    private TextField sellingPrice2;
    @FXML
    private TextField grossPrice2;



    @FXML
    private ComboBox categories;

    Stack<Good> productStack = new Stack<Good>();
    int stackIndex = 0;

    Queue<Good> productQueue = new LinkedList<Good>();
    int queueIndex = 0;

    List<Good> productList = new ArrayList<Good>();
    int listIndex = 0;


    ObservableList<String> categoryList = FXCollections.observableArrayList("Beverages", "Bread/Bakery", "Canned Goods",
            "Dairy", "Baking goods", "Frozen Foods", "Meat", "Produce", "Cleaners", "Paper Goods", "Personal Care");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categories.setValue("Beverages");
        categories.setItems(categoryList);
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        String _category = categories.getSelectionModel().getSelectedItem().toString();

        String _productName1 = productName1.getText();
        int _quantity1 = Integer.parseInt(quantity1.getText());
        double _sellingPrice1 = Double.parseDouble(sellingPrice1.getText());
        double _buyingPrice1 = Double.parseDouble(buyingPrice1.getText());
        double _grossPrice1 = Double.parseDouble(grossPrice1.getText());

        String _productName2 = productName2.getText();
        int _quantity2 = Integer.parseInt(quantity2.getText());
        double _sellingPrice2 = Double.parseDouble(sellingPrice2.getText());
        double _buyingPrice2 = Double.parseDouble(buyingPrice2.getText());
        double _grossPrice2 = Double.parseDouble(grossPrice2.getText());

        Good good1 = new Good(_category, _productName1, _quantity1, _buyingPrice1, _sellingPrice1, _grossPrice1);
        Good good2 = new Good(_category, _productName2, _quantity2, _buyingPrice2, _sellingPrice2, _grossPrice2);

        if (categories.getSelectionModel().getSelectedIndex()  >=0 && categories.getSelectionModel().getSelectedIndex() < 5) {
            productStack.push(good1);
            productStack.push(good2);
            this.stackIndex += 2;
        }

        else if (categories.getSelectionModel().getSelectedIndex()  >=5 && categories.getSelectionModel().getSelectedIndex() < 8) {
            productQueue.add(good1);
            productQueue.add(good2);
            this.queueIndex +=2;
        }

        else {
            productList.add(listIndex, good1);
            productList.add(listIndex + 1, good2);
            this.listIndex += 2;
        }

    System.out.println(categories.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void remove(ActionEvent actionEvent) {

    }

    @FXML
    private void save(ActionEvent actionEvent) {
        ManageGoods manageGoods = new ManageGoods();

        if (categories.getSelectionModel().getSelectedIndex()  >=0 && categories.getSelectionModel().getSelectedIndex() < 5) {
            manageGoods.addGoodWithStack(productStack, this.stackIndex);
        }

        else if (categories.getSelectionModel().getSelectedIndex()  >=5 && categories.getSelectionModel().getSelectedIndex() < 8) {
            manageGoods.addGoodWithQueue(productQueue, this.queueIndex);
        }

        else {
            manageGoods.addGoodWithList(productList, this.stackIndex);
        }

        System.out.println("done");
    }

    public void removeFromStack() {
        try {
            this.productStack.pop();
            stackIndex = stackIndex -1;
        }
        catch (Exception ex) {
            System.out.println(""+ex);
        }
    }

    public  void removeFromQueue() {
        try {
            this.productQueue.remove();
            queueIndex = stackIndex -1;
        }

        catch (Exception ex) {
            System.out.println("" + ex);
        }

    }

    public void removeFromList() {
        try {
            this.productList.remove(listIndex);
            listIndex = listIndex - 1;
        }

        catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
}

