package com.example.chessapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void createPieceTest(){
        Piece piece = new Piece("White", 1, 1,2);
        piece.type = "Rook";

        assertNotNull(piece);
        assertEquals(piece.type, "Rook");
    }
}