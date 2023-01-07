package com.example.chessapp;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Objects;

public class Piece extends ImageView {
    String color, type;
    int x, y;
    ArrayList<String> possibleMoves;

    public Piece(String color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void setPiece(Image image){
        this.setImage(image);
    }

    public void setImage(){
        String resourceStream = "/images/" + "" + this.color + "" + this.type + "" + ".png";
        this.setPiece(new Image(Objects.requireNonNull(App.class.getResourceAsStream(resourceStream))));
    }

    private void addEventHandler(){
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                checkMoves();
            }
        });
    }

    public void checkMoves(){}
}
