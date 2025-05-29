package org.cleasby.tictactoe.winners;

import org.cleasby.tictactoe.Board;
import org.cleasby.tictactoe.BoardFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test SquareWinner functionality.
 */
public class BoxWinnerTest {

    private BoxWinner boxWinner;

    @BeforeEach
    void setUp() {
        // Default square size 2
        boxWinner = new BoxWinner(2);
    }

    @Test
    void testCheckWinner_2x2SquareRed_TopLeft_ReturnsTrue() {
        // Arrange - 2x2 square of RED pieces in the top left
        Board board = BoardFixtures.initializeBoard(
                "RR  ",
                "RR  ",
                "    ",
                "    "
        );

        // Act & Assert
        assertTrue(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_2x2SquareBlack_BottomRight_ReturnsTrue() {
        // Arrange - 2x2 square of BLACK pieces in the bottom right
        Board board = BoardFixtures.initializeBoard(
                "    ",
                "    ",
                "  BB",
                "  BB"
        );

        // Act & Assert
        assertTrue(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_2x2SquareRed_Center_ReturnsTrue() {
        // Arrange - 2x2 square of RED pieces in the center
        Board board = BoardFixtures.initializeBoard(
                "    ",
                " RR ",
                " RR ",
                "    "
        );

        // Act & Assert
        assertTrue(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_MixedPieces_ReturnsFalse() {
        // Arrange - No complete 2x2 square of same pieces
        Board board = BoardFixtures.initializeBoard(
                "RB  ",
                "BR  ",
                "    ",
                "    "
        );

        // Act & Assert
        assertFalse(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_NoCompleteSquare_ReturnsFalse() {
        // Arrange - Almost a 2x2 square but missing one piece
        Board board = BoardFixtures.initializeBoard(
                "RR  ",
                "R   ",
                "    ",
                "    "
        );

        // Act & Assert
        assertFalse(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_NoneInSquare_ReturnsFalse() {
        // Arrange - 2x2 area with a NONE piece
        Board board = BoardFixtures.initializeBoard(
                "RR  ",
                "R   ",
                "    ",
                "    "
        );

        // Act & Assert
        assertFalse(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_EmptyBoard_ReturnsFalse() {
        // Arrange - Empty board (all NONE)
        Board board = new Board(4, 4);

        // Act & Assert
        assertFalse(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_LargerBoard_ReturnsTrue() {
        // Arrange - 5x5 board with a 2x2 square
        Board board = BoardFixtures.initializeBoard(
                "     ",
                "     ",
                "  RR ",
                "  RR ",
                "     "
        );

        // Act & Assert
        assertTrue(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_SmallBoard_ReturnsFalse() {
        // Arrange - Board too small for a 2x2 square
        Board board = new Board(1, 1);

        // Act & Assert
        assertFalse(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_RectangularBoard_ReturnsTrue() {
        // Arrange - 3x4 rectangular board with a 2x2 square
        Board board = BoardFixtures.initializeBoard(
                "   ",
                "BB ",
                "BB ",
                "   "
        );

        // Act & Assert
        assertTrue(boxWinner.checkWinner(board));
    }

    @Test
    void testCheckWinner_Size3Square_ReturnsTrue() {
        // Arrange - 4x4 board with a 3x3 square
        BoxWinner size3Winner = new BoxWinner(3);
        Board board = BoardFixtures.initializeBoard(
                "RRR ",
                "RRR ",
                "RRR ",
                "    "
        );

        // Act & Assert
        assertTrue(size3Winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_Size1Square_ReturnsTrue() {
        // Arrange - 4x4 board with a 1x1 "square" (single piece)
        BoxWinner size1Winner = new BoxWinner(1);
        Board board = BoardFixtures.initializeBoard(
                "R   ",
                "    ",
                "    ",
                "    "
        );

        // Act & Assert
        assertTrue(size1Winner.checkWinner(board));
    }
}
