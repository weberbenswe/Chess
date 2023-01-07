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
 * Init Chess Program and load board for play, also allows user to select
 * options menu
 */
public class App extends Application {

    private static Scene scene;
    private static final String MAIN_CLASS = "main.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(MAIN_CLASS)));
        Scene scene = new Scene(root);

        stage.getIcons().add(getIcon());
        stage.setTitle("Home Chess");

        stage.setScene(scene);
        stage.show();
    }

    public static Image getIcon() {
            return new Image(Objects.requireNonNull(App.class.getResourceAsStream("/images/programIcon.png")));
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}