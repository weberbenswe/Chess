package com.example.chessapp;

import java.util.Objects;

public class Coordinate {
    private int x, y;
    private final int[] coordinate;
    public boolean inBounds = isInBounds();
    private int hashCode;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        this.coordinate = new int[]{x, y};
        this.hashCode = Objects.hash(x, y);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    public boolean isInBounds(){
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    public boolean equals(Coordinate comparison){
        return comparison.getX() == x && comparison.getY() == y;
    }

    public void setX(int newX){
        x = newX;
        coordinate[0] = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int newY){
        y = newY;
        coordinate[1] = y;
    }

    public int getY(){
        return y;
    }

    public void setCoordinate(int x, int y){
        coordinate[0] = x;
        coordinate[1] = y;
    }

    public int[] getCoordinate(){
        return new int[]{x, y};
    }
}
