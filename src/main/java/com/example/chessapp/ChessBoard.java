package com.example.chessapp;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;

import javafx.geometry.Point3D;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ChessBoard {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    private static final ArrayList<Square> squares = new ArrayList<>();
    private static final HashMap<Integer, Square> squaresMap = new HashMap<>();
    private int[][] matrix;
    GridPane chessBoard;

    public ChessBoard(GridPane chessBoard) {
        this.chessBoard = chessBoard;
        makeBoard(this.chessBoard);
    }

    private void makeBoard(GridPane chessBoard) {
        loadMatrix();
        for (int i=0; i<matrix[0].length; i++) {
            for (int j=0; j<matrix.length; j++) {
                Square square = new Square(i, j, matrix[j][i]);
                square.setPrefHeight(100);
                square.setPrefWidth(100);
                square.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                setColor(square, j, i);
                chessBoard.add(square, i, j);
                squares.add(square);
                squaresMap.put(square.getName(), square);
            }
        }
        addPieces();
    }

    private void addPieces(){
        //loop through squares assigning each square a piece
        for(Square square : squares){
            if(square.occupied){
                continue;
            }

            // Placing the white pieces
            if(square.y == 0){
                switch (square.x) {
                    case 0, 7 -> addPiece(square, new Rook(WHITE, square.x, square.y, square.getName()));
                    case 1, 6 -> addPiece(square, new Knight(WHITE, square.x, square.y, square.getName()));
                    case 2, 5 -> addPiece(square, new Bishop(WHITE, square.x, square.y, square.getName()));
                    case 3 -> addPiece(square, new King(WHITE, square.x, square.y, square.getName()));
                    case 4 -> addPiece(square, new Queen(WHITE, square.x, square.y, square.getName()));
                }
            }
            if(square.y == 1){
                addPiece(square, new Pawn(WHITE, square.x, square.y, square.getName()));
            }

            // Placing the black pieces
            if(square.y == 6){
                addPiece(square, new Pawn(BLACK, square.x, square.y, square.getName()));
            }
            if(square.y == 7){
                switch(square.x){
                    case 0, 7 -> addPiece(square, new Rook(BLACK, square.x, square.y, square.getName()));
                    case 1, 6 -> addPiece(square, new Knight(BLACK, square.x, square.y, square.getName()));
                    case 2, 5 -> addPiece(square, new Bishop(BLACK, square.x, square.y, square.getName()));
                    case 3 -> addPiece(square, new King(BLACK, square.x, square.y, square.getName()));
                    case 4 -> addPiece(square, new Queen(BLACK, square.x, square.y, square.getName()));
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
            square.backgroundColor = WHITE;
        } else {
            square.setBackground(new Background(new BackgroundFill(black, null, null)));
            square.backgroundColor = BLACK;
        }
    }

    public static ArrayList<Square> getSquares(){
        return squares;
    }

    public static HashMap<Integer, Square> getSquaresMap(){
        return squaresMap;
    }

    private void loadMatrix(){
        this.matrix = new int[][]{
                {0, 1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20, 21, 22, 23},
                {24, 25, 26, 27, 28, 29, 30, 31},
                {32, 33, 34, 35, 36, 37, 38, 39},
                {40, 41, 42, 43, 44, 45, 46, 47},
                {48, 49, 50, 51, 52, 53, 54, 55},
                {56, 57, 58, 59, 60, 61, 62, 63}
        };
    }
}

