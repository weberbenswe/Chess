package com.example.chessapp;

public class King extends Piece {

    public King(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "King";
        setImage();
    }

    @Override
    public void getPossibleMoves(){

    }
}
