package com.example.chessapp;

public class Knight extends Piece{

    public Knight(String color, int x, int y){
        super(color, x, y);
        this.type = "Knight";
        setImage();
    }
}
