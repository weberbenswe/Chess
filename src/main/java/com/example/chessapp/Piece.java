package com.example.chessapp;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.*;

public class Piece extends ImageView {
    boolean successfulMove= false;
    String color, type;
    int x, y, position;
    double startDragX, startDragY;
    double startPosX, startPosY;
    HashSet<Integer> possibleMoves;
    ArrayList<Square> squares = ChessBoard.getSquares();
    ArrayList<Square> highLightedSquares;



    public Piece(String color, int x, int y, int startPos){
        this.color = color;
        this.x = x;
        this.y = y;
        this.position = startPos;
        this.possibleMoves = new HashSet<>();
        this.pieceInteraction();
    }

    public int getPosition(){
        return this.position;
    }

    public void setPiece(Image image){
        this.setImage(image);
    }

    public void setImage(){
        String resourceStream = "/images/" + "" + this.color + "" + this.type + "" + ".png";
        this.setPiece(new Image(Objects.requireNonNull(App.class.getResourceAsStream(resourceStream))));
    }

    public void pieceInteraction(){
        // Selecting Piece
        this.setOnMousePressed(mouseEvent -> {
            this.getParent().setViewOrder(-1);
            System.out.println("Piece: X: " + this.x + " Y: " + this.y + " Type: " + this.type + " Position: " + this.position);
            getPossibleMoves();
            highlightMoves(possibleMoves);
            System.out.println("Possible Moves: " + possibleMoves);
            startDragX = mouseEvent.getSceneX();
            startDragY = mouseEvent.getSceneY();
        });

        // Moving Piece
        this.setOnMouseDragged(mouseEvent -> {
            getPossibleMoves();
            highlightMoves(possibleMoves);
            this.setTranslateX(mouseEvent.getSceneX() - startDragX);
            this.setTranslateY(mouseEvent.getSceneY() - startDragY);
        });

        // Releasing piece
        this.setOnMouseReleased(mouseEvent -> {
            resetSquares();
            this.toFront();
            if(!successfulMove){
                this.setTranslateX(startPosX);
                this.setTranslateY(startPosY);
            }
        });
    }

    public void getPossibleMoves() {
        highlightMoves(possibleMoves);
    }

    public void highlightMoves(HashSet<Integer> possibleMoves){
        Color highlightColor = Color.rgb(144, 238, 144);
        highLightedSquares = new ArrayList<>();
        if(possibleMoves.isEmpty()){
            return;
        }

        for(Square square : squares){
            highLightedSquares.add(square);
            int name = square.getName();
            if(possibleMoves.contains(name)){
                square.setBackground(new Background(new BackgroundFill(highlightColor, null, null)));
                square.setEffect(new Glow(.5));
            }
        }
    }

    public void resetSquares(){
        Color black = Color.rgb(100, 85, 85);
        Color white = Color.rgb(255, 255, 255);
        for(Square square : highLightedSquares){
            if(square.backgroundColor == ChessBoard.WHITE){
                square.setBackground(new Background(new BackgroundFill(white, null, null)));
            } else {
                square.setBackground(new Background(new BackgroundFill(black, null, null)));
            }
            square.setEffect(null);
        }
    }
}
