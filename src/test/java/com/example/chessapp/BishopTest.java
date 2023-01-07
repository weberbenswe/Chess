package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void createBishopTest(){
        Bishop bishop = new Bishop("black", 1, 1);
        bishop.type = "Queen";

        assertNotNull(bishop);
        assertEquals(bishop.type, "Queen");
    }

}