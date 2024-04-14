module com.example.repo9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repo9 to javafx.fxml;
    exports com.example.repo9;
}