module org.example.controle2java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql;
    requires mysql.connector.j;

    opens org.example.controle2java to javafx.fxml;
    exports org.example.controle2java;
    exports org.example.controle2java.Controller;
    exports org.example.controle2java.Models;