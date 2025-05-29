package org.cleasby.tictactoe.winners;

import org.cleasby.tictactoe.Board;
import org.cleasby.tictactoe.Square;
import org.cleasby.tictactoe.Winner;

/**
 * Check for a winner by checking for a complete square/box of the same piece.
 */
public class BoxWinner implements Winner {
    private final int size;

    public BoxWinner(int size) {
        this.size = size;
    }

    @Override
    public boolean checkWinner(Board board) {
        // Check for complete squares
        for (int row = 0; row < board.getHeight() - size + 1; row++) {
            for (int col = 0; col < board.getWidth() - size + 1; col++) {
                if (checkSquare(col, row, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the given board square is a complete square/box of the same piece.
     *
     * @param upperLeftCol upper left column
     * @param upperLeftRow upper left row
     * @param board        board
     * @return true if the square is a complete square/box of the same piece, false otherwise.
     */
    private boolean checkSquare(int upperLeftCol, int upperLeftRow, Board board) {
        Square square = board.getPosition(upperLeftCol, upperLeftRow);
        if (square == Square.NONE) {
            return false;
        }
        for (int row = upperLeftRow; row < upperLeftRow + size; row++) {
            for (int col = upperLeftCol; col < upperLeftCol + size; col++) {
                if (board.getPosition(col, row) != square) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Square";
    }
}
