package com.example.chessapp;

public class Rook extends Piece{

    public Rook(String color, int x, int y, int startPos) {
        super(color, x, y, startPos);
        this.type = "Rook";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
    }
}
