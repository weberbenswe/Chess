package com.example.chessapp;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * Runs fxml, loading chessboard
 * */
public class Controller {

    @FXML
    GridPane chessBoard;

    public void initialize() {
        Game game = new Game(chessBoard);
    }
}
