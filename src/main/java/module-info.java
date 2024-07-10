module com.example.canvastutorial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.canvastutorial to javafx.fxml;
    exports com.example.canvastutorial;
}