package com.example.chessapp;

import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "Knight";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        // 8 possible moves
        // Every combo of: [+/-2,+/-1], [+/-1,+/-2]
        ArrayList<Coordinate> availableMoves = possibleMoves(this.x, this.y);
        for(Coordinate move : availableMoves){
            if(!move.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(move);
            if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
            }
        }
    }

    private ArrayList<Coordinate> possibleMoves(int x, int y){
        ArrayList<Coordinate> possibleMoves = new ArrayList<>();
        //Right
        possibleMoves.add(new Coordinate(x+2, y+1));
        possibleMoves.add(new Coordinate(x+2, y-1));
        possibleMoves.add(new Coordinate(x-2, y+1));
        possibleMoves.add(new Coordinate(x-2, y-1));
        //Left
        possibleMoves.add(new Coordinate(x+1, y+2));
        possibleMoves.add(new Coordinate(x+1, y-2));
        possibleMoves.add(new Coordinate(x-1, y+2));
        possibleMoves.add(new Coordinate(x-1, y-2));
        //Up
        possibleMoves.add(new Coordinate(x+2, y-1));
        possibleMoves.add(new Coordinate(x-2, y-1));
        possibleMoves.add(new Coordinate(x+1, y-2));
        possibleMoves.add(new Coordinate(x-1, y-2));
        //Down
        possibleMoves.add(new Coordinate(x+2, y+1));
        possibleMoves.add(new Coordinate(x-2, y+1));
        possibleMoves.add(new Coordinate(x+1, y+2));
        possibleMoves.add(new Coordinate(x-1, y+2));
        return possibleMoves;
    }
}
