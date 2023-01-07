package com.example.chessapp;

public class Queen extends Piece{

    public Queen(String color, int x, int y){
        super(color, x, y);
        this.type = "Queen";
        setImage();
    }
}
