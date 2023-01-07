package com.example.chessapp;

public class Pawn extends Piece{
    public Pawn(String color, int x, int y) {
        super(color, x, y);
        this.type = "Pawn";
        setImage();
    }

    @Override
    public void checkMoves(){
        //can move 2 up if not moved before, otherwise can move 1
    }
}
