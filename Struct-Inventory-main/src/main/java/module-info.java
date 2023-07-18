module com.example.structinventory {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.structinventory to javafx.fxml;
    opens controllers to javafx.fxml;
    exports com.example.structinventory;
    exports models;
    exports controllers;
}