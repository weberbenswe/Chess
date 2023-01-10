package com.example.chessapp;

import java.util.Objects;

public class Pawn extends Piece{
    private boolean hasMoved = false;

    public Pawn(String color, int x, int y, int startPos) {
        super(color, x, y, startPos);
        this.type = "Pawn";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        if(Objects.equals(this.color, ChessBoard.WHITE)){
            whiteMoves();
        } else {
            blackMoves();
        }
    }

    private void whiteMoves(){
        if(this.hasMoved){
            possibleMoves.add(this.position + 8);
        } else {
            possibleMoves.add(this.position + 8);
            possibleMoves.add(this.position + 16);
        }
    }

    private void blackMoves(){
        if(this.hasMoved){
            possibleMoves.add(this.position - 8);
        } else {
            possibleMoves.add(this.position - 8);
            possibleMoves.add(this.position - 16);
        }
    }
}
