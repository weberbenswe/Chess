package com.example.chessapp;

import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.*;

/**
 * Acts as super for all piece types controlling similar logic like movement, capturing, and image setting
 * */
public class Piece extends ImageView {
    boolean hasMoved, inCheck;
    public int direction, x, y;
    String color, type;
    double startDragX, startDragY, currX, currY;
    Coordinate coordinate;
    HashSet<Integer> possibleMoves;
    HashMap<Coordinate, Square> squaresMap = ChessBoard.getSquaresMap();
    ArrayList<Square> squares = ChessBoard.getSquares();
    ArrayList<Square> highLightedSquares;
    Image image;

    public Piece(String color, int x, int y, int startPos){
        this.color = color;
        this.x = x;
        this.y = y;
        this.coordinate = new Coordinate(x, y);
        this.hasMoved = false;
        this.possibleMoves = new HashSet<>();
        this.direction = Objects.equals(this.color, "white") ? 1 : -1;
        this.pieceInteraction();
    }

    /**
     * Defines image for individual piece created in ChessBoard.cls
     * */
    public Image setPiece(Image image){
        this.setImage(image);
        return image;
    }

    public void setImage(){
        String resourceStream = "/images/" + "" + this.color + "" + this.type + "" + ".png";
        this.image = this.setPiece(new Image(Objects.requireNonNull(App.class.getResourceAsStream(resourceStream))));
    }

    /**
     * Control the click-and-drag feature for moving chess pieces
     * */
    public void pieceInteraction(){
        // Selecting Piece
        this.setOnMousePressed(mouseEvent -> {
            this.setMouseTransparent(true);
            startDragX = mouseEvent.getSceneX();
            startDragY = mouseEvent.getSceneY();
            this.getParent().setViewOrder(-1);
            moves();
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
            checkSuccessfulMove(node);
            this.setMouseTransparent(false);
            this.possibleMoves = new HashSet<>();
            mouseEvent.consume();
        });
    }

    /**
     * Find list of possible moves - super for other piece objects with specific moves
     * Confirms if player is in check and acts accordingly
     * */
    public void moves(){
        getPossibleMoves();
        if(inCheck){
            boolean pieceProtectKing = protectOnly();
            if(!pieceProtectKing || !Objects.equals(this.type, "King")){
                this.possibleMoves = new HashSet<>();
            }
        }
    }

    private boolean protectOnly() {
        // Need to check if piece can protect king by intersecting path of attacker
        return true;
    }

    public void getPossibleMoves() {}

    /**
     * Compares selected move with possible moves for movement control
     * */
    public void checkSuccessfulMove(Node node){
        if(!(node instanceof Square)){
            return;
        }
        Square targetSquare = (Square) node;
        Square prevSquare = (Square) this.getParent();
        int target = targetSquare.getName();

        for(int move : possibleMoves) {
            if (target == move){

                //Prep target square
                if(targetSquare.occupied) {
                    targetSquare.getChildren().clear();
                    targetSquare.occupied = false;
                }

                //Move in here
                targetSquare.getChildren().add(this);
                targetSquare.occupied = true;
                this.coordinate = new Coordinate(targetSquare.x, targetSquare.y);
                this.x = targetSquare.x;
                this.y = targetSquare.y;

                //Update prev square
                prevSquare.occupied = false;
                prevSquare.getChildren().clear();

                this.hasMoved = true;
            }
        }
        this.resetSquares();
    }

    /**
     * Set highlighting on moves that are valid - allowing for movement of those pieces
     * */
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

    /**
     * Super method verifying if piece can be captured or is the players own piece
     * */
    boolean occupiedByEnemy(Square square){
        if(square.occupied){
            Piece piece = (Piece) square.getChildren().get(0);
            return piece.direction != this.direction;
        }
        return true;
    }
}