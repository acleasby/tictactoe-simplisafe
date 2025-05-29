package org.cleasby.tictactoe.winners;

import org.cleasby.tictactoe.Board;
import org.cleasby.tictactoe.BoardFixtures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test StraightLineWinner functionality.
 */
public class StraightLineWinnerTest {

    @Test
    void testCheckWinner_HorizontalRedLine_ReturnsTrue() {
        // Arrange - horizontal red line in row 1
        Board board = BoardFixtures.initializeBoard(
                "    ",
                "RRRR",
                "    ",
                "    "
        );
        StraightLineWinner winner = new StraightLineWinner(1, 0, Direction.HORIZONTAL);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_HorizontalBlackLine_ReturnsTrue() {
        // Arrange - horizontal black line in row 2
        Board board = BoardFixtures.initializeBoard(
                "    ",
                "    ",
                "BBBB",
                "    "
        );
        StraightLineWinner winner = new StraightLineWinner(2, 0, Direction.HORIZONTAL);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_HorizontalMixedPieces_ReturnsFalse() {
        // Arrange - horizontal line with mixed pieces
        Board board = BoardFixtures.initializeBoard(
                "    ",
                "RBRB",
                "    ",
                "    "
        );
        StraightLineWinner winner = new StraightLineWinner(1, 0, Direction.HORIZONTAL);

        // Act & Assert
        assertFalse(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_VerticalRedLine_ReturnsTrue() {
        // Arrange - vertical red line in column 2
        Board board = BoardFixtures.initializeBoard(
                "  R ",
                "  R ",
                "  R ",
                "  R "
        );
        StraightLineWinner winner = new StraightLineWinner(0, 2, Direction.VERTICAL);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_VerticalBlackLine_ReturnsTrue() {
        // Arrange - vertical black line in column 0
        Board board = BoardFixtures.initializeBoard(
                "B   ",
                "B   ",
                "B   ",
                "B   "
        );
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.VERTICAL);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_VerticalMixedPieces_ReturnsFalse() {
        // Arrange - vertical line with mixed pieces
        Board board = BoardFixtures.initializeBoard(
                "R   ",
                "B   ",
                "R   ",
                "B   "
        );
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.VERTICAL);

        // Act & Assert
        assertFalse(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_DiagonalDownRedLine_ReturnsTrue() {
        // Arrange - diagonal down red line from top-left
        Board board = BoardFixtures.initializeBoard(
                "R   ",
                " R  ",
                "  R ",
                "   R"
        );
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.DIAGONAL_DOWN);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_DiagonalDownBlackLine_ReturnsTrue() {
        // Arrange - diagonal down black line from top-left
        Board board = BoardFixtures.initializeBoard(
                "B   ",
                " B  ",
                "  B ",
                "   B"
        );
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.DIAGONAL_DOWN);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_DiagonalDownMixedPieces_ReturnsFalse() {
        // Arrange - diagonal down with mixed pieces
        Board board = BoardFixtures.initializeBoard(
                "R   ",
                " B  ",
                "  R ",
                "   B"
        );
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.DIAGONAL_DOWN);

        // Act & Assert
        assertFalse(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_DiagonalUpRedLine_ReturnsTrue() {
        // Arrange - diagonal up red line from bottom-left
        Board board = BoardFixtures.initializeBoard(
                "   R",
                "  R ",
                " R  ",
                "R   "
        );
        StraightLineWinner winner = new StraightLineWinner(3, 0, Direction.DIAGONAL_UP);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_DiagonalUpBlackLine_ReturnsTrue() {
        // Arrange - diagonal up black line from bottom-left
        Board board = BoardFixtures.initializeBoard(
                "   B",
                "  B ",
                " B  ",
                "B   "
        );
        StraightLineWinner winner = new StraightLineWinner(3, 0, Direction.DIAGONAL_UP);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_DiagonalUpMixedPieces_ReturnsFalse() {
        // Arrange - diagonal up with mixed pieces
        Board board = BoardFixtures.initializeBoard(
                "   R",
                "  B ",
                " R  ",
                "B   "
        );
        StraightLineWinner winner = new StraightLineWinner(3, 0, Direction.DIAGONAL_UP);

        // Act & Assert
        assertFalse(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_StartingPieceNone_ReturnsFalse() {
        // Arrange - starting position is NONE
        Board board = new Board(4, 4);
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.HORIZONTAL);

        // Act & Assert
        assertFalse(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_RectangularBoard_ReturnsTrue() {
        // Arrange - rectangular board with horizontal line
        Board board = BoardFixtures.initializeBoard(
                "RRR",
                "   ",
                "   ",
                "   "
        );
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.HORIZONTAL);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }

    @Test
    void testCheckWinner_LargerBoard_ReturnsTrue() {
        // Arrange - 5x5 board with vertical line
        Board board = BoardFixtures.initializeBoard(
                "R    ",
                "R    ",
                "R    ",
                "R    ",
                "R    "
        );
        StraightLineWinner winner = new StraightLineWinner(0, 0, Direction.VERTICAL);

        // Act & Assert
        assertTrue(winner.checkWinner(board));
    }
}
