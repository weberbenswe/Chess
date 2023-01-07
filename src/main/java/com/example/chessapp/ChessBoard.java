package com.example.chessapp;

import java.util.ArrayList;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ChessBoard {
    private final String WHITE = "white";
    private final String BLACK = "black";
    GridPane chessBoard;
    public ArrayList<Square> squares = new ArrayList<Square>();

    public ChessBoard(GridPane chessBoard) {
        this.chessBoard = chessBoard;
        makeBoard(this.chessBoard);
    }

    private void makeBoard(GridPane chessBoard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square(i, j);
                square.setPrefHeight(100);
                square.setPrefWidth(100);
                square.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                setColor(square, j, i);
                chessBoard.add(square, i, j, 1, 1);
                squares.add(square);
            }
        }
        addPieces();
    }

    private void addPieces(){
        //loop through squares assigning each square a piece
        for(Square square : squares){
            if(square.occupied){
                continue;
            }ss

            // Placing the white pieces
            if(square.y == 0){
                switch (square.x) {
                    case 0, 7 -> addPiece(square, new Rook(WHITE, square.x, square.y));
                    case 1, 6 -> addPiece(square, new Knight(WHITE, square.x, square.y));
                    case 2, 5 -> addPiece(square, new Bishop(WHITE, square.x, square.y));
                    case 3 -> addPiece(square, new King(WHITE, square.x, square.y));
                    case 4 -> addPiece(square, new Queen(WHITE, square.x, square.y));
                }
            }
            if(square.y == 1){
                addPiece(square, new Pawn(WHITE, square.x, square.y));
            }

            // Placing the black pieces
            if(square.y == 6){
                addPiece(square, new Pawn(BLACK, square.x, square.y));
            }
            if(square.y == 7){
                switch(square.x){
                    case 0, 7 -> addPiece(square, new Rook(BLACK, square.x, square.y));
                    case 1, 6 -> addPiece(square, new Knight(BLACK, square.x, square.y));
                    case 2, 5 -> addPiece(square, new Bishop(BLACK, square.x, square.y));
                    case 3 -> addPiece(square, new King(BLACK, square.x, square.y));
                    case 4 -> addPiece(square, new Queen(BLACK, square.x, square.y));
                }
            }
        }
    }

    private void addPiece(Square square, Piece piece) {
        square.getChildren().add(piece);
        square.occupied = true;
    }

    private void setColor(Square square, int x, int y) {
        Color black = Color.rgb(100, 85, 85);
        Color white = Color.rgb(255, 255, 255);

        if ((x + y) % 2 == 0) {
            square.setBackground(new Background(new BackgroundFill(white, null, null)));
        } else {
            square.setBackground(new Background(new BackgroundFill(black, null, null)));
        }
    }
}

