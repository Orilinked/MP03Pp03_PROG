module com.example.mp03pp03_prog {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mp03pp03_prog to javafx.fxml;
    exports com.example.mp03pp03_prog;
}