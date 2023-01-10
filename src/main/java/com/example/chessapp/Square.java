package com.example.chessapp;

import javafx.scene.layout.StackPane;

public class Square extends StackPane {
    int x, y;
    boolean occupied;
    private final int name;
    String backgroundColor;

    public Square(int x, int y, int name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.occupied = false;
    }

    public int getName(){
        return this.name;
    }
}
