package org.cleasby.tictactoe;

import org.cleasby.tictactoe.winners.CornerWinner;
import org.cleasby.tictactoe.winners.BoxWinner;
import org.cleasby.tictactoe.winners.StraightLineWinner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test TicTacToe game functionality.
 */
public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        // Standard 3x3 game board
        game = new TicTacToe(3, 3);
    }

    @Test
    void testInitialState() {
        // New game should not be over
        assertFalse(game.isGameOver());
        // No winner at start
        assertNull(game.checkWinner());
        // All moves should be available
        assertTrue(game.anyMovesLeft());
    }

    @Test
    void testMakeValidMove() {
        // When making a valid move
        boolean result = game.makeMove(0, 0, Square.RED);

        // Then the move should be successful
        assertTrue(result);
    }

    @Test
    void testMakeInvalidMove_AlreadyOccupied() {
        // Given a position that is already occupied
        game.makeMove(1, 1, Square.RED);

        // When trying to make a move to the same position
        boolean result = game.makeMove(1, 1, Square.BLACK);

        // Then the move should fail
        assertFalse(result);
    }

    @Test
    void testMakeMove_OutOfBounds() {
        // When making a move outside the board
        assertThrows(IllegalArgumentException.class, () -> {
            game.makeMove(-1, 0, Square.RED);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.makeMove(0, -1, Square.RED);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.makeMove(3, 0, Square.RED);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.makeMove(0, 3, Square.RED);
        });
    }

    @Test
    void testCheckWinner_HorizontalLine() {
        // Given a horizontal line of RED squares
        game.makeMove(0, 0, Square.RED);
        game.makeMove(1, 0, Square.RED);
        game.makeMove(2, 0, Square.RED);

        // When checking for a winner
        Winner winner = game.checkWinner();

        // Then a winner should be found
        assertNotNull(winner);
        // And it should be a StraightLineWinner
        assertTrue(winner instanceof StraightLineWinner);
        // And the game should be over
        assertTrue(game.isGameOver());
    }

    @Test
    void testCheckWinner_VerticalLine() {
        // Given a vertical line of BLACK squares
        game.makeMove(0, 0, Square.BLACK);
        game.makeMove(0, 1, Square.BLACK);
        game.makeMove(0, 2, Square.BLACK);

        // When checking for a winner
        Winner winner = game.checkWinner();

        // Then a winner should be found
        assertNotNull(winner);
        // And it should be a StraightLineWinner
        assertTrue(winner instanceof StraightLineWinner);
        // And the game should be over
        assertTrue(game.isGameOver());
    }

    @Test
    void testCheckWinner_DiagonalDown() {
        // Given a diagonal line of RED squares
        game.makeMove(0, 0, Square.RED);
        game.makeMove(1, 1, Square.RED);
        game.makeMove(2, 2, Square.RED);

        // When checking for a winner
        Winner winner = game.checkWinner();

        // Then a winner should be found
        assertNotNull(winner);
        // And it should be a StraightLineWinner
        assertTrue(winner instanceof StraightLineWinner);
        // And the game should be over
        assertTrue(game.isGameOver());
    }

    @Test
    void testCheckWinner_DiagonalUp() {
        // Given a diagonal line of BLACK squares
        game.makeMove(0, 2, Square.BLACK);
        game.makeMove(1, 1, Square.BLACK);
        game.makeMove(2, 0, Square.BLACK);

        // When checking for a winner
        Winner winner = game.checkWinner();

        // Then a winner should be found
        assertNotNull(winner);
        // And it should be a StraightLineWinner
        assertTrue(winner instanceof StraightLineWinner);
        // And the game should be over
        assertTrue(game.isGameOver());
    }

    @Test
    void testCheckWinner_AllCorners() {
        // Given all corners are RED
        game.makeMove(0, 0, Square.RED);
        game.makeMove(2, 0, Square.RED);
        game.makeMove(0, 2, Square.RED);
        game.makeMove(2, 2, Square.RED);

        // When checking for a winner
        Winner winner = game.checkWinner();

        // Then a winner should be found
        assertNotNull(winner);
        // And it should be a CornerWinner
        assertTrue(winner instanceof CornerWinner);
        // And the game should be over
        assertTrue(game.isGameOver());
    }

    @Test
    void testCheckWinner_Box() {
        // Given a 2x2 box of BLACK squares in the top-left
        // For a 3x3 board, use a larger board to test
        TicTacToe largerGame = new TicTacToe(4, 4);
        largerGame.makeMove(0, 0, Square.BLACK);
        largerGame.makeMove(1, 0, Square.BLACK);
        largerGame.makeMove(0, 1, Square.BLACK);
        largerGame.makeMove(1, 1, Square.BLACK);

        // When checking for a winner
        Winner winner = largerGame.checkWinner();

        // Then a winner should be found
        assertNotNull(winner);
        // And it should be a BoxWinner
        assertTrue(winner instanceof BoxWinner);
        // And the game should be over
        assertTrue(largerGame.isGameOver());
    }

    @Test
    void testIsGameOver_Draw() {
        // Given a board with no winner and filled with alternating pieces
        game.makeMove(0, 0, Square.RED);
        game.makeMove(0, 1, Square.BLACK);
        game.makeMove(0, 2, Square.RED);
        game.makeMove(1, 0, Square.BLACK);
        game.makeMove(1, 1, Square.RED);
        game.makeMove(1, 2, Square.BLACK);
        game.makeMove(2, 0, Square.BLACK);
        game.makeMove(2, 1, Square.RED);
        game.makeMove(2, 2, Square.BLACK);

        // When checking if the game is over
        boolean gameOver = game.isGameOver();

        // Then the game should be over (draw)
        assertTrue(gameOver);
        // And there should be no winner
        assertNull(game.checkWinner());
        // And there should be no moves left
        assertFalse(game.anyMovesLeft());
    }

    @Test
    void testIsGameOver_InProgress() {
        // Given a board with some moves but no winner
        game.makeMove(0, 0, Square.RED);
        game.makeMove(1, 1, Square.BLACK);

        // When checking if the game is over
        boolean gameOver = game.isGameOver();

        // Then the game should not be over
        assertFalse(gameOver);
        // And there should be no winner
        assertNull(game.checkWinner());
        // And there should be moves left
        assertTrue(game.anyMovesLeft());
    }

    @Test
    void testCustomBoardSize() {
        // Given a custom sized board
        TicTacToe customGame = new TicTacToe(4, 5);

        // When checking the initial state
        boolean gameOver = customGame.isGameOver();

        // Then the game should not be over
        assertFalse(gameOver);
        // And there should be no winner
        assertNull(customGame.checkWinner());
        // And there should be moves left
        assertTrue(customGame.anyMovesLeft());
    }
}
