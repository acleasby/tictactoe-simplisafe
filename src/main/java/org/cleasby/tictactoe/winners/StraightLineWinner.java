package org.cleasby.tictactoe.winners;

import org.cleasby.tictactoe.Board;
import org.cleasby.tictactoe.Square;
import org.cleasby.tictactoe.Winner;

/**
 * Check for a winner by checking a straight line of the same piece.  Line may be horizontal, vertical, or diagonal.
 */
public class StraightLineWinner implements Winner {
    private final int fromRow, fromCol;
    private final Direction direction;

    public StraightLineWinner(int fromRow, int fromCol, Direction direction) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.direction = direction;
    }

    @Override
    public boolean checkWinner(Board board) {
        // Check for a winner in a straight line according to the configured direction
        Square square = board.getPosition(fromCol, fromRow);
        if (square == Square.NONE) {
            return false;
        }
        for (int i = 0; i < board.getWidth(); i++) {
            int x = fromCol + i * direction.xOffset;
            int y = fromRow + i * direction.yOffset;
            if (y < 0 || board.getPosition(x, y) != square) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return direction.name();
    }
}
