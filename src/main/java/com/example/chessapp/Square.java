package com.example.chessapp;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Square extends StackPane {
    int x, y;
    boolean occupied;
    String name;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.occupied = false;
    }

    public void setName(String name){
        this.name = name;
    }
}
