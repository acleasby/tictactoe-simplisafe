package org.cleasby.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Board functionality.
 */
public class BoardTest {

    @Test
    void testConstructor_ValidDimensions() {
        // When creating a board with valid dimensions
        Board board = new Board(3, 4);

        // Then the board should be created with the correct dimensions
        assertEquals(3, board.getWidth());
        assertEquals(4, board.getHeight());
        
        // And all positions should be initialized to NONE
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                assertEquals(Square.NONE, board.getPosition(x, y));
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void testConstructor_InvalidWidth(int width) {
        // When creating a board with invalid width
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> new Board(width, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void testConstructor_InvalidHeight(int height) {
        // When creating a board with invalid height
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> new Board(3, height));
    }

    @Test
    void testGetPosition_ValidCoordinates() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When getting a position with valid coordinates
        Square square = board.getPosition(1, 2);
        
        // Then the correct square should be returned
        assertEquals(Square.NONE, square);
    }

    @Test
    void testGetPosition_NegativeX() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When getting a position with negative x
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.getPosition(-1, 0));
    }

    @Test
    void testGetPosition_NegativeY() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When getting a position with negative y
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.getPosition(0, -1));
    }

    @Test
    void testGetPosition_XTooLarge() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When getting a position with x too large
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.getPosition(3, 0));
    }

    @Test
    void testGetPosition_YTooLarge() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When getting a position with y too large
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.getPosition(0, 3));
    }

    @Test
    void testSetPosition_ValidCoordinates() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When setting a position with valid coordinates
        Board result = board.setPosition(1, 2, Square.RED);
        
        // Then the position should be updated
        assertEquals(Square.RED, board.getPosition(1, 2));
        
        // And the method should return the board for chaining
        assertSame(board, result);
    }

    @Test
    void testSetPosition_NegativeX() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When setting a position with negative x
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.setPosition(-1, 0, Square.RED));
    }

    @Test
    void testSetPosition_NegativeY() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When setting a position with negative y
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.setPosition(0, -1, Square.RED));
    }

    @Test
    void testSetPosition_XTooLarge() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When setting a position with x too large
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.setPosition(3, 0, Square.RED));
    }

    @Test
    void testSetPosition_YTooLarge() {
        // Given a board
        Board board = new Board(3, 3);
        
        // When setting a position with y too large
        // Then an IllegalArgumentException should be thrown
        assertThrows(IllegalArgumentException.class, () -> board.setPosition(0, 3, Square.RED));
    }

    @Test
    void testGetWidth() {
        // Given boards with different widths
        Board board1 = new Board(3, 4);
        Board board2 = new Board(5, 2);
        
        // When getting the width
        int width1 = board1.getWidth();
        int width2 = board2.getWidth();
        
        // Then the correct widths should be returned
        assertEquals(3, width1);
        assertEquals(5, width2);
    }

    @Test
    void testGetHeight() {
        // Given boards with different heights
        Board board1 = new Board(3, 4);
        Board board2 = new Board(5, 2);
        
        // When getting the height
        int height1 = board1.getHeight();
        int height2 = board2.getHeight();
        
        // Then the correct heights should be returned
        assertEquals(4, height1);
        assertEquals(2, height2);
    }
}
