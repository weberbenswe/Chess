package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    void createKingTest(){
        King king = new King("White", 1, 1, 2);

        assertNotNull(king);
        assertEquals(king.type, "King");
    }
}