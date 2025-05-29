package org.cleasby.tictactoe.winners;

import org.cleasby.tictactoe.Board;
import org.cleasby.tictactoe.BoardFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test CornerWinner functionality.
 */
public class CornerWinnerTest {

    private CornerWinner cornerWinner;
    private Board board;

    @BeforeEach
    void setUp() {
        cornerWinner = new CornerWinner();
        board = new Board(4, 4);
    }

    @Test
    void testCheckWinner_AllCornersSameRed_ReturnsTrue() {
        // Arrange - set all corners to RED
        Board board = BoardFixtures.initializeBoard(
                "R  R",
                "    ",
                "    ",
                "R  R"
        );

        assertTrue(cornerWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_AllCornersSameBlack_ReturnsTrue() {
        // Arrange - set all corners to BLACK
        Board board = BoardFixtures.initializeBoard(
                "B  B",
                "    ",
                "    ",
                "B  B"
        );

        assertTrue(cornerWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_TopLeftCornerNone_ReturnsFalse() {
        Board board = BoardFixtures.initializeBoard(
                "   R",
                "    ",
                "    ",
                "R  R"
        );

        assertFalse(cornerWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_MixedCorners_ReturnsFalse() {
        // Arrange - mixed RED and BLACK corners
        Board board = BoardFixtures.initializeBoard(
                "R  B",
                "    ",
                "    ",
                "B  R"
        );

        assertFalse(cornerWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_AllCornersNone_ReturnsFalse() {
        // All corners are NONE (default for a new board)
        board = new Board(4, 4);

        assertFalse(cornerWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_LargerBoard_ReturnsTrue() {
        // Arrange - 5x5 board with all corners RED
        Board board = BoardFixtures.initializeBoard(
                "B   B",
                "     ",
                "     ",
                "B   B"
        );

        assertTrue(cornerWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_RectangularBoard_ReturnsTrue() {
        Board board = BoardFixtures.initializeBoard(
                "R R",
                "   ",
                "   ",
                "R R"
        );

        assertTrue(cornerWinner.checkWinner(board));
    }
}
