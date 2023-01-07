package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void createSquare(){
        Square square = new Square(1, 1);

        assertNotNull(square);
        assertEquals(square.occupied, false);
    }
    @Test
    void setName() {
        Square square = new Square(1, 1);
        square.setName("Test");

        assertEquals(square.name, "Test");
    }
}