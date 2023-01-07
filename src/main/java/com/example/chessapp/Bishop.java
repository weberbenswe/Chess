package com.example.chessapp;

public class Bishop extends Piece{

    public Bishop(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "Bishop";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
    }
}