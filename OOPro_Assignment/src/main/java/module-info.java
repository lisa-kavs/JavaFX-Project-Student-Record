module com.example.oopro_assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oopro_assignment to javafx.fxml;
    exports com.example.oopro_assignment;
}