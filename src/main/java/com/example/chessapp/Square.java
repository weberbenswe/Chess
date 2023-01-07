package com.example.chessapp;

import javafx.scene.layout.StackPane;

public class Square extends StackPane {
    int x, y;
    boolean occupied;
    private int name;

    public Square(int x, int y, int name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.occupied = false;
        this.setOnMouseClicked(mouseEvent -> {
            System.out.println("Square: X: " + this.x + " Y: " + this.y + " Pos: " + this.name);
        });
    }

    public int setName(int name){
        this.name = name;
        return name;
    }

    public int getName(){
        return this.name;
    }
}
