package org.cleasby.tictactoe;

/**
 * Fixtures for Board tests.
 */
public class BoardFixtures {
    /**
     * Initialize a board from a String array.
     *
     * @param boardLines lines
     * @return board
     */
    public static Board initializeBoard(String... boardLines) {
        Board board = new Board(boardLines[0].length(), boardLines.length);
        for (int row = 0; row < boardLines.length; row++) {
            for (int col = 0; col < boardLines[row].length(); col++) {
                board.setPosition(col, row, Square.forValue(boardLines[row].substring(col, col + 1)));
            }
        }
        return board;
    }
}
