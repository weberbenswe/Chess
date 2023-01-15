package com.example.chessapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Init Chess Program and load board for play
 */
public class App extends Application {

    private static Scene scene;
    private static final String MAIN_CLASS = "main.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(MAIN_CLASS)));
        Scene scene = new Scene(root);

        stage.getIcons().add(getIcon());
        stage.setTitle("Chess");

        stage.setScene(scene);
        stage.show();
    }

    public static Image getIcon() {
            return new Image(Objects.requireNonNull(App.class.getResourceAsStream("/images/programIcon.png")));
    }

    public static void main(String[] args) {
        launch();
    }
}