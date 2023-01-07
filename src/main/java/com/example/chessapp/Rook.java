package com.example.chessapp;

public class Rook extends Piece{

    public Rook(String color, int x, int y) {
        super(color, x, y);
        this.type = "Rook";
        setImage();
    }
}
