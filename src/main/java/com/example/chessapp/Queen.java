package com.example.chessapp;

public class Queen extends Piece{

    public Queen(String color, int x, int y, int startPos){
        super(color, x, y, startPos);
        this.type = "Queen";
        setImage();
    }

    @Override
    public void getPossibleMoves(){
        // Any 8 directions, any distance
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
