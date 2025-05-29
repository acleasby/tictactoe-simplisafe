package org.cleasby.tictactoe;

import org.cleasby.tictactoe.winners.CornerWinner;
import org.cleasby.tictactoe.winners.BoxWinner;
import org.cleasby.tictactoe.winners.StraightLineWinner;
import org.cleasby.tictactoe.winners.Direction;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Tic Tac Toe game.
 */
public class TicTacToe {
    private final Board board;

    private final Set<Winner> winConditions = new HashSet<>();

    /**
     * Create a new Tic Tac Toe game with the given dimensions.
     *
     * @param width  width
     * @param height height
     */
    public TicTacToe(int width, int height) {
        this.board = new Board(width, height);
        // Various win conditions are enabled for the game, allowing the rules to be adapted if needed.
        for (int i = 0; i < width; i++) {
            winConditions.add(new StraightLineWinner(0, i, Direction.VERTICAL));
        }
        for (int i = 0; i < height; i++) {
            winConditions.add(new StraightLineWinner(i, 0, Direction.HORIZONTAL));
        }
        winConditions.add(new StraightLineWinner(0, 0, Direction.DIAGONAL_DOWN));
        winConditions.add(new StraightLineWinner(height - 1, 0, Direction.DIAGONAL_UP));
        winConditions.add(new CornerWinner());
        winConditions.add(new BoxWinner(2));
    }

    /**
     * Check for a winner by checking for any of the win conditions.
     *
     * @return the winning condition, or null if no winner was found.
     */
    public Winner checkWinner() {
        for (Winner winCondition : winConditions) {
            if (winCondition.checkWinner(board)) {
                return winCondition;
            }
        }
        return null;
    }

    /**
     * Check if there are any moves left in the game.
     *
     * @return true if there are any moves left, false otherwise.
     */
    public boolean anyMovesLeft() {
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (board.getPosition(x, y) == Square.NONE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the game is over.  A game is over when either a winner is found or there are no moves left.
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return checkWinner() != null || !anyMovesLeft();
    }

    /**
     * Make a move at the given coordinates.  If the move is valid, the square is set to the given value.
     *
     * @param col    column
     * @param row    row
     * @param square value to set the square to.  Must be a valid Tic Tac Toe piece.
     * @return true if the move was valid, false otherwise.  If the move was valid, the board is updated.  If the
     * move was invalid, the board is not updated.
     */
    public boolean makeMove(int col, int row, Square square) {
        if (board.getPosition(col, row) != Square.NONE) {
            return false;
        }
        board.setPosition(col, row, square);
        return true;
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
