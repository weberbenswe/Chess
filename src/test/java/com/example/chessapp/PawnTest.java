package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void createPawnTest(){
        Pawn pawn = new Pawn("White", 1, 1);

        assertNotNull(pawn);
        assertEquals(pawn.type, "Pawn");
    }
}