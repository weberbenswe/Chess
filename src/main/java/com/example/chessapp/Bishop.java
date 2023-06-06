package com.example.chessapp;

public class Bishop extends Piece{

    public Bishop(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "Bishop";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for(int x=this.x+1, y=this.y+1; x < 8 && y < 8; x++, y++){
            Coordinate downRight = new Coordinate(x, y);
            if(!downRight.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(downRight);
            if(square.occupied && !occupiedByEnemy(square)){
                break;
            } else if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());  
                break;
            }
        }

        for(int x=this.x-1, y=this.y-1; x >= 0 && y >= 0; x--, y--){
            Coordinate upLeft = new Coordinate(x, y);
            if(!upLeft.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(upLeft);
            if(square.occupied && !occupiedByEnemy(square)){
                break;
            } else if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
                break;
            }
        }

        for(int x=this.x+1, y=this.y-1; x < 8 && y >= 0; x++, y--){
            Coordinate upRight = new Coordinate(x, y);
            if(!upRight.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(upRight);
            if(square.occupied && !occupiedByEnemy(square)){
                break;
            } else if(!square.occupied){
                possibleMoves.add(square.getName());
            } else if(square.occupied && occupiedByEnemy(square)){
                possibleMoves.add(square.getName());
                break;
            }
        }

        for(int x=this.x-1, y=this.y+1; x >= 0 && y < 8; x--, y++){
            Coordinate downLeft = new Coordinate(x, y);
            if(!downLeft.isInBounds()){
                continue;
            }
            Square square = squaresMap.get(downLeft);
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