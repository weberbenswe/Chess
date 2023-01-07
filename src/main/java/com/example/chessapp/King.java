package com.example.chessapp;

public class King extends Piece {

    public King(String color, int x, int y){
        super(color, x, y);
        this.type = "King";
        setImage();
    }
}
