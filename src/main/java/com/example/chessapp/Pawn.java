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
        Coordinate currLocation = new Coordinate(x, y);

        Coordinate upOne = new Coordinate(x, y+ 1*direction);
        boolean upOneCheck = false;
        if(upOne.isInBounds()){
            Square square = squaresMap.get(upOne);
            if(!square.occupied){
                possibleMoves.add(square.getName());
                upOneCheck = true;
            }
        }

        Coordinate upTwo = new Coordinate(x, y+ 2*direction);
        if(upTwo.isInBounds()){
            Square square = squaresMap.get(upTwo);
            if(!square.occupied && upOneCheck && !this.hasMoved){
                possibleMoves.add(square.getName());
            }
        }

        Coordinate diagLeft = new Coordinate(x+1*direction, y+ 1*direction);
        if(diagLeft.isInBounds()){
            Square square = squaresMap.get(diagLeft);
            if(diagCapture(square)){
                possibleMoves.add(square.getName());
            }
        }

        Coordinate diagRight = new Coordinate(x-1*direction, y+ 1*direction);
        if(diagRight.isInBounds()){
            Square square = squaresMap.get(diagRight);
            if(diagCapture(square)){
                possibleMoves.add(square.getName());
            }
        }
    }

    private boolean diagCapture(Square square){
        if(square.occupied){
            String color = ((Piece) square.getChildren().get(0)).color;
            return !Objects.equals(color, this.color);
        }
        return false;
    }
}
