package com.example.chessapp;

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
    double startDragX, startDragY;
    HashSet<Integer> possibleMoves;
    ArrayList<Square> squares = ChessBoard.getSquares();
    HashMap<Square, Background> highlightedSquares;


    public Piece(String color, int x, int y, int startPos){
        this.color = color;
        this.x = x;
        this.y = y;
        this.position = startPos;
        this.highlightedSquares = new HashMap<>();
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
        this.setOnMousePressed(mouseEvent -> {
            System.out.println("Piece: X: " + this.x + " Y: " + this.y + " Type: " + this.type + " Position: " + this.position);
            getPossibleMoves();
            highlightMoves(possibleMoves);
            System.out.println("Possible Moves: " + possibleMoves);
            startDragX = mouseEvent.getSceneX();
            startDragY = mouseEvent.getSceneY();
        });

        this.setOnMouseDragged(mouseEvent -> {
            getPossibleMoves();s
            highlightMoves(possibleMoves);
            this.setTranslateX(mouseEvent.getSceneX() - startDragX);
            this.setTranslateY(mouseEvent.getSceneY() - startDragY);
        });

        this.setOnMouseReleased(mouseEvent -> {
            resetSquares();
            this.toFront();
        });
    }

    public void getPossibleMoves() {
        highlightMoves(possibleMoves);
    }

    public void highlightMoves(HashSet<Integer> possibleMoves){
        Color color = Color.rgb(144, 238, 144);
        if(possibleMoves.isEmpty()){
            return;
        }
        for(Square square : squares){
            int name = square.getName();
            if(possibleMoves.contains(name)){
                Background background = square.getBackground();
                //BackgroundFill fill = background.getFills().get(0);
                //Color ogColor = (Color) fill.getFill();
                highlightedSquares.put(square, background);
                //System.out.println(ogColor.toString());

                square.setBackground(new Background(new BackgroundFill(color, null, null)));
                square.setEffect(new Glow(.5));
            }
        }
    }

    public void resetSquares(){
        for(Square square : highlightedSquares.keySet()){
            Background background = highlightedSquares.get(square);
            //BackgroundFill fill = background.getFills().get(0);
            //Color ogColor = (Color) fill.getFill();
            square.setBackground(background);
            square.setEffect(null);
        }
    }
}
