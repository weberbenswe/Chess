package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void createKnightTest(){
        Knight knight = new Knight("white", 2, 1, 2);
        knight.type = "Queen";
        knight.type = "Knight";

        assertNotNull(knight);
        assertEquals(knight.type, "Knight");
    }
}