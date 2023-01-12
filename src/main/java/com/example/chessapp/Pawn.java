package com.example.chessapp;

import java.util.Objects;

public class Pawn extends Piece{

    public Pawn(String color, int x, int y, int currPos) {
        super(color, x, y, currPos);
        this.type = "Pawn";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        int moveOne = position+8*direction;
        int moveTwo = position+16*direction;
        int diagonalLeft = position+7*direction;
        int diagonalRight = position+9*direction;

        for(Square square : squares) {
            int target = square.getName();
            boolean targetLeftEdge = target % 8 == 0 && position % 7 == 0;
            boolean targetRightEdge = target % 7 == 0 && position % 8 == 0;
            boolean targetTopEdge = target < 8 && target > -1;
            boolean targetBottomEdge = target < 64 && target > 55;
            boolean occupied = square.occupied;
            boolean pathClear = pathClear(moveOne);

            // Prevent falling OOB
            if (targetLeftEdge || targetRightEdge || targetTopEdge || targetBottomEdge) {
                continue;
            }
            // Move forward
            if(!occupied){
                if(target == moveOne || (!hasMoved && pathClear && target == moveTwo)){
                    this.possibleMoves.add(target);
                }
            }
            // Capture
            if (occupied) {
                boolean notSameColor = checkColor(square);
                if (notSameColor && (target == diagonalLeft || target == diagonalRight)) {
                    this.possibleMoves.add(target);
                }
            }
        }
    }

    private boolean pathClear(int moveOne) {
        Square pathSquare = squaresMap.get(moveOne);
        return !pathSquare.occupied;
    }

    private boolean checkColor(Square square){
        Piece targetPiece = (Piece) square.getChildren().get(0);
        String color = targetPiece.color;

        return !Objects.equals(color, this.color);
    }
}
