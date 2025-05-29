package org.cleasby.tictactoe;

/**
 * Represents a 2D game board for Tic Tac Toe with a grid of squares.
 * The board can be of any rectangular dimensions and supports accessing
 * and modifying positions with coordinates.
 */
public class Board {

    // The 2D array representing the board grid. First index is column (x), second is row (y)
    private final Square[][] board;

    /**
     * Creates a new board with the specified dimensions.
     * All positions are initialized to Square.NONE.
     *
     * @param width  the width of the board (number of columns)
     * @param height the height of the board (number of rows)
     * @throws IllegalArgumentException if width or height is less than 1
     */
    public Board(int width, int height) {
        // Validate board dimensions
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Invalid board size");
        }

        // Initialize the board with all positions set to NONE
        board = new Square[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = Square.NONE;
            }
        }
    }

    /**
     * Gets the Square at the specified position.
     *
     * @param col the x-coordinate (column)
     * @param row the y-coordinate (row)
     * @return the Square at the specified position
     * @throws IllegalArgumentException if the coordinates are outside the board's dimensions
     */
    public Square getPosition(int col, int row) {
        // Validate position coordinates
        if (col < 0 || col >= board.length || row < 0 || row >= board[col].length) {
            throw new IllegalArgumentException("Invalid position: " + col + "," + row);
        }
        return board[col][row];
    }

    /**
     * Gets the width of the board (number of columns).
     *
     * @return the width of the board
     */
    public int getWidth() {
        return board.length;
    }

    /**
     * Gets the height of the board (number of rows).
     *
     * @return the height of the board
     */
    public int getHeight() {
        return board[0].length;
    }

    /**
     * Sets the Square at the specified position.
     * Allows for method chaining with the returned Board reference.
     *
     * @param x      the x-coordinate (column)
     * @param y      the y-coordinate (row)
     * @param square the Square to set at the position
     * @return this Board instance for method chaining
     * @throws IllegalArgumentException if the coordinates are outside the board's dimensions
     */
    public Board setPosition(int x, int y, Square square) {
        // Validate position coordinates
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            throw new IllegalArgumentException("Invalid position");
        }
        board[x][y] = square;
        return this;
    }

    /**
     * Returns a string representation of the board.
     * Each row is printed on a new line with equally spaced columns.
     *
     * @return a formatted string representation of the board
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Iterate through rows
        for (int y = 0; y < board[0].length; y++) {
            // Iterate through columns
            for (int x = 0; x < board.length; x++) {
                // Append the square value and pad with spaces for alignment
                sb.append(board[x][y] + spaces(6 - board[x][y].toString().length()));
            }
            // Add a newline character after each row
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Helper method to create a string of spaces for formatting.
     *
     * @param length the number of spaces to generate
     * @return a string containing the specified number of spaces
     */
    private static String spaces(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
