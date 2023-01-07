package com.example.chessapp;

public class Knight extends Piece{

    public Knight(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "Knight";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
    }
}
