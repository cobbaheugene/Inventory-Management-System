package controllers;

import models.Good;

import java.sql.*;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ManageGoods {
    private String url = "http://localhost/phpmyadmin/index.php?route=/database/structure&db=Tugaventory";//"jdbc:mysql://localhost:3306/struct";
//    private String username ="russell";
//    private  String password ="12345";

    public void addGoodWithStack(Stack<Good> goods, int index) {
        try {

//            Connection connection = DriverManager.getConnection(url, username, password);
            Connection connection = DriverManager.getConnection(url);

            for(int i=0; i< index; i++) {
                Good good = goods.pop();
                String category = good.category;
                String name = good.name;
                int quantity = good.quantity;
                double buyingPrice = good.buyingPrice;
                double sellingPrice = good.sellingPrice;
                double grossPrice = good.grossPrice;

                PreparedStatement ps = connection.prepareStatement("INSERT INTO goods (category, name, quantity, buyingPrice, sellingPrice, grossPrice) VALUES ('" + category + "','" + name + "'," + quantity + "," + buyingPrice + "," + sellingPrice + "," + grossPrice + ")");
                ps.execute();

            }

            connection.close();
        }

        catch (Exception ex) {
            System.out.println("" + ex);
        }

    }

    public void addGoodWithQueue(Queue<Good> goods, int index) {
        try {

//            Connection connection = DriverManager.getConnection(url, username, password);
            Connection connection = DriverManager.getConnection(url);

            for(int i=0; i< index; i++) {
                Good good = goods.remove();
                String category = good.category;
                String name = good.name;
                int quantity = good.quantity;
                double buyingPrice = good.buyingPrice;
                double sellingPrice = good.sellingPrice;
                double grossPrice = good.grossPrice;

                PreparedStatement ps = connection.prepareStatement("INSERT INTO goods (category, name, quantity, buyingPrice, sellingPrice, grossPrice) VALUES ('" + category + "','" + name + "'," + quantity + "," + buyingPrice + "," + sellingPrice + "," + grossPrice + ")");
                ps.execute();
            }

            connection.close();
        }

        catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    public void addGoodWithList(List<Good> goods, int index) {
        try {

//            Connection connection = DriverManager.getConnection(url, username, password);
            Connection connection = DriverManager.getConnection(url);

            for(int i=0; i< index; i++) {
                Good good = goods.get(i);
                String category = good.category;
                String name = good.name;
                int quantity = good.quantity;
                double buyingPrice = good.buyingPrice;
                double sellingPrice = good.sellingPrice;
                double grossPrice = good.grossPrice;

                PreparedStatement ps = connection.prepareStatement("INSERT INTO goods (category, name, quantity, buyingPrice, sellingPrice, grossPrice) VALUES ('" + category + "','" + name + "'," + quantity + "," + buyingPrice + "," + sellingPrice + "," + grossPrice + ")");
                ps.execute();            }

            connection.close();
        }

        catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    public void connectDatabase() {

    }
}
