package org.cleasby.tictactoe;

/**
 * Represents a Tic Tac Toe/board square.  Squares may be empty, red, or black.
 */
public enum Square {
    RED("R"), BLACK("B"), NONE(" ");

    private final String symbol;

    Square(String symbol) {
        this.symbol = symbol;
    }

    public static Square forValue(String value) {
        for(Square square : values()) {
            if(square.symbol.equals(value)) {
                return square;
            }
        }
        throw new IllegalArgumentException("Invalid piece value: " + value);
    }
}
