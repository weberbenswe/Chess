package com.example.chessapp;

public class Rook extends Piece{

    public Rook(String color, int x, int y, int startPos) {
        super(color, x, y, startPos);
        this.type = "Rook";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        for(int down=y+1; down<8; down++){
            Coordinate location = new Coordinate(x, down);
            if(!location.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(location);
            if(square.occupied && !occupiedByEnemy(square)){
                break;
            } else if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
                break;
            }
        }

        for(int up=y-1; up>=0; up--){
            Coordinate location = new Coordinate(x, up);
            if(!location.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(location);
            if(square.occupied && !occupiedByEnemy(square)){
                break;
            } else if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
                break;
            }
        }

        for(int right=x+1; right<8; right++){
            Coordinate location = new Coordinate(right, y);
            if(!location.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(location);
            if(square.occupied && !occupiedByEnemy(square)){
                break;
            } else if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
                break;
            }
        }

        for(int left=x-1; left>=0; left--){
            Coordinate location = new Coordinate(left, y);
            if(!location.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(location);
            if(square.occupied && !occupiedByEnemy(square)){
                break;
            } else if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
                break;
            }
        }
    }
}
