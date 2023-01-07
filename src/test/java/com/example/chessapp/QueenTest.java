package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void createQueenTest(){
        Queen queen = new Queen("White", 1, 1);

        assertNotNull(queen);
        assertEquals(queen.type, "Queen");
    }
}