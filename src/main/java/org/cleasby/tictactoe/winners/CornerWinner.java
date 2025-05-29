package org.cleasby.tictactoe.winners;

import org.cleasby.tictactoe.Board;
import org.cleasby.tictactoe.Square;
import org.cleasby.tictactoe.Winner;

/**
 * Check for a winner by checking for corners of the same piece.
 */
public class CornerWinner implements Winner {
    @Override
    public boolean checkWinner(Board board) {
        // Check for corners
        Square topLeftCorner = board.getPosition(0, 0);
        if (topLeftCorner == Square.NONE) {
            return false;
        }
        Square bottomLeftCorner = board.getPosition(0, board.getHeight() - 1);
        Square topRightCorner = board.getPosition(board.getWidth() - 1, 0);
        Square bottomRightCorner = board.getPosition(board.getWidth() - 1, board.getHeight() - 1);
        return topLeftCorner == bottomLeftCorner &&
                topRightCorner == bottomRightCorner
                && topLeftCorner == topRightCorner;
    }

    @Override
    public String toString() {
        return "Corners";
    }
}
