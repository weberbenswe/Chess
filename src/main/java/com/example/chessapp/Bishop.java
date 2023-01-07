package com.example.chessapp;

public class Bishop extends Piece{

    public Bishop(String color, int x, int y){
        super(color, x, y);
        this.type = "Bishop";
        setImage();
    }
}
