package com.example.chessapp;

import javafx.scene.layout.GridPane;

public class Game {

    public static GridPane chessBoard;
    public static ChessBoard cb;

    public Game(GridPane chessBoard) {
        cb = new ChessBoard(chessBoard);
    }

}
