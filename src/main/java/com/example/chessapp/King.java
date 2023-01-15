package com.example.chessapp;

import java.util.ArrayList;

public class King extends Piece {

    public King(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "King";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        Coordinate currLocation = new Coordinate(x, y);

        ArrayList<Coordinate> moves = possibleMoves(currLocation);
        for(Coordinate move : moves){
            if(!move.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(move);

            if(!square.occupied || occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
            }
        }
    }

    private ArrayList<Coordinate> possibleMoves(Coordinate coordinate){
        int x = coordinate.getX();
        int y = coordinate.getY();
        ArrayList<Coordinate> possibleMoves = new ArrayList<>();
        possibleMoves.add(new Coordinate(x+1, y));
        possibleMoves.add(new Coordinate(x-1, y));
        possibleMoves.add(new Coordinate(x, y+1));
        possibleMoves.add(new Coordinate(x, y-1));
        possibleMoves.add(new Coordinate(x+1, y+1));
        possibleMoves.add(new Coordinate(x-1, y-1));
        possibleMoves.add(new Coordinate(x-1, y+1));
        possibleMoves.add(new Coordinate(x+1, y-1));

        return possibleMoves;
    }
}
