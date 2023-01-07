package com.example.chessapp;

public class Queen extends Piece{

    public Queen(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "Queen";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
    }
}
