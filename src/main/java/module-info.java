module com.example.chessapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens com.example.chessapp to javafx.fxml;
    exports com.example.chessapp;
}