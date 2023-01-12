package com.example.chessapp;

import java.util.Objects;

public class King extends Piece {

    public King(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "King";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        int[] options = new int[]{direction, -direction, 7*direction, 8*direction, 9*direction, -7*direction, -8*direction, -9*direction};
        for(int option : options){
            if(!squaresMap.containsKey(option)){
                continue;
            }
            Square square = squaresMap.get(option);
            int target = square.getName();
            boolean targetLeftEdge = target % 8 == 0 && position % 7 == 0;
            boolean targetRightEdge = target % 7 == 0 && position % 8 == 0;
            boolean targetTopEdge = target < 8 && target > -1;
            boolean targetBottomEdge = target < 64 && target > 55;
            // Prevent falling OOB
            if (targetLeftEdge || targetRightEdge || targetTopEdge || targetBottomEdge) {
                continue;
            }
            if(square.occupied){
                boolean notSameColor = checkColor(square);
                if(notSameColor){
                    this.possibleMoves.add(target);
                }
            }
            if(!square.occupied){
                this.possibleMoves.add(target);
            }
        }
    }

    private boolean checkColor(Square square){
        Piece targetPiece = (Piece) square.getChildren().get(0);
        String color = targetPiece.color;

        return !Objects.equals(color, this.color);
    }
}
