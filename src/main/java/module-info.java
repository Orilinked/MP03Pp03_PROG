module com.example.mp03pp03_prog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mp03pp03_prog to javafx.fxml;
    exports com.example.mp03pp03_prog;
}