package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void createSquare(){
        Square square = new Square(1, 1, 2);

        assertNotNull(square);
        assertEquals(square.occupied, false);
    }
    @Test
    void setName() {
        Square square = new Square(1, 1, 2);
        int name = square.getName();

        assertEquals(name, 2);
    }
}