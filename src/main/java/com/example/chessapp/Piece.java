package com.example.chessapp;

import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.*;

public class Piece extends ImageView {
    String color, type;
    int x, y, position;
    boolean hasMoved;
    double startDragX, startDragY, currX, currY;
    public int direction;
    HashSet<Integer> possibleMoves;
    HashMap<Integer, Square> squaresMap = ChessBoard.getSquaresMap();
    ArrayList<Square> squares = ChessBoard.getSquares();
    ArrayList<Square> highLightedSquares;
    Image image;



    public Piece(String color, int x, int y, int startPos){
        this.color = color;
        this.x = x;
        this.y = y;
        this.position = startPos;
        this.hasMoved = false;
        this.possibleMoves = new HashSet<>();
        this.direction = Objects.equals(this.color, "white") ? 1 : -1;
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
            moves();
            System.out.println("Piece: " + this.type + " Moved?: " + this.hasMoved + " Position: " + this.position);
            System.out.println("Possible moves: " + this.possibleMoves);
            highlightMoves(possibleMoves);
            mouseEvent.consume();
        });

        // Moving Piece
        this.setOnMouseDragged(mouseEvent -> {
            this.currX = mouseEvent.getSceneX() - startDragX;
            this.currY = mouseEvent.getSceneY() - startDragY;
            this.relocate(currX, currY);
            startDragX = mouseEvent.getSceneX();
            startDragY = mouseEvent.getSceneY();
            mouseEvent.consume();
        });

        this.setOnMouseReleased(mouseEvent -> {
            Node node = mouseEvent.getPickResult().getIntersectedNode();
            boolean isSuccessfulMove = checkSuccessfulMove(node);
            if(isSuccessfulMove){
                this.hasMoved = true;
                this.resetSquares();
            } else {
                this.resetSquares();
            }
            this.setMouseTransparent(false);
            this.possibleMoves = new HashSet<>();
            mouseEvent.consume();
        });
    }

    public void moves(){
        //TODO: should not go off edge of board
        getPossibleMoves();
    }

    public void getPossibleMoves() {}

    public boolean checkSuccessfulMove(Node node){
        if(!(node instanceof Square)){
            return false;
        }
        Square targetSquare = (Square) node;
        Square prevSquare = (Square) this.getParent();
        int target = targetSquare.getName();

        for(int move : possibleMoves) {
            // TODO: Only job here is to move square if it's in the list of successful moves
            if (target == move){

                //Prep target square
                if(targetSquare.occupied) {
                    targetSquare.getChildren().clear();
                    targetSquare.occupied = false;
                }

                //Move in here
                targetSquare.getChildren().add(this);
                targetSquare.occupied = true;
                this.x = targetSquare.x;
                this.y = targetSquare.y;
                this.position = target;

                //Update prev square
                prevSquare.occupied = false;
                prevSquare.getChildren().clear();

                this.hasMoved = true;
                return true;
            }
        }
        return false;
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
