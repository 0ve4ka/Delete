module org.example.perevozki {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires javafx.swing;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires org.hibernate.validator;
    requires org.postgresql.jdbc;


    opens org.example.perevozki to javafx.fxml;
    exports org.example.perevozki;
    exports org.example.perevozki.controllers;
    opens  org.example.perevozki.controllers to javafx.fxml;
    exports org.example.perevozki.repositories;
    opens org.example.perevozki.repositories to javafx.fxml;
    opens org.example.perevozki.util to org.hibernate.orm.core;
    opens org.example.perevozki.models to org.hibernate.orm.core, javafx.base;



}