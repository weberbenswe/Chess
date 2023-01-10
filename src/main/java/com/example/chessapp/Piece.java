package com.example.chessapp;

import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.*;

// TODO: 1. add functionality to move piece to new location

public class Piece extends ImageView {
    String color, type;
    int x, y, position;
    double startDragX, startDragY, startPosX, startPosY, currX, currY;
    HashSet<Integer> possibleMoves;
    ArrayList<Square> squares = ChessBoard.getSquares();
    ArrayList<Square> highLightedSquares;
    Image image;



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

    public Image setPiece(Image image){
        this.setImage(image);
        return image;
    }

    public void setImage(){
        String resourceStream = "/images/" + "" + this.color + "" + this.type + "" + ".png";
        this.image = this.setPiece(new Image(Objects.requireNonNull(App.class.getResourceAsStream(resourceStream))));
    }

    public void pieceInteraction(){
        // Selecting Piece
        this.setOnMousePressed(mouseEvent -> {
            this.setMouseTransparent(true);
            startDragX = mouseEvent.getSceneX();
            startDragY = mouseEvent.getSceneY();
            this.getParent().setViewOrder(-1);
            getPossibleMoves();
            highlightMoves(possibleMoves);
            mouseEvent.consume();
        });

        // Moving Piece
        this.setOnMouseDragged(mouseEvent -> {
            this.setTranslateX(mouseEvent.getSceneX() - startDragX);
            this.setTranslateY(mouseEvent.getSceneY() - startDragY);
        });

        this.setOnMouseReleased(mouseEvent -> {
            ChessBoard.movingPiece = true;
            Square square = ChessBoard.findSquare(mouseEvent);
            this.resetSquares();
            this.setTranslateX(startPosX);
            this.setTranslateY(startPosY);
            this.setMouseTransparent(false);
            mouseEvent.consume();
        });
    }

    public void getPossibleMoves() {}

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

    public boolean checkSuccessfulMove(){
        //PickResult pickResult = mouseEvent.getPickResult();
        //Node node = pickResult.getIntersectedNode().getParent();
        //Square square = (Square) node;
        //System.out.println(square.getName());


        return false;
        // Check square on release
        // set coords of piece to new square

    }
}
