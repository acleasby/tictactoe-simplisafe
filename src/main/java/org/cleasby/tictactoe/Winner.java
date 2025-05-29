package org.cleasby.tictactoe;

/**
 * Represents a condition that can be checked to determine if a game is over.
 */
public interface Winner {
    /**
     * Check if the given board is a winner.
     *
     * @param board board
     * @return true if the board is a winner, false otherwise.
     */
    boolean checkWinner(Board board);
}
