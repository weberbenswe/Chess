package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    void createRookTest(){
        Rook rook = new Rook("White", 1, 1, 2);

        assertNotNull(rook);
        assertEquals(rook.type, "Rook");
    }
}